package com.spring.hycspringboot.controller;

import com.spring.hycspringboot.domain.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HellowController {
    @RequestMapping("/hellow" )
    public User hellow() {
        User u = new User();
        u.setName("fuck");
        return u;
    }

}
