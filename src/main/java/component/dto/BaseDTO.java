package component.dto;

import lombok.Getter;

/**
 * @Program: common
 * @Date: 2023/5/18 21:44
 * @Author: ShiCheng
 * @Description: 方法响应体
 */
@Getter
public class BaseDTO<T> {

    private String resultMsg;
    private boolean isSuccess;
    private T data;

    BaseDTO(String resultMsg, boolean isSuccess){
        this.resultMsg = resultMsg;
        this.isSuccess = isSuccess;
    }

    BaseDTO(boolean isSuccess){
        this("", isSuccess);
    }

    private BaseDTO<T> setData(T data){
        this.data = data;
        return this;
    }

    public static BaseDTO<Object> success(){
        return new BaseDTO<>(true);
    }

    public static BaseDTO<Object> success(String resultMsg){
        return new BaseDTO<>(resultMsg,true);
    }

    public static <T> BaseDTO<T> success(T data){
        return new BaseDTO<T>(true).setData(data);
    }

    public static <T> BaseDTO<T> success(String resultMsg, T data){
        return new BaseDTO<T>(resultMsg, true).setData(data);
    }

    public static BaseDTO<Object> failed(){
        return new BaseDTO<>(false);
    }

    public static BaseDTO<Object> failed(String resultMsg){
        return new BaseDTO<>(resultMsg,false);
    }

    public static <T> BaseDTO<T> failed(T data){
        return new BaseDTO<T>(false).setData(data);
    }

    public static <T> BaseDTO<T> failed(String resultMsg, T data){
        return new BaseDTO<T>(resultMsg, false).setData(data);
    }
}
