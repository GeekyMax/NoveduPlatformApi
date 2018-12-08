package cn.novedu.controller;

import cn.novedu.security.IgnoreSecurity;
import cn.novedu.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLDecoder;
import java.util.Date;

/**
 * @author Max Huang
 */
@Controller
public class VideoController {
    private Logger logger = LoggerFactory.getLogger(VideoController.class);
    private static final String STORAGE = "storage";
    @Autowired
    private FileService fileService;

    @IgnoreSecurity
    @RequestMapping("/storage/**")
    public void bigFileDownload(HttpServletRequest request,
                                HttpServletResponse response) throws IOException {
        String uri = URLDecoder.decode(request.getRequestURI(), "UTF-8");

        String filename = uri.substring(uri.indexOf(STORAGE) + STORAGE.length()
                + 1);
        File downloadFile = fileService.getFile(filename);
        long fileLength = downloadFile.length();
        // 记录已下载文件大小
        long pastLength = 0;
        // 记录客户端需要下载的字节段的最后一个字节偏移量（比如bytes=27000-39000，则这个值是为39000）
        long toLength = 0;
        // 客户端请求的字节总量
        long contentLength = 0;
        // 记录客户端传来的形如“bytes=27000-”或者“bytes=27000-39000”的内容
        String rangeBytes = "";

        // ETag header
        // The ETag is contentLength + lastModified
        response.setHeader("ETag",
                "W/\"" + fileLength + "-" + downloadFile.lastModified() + "\"");
        // Last-Modified header
        response.setHeader("Last-Modified",
                new Date(downloadFile.lastModified()).toString());

        // 客户端请求的下载的文件块的开始字节
        if (request.getHeader("Range") != null) {
            response.setStatus(HttpServletResponse.SC_PARTIAL_CONTENT);
            logger.info("request.getHeader(\"Range\")="
                    + request.getHeader("Range"));
            rangeBytes = request.getHeader("Range").replaceAll("bytes=", "");
            // bytes=969998336-
            if (rangeBytes.indexOf('-') == rangeBytes.length() - 1) {
                rangeBytes = rangeBytes.substring(0, rangeBytes.indexOf('-'));
                pastLength = Long.parseLong(rangeBytes.trim());
                toLength = fileLength - 1;
                // bytes=1275856879-1275877358
            } else {
                String temp0 = rangeBytes.substring(0, rangeBytes.indexOf('-'));
                String temp2 = rangeBytes.substring(
                        rangeBytes.indexOf('-') + 1, rangeBytes.length());
                // bytes=1275856879-1275877358，从第 1275856879个字节开始下载
                pastLength = Long.parseLong(temp0.trim());
                // bytes=1275856879-1275877358，到第 1275877358 个字节结束
                toLength = Long.parseLong(temp2);
            }
        } else {// 从开始进行下载
            toLength = fileLength - 1;
        }
        // 客户端请求的是1275856879-1275877358 之间的字节
        contentLength = toLength - pastLength + 1;
        if (contentLength < Integer.MAX_VALUE) {
            response.setContentLength((int) contentLength);
        } else {
            // Set the content-length as String to be able to use a long
            response.setHeader("content-length", "" + contentLength);
        }
        response.setContentType("application/video");

        // 告诉客户端允许断点续传多线程连接下载,响应的格式是:Accept-Ranges: bytes
        response.setHeader("Accept-Ranges", "bytes");
        // 必须先设置content-length再设置header
        response.addHeader("Content-Range", "bytes " + pastLength + "-"
                + toLength + "/" + fileLength);

        response.setBufferSize(2048);

        InputStream istream = null;
        OutputStream os;
        try {
            os = response.getOutputStream();
            istream = new BufferedInputStream(
                    new FileInputStream(downloadFile), 2048);
            try {
                copyRange(istream, os, pastLength, toLength);
            } catch (IOException ie) {
                /* 在写数据的时候， 对于 ClientAbortException 之类的异常，
                 * 是因为客户端取消了下载，而服务器端继续向浏览器写入数据时， 抛出这个异常，这个是正常的。
                 * 尤其是对于迅雷这种吸血的客户端软件， 明明已经有一个线程在读取 bytes=1275856879-1275877358，
                 * 如果短时间内没有读取完毕，迅雷会再启第二个、第三个。。。线程来读取相同的字节段， 直到有一个线程读取完毕，迅雷会 KILL
                 * 掉其他正在下载同一字节段的线程， 强行中止字节读出，造成服务器抛 ClientAbortException。
                 * 所以，我们忽略这种异常
                 */
                // ignore
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            if (istream != null) {
                try {
                    istream.close();
                } catch (IOException e) {
                    logger.error(e.getMessage(), e);
                }
            }
        }
    }

    protected void copyRange(InputStream istream, OutputStream ostream,
                             long start, long end) throws IOException {

        long skipped = 0;
        skipped = istream.skip(start);

        if (skipped < start) {
            throw new IOException("skip fail: skipped=" + Long.valueOf(skipped)
                    + ", start=" + Long.valueOf(start));
        }

        long bytesToRead = end - start + 1;

        byte buffer[] = new byte[2048];
        int len = buffer.length;
        while ((bytesToRead > 0) && (len >= buffer.length)) {
            try {
                len = istream.read(buffer);
                if (bytesToRead >= len) {
                    ostream.write(buffer, 0, len);
                    bytesToRead -= len;
                } else {
                    ostream.write(buffer, 0, (int) bytesToRead);
                    bytesToRead = 0;
                }
            } catch (IOException e) {
                len = -1;
                throw e;
            }
            if (len < buffer.length) {
                break;
            }
        }

    }

}
