package co.shop.controller;

import co.shop.model.dto.JwtRequest;
import co.shop.model.dto.JwtResponse;
import co.shop.model.dto.UserDto;
import co.shop.service.SecUserDetailsService;
import co.shop.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenUtil;

    @Autowired
    private SecUserDetailsService userDetailsService;

    //    @RolesAllowed(Role.AUTHOR_ADMIN)
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authRequest) throws AuthenticationException {
        UsernamePasswordAuthenticationToken authReqToken = new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authReqToken);
//        if (authenticate.isAuthenticated())
        SecurityContext sc =SecurityContextHolder.getContext();
        sc.setAuthentication(authenticate);

//        final JwtUser userDetails = userDetailsService.loadUserByUsername(authRequest.getUserName());

        final String token = jwtTokenUtil.generateToken(authenticate );

        return ResponseEntity.ok(new JwtResponse(token));
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody UserDto user) throws Exception {
        return ResponseEntity.ok(userDetailsService.save(user));
    }


    @Scope(value = "ADMIN")
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ResponseEntity<?> sayHello() throws Exception {
        return ResponseEntity.ok("Hellooooo");
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

}
