package com.getarrays.project3.filter;

import com.getarrays.project3.constant.SecurityConstant;
import com.getarrays.project3.utility.JWTTokenProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.getarrays.project3.constant.SecurityConstant.TOKEN_PREFIX;

@Component
public class JwtAuthorizationFilter extends OncePerRequestFilter { //authorize or not any request that comes in
    // this filter intercepts incoming requests, checks for the presence and validity of a JWT token in the Authorization header, and if valid, sets up the Spring Security context with the user's authentication information.
    // It also handles pre-flight requests by allowing OPTIONS requests to pass through without further processing.
    private JWTTokenProvider jwtTokenProvider;

    public JwtAuthorizationFilter(JWTTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }
    //doFilterInternal method is invoked only once per request.
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (request.getMethod().equalsIgnoreCase(SecurityConstant.OPTIONS_HTTP_METHOD)) { //determine whether a client is allowed to make a particular request to the server.
            response.setStatus(HttpStatus.OK.value());  //if request method is OPTION, we don't do anything, we just set the status ok.
        } else {
            String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION); //retrieves the value of AUTHORIZATION
            //If the Authorization header is missing or doesn't start with the token prefix 'bearer ' it means the request does not include a valid JWT token
            if (authorizationHeader == null || !authorizationHeader.startsWith(TOKEN_PREFIX)) {
                filterChain.doFilter(request, response);
                return;
            }
            String token = authorizationHeader.substring(TOKEN_PREFIX.length());  //removes the "bearer " from the token, and it's going to leave us with the actual token
            String username = jwtTokenProvider.getSubject(token); //get user from token provider
            if (jwtTokenProvider.isTokenValid(username, token) && SecurityContextHolder.getContext().getAuthentication() == null) {
                List<GrantedAuthority> authorities = jwtTokenProvider.getAuthorities(token);
                Authentication authentication = jwtTokenProvider.getAuthentication(username, authorities, request);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } else {
                SecurityContextHolder.clearContext();
            }
        }
        filterChain.doFilter(request, response);
    }
}
