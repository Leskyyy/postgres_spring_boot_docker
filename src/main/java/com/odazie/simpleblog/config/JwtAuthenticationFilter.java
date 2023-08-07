package com.odazie.simpleblog.config;

import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter
{
    @Override
    protected void doFilterInternal( @NonNull HttpServletRequest aHttpServletRequest,
        @NonNull HttpServletResponse aHttpServletResponse, @NonNull FilterChain aFilterChain )
        throws ServletException, IOException
    {
        final String authenticationHeader = aHttpServletRequest.getHeader( "Authorization" );
        final String jwt;
        final String email;

        if (authenticationHeader == null || !authenticationHeader.startsWith( "Bearer " ))
        {
            aFilterChain.doFilter( aHttpServletRequest, aHttpServletResponse );
            return;
        }

        jwt = authenticationHeader.substring( 7 );
        email = JwtUtil.extractEmail( jwt );
    }
}
