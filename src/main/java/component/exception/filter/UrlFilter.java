package component.exception.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Program: common
 * @Date: 2023/5/20 18:04
 * @Author: ShiCheng
 * @Version: 1.0
 * @Description: 请求url过滤器，还需要注入容器bean
 */
public class UrlFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        String remoteHost = servletRequest.getRemoteHost();
        String requestURL = servletRequest.getRequestURL().toString();
        String remoteUser = servletRequest.getRemoteUser();
        //TODO 请求url访问权限，过滤敏感词，防止sql注入，压缩响应信息等

        //继续执行
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
