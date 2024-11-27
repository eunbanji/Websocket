package com.example.websocket_demo3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private InviteCodeService inviteCodeService; // 초대 코드 관리 서비스

    @Autowired
    private UserService userService; // 사용자 관리 서비스 (저장 등)

    /**
     * 사용자 등록을 처리하는 엔드포인트
     * @param user 요청 본문에 담긴 사용자 정보
     * @return 등록 결과 메시지
     */
    @PostMapping("/user/register")
    public String registerUser(@RequestBody User user) {
        // 초대 코드가 유효한지 확인
        if (!inviteCodeService.isInviteCodeValid(user.getInviteCode())) {
            return "Invalid invite code.";
        }

        // 초대 코드가 유효하다면 사용자 저장
        userService.saveUser(user); // 사용자 저장
        inviteCodeService.removeInviteCode(user.getInviteCode()); // 사용된 초대 코드 제거

        return "Registration successful!";
    }
}
