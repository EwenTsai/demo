package com.example.demo.user.vo;

import com.example.demo.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 用户前端展示对象
 * @author Roy Chen
 * @version 1.0.0
 */
@Data
@AllArgsConstructor
public class UserVO {

    private Integer id;

    private String nickname;

    public static UserVO convert(User user) {
        return new UserVO(user.getId(), user.getNickname());
    }

}
