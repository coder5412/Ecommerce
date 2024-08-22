/*
package com.example.Ecommerce.config;

import lombok.Value;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class SimpleCosFilter implements Filter {

  */
/*  @Value("${app.client.url}")
    private String clientAppUrl="";*//*




    public SimpleCosFilter() {

    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

        HttpServletResponse response = (HttpServletResponse) res;
        HttpServletRequest request = (HttpServletRequest) req;
        Map<String, String> map = new HashMap<>();
        String origin = request.getHeader("Origin");
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Access-Control-Allow-Origin"));
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, Put,OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "*");

    if("OPTIONS".equalsIgnoreCase(request.getMethod())) {
        response.setStatus(HttpServletResponse.SC_OK);
    }else {
        chain.doFilter(req, res);
    }
    }
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//    }
//    @Override
//    public void destory(){
//
//    }
    @Override
    public boolean isLoggable(LogRecord record) {
        return false;
    }
}
*/
