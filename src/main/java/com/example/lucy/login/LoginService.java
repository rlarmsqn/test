package com.example.lucy.login;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final LoginMapper loginMapper;

    public void userInsert(LoginDTO loginDto) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(7);
        String result = encoder.encode(loginDto.getUserPw());
        loginDto.setUserPw(result);
        loginMapper.userInsert(loginDto);
    }

    public List<LoginDTO> userSelectList() {
        return loginMapper.userSelectList();
    }
}
