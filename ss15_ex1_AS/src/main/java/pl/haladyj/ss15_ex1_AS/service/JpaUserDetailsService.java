package pl.haladyj.ss15_ex1_AS.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import pl.haladyj.ss15_ex1_AS.entity.User;
import pl.haladyj.ss15_ex1_AS.repository.UserRepository;
import pl.haladyj.ss15_ex1_AS.security.model.SecurityUser;

public class JpaUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository
                .findUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));

        var securityUser =new SecurityUser(user);

        return securityUser;
    }
}
