package com.springdemo.flyhighproject.payload;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignUpResponse {

    private String username;
    private String email;

}
