package com.example.demo.security.service.impl;

import com.example.demo.model.entity.Role;
import com.example.demo.model.entity.UserRole;
import com.example.demo.model.repository.RoleRepository;
import com.example.demo.model.repository.UserRoleRepository;
import com.example.demo.security.entity.SimpleUserDetails;
import com.example.demo.security.service.SimpleUserDetailsService;
import com.example.demo.model.entity.User;
import com.example.demo.model.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SimpleUserDetailsServiceImpl implements SimpleUserDetailsService {

    @Resource
    private UserRepository userRepository;

    @Resource
    private UserRoleRepository userRoleRepository;

    @Resource
    private RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(s);
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        if (user.isPresent()){
            List<UserRole> userRoles = userRoleRepository.findByUserId(user.get().getId().toString());
            for (UserRole userRole : userRoles) {
                Optional<Role> role = roleRepository.findById(userRole.getId());
                if (role.isPresent() && role.get().getRoleName() != null) {
                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_"+role.get().getRoleName());
                    grantedAuthorities.add(grantedAuthority);
                }
            }
            return new org.springframework.security.core.userdetails.User(user.get().getUsername(), user.get().getPassword(), grantedAuthorities);
        }
        return null;
    }
}
