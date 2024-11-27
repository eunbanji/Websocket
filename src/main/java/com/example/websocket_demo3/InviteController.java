package com.example.websocket_demo3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class InviteController {

    @Autowired
    private InviteCodeService inviteCodeService; // InviteCodeService를 통해 초대 코드를 관리

    /**
     * 초대 코드를 생성하는 엔드포인트
     * @return 초대 코드를 담은 JSON 형태의 응답
     */
    @PostMapping("/generateInviteCode")
    public Map<String, String> generateInviteCode() {
        Map<String, String> response = new HashMap<>();
        try {
            // 고유한 초대 코드 생성 및 저장
            String inviteCode = inviteCodeService.generateInviteCode();
            inviteCodeService.saveInviteCode(inviteCode);
            response.put("inviteCode", inviteCode);
        } catch (Exception e) {
            // 예외 발생 시 오류 메시지를 JSON으로 반환
            response.put("error", "Failed to generate invite code");
        }
        return response;
    }

}
