package co.shop.service;


import co.shop.model.dto.UserDto;
import co.shop.model.entity.user.JwtUser;
import co.shop.model.entity.user.User;
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
        User tscUser = userRepository.findByUserName(loginId);
        if (tscUser == null) {
            throw new UsernameNotFoundException("User not found with username: " + loginId);
        }
        return JwtUserFactory.create(tscUser);
    }

    public User save(UserDto user) {
        User newUser = new User();
        newUser.setName(user.getName());
        newUser.setFamily(user.getFamily());
        newUser.setNationalCode(user.getNationalCode());
        newUser.setEnabled(user.getActive());
        newUser.setPhone(user.getPhoneNumber());
        newUser.setUserName(user.getUserName());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        newUser.setCreateDate(null);
        return userRepository.save(newUser);
    }

}
