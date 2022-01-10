package com.WebSocket.Backend.Model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private Integer id;
    private String message;

}