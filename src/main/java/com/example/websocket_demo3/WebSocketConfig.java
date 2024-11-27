package com.example.websocket_demo3;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.*;


// WebSocket 설정을 위한 클래스
@Configuration
@EnableWebSocket  // WebSocket을 활성화하는 애노테이션. 이 애노테이션을 통해 Spring에서 WebSocket을 지원하도록 설정함
public class WebSocketConfig implements WebSocketConfigurer {

    /**
     * WebSocket 핸들러를 등록하는 메서드.
     * 특정 URL 경로와 WebSocket 핸들러를 매핑하여 해당 경로로 들어오는 WebSocket 요청을 처리함.
     * @param registry WebSocket 핸들러를 등록할 수 있는 레지스트리 객체
     */
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        // WebSocket 핸들러 MyWebSocketHandler를 "/chat" 경로에 등록하고,
        // 모든 출처(origin)에서의 WebSocket 연결을 허용하기 위해 setAllowedOrigins("*")을 사용
        registry.addHandler(new MyWebSocketHandler(), "/chat").setAllowedOrigins("*");
    }


}
