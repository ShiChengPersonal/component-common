package component.exception.handler;

import com.google.gson.JsonIOException;
import component.constant.ErrorConstant;
import component.exception.entity.BizException;
import component.exception.entity.Message;
import component.exception.entity.Response;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Program: common
 * @Date: 2023/5/18 20:53
 * @Author: ShiCheng
 * @Description: 自定义异常处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 默认异常处理
     * @param exception
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Response exceptionHandler(Exception exception){
        return Response.failed(ErrorConstant.SYSTEM_UNKNOWN_CODE, ErrorConstant.SYSTEM_UNKNOWN_MSG);
    }

    /**
     * json转换异常
     * @param jsonIOException
     * @return
     */
    @ExceptionHandler(value = JsonIOException.class)
    @ResponseBody
    public Response bizExceptionHandler(JsonIOException jsonIOException){
        return Response.getResponse(new Message() {
            @Override
            public String getCode() {
                return ErrorConstant.COMMON_JSON_HANDLER_CODE;
            }

            @Override
            public String getMsg() {
                return ErrorConstant.COMMON_JSON_HANDLER_MSG;
            }

            @Override
            public Object getData() {
                return jsonIOException.toString();
            }
        });
    }


    /**
     * 自定义业务处理异常
     * @param bizException
     * @return 业务异常信息
     */
    @ExceptionHandler(value = BizException.class)
    @ResponseBody
    public Response bizExceptionHandler(BizException bizException){
        return Response.getResponse(bizException);
    }

    /**
     * 异常产生原因：
     * 1、@Valid注解，请求实体属性值校验失败，如非空校验
     * @param exception
     * @return 响应异常属性
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public Response MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException exception) {
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        StringBuilder stringBuilder = new StringBuilder();
        for (FieldError f : fieldErrors) {
            stringBuilder.append(f.getDefaultMessage());
            stringBuilder.append("[");
            stringBuilder.append(f.getField());
            stringBuilder.append("];");
        }
        return Response.failed(stringBuilder.toString());
    }

    /**
     * 异常产生原因：
     * 1、传入的参数类型不一致
     * 2、使用@RequestBody注解，调用接口没有传参
     * @param exception
     * @return
     */
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    @ResponseBody
    public Response httpMessageNotReadableExceptionHandler(HttpMessageNotReadableException exception){
        return Response.failed(ErrorConstant.COMMON_MESSAGE_NOT_READABLE_CODE, ErrorConstant.COMMON_MESSAGE_NOT_READABLE_MSG);
    }

    /**
     * 异常产生原因：
     * 1、请求参数不满足业务处理条件时，主动抛出此异常
     * 2、参数处理异常
     * @param exception
     * @return
     */
    @ExceptionHandler(value = IllegalArgumentException.class)
    @ResponseBody
    public Response illegalArgumentExceptionHandler(IllegalArgumentException exception){
        return Response.failed(ErrorConstant.BIZ_ILLEGAL_ARGUMENT_CODE, ErrorConstant.BIZ_ILLEGAL_ARGUMENT_MSG);
    }

}
