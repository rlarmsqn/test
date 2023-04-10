package com.example.lucy.login;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final LoginMapper loginMapper;

    public void userInsert(LoginDTO loginDto) {
        String registerId = loginDto.getUserId();
        List<HashMap<String, Object>> result = loginMapper.userSelectList();
        for(int i=0; i < result.size(); i++) {
            String userId = (String) result.get(i).get("userId");
            System.out.println(userId);
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(7);
//        String result = encoder.encode(loginDto.getUserPw());
//        loginDto.setUserPw(result);
//        loginMapper.userInsert(loginDto);
    }
}
