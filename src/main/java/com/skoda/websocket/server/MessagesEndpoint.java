/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skoda.websocket.server;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author andrej
 */
@ServerEndpoint("/messages")
public class MessagesEndpoint {
    private Session session;
    
    @OnOpen
    public void init(Session session){
        this.session = session;
    }
    
    @OnMessage
    public void onMessage(String message){
        System.out.println("---"+ message);
        try {
            this.session.getBasicRemote().sendText("Echo: "+message);
        } catch (IOException ex) {
            Logger.getLogger(MessagesEndpoint.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
