package component.constant;

/**
 * @Program: common
 * @Date: 2023/5/17 22:50
 * @Author: ShiCheng
 * @Description: sql执行枚举
 */
public class SQLStatusConstant {

    public static String SQL_SUCCESS_INSERT = "插入成功";
    public static String SQL_SUCCESS_UPDATE = "更新成功";
    public static String SQL_SUCCESS_DELETE = "删除成功";
    public static String SQL_SUCCESS_QUERY = "查询成功";

    public static String SQL_FAIL_EMPTY = "没有记录";
    public static String SQL_FAIL_EXISTS = "记录已存在";
    public static String SQL_FAIL_MULTIPLE = "记录存在多条";

    public static String SQL_ERROR_VIOLATION_OF_UNIQUE_INDEX = "违反唯一索引";
    public static String SQL_ERROR_PRIMARY_CONFLICT = "主键冲突";
    public static String SQL_ERROR_PARAMETER = "缺少参数";
    public static String SQL_ERROR_INSERT = "插入失败";
    public static String SQL_ERROR_UPDATE = "更新失败";
    public static String SQL_ERROR_DELETE = "删除失败";
    public static String SQL_ERROR_QUERY = "查询失败";
}
