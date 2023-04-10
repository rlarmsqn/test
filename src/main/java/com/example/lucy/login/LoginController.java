package com.example.lucy.login;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;

    @RequestMapping("/user")
    public void userInsert(@RequestBody LoginDto loginDto) {
        System.out.println(loginDto.toString());
        loginService.insertUser(loginDto);

//        return new ResponseEntity("success", HttpStatus.OK);
    }
}
