package com.kannan.safe_forgetful_assistant.controller;

import com.kannan.safe_forgetful_assistant.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ChatController {

    private final ChatService chatService;

    @GetMapping("/chat")
    public String chat(
            @RequestParam String message
    ) {

        return chatService.chat(message);
    }
}