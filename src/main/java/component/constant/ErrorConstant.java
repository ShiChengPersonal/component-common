package component.constant;

/**
 * @Program: common
 * @Date: 2023/5/18 21:13
 * @Author: ShiCheng
 * @Description:
 */
public class ErrorConstant {

    //默认成功、失败
    public static final String SUCCESS_CODE = "000000";
    public static final String SUCCESS_MSG = "成功";
    public static final String FAILED_CODE = "999999";
    public static final String FAILED_MSG = "失败";

    //通用错误
    public static final String COMMON_MESSAGE_NOT_READABLE_CODE = "C00000";
    public static final String COMMON_MESSAGE_NOT_READABLE_MSG = "请求参数不可解析";
    public static final String COMMON_DATA_HANDLER_CODE = "C00001";
    public static final String COMMON_DATA_HANDLER_MSG = "数据处理失败";
    public static final String COMMON_JSON_HANDLER_CODE = "C00002";
    public static final String COMMON_JSON_HANDLER_MSG = "JSON转换失败";


    //业务错误
    public static final String BIZ_ILLEGAL_ARGUMENT_CODE = "B00000";
    public static final String BIZ_ILLEGAL_ARGUMENT_MSG = "请求参数不满足";
    public static final String BIZ_NOT_SUPPORTED_TYPE_CODE = "B00001";
    public static final String BIZ_NOT_SUPPORTED_TYPE_MSG = "不支持此业务类型";
    public static final String BIZ_FAILED_HANDLER_CODE = "B99999";
    public static final String BIZ_FAILED_HANDLER_MSG = "业务处理失败";


    //系统错误
    public static final String SYSTEM_UNKNOWN_CODE = "E00000";
    public static final String SYSTEM_UNKNOWN_MSG = "未知错误";
    public static final String SYSTEM_WITHOUT_SERVICE_CODE = "E00001";
    public static final String SYSTEM_WITHOUT_SERVICE_MSG = "没有相应服务";
    public static final String SYSTEM_NO_RESPONSE_CODE = "E00002";
    public static final String SYSTEM_NO_RESPONSE_MSG = "没有响应";

}
