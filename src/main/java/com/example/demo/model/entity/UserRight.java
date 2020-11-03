package com.example.demo.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "user_right")
public class UserRight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "right_id")
    private String rightId;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "create_user")
    private String user;
}
