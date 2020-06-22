package com.danielei.entity;

import lombok.Data;

/**
 * 描述:
 * date: 2020/6/22 0022
 **/
@Data
public class User {
    private int id;
    private String name;
    private String email;
    private String passcode;


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", passcode='" + passcode + '\'' +
                '}';
    }
}
