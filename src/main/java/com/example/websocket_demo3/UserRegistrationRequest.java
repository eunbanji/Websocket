package com.example.websocket_demo3;

public class UserRegistrationRequest {
    private String email;
    private String password;
    private String inviteCode;

    // Getters and Setters

    // User 엔티티로 변환
    public User toUser() {
        User user = new User();
        user.setEmail(this.email);
        user.setPassword(this.password);
        return user;
    }
}
