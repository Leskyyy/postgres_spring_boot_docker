package com.odazie.simpleblog.config;

import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
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

    private final JwtUtil jwtUtil;
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal( @NonNull HttpServletRequest aHttpServletRequest,
        @NonNull HttpServletResponse aHttpServletResponse, @NonNull FilterChain aFilterChain )
        throws ServletException, IOException
    {
        final String authenticationHeader = aHttpServletRequest.getHeader( "Authorization" );
        final String jwt;
        final String email;

        if( authenticationHeader == null || !authenticationHeader.startsWith( "Bearer " ) )
        {
            aFilterChain.doFilter( aHttpServletRequest, aHttpServletResponse );
            return;
        }

        jwt = authenticationHeader.substring( 7 );
        email = jwtUtil.extractEmail( jwt );

        if( email != null && SecurityContextHolder.getContext()
            .getAuthentication() == null )
        {
            UserDetails userDetails = this.userDetailsService.loadUserByUsername( email );
            if( jwtUtil.isTokenValid( jwt, userDetails ) )
            {
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                    userDetails, null, userDetails.getAuthorities() );

                authToken
                    .setDetails( new WebAuthenticationDetailsSource().buildDetails( aHttpServletRequest ) );

                SecurityContextHolder.getContext()
                    .setAuthentication( authToken );
            }
        }
        aFilterChain.doFilter( aHttpServletRequest, aHttpServletResponse );
    }
}
