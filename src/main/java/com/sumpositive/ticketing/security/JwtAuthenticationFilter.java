
package com.sumpositive.ticketing.security;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JWTSecurity jwtSecurity;

    public JwtAuthenticationFilter(JWTSecurity jwtSecurity) {
        this.jwtSecurity = jwtSecurity;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,HttpServletResponse response,FilterChain filterChain) throws ServletException, IOException {

             String authorizationHeader = request.getHeader("Authorization");
             String token = null;
             String email = null;

        if (authorizationHeader != null
                && authorizationHeader.startsWith("Bearer ")) {

            token = authorizationHeader.substring(7);

            try {
                email = jwtSecurity.extractEmail(token);
            } catch (Exception exception) {
                email = null;
            }
        }

        if (email != null
                && SecurityContextHolder.getContext()
                        .getAuthentication() == null) {

            if (jwtSecurity.validateToken(token, email)) {

                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(
                                email,
                                null,
                                java.util.Collections.emptyList()
                        );

                authentication.setDetails(
                        new WebAuthenticationDetailsSource()
                                .buildDetails(request)
                );

                SecurityContextHolder.getContext() .setAuthentication(authentication);
            }
        }

        filterChain.doFilter(request, response);
    }
}
