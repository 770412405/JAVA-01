package com.example.xz.v2;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Table(name = "account")
@ToString
public class Account2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @Column(name = "name")
//    @TableField("name")
    private String name;

    @Column(name = "phone")
//    @TableField("phone")
    private String phone;

    @Column(name = "money")
    private BigDecimal money;
}
