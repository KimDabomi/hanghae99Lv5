package org.sparta.hanghae99lv5.dto;

import lombok.Getter;
import org.sparta.hanghae99lv5.entity.Cart;

@Getter
public class UserRequestDto {
    private String email;
    private String password;
    private String gender;
    private String phone;
    private String address;
    private String auth;
}
