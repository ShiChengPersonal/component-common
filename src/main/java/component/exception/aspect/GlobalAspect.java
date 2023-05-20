package component.exception.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Program: common
 * @Date: 2023/5/20 11:57
 * @Author: ShiCheng
 * @Description: 全局切面代理
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface GlobalAspect {
}
