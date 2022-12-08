package co.shop.security;

import co.shop.model.entity.user.JwtUser;
import co.shop.model.entity.user.Role;
import co.shop.model.entity.user.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;


import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public final class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser create(Users users) {
        return new JwtUser(
                users.getId(),
                users.getUserName(),
                users.getName(),
                users.getFamily(),
                users.getNationalCode(),
                users.getPassword(),
                mapToGrantedAuthorities(users.getRoles()),true,new Date() );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(Collection<Role> authorities) {
        return authorities.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getName()))
                .collect(Collectors.toList());
    }
}
