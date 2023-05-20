package component.exception.entity;

/**
 * @Program: common
 * @Date: 2023/5/17 22:09
 * @Author: ShiCheng
 * @Description: 交易异常
 */
public class BizException extends RuntimeException implements Message<Object>{

    private static final long serialVersionUID = 1L;

    private String errorCode;
    private String errorMsg;
    private Object data;

    public BizException(){
        super("");
    }

    public BizException(String errorCode, String errorMsg, Object data){
        super(Message.toJsonString(errorCode, errorMsg, data));
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.data = data;
    }

    public BizException(String errorCode, String errorMsg){
        this(errorCode, errorMsg, null);
    }

    public BizException(String errorMsg){
        this(Message.FAIL.getCode(), errorMsg, null);
    }

    @Override
    public String getCode() {
        return errorCode;
    }

    @Override
    public String getMsg() {
        return errorMsg;
    }

    @Override
    public Object getData() {
        return data;
    }

    public String toString(){
        return Message.toJsonString(errorCode, errorMsg, data);
    }
}
