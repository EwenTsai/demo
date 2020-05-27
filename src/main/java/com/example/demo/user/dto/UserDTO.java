package com.example.demo.user.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * 用户转换对象
 * @author Roy Chen
 * @version 1.0.0
 */
@Data
public class UserDTO {

    @NotBlank(message = "用户名不能为空")
    @Pattern(regexp = "^[a-zA-Z0-9_-]{4,16}$", message = "用户名长度为4-16（字母，数字，下划线，减号）")
    private String username;

    @NotBlank(message = "密码不能为空")
    @Pattern(regexp = "^[a-zA-Z0-9_-]{6,16}$", message = "密码长度为6-16（字母，数字，下划线，减号）")
    private String password;

}
