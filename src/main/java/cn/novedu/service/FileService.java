package cn.novedu.service;

import org.springframework.stereotype.Service;

import java.io.File;

/**
 * @author Max Huang
 */
@Service
public class FileService {
    public File getFile(String fileName) {
        return new File("C:/Code/storage/" + fileName);
    }
}
