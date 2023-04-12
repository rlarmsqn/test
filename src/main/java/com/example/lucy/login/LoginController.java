package com.example.lucy.login;

import com.example.lucy.login.dto.LoginDTO;
import com.example.lucy.login.service.LoginService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;

    @PostMapping("/user")
    public ResponseEntity userInsert(@RequestBody @Valid LoginDTO loginDto, Errors errors) {

        if(errors.hasErrors()) {
            List<ObjectError> list = errors.getAllErrors();
            return new ResponseEntity(list.get(0).getDefaultMessage(), HttpStatus.BAD_REQUEST);
        }

         HttpHeaders header = new HttpHeaders();
         header.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

         return new ResponseEntity(loginService.userInsert(loginDto), header, HttpStatus.OK);
    }

}
