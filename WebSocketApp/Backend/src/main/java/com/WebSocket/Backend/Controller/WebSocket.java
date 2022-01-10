package com.WebSocket.Backend.Controller;

import com.WebSocket.Backend.Model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebSocket {

    public static final String GENERAL_MESSAGE = "/topic/general";

    @Autowired
    SimpMessagingTemplate template;

    @PostMapping("/send/general")
    public ResponseEntity sendGeneralMessage(@RequestBody Message message) {
        template.convertAndSend(GENERAL_MESSAGE, message);
        return ResponseEntity.ok().body(message);
    }

    @MessageMapping("/general")
    @SendTo(GENERAL_MESSAGE)
    public Message broadcastGeneralMessage(@Payload Message message) {
        return message;
    }
}
