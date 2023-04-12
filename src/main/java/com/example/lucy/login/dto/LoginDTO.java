package com.example.lucy.login.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginDTO {

    @NotEmpty
    @Pattern(regexp = "(?=.*[a-z0-9])(?=\\S+$).{5,15}",
            message = "ID는 영문 소문자, 숫자로 5자 ~ 15자로 입력하세요.(공백불가)")
    private String userId;

    @NotEmpty
    @Pattern(regexp="(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,20}",
            message = "PW는 영문 대 소문자와 숫자, 특수문자가 적어도 1개 이상씩 포함된 8자 ~ 20자로 입력하세요.(공백불가)")
    private String userPw;

    private String userRole;

}
