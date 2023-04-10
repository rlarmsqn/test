package com.example.lucy.login;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface LoginMapper {
    void userInsert(LoginDTO loginDto);

    List<LoginDTO> userSelectList();
}
