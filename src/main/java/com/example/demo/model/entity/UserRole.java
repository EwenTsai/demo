package com.example.demo.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "user_role")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "role_id")
    private String roleId;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "create_user")
    private String user;
}
