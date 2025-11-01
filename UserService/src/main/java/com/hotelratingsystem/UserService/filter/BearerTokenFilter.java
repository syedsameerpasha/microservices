package com.hotelratingsystem.UserService.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
public class BearerTokenFilter implements Filter {

    private static final String VALID_TOKEN = "7259597880";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String authorizationHeader = httpRequest.getHeader("Authorization");

        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            httpResponse.getWriter().write(" Missing or invalid Authorization header");
            return;
        }

        // Extract token value
        String token = authorizationHeader.substring(7); // remove "Bearer "

        if (!VALID_TOKEN.equals(token)) {
            httpResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
            httpResponse.getWriter().write(" Invalid Bearer Token");
            return;
        }

        //  If valid, continue
        System.out.println(" Valid token. Allowing request...");
        chain.doFilter(request, response);
    }
}
