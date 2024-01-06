package com.ecom.app.security;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.WebUtils;

import com.ecom.app.util.Utility;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

	@Autowired
	private JwtUserDetailsService jwtUserDetailsService;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private Utility utility;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {

		final String requestTokenHeader = request.getHeader("Authorization");
		String url = request.getRequestURI().substring(request.getContextPath().length());
		String methodType = request.getMethod();
		String username = null;
		String jwtToken = null;

		// JWT Token is in the form "Bearer token". Remove Bearer word and get
		// only the Token
		if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
			jwtToken = requestTokenHeader.substring(7);
			try {
				username = jwtTokenUtil.getUsernameFromToken(jwtToken);
			} catch (IllegalArgumentException e) {
				System.out.println("Unable to get JWT Token");

				String userIdStr = request.getHeader("userId");
				if (userIdStr != null) {
					String[] userDetail = userIdStr.split("__");
					if (userDetail[0] != null && !(userDetail[0].trim().equalsIgnoreCase(""))) {
						try {
							Long userId = Long.valueOf(userDetail[0].trim());
							String userType = userDetail[2].trim();
						} catch (Exception ex) {
							// TODO: handle exception
						}
					}
				}
				ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper(request);

			} catch (ExpiredJwtException e) {
				System.out.println("JWT Token has expired");
				String userIdStr = request.getHeader("userId");
				if (userIdStr != null) {
					String[] userDetail = userIdStr.split("__");
					if (userDetail[0] != null && !(userDetail[0].trim().equalsIgnoreCase(""))) {
						try {
							Long userId = Long.valueOf(userDetail[0].trim());
							String userType = userDetail[2].trim();
						} catch (Exception ex) {
							// TODO: handle exception
						}
					}
				}
				ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper(request);

			} catch (Exception ex) {
				System.out.println("JWT Token not valid");
				String userIdStr = request.getHeader("userId");
				if (userIdStr != null) {
					String[] userDetail = userIdStr.split("__");
					if (userDetail[0] != null && !(userDetail[0].trim().equalsIgnoreCase(""))) {
						try {
							Long userId = Long.valueOf(userDetail[0].trim());
							String userType = userDetail[2].trim();
						} catch (Exception e) {
							// TODO: handle exception
						}
					}
				}
				ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper(request);

			}
		} else {
			logger.warn("JWT Token does not begin with Bearer String");
		}

		// Once we get the token validate it.
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			boolean havePermission = utility.hasPermission(url, methodType, username);

			if (havePermission) {
				UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(username);
				// if token is valid configure Spring watsoogps to manually set
				// authentication
				if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {
					UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
							userDetails, null, userDetails.getAuthorities());
					usernamePasswordAuthenticationToken
							.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					// After setting the Authentication in the context, we specify
					// that the current user is authenticated. So it passes the
					// Spring watsoogps Configurations successfully.
					SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
				}
			}
		}
		chain.doFilter(request, response);
	}

	private String getRequestPayload(HttpServletRequest request) {
		ContentCachingRequestWrapper wrapper = WebUtils.getNativeRequest(request, ContentCachingRequestWrapper.class);
		if (wrapper != null) {
			byte[] buf = wrapper.getContentAsByteArray();
			if (buf.length > 0) {
				int length = buf.length;
				try {
					return new String(buf, 0, length, wrapper.getCharacterEncoding());
				} catch (UnsupportedEncodingException ex) {
					return "[unknown]";
				}
			}
		}
		return "";
	}

}
