package com.example.demo.model.vo;

import com.example.demo.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserVO {

    private Integer id;

    private String nickname;

    public static UserVO convert(User user) {
        return new UserVO(user.getId(), user.getNickname());
    }

}
