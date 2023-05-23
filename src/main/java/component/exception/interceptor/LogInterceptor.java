package component.exception.interceptor;

import component.utils.DateUtil;
import component.utils.JsonUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

/**
 * @Program: component-common
 * @Date: 2023/5/23 19:46
 * @Author: ShiCheng
 * @Version: 1.0
 * @Description:
 */
@Log4j2
public class LogInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LocalDateTime localDateTime = DateUtil.getLocalDateTime();
        Long start = DateUtil.toTimeStampWithCTT(localDateTime);
        String threadName = "T-" + start;
        Thread.currentThread().setName(threadName);
        request.setAttribute("start_time", start);
        log.info(String.format("Thread[%s] request start,current time:{%s}"
                , threadName, localDateTime.toString()));
        String args = JsonUtils.toJson(request.getParameterMap());
        log.warn(String.format("Thread[%s] client:[host:{%s},user:{%s}],request:[method:{%s},uri:[%s],args:{%s}]"
                , threadName, request.getRemoteHost(), request.getRemoteUser(), request.getMethod(), request.getRequestURI()
                , args == null ? null : (args.length() > 2000? args.substring(0, 2000) : args)));
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        LocalDateTime localDateTime = DateUtil.getLocalDateTime();
        Long end = DateUtil.toTimeStampWithCTT(localDateTime);
        Long start = (Long)request.getAttribute("start_time");
        log.info(String.format("Thread[%s] request end,current time:{%s}, request spend:{%s} millisecond", Thread.currentThread().getName(), localDateTime.toString(), end - start));
    }
}
