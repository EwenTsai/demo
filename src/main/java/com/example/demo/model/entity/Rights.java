package com.example.demo.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "rights")
public class Rights {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer right_id;

    @Column(name = "right_name")
    private String rightName;

    @Column(name = "right_code")
    private String rightCode;
}
