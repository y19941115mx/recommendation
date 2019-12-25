package com.ymx.recommendation.model.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;

@Entity
@Data
@DynamicUpdate
public class User extends Base{

    private String nick_name;

    private String phone;

    private String password;

    private Integer gender=0;
}
