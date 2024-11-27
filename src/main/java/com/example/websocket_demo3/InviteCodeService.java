package com.example.websocket_demo3;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Service
public class InviteCodeService {
    private Set<String> inviteCodes = new HashSet<>(); // 초대 코드 목록을 저장하는 Set

    /**
     * 초대 코드를 저장하는 메서드
     * @param inviteCode 저장할 초대 코드
     */
    public void saveInviteCode(String inviteCode) {
        inviteCodes.add(inviteCode);
    }

    /**
     * 초대 코드가 유효한지 확인하는 메서드
     * @param inviteCode 확인할 초대 코드
     * @return 유효한 경우 true, 아니면 false
     */
    public boolean isInviteCodeValid(String inviteCode) {
        return inviteCodes.contains(inviteCode);
    }

    /**
     * 사용된 초대 코드를 제거하는 메서드
     * @param inviteCode 제거할 초대 코드
     */
    public void removeInviteCode(String inviteCode) {
        inviteCodes.remove(inviteCode);
    }

    /**
     * 새로운 고유 초대 코드를 생성하는 메서드
     * @return 생성된 초대 코드 (8자리)
     */
    public String generateInviteCode() {
        return UUID.randomUUID().toString().substring(0, 8); // 8자리로 자른 고유 초대 코드
    }
}
