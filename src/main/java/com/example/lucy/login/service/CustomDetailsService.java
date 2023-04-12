package com.example.lucy.login.service;

import com.example.lucy.login.LoginMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomDetailsService implements UserDetailsService {

    private final LoginMapper loginMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("username : {}", username);
        Optional<UserDetails> user = loginMapper.userSelect(username);
        log.info("user : {}", user);

        if(user.isEmpty()) {
            throw new UsernameNotFoundException("등록된 ID가 없습니다.");
        }

        log.info("user.get() : {}", user.get());

        return user.get();
    }

}
