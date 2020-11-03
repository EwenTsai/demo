package com.example.demo.service;

import com.example.demo.model.dto.UserDTO;
import com.example.demo.model.vo.UserVO;

public interface UserService {

    /**
     * 用户注册
     * @param dto 用户dto
     */
    void register(UserDTO dto);

    /**
     * 用户登录
     * @param dto 用户dto
     * @return { token }
     */
    String login(UserDTO dto);

    /**
     * 用户名是否可用
     * @param username 用户名
     * @return { true or false }
     */
    boolean isUsernameValid(String username);

    /**
     * 获取用户信息
     * @param token 令牌
     * @return { user }
     */
    UserVO getUserInfo(String token);

}
