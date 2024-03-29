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

		final String requestTokenHeader = request.getHeader("Authorization");

        Enumeration<String> headerNames = request.getHeaderNames();
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
        LOGGER.info("Context path is {}", request.getContextPath());
        LOGGER.info("----------------------------header----------------------------------------");
        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                String name = headerNames.nextElement();
                LOGGER.info("Header: {}  value: {}", name, request.getHeader(name));
            }
        }
        String username = null;
        String jwtToken = null;
		// JWT Token is in the form "Bearer token". Remove Bearer word and get
		// only the Token
        if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
            jwtToken = requestTokenHeader.substring(7);
            jwtTokenUtil.setToken("Bearer " + jwtToken);
            try {
                username = jwtTokenUtil.getUsernameFromToken(jwtToken);
            } catch (IllegalArgumentException e) {
                LOGGER.error("Unable to get JWT Token");
            } catch (ExpiredJwtException e) {
                LOGGER.error("JWT Token has expired");
            }
		} else {
            logger.warn("JWT Token does not begin with Bearer String");
        }

        // Once we get the token validate it.
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = this.jwtUserDetailsService.loadUserByUsername(username);

			// if token is valid configure Spring Security to manually set
			// authentication
            if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {

				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				// After setting the Authentication in the context, we specify
				// that the current user is authenticated. So it passes the
				// Spring Security Configurations successfully.
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        chain.doFilter(request, response);
    }

}
