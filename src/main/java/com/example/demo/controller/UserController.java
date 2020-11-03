package com.example.demo.controller;

import com.example.demo.common.util.JwtUtils;
import com.example.demo.model.dto.UserDTO;
import com.example.demo.service.UserService;
import com.example.demo.common.util.ResponseObject;
import com.example.demo.model.vo.UserVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    public ResponseEntity<ResponseObject<?>> login(@Valid UserDTO user) {
        String token = userService.login(user);
        if (StringUtils.isNotEmpty(token)) {
            return ResponseEntity.ok(ResponseObject.success(token));
        }
        return ResponseEntity.ok(ResponseObject.failed("用户名或密码错误"));
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseObject<?>> register(@Valid UserDTO user) {
        if (userService.isUsernameValid(user.getUsername())) {
            userService.register(user);
            return ResponseEntity.ok(ResponseObject.success(null, "注册成功"));
        }
        return ResponseEntity.ok(ResponseObject.failed("该用户名已被注册"));
    }

    @GetMapping("/get")
    @PreAuthorize("hasAnyRole('admin','user')")
    public ResponseEntity<ResponseObject<?>> getUserInfo(HttpServletRequest request) {
        String token = JwtUtils.getRequestToken(request);
        UserVO vo = userService.getUserInfo(token);
        if (vo != null) {
            return ResponseEntity.ok(ResponseObject.success(vo));
        }
        return ResponseEntity.ok(ResponseObject.unauthorized());
    }

}
