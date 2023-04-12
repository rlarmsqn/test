package com.example.lucy.login.service;

import com.example.lucy.login.LoginMapper;
import com.example.lucy.login.dto.LoginDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class LoginService {
    private final LoginMapper loginMapper;

    public String userInsert(LoginDTO loginDto) {
        String registerId = loginDto.getUserId();
        List<LoginDTO> list = loginMapper.userSelectList();
        for(int i=0; i < list.size(); i++) {
            String userId = list.get(i).getUserId();
            if(registerId.equals(userId)) {
                return "중복된 ID입니다.";
            }
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(7);
        String result = encoder.encode(loginDto.getUserPw());
        loginDto.setUserPw(result);
        loginMapper.userInsert(loginDto);

        return "등록되었습니다.";
    }

}
