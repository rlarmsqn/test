package com.example.lucy.login;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LoginDao {
    void insertUser(LoginDto loginDto);
//    LoginDto selectUser();
}
