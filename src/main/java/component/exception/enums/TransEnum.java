package component.exception.enums;

import component.constant.ErrorConstant;
import lombok.Getter;

/**
 * @Program: common
 * @Date: 2023/5/17 21:34
 * @Author: ShiCheng
 * @Description: 交易状态枚举类
 */
@Getter
public enum TransEnum {
    SUCCESS(ErrorConstant.SUCCESS_CODE, ErrorConstant.SUCCESS_MSG),
    FAIL(ErrorConstant.FAILED_CODE, ErrorConstant.FAILED_MSG),;

    private String code;
    private String message;

    TransEnum(String code, String message){
        this.code = code;
        this.message = message;
    }
}
