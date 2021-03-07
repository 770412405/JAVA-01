package com.example.xz.model;


import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Table(name = "account")
//@TableName("account")
@ToString
public class Account1 {

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
//    @TableField("money")
    private BigDecimal money;
}
