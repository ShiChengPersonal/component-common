package component.exception.aspect;

import component.utils.DateUtil;
import component.utils.JsonUtils;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
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
@Aspect
@Component
@Log4j2
public class GlobalAspectHandler {

    private static final ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    @Pointcut(value = "@annotation(GlobalAspect)")
    public void globalAspect() {
    }

    @Before("globalAspect()")
    public void before(){
        LocalDateTime localDateTime = DateUtil.getLocalDateTime();
        Long start = DateUtil.toTimeStampWithCTT(localDateTime);
        Thread.currentThread().setName("thread" + start);
        log.info(String.format("线程[%s]请求开始，当前时间：{%s}", Thread.currentThread().getName(), localDateTime.toString()));
        threadLocal.set(start);
    }

    @Around("globalAspect()")
    public Object around(ProceedingJoinPoint point) throws Throwable{
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String requestURI = request.getRequestURI();
        if (StringUtils.isBlank(requestURI)){
            return point.proceed();
        }
        String remoteHost = request.getRemoteHost();
        String remoteUser = request.getRemoteUser();
        log.info(String.format("线程[%s]客户端信息：{%s}，{%s}", Thread.currentThread().getName(), remoteHost, remoteUser));
        String method = request.getMethod();
        Object[] args = point.getArgs();
        String json = JsonUtils.toJson(args);
        log.info(json);
        return point.proceed();
    }

    @After("globalAspect()")
    public void after(){
        LocalDateTime localDateTime = DateUtil.getLocalDateTime();
        Long end = DateUtil.toTimeStampWithCTT(localDateTime);
        Long start = threadLocal.get();
        log.info(String.format("线程[%s]请求结束，当前时间：{%s}，共用时：{%s}秒", Thread.currentThread().getName(), localDateTime.toString(), (end - start)/1000));
    }
}
