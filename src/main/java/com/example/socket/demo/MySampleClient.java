package com.example.socket.demo;

import lombok.Getter;
import lombok.SneakyThrows;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.net.URI;
import java.util.concurrent.ExecutionException;

public class MySampleClient extends TextWebSocketHandler {
    @Getter
    private WebSocketSession clientSession;

    public MySampleClient () throws ExecutionException, InterruptedException {
        StandardWebSocketClient webSocketClient = new StandardWebSocketClient();
       // this.clientSession = webSocketClient.doHandshake(this, new WebSocketHttpHeaders(), URI.create("wss://sig.sutran.gob.pe")).get();
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) {
        System.out.println(message.getPayload());
    }

    @SneakyThrows
    public static void main(String[] args)  {
        MySampleClient sampleClient =  new MySampleClient();
        //sampleClient.getClientSession().sendMessage(new TextMessage("Hello!"));
        Thread.sleep(2000);
    }
}
