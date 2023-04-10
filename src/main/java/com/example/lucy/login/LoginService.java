package com.example.lucy.login;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final LoginDao loginDao;

    public void insertUser(LoginDto loginDto) {
        loginDao.insertUser(loginDto);
    }
}
