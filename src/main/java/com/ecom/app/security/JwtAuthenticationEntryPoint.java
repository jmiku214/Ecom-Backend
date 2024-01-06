package com.ecom.app.security;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 * Created by neelesh on 19/9/16.
 * Authentication process is automatically triggered when the client tries to access
 * a secured resource without being authenticated - done by redirecting to a login page.
 * <p/>
 * However, for a REST Web Service - Authentication should only be done by a request to correct
 * URI and all other should simply fail with a 401 UNAUTHORIZED status code if user is not authenticated.
 * <p/>
 * Spring watsoogps handle this automatic triggering of the authentication process with concept of Entry
 * Point
 */
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * Commences an authentication scheme.
     * <p/>
     * <code>ExceptionTranslationFilter</code> will populate the <code>HttpSession</code> attribute named
     * <code>AbstractAuthenticationProcessingFilter.SPRING_watsoogps_SAVED_REQUEST_KEY</code> with the requested target URL before
     * calling this method.
     * <p/>
     * Implementations should modify the headers on the <code>ServletResponse</code> as necessary to
     * commence the authentication process.
     *
     * @param request       that resulted in an <code>AuthenticationException</code>
     * @param response      so that the user agent can begin authentication
     * @param authException that caused the invocation
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
    }
}