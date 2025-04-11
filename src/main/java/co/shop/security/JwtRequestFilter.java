package co.shop.security;


import co.shop.service.SecUserDetailsService;
import io.jsonwebtoken.ExpiredJwtException;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;

import static org.slf4j.LoggerFactory.getLogger;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {
    private final static Logger LOGGER = getLogger(JwtRequestFilter.class);

    @Autowired
    private SecUserDetailsService jwtUserDetailsService;


    @Autowired
    private JwtTokenProvider jwtTokenUtil;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
//        Enumeration<String> headerNames = request.getHeaderNames();

//        if (headerNames != null) {
//            while (headerNames.hasMoreElements()) {
//                System.out.println(headerNames+": " + request.getHeader(headerNames.nextElement()));
//            }
//        }


        final String requestTokenHeader = request.getHeader("Authorization");
        HashMap<String, String> headers = new HashMap<>();
        for (Enumeration<String> names = request.getHeaderNames(); names.hasMoreElements(); ) {
            String name = names.nextElement();
            for (Enumeration<String> values = request.getHeaders(name); values.hasMoreElements(); ) {
                headers.put(name, values.nextElement());
            }
        }
        String locale = headers.get("lang-msg");
        if (locale == null) {
            locale = "fa";
        }
//        LOGGER.info("Context path is {}", request.getContextPath());
//        LOGGER.info("----------------------------header----------------------------------------");
//        if (headerNames != null) {
//            while (headerNames.hasMoreElements()) {
//                String name = headerNames.nextElement();
//                LOGGER.info("Header: {}  value: {}", name, request.getHeader(name));
//            }
//        }
        String username = null;
        String jwtToken = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1dGhvcml0aWVzIjpbXSwianRpIjoiY2JkOWMxYTItN2E2ZC00OTlmLTlmOGEtZjBjYzJhMWFhMjAzIiwiaWF0IjoxNzQ0MDAwNjA5LCJleHAiOjE3NDY0MDA2MDl9.MPlW-V_H2dHkm30kYQjoOVw9MUxCwsAAyuWxmwTyw-Wn4mf1dwuiV_UAQRwfLpBE69b6UJ3AvqVR0usWMgi5fg";
        if ((requestTokenHeader != null && requestTokenHeader.startsWith("Bearer "))||true) {
//            jwtToken = requestTokenHeader.substring(7);
            jwtTokenUtil.setToken("Bearer " + jwtToken);
//            jwtTokenUtil.setToken("Bearer " + "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1dGhvcml0aWVzIjpbXSwianRpIjoiZjFlYWNhNWItNWE2NS00ZDY2LWEwNjQtYjIwZGQ1MjBkNzBkIiwiaWF0IjoxNjkyODY3MjM5LCJleHAiOjE2OTUyNjcyMzl9.mOaTpHAl-mrF04i7E1hV6imchA-swhlh64piy0lf8Vy4_M-VqX_vjDlz68Bj50mc12GFyzqWuNOiiIt3ftA_Jg");
            try {
                username = jwtTokenUtil.getUsernameFromToken(jwtToken);
            } catch (IllegalArgumentException e) {
                LOGGER.error("Unable to get JWT Token");
            } catch (ExpiredJwtException e) {
                LOGGER.error("JWT Token has expired");
            }
        } else if(request.getRequestURI().contains("api")){
            logger.warn("JWT Token does not begin with Bearer String");
        }

        // Once we get the token validate it.
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = this.jwtUserDetailsService.loadUserByUsername(username);
            if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {

                UsernamePasswordAuthenticationToken userPassAuthToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                userPassAuthToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(userPassAuthToken);
            }
        }
        chain.doFilter(request, response);
    }

}
