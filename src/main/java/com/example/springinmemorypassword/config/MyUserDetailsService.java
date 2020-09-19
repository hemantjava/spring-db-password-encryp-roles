package com.example.springinmemorypassword.config;

import com.example.springinmemorypassword.entity.User;
import com.example.springinmemorypassword.entity.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException {

        final Optional<User> userOptional = userRepository.findByUsername(username);
        userOptional.orElseThrow(( ) -> new UsernameNotFoundException("Not Found Exception"));
        return userOptional.map(CustomUserDetails::new).get();
    }


}
