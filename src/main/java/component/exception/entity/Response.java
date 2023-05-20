package component.exception.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.ObjectUtils;
import component.utils.JsonUtils;

/**
 * @Program: common
 * @Date: 2023/5/17 21:27
 * @Author: ShiCheng
 * @Description: 响应体
 */
@Setter
@Getter
public class Response<T> {

    @ApiModelProperty(
            name = "错误码",
            value = "错误码",
            required = true
    )
    private String code;

    @ApiModelProperty(
            name = "错误信息",
            value = "错误信息",
            required = true
    )
    private String info;

    @ApiModelProperty(
            name = "返回数据",
            value = "返回数据",
            required = true
    )
    private T data;

    public Response(String code, String info, T data){
        this.code = code;
        this.info = info;
        this.data = data;
    }

    public Response(String code, String info){
        this(code, info, null);
    }

    public Response(Message message, T data){
        this(message.getCode(), message.getMsg() , data);
    }

    public Response(Message message){
        this(message,null);
    }

    public Response(){
        this(Message.SUCCESS);
    }

    public static Response<Object> getResponse(BizException exception){
        return new Response(exception.getCode(), exception.getMsg(), exception.getData());
    }

    public static Response<Object> getResponse(Message message){
        return new Response(message.getCode(), message.getMsg(), message.getData());
    }

    public static Response success(){
        return new Response(Message.SUCCESS);
    }

    public static <T> Response<T> success(T data){
        return new Response(Message.SUCCESS, data);
    }

    public static Response failed(){
        return new Response(Message.FAIL);
    }

    public static Response failed(String info){
        return new Response(Message.FAIL.getCode(), info);
    }

    public static Response failed(String code, String info){
        return new Response(code, info);
    }

    public static <T> Response<T> failed(T data){
        return new Response(Message.FAIL, data);
    }

    public String toString(){
        return String.format("{code:[%s],info:[%s],data:[%s]}",
                code, info,
                ObjectUtils.isEmpty(data) ? null :
                        ObjectUtils.defaultIfNull(JsonUtils.toJson(data), "data conversion failed"));
    }
}
