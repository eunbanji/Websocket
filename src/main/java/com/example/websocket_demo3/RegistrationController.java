package com.example.websocket_demo3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @PostMapping
    public String registerUser(User user) {
        userService.registerUser(user);  // 사용자 정보 저장
        return "redirect:/main";  // 회원가입 후 로그인 페이지로 이동
    }
}
