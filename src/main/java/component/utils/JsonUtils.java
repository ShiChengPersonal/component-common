package component.utils;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @Program: component.component.utils
 * @Date: 2023/5/17 22:03
 * @Author: ShiCheng
 * @Description: json工具类，基于GSON
 */
public class JsonUtils {

    private static final Gson gson = new Gson();

    public static <T> T toObject(String origin, Class<T> clazz){
        if (StringUtils.isBlank(origin) || ObjectUtils.isEmpty(clazz)){
            return null;
        }
        try {
            return gson.fromJson(origin, clazz);
        } catch (JsonSyntaxException e) {
            return null;
        }
    }

    public static String toJson(Object object){
        if (ObjectUtils.isEmpty(object)){
            return null;
        }
        try {
            return gson.toJson(object);
        } catch (Exception e) {
            return null;
        }
    }
}
