package com.example.lucy.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/*import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;*/
import java.io.IOException;
import java.util.HashMap;

@Slf4j
@RestController
public class Controller {
    @RequestMapping("/hijson")
    public String hi(HttpServletRequest req, HttpServletResponse res, @RequestBody HashMap<String, String> xss, HttpSession session) throws IOException {
        Cookie[] cookie = req.getCookies();
        System.out.println("req = " + xss);
        log.info("Session id = {}", session.getId());
        log.info("Session = {}", session);
        log.info("CookieName = {}", cookie[0].getName());
        log.info("CookieValue = {}", cookie[0].getValue());
        Cookie cookie2 = new Cookie("hihi", "hihhihi");
        cookie2.setHttpOnly(false);
        res.addCookie(cookie2);
        return xss.get("xss");
    }

    @RequestMapping("/hitext")
    public String hi(HttpServletRequest req, HttpServletResponse res, @RequestParam String xss) throws IOException {
        System.out.println("xss = " + xss);
        return xss;
    }

    @RequestMapping("/csrf")
    public void csrf(@RequestBody HashMap<String, Object> csrf) {
        System.out.println(csrf);
    }
}
