package com.example.demo.user.service.impl;

import com.example.demo.common.util.JwtUtils;
import com.example.demo.redis.service.RedisService;
import com.example.demo.user.dto.UserDTO;
import com.example.demo.user.entity.User;
import com.example.demo.user.repository.UserRepository;
import com.example.demo.security.util.SecurityUtils;
import com.example.demo.user.service.UserService;
import com.example.demo.user.vo.UserVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Value(value = "${token.expires.hours}")
    private long tokenExpiresHours;

    @Resource
    private UserRepository userRepository;

    @Resource
    private RedisService redisService;

    @Override
    public void register(UserDTO dto) {
        User user = new User();
        Date now = new Date();
        user.setUsername(dto.getUsername());
        user.setPassword(SecurityUtils.encode(dto.getPassword()));
        user.setNickname(String.valueOf(now.getTime()));
        user.setCreatedTime(now);
        user.setUpdatedTime(now);
        userRepository.save(user);
    }

    @Override
    public String login(UserDTO dto) {
        Optional<User> user = userRepository.findByUsername(dto.getUsername());
        if (user.isEmpty() || !SecurityUtils.matches(dto.getPassword(), user.get().getPassword())) {
            return null;
        }
        String token = JwtUtils.generateToken(user.get(), tokenExpiresHours);
        redisService.store(token, user.get().getUsername(), tokenExpiresHours * 3600);
        return token;
    }

    @Override
    public boolean isUsernameValid(String username) {
        return userRepository.findByUsername(username).isEmpty();
    }

    @Override
    public UserVO getUserInfo(String token) {
        String username = redisService.get(token).toString();
        Optional<User> user = userRepository.findByUsername(username);
        return user.isEmpty() ? null : UserVO.convert(user.get());
    }

}
