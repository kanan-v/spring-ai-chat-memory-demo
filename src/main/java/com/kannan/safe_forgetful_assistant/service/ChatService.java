package com.kannan.safe_forgetful_assistant.service;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SafeGuardAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatClient chatClient;
    private final MessageWindowChatMemory chatMemory;

    public String chat(String message) {

        // SAFETY GUARDRAIL
        if (message.toLowerCase().contains("competitor")) {
            return "Blocked by safety guardrail.";
        }

        return chatClient.prompt()
                .user(message)
                .advisors(
                        MessageChatMemoryAdvisor.builder(chatMemory)

                                .build(),

//                        new SafeGuardAdvisor(),

                        new SimpleLoggerAdvisor()
                )
                .advisors(advisorSpec ->
                        advisorSpec.param(
                                ChatMemory.CONVERSATION_ID,
                                "user-1"
                        )
                )


                .call()
                .content();
    }
}