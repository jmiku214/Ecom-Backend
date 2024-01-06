package com.ecom.app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter implements Filter {

    @Value("${cors.allow.domain:*}")
    private String origin;

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {


        HttpServletResponse response = (HttpServletResponse) res;

        HttpServletRequest request = (HttpServletRequest) req;

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Allow", "OPTIONS");
        response.setHeader("Access-Control-Allow-Methods", "POST,GET,DELETE,OPTIONS,PUT,PATCH");

        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Access-Control-Allow-Origin,Origin,"
                + " X-ACCESS_TOKEN,Authorization,Content-Type, x-requested-with, X-Custom-Header,Content-Range,Content-Disposition," +
                "Content-Description,userId,userType");
        response.setHeader("Access-Control-Allow-Credentials", "true");

        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            chain.doFilter(req, res);
        }


        //"X-ACCESS_TOKEN", "Access-Control-Allow-Origin", "Authorization", "Origin", "x-requested-with",
        //"Content-Type", "Content-Range", "Content-Disposition", "Content-Description"
    }

    public void init(FilterConfig filterConfig) {

    }

    public void destroy() {
    }
}