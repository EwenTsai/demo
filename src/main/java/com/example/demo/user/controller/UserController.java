package com.example.demo.user.controller;

import com.example.demo.common.util.JwtUtils;
import com.example.demo.user.dto.UserDTO;
import com.example.demo.user.service.UserService;
import com.example.demo.common.util.Result;
import com.example.demo.user.vo.UserVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/login")
    public Result<?> login(@Valid UserDTO user) {
        String token = userService.login(user);
        if (StringUtils.isNotEmpty(token)) {
            return Result.success(token);
        }
        return Result.failed("用户名或密码错误");
    }

    @PostMapping("/register")
    public Result<?> register(@Valid UserDTO user) {
        if (userService.isUsernameValid(user.getUsername())) {
            userService.register(user);
            return Result.success(null, "注册成功");
        }
        return Result.failed("该用户名已被注册");
    }

    @GetMapping("/get")
    public Result<?> getUserInfo(HttpServletRequest request) {
        String token = JwtUtils.getRequestToken(request);
        UserVO vo = userService.getUserInfo(token);
        if (vo != null) {
            return Result.success(vo);
        }
        return Result.unauthorized();
    }

}
