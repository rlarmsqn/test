package com.example.lucy.login;

import com.example.lucy.login.dto.LoginDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Mapper
@Repository
public interface LoginMapper {
    void userInsert(LoginDTO loginDto);

    List<LoginDTO> userSelectList();

    Optional<UserDetails> userSelect(String userId);
}
