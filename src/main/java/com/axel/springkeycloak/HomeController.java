package com.axel.springkeycloak;

import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String home() {
        return "homepage (public)";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest httpServletRequest) throws ServletException {

        httpServletRequest.logout();
        return "logged out";
    }
}