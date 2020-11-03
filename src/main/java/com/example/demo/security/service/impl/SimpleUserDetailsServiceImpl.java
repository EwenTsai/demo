package com.example.demo.security.service.impl;

import com.example.demo.security.entity.SimpleUserDetails;
import com.example.demo.security.service.SimpleUserDetailsService;
import com.example.demo.model.entity.User;
import com.example.demo.model.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class SimpleUserDetailsServiceImpl implements SimpleUserDetailsService {

    @Resource
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(s);
        return user.map(SimpleUserDetails::new).orElse(null);
    }

}
