package component.bo;

import lombok.Getter;

/**
 * @Program: common
 * @Date: 2023/5/18 21:44
 * @Author: ShiCheng
 * @Description: 方法响应体
 */
@Getter
public class BaseBO<T> {

    private String resultMsg;
    private boolean isSuccess;
    private T data;

    BaseBO(String resultMsg, boolean isSuccess){
        this.resultMsg = resultMsg;
        this.isSuccess = isSuccess;
    }

    BaseBO(boolean isSuccess){
        this("", isSuccess);
    }

    private BaseBO<T> setData(T data){
        this.data = data;
        return this;
    }

    public static BaseBO<Object> success(){
        return new BaseBO<>(true);
    }

    public static BaseBO<Object> success(String resultMsg){
        return new BaseBO<>(resultMsg,true);
    }

    public static <T> BaseBO<T> success(T data){
        return new BaseBO<T>(true).setData(data);
    }

    public static <T> BaseBO<T> success(String resultMsg, T data){
        return new BaseBO<T>(resultMsg, true).setData(data);
    }

    public static BaseBO<Object> failed(){
        return new BaseBO<>(false);
    }

    public static BaseBO<Object> failed(String resultMsg){
        return new BaseBO<>(resultMsg,false);
    }

    public static <T> BaseBO<T> failed(T data){
        return new BaseBO<T>(false).setData(data);
    }

    public static <T> BaseBO<T> failed(String resultMsg, T data){
        return new BaseBO<T>(resultMsg, false).setData(data);
    }
}
