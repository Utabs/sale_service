package co.shop.service;


import co.shop.model.dto.UserDto;
import co.shop.model.entity.user.JwtUser;
import co.shop.model.entity.user.Users;
import co.shop.repository.UserRepository;
import co.shop.security.JwtUserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SecUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;


    @Override
    public JwtUser loadUserByUsername(String loginId) throws UsernameNotFoundException {
        Users tscUsers = userRepository.findByUserName(loginId);
        if (tscUsers == null) {
            throw new UsernameNotFoundException("User not found with username: " + loginId);
        }
        return JwtUserFactory.create(tscUsers);
    }

    public Users save(UserDto user) {
        Users newUsers = new Users();
        newUsers.setName(user.getName());
        newUsers.setFamily(user.getFamily());
        newUsers.setNationalCode(user.getNationalCode());
        newUsers.setEnabled(user.getActive());
        newUsers.setPhone(user.getPhoneNumber());
        newUsers.setUserName(user.getUserName());
        newUsers.setPassword(bcryptEncoder.encode(user.getPassword()));
        newUsers.setCreateDate(null);
        return userRepository.save(newUsers);
    }

}
