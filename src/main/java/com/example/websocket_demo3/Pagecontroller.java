package com.example.websocket_demo3;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Pagecontroller {

    @GetMapping("/main")
    public String mainPage() {
        return "main";  // main.jsp 또는 main.html 파일을 찾음
    }

    @GetMapping("/createAccount")
    public String createAccountPage() {
        return "Create_account";  // Create_account.jsp 또는 Create_account.html을 찾음
    }

    @GetMapping("/register")
    public String registerPage() {
        return "InviteFriend";
    }

    @GetMapping("/main_menu")
    public String mainMenuPage(Model model, @AuthenticationPrincipal User user) {
        // 현재 로그인된 사용자의 이메일을 모델에 추가
        String email = (user != null) ? user.getUsername() : "Guest";
        model.addAttribute("email", email);

        return "main_menu";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";  // login.jsp 또는 login.html 파일을 반환하도록 설정
    }

    @GetMapping("/chat")
    public String liveChatPage() {
        return "Live_chat";  // Live_chat.html 파일을 찾음
    }
}
