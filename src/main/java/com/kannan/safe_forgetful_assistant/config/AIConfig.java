package com.kannan.safe_forgetful_assistant.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.InMemoryChatMemoryRepository;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AIConfig {
    @Bean
    public ChatClient chatClient(ChatClient.Builder chatClientBuilder) {
        return chatClientBuilder.build();
    }

    @Bean
    public MessageWindowChatMemory chatMemory() {

        return MessageWindowChatMemory.builder()
                .chatMemoryRepository(
                        new InMemoryChatMemoryRepository()
                )
                .maxMessages(3)
                .build();
    }
}
