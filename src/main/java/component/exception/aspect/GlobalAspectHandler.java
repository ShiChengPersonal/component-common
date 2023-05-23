package component.exception.aspect;

import component.utils.DateUtil;
import component.utils.JsonUtils;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;


/**
 * @Program: common
 * @Date: 2023/5/20 12:30
 * @Author: ShiCheng
 * @Description:
 */
@Log4j2
@Aspect
public class GlobalAspectHandler {

    @Pointcut(value = "@annotation(GlobalAspect)")
    public void globalAspect() {
    }

//    @Before("globalAspect()")
//    public void before(){
//        log.warn(1);
//    }
//
//    @Around("globalAspect()")
//    public Object around(ProceedingJoinPoint point) throws Throwable{
//        log.warn(2);
//        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//        String requestURI = request.getRequestURI();
//        String remoteHost = request.getRemoteHost();
//        String remoteUser = request.getRemoteUser();
//        String method = request.getMethod();
//        String args = JsonUtils.toJson(point.getArgs());
//
//        Object proceed = point.proceed();
//        //可再添加逻辑
//        log.warn(3);
//        return proceed;
//    }
//
//    @After("globalAspect()")
//    public void after(){
//        log.warn(4);
//        LocalDateTime localDateTime = DateUtil.getLocalDateTime();
//        Long end = DateUtil.toTimeStampWithCTT(localDateTime);
//        Long start = threadLocal.get();
//        log.info(String.format("Thread[%s] request end,current time:{%s}, request spend:{%s} millisecond", Thread.currentThread().getName(), localDateTime.toString(), end - start));
//    }

    @AfterReturning(value = "globalAspect()", returning = "response")
    public void afterReturning(Object response){
        log.info(String.format("Thread[%s] response success, info:{%s}", Thread.currentThread().getName(), JsonUtils.toJson(response)));
    }

    @AfterThrowing(value = "globalAspect()", throwing = "ex")
    public void afterThrowing(Throwable ex){
        log.error(String.format("Thread[%s] response failed, info:{%s}", Thread.currentThread().getName(), JsonUtils.toJson(ex.getMessage())));
    }
}
