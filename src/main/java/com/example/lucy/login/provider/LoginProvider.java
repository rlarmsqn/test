/*
package com.example.lucy.login.provider;

import com.example.lucy.login.dto.LoginDTO;
import com.example.lucy.login.dto.UserDetailsDTO;
import com.example.lucy.login.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class LoginProvider implements AuthenticationProvider {

    private final LoginService loginService;

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Object details = authentication.getDetails();

        String userId = authentication.getName();
        String userPw = (String) authentication.getCredentials();

        log.info("details : {}", authentication);
        log.info("userId : {}", userId);
        log.info("userPw : {}", userPw);

        String resultUserPw = "";
        Object resultObj = null;

        LoginDTO param = new LoginDTO();
        param.setUserId(userId);
        param.setUserPw(userPw);

        UserDetailsDTO userInfo = loginService.userSelect(userId);

        // 사용자 존재여부
        if(userInfo == null) {
            throw new BadCredentialsException("아이디가 존재하지 않습니다.");
        } else {
            resultUserPw = userInfo.getUserPw();
            userInfo.setUserPw(null);
            resultObj = userInfo;
        }

        // 비밀번호 체크
        if(!userPw.equals(resultUserPw)) {
            throw new BadCredentialsException("비밀번호가 일치하지 않습니다.");
        }

        // 권한 리스트
        List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
        roles.add(new SimpleGrantedAuthority(userInfo.getUserRole()));

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userId, userPw, roles);
        authenticationToken.setDetails(resultObj);

        return authenticationToken;
    }
}
*/
