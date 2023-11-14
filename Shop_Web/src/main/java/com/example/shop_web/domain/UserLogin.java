package com.example.shop_web.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class UserLogin {
    private String username;
    private String password;

}
