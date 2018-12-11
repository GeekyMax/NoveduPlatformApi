package cn.novedu.jdbc.paging;

import cn.novedu.mapper.SysMapper;
import cn.novedu.param.PagingParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Max Huang
 */
@Component
public class PagingManager {
    @Autowired
    private SysMapper sysMapper;

    public String handleOrderBy(String tableName, String columnName, String order) {
        order = order.trim().toLowerCase();
        if (!"desc".equals(order) && !"asc".equals(order)) {
            return null;
        }
        columnName = columnName.trim().toLowerCase();
        tableName = tableName.trim().toLowerCase();
        if (checkTableNameAndColumnName(tableName, columnName)) {
            return columnName + " " + order;
        } else {
            return null;
        }
    }

    private Boolean checkTableNameAndColumnName(String tableName, String columnName) {
        if (tableName != null && columnName != null) {
            return sysMapper.existColumn(tableName, columnName);
        } else {
            return false;
        }
    }

    public PagingParam createPagingParam(int pageNum, int pageSize, String order, String sort) {
        String orderBy = handleOrderBy("post", sort, order);
        if (orderBy == null) {
            orderBy = "post_time asc";
        }
        return new PagingParam(pageNum, pageSize, orderBy);
    }
}
