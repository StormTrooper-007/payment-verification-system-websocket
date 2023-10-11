package com.example.paymentverificationsystemwebsocket;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;


@Service
@RequiredArgsConstructor
public class WebSocketService  extends TextWebSocketHandler {
    private final WebSocketSessionManager sessionManager;
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception{
        sessionManager.addNewSession(session);
        //session.sendMessage(new TextMessage("connected"));
        System.out.println("connected");
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
        String receivedMessage = message.getPayload();
        System.out.println("recieved message: " + receivedMessage);
        try{
            sessionManager.sendMessage(new TextMessage(receivedMessage));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws IOException {

    }
}
