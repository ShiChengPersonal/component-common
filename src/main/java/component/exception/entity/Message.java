package component.exception.entity;

import component.constant.ErrorConstant;
import component.utils.JsonUtils;

import java.util.LinkedHashMap;

/**
 * @Program: common
 * @Date: 2023/5/17 21:28
 * @Author: ShiCheng
 * @Description:
 */
public interface Message<T> {
    Message FAIL = new Message<Object>() {
        @Override
        public String getCode() {
            return ErrorConstant.FAILED_CODE;
        }

        @Override
        public String getMsg() {
            return ErrorConstant.FAILED_MSG;
        }

        @Override
        public Object getData() {
            return null;
        }
    };

    Message SUCCESS = new Message<Object>() {
        @Override
        public String getCode() {
            return ErrorConstant.SUCCESS_CODE;
        }

        @Override
        public String getMsg() {
            return ErrorConstant.SUCCESS_MSG;
        }

        @Override
        public Object getData() {
            return null;
        }
    };

    String PREFIX_SYSTEM = "E";
    String PREFIX_COMMON = "C";
    String PREFIX_BIZ = "B";
    String PREFIX_TRADE = "T";

    String getCode();
    String getMsg();
    T getData();

    static String toJsonString(String code, String msg, Object data){
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("code", code);
        map.put("msg", msg);
        map.put("data", data);
        return JsonUtils.toJson(map);
    }

    default BizException toBizException(){
        return new BizException(this.getCode(), this.getMsg(), this.getData());
    }

    default BizException toBizException(Object data){
        return new BizException(this.getCode(), this.getMsg(), data);
    }

}
