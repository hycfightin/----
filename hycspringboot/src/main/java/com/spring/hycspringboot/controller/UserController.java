package com.spring.hycspringboot.controller;

import com.spring.hycspringboot.domain.User;
import com.spring.hycspringboot.repostry.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserRepository userRepository;
    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @PostMapping("/person/save")
    public User save(@RequestParam String name ,@RequestParam String age ,@RequestParam String company){
        User user = new User();
        user.setName(name);
        if(userRepository.save(user)){
            System.out.print("baocun "+ user.toString()+"在"+age+"岁加入了"+company);
        }
        return user;
    }
}
