package com.example.lucy;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.HashMap;

@RestController
public class Controller {
    @RequestMapping("/hijson")
    public String hi(HttpServletRequest req, HttpServletResponse res, @RequestBody HashMap<String, String> xss) throws IOException {
        System.out.println("req = " + xss);
        return xss.get("xss");
    }

    @RequestMapping("/hitext")
    public String hi(HttpServletRequest req, HttpServletResponse res, @RequestParam String xss) throws IOException {
        System.out.println("req = " + req.getParameter("xss"));
        return "<li>content</li>";
    }

    @RequestMapping("/csrf")
    public void csrf(@RequestBody HashMap<String, Object> csrf) {
        System.out.println(csrf);
    }
}
