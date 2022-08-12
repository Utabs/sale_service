package co.shop.security;

import co.shop.model.entity.user.JwtUser;
import co.shop.model.entity.user.Role;
import co.shop.model.entity.user.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;


import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public final class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser create(User user) {
        return new JwtUser(
                user.getId(),
                user.getUserName(),
                user.getName(),
                user.getFamily(),
                user.getNationalCode(),
                user.getPassword(),
                mapToGrantedAuthorities(user.getRoles()),true,new Date() );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(Collection<Role> authorities) {
        return authorities.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getName()))
                .collect(Collectors.toList());
    }
}
