package com.example.paymentverificationsystemwebsocket;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class WebSocketSessionManager {
    List<WebSocketSession> sessions = new ArrayList<>();

    public void addNewSession(WebSocketSession session){
        sessions.add(session);
    }

    public void sendMessage(TextMessage message) throws IOException {
        for (WebSocketSession session : sessions) {
            if(session.isOpen()){
                session.sendMessage(message);
            }
        }
    }
}
