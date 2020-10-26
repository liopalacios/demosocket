package com.example.socket.demo.websocket2;

import javax.websocket.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@ClientEndpoint
public class WebsocketDemo2 extends Endpoint {
    Session session;
    private WebSocketContainer container;

    @Override
    public void onOpen(Session session, EndpointConfig endpointConfig) {
        this.session = session;

        this.session.addMessageHandler(new MessageHandler.Whole<String>() {
            @Override
            public void onMessage(String s) {
                System.out.println(s);
            }
        });
    }

    @Override
    public void onError(Session session, Throwable throwable) {
        super.onError(session, throwable);
    }

    public void connect() throws DeploymentException, IOException, URISyntaxException{
        this.container = ContainerProvider.getWebSocketContainer();
        ClientEndpointConfig config = ClientEndpointConfig.Builder.create()
                .configurator(new ClientEndpointConfig.Configurator())
                .build();
        container.connectToServer(this,config,new URI("ws://sig.sutran.gob.pe"));
    }

    public WebsocketDemo2() {

    }
    public void send_message(String msg) throws IOException {
        this.session.getBasicRemote().sendText(msg);
    }
}
