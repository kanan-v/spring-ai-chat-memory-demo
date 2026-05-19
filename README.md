# Safe & Forgetful Assistant 🤖

AI-powered conversational assistant built using Spring AI and Ollama.

This project demonstrates:
- conversational memory
- memory window management
- AI guardrails/safety filtering
- advisor-based prompt injection
- conversation logging

using Spring AI's advisor architecture.

---

# 🚀 Features

- Conversational AI chatbot
- Remembers user information
- Forgetful short-term memory
- AI safety guardrails
- Prompt logging
- Advisor-based architecture
- Local LLM using Ollama

---

# 🧠 Concepts Demonstrated

## 1️⃣ Chat Memory

The assistant remembers recent conversation history using:

```java
MessageWindowChatMemory
```

Example:

```text
User: Hi, I'm Alice
User: What is my name?
Bot: Alice
```

---

## 2️⃣ Forgetful Memory Window

Memory size is limited:

```java
.maxMessages(3)
```

After enough conversation turns, older messages are forgotten.

Example:

```text
1. Hi I'm Alice
2. Hello
3. How are you?
4. Tell me a joke
5. What is my name?
```

Response:

```text
I don't remember your name.
```

---

## 3️⃣ Safety Guardrails

The assistant blocks restricted terms before sending requests to the LLM.

Blocked word:

```text
competitor
```

Example:

```text
User: Tell me about competitor products
Bot: Blocked by safety guardrail.
```

---

## 4️⃣ Prompt Logging

Using:

```java
SimpleLoggerAdvisor
```

the full conversation history injected into the prompt is visible in application logs.

This demonstrates:
- advisor chaining
- memory injection
- prompt observability

---

# 🛠️ Tech Stack

- Java 21
- Spring Boot
- Spring AI
- Ollama
- Maven
- Lombok

---

# 📂 Project Structure

```text
src/main/java/com/kannan/safe_forgetful_assistant
│
├── controller
│   └── ChatController.java
│
├── service
│   └── ChatService.java
│
├── config
│   └── AIConfig.java
│
└── SafeForgetfulAssistantApplication.java
```

---

# ⚙️ Setup Instructions

## 1️⃣ Clone Repository

```bash
git clone https://github.com/kanan-v/safe-forgetful-assistant.git
cd safe-forgetful-assistant
```

---

## 2️⃣ Install Ollama

Download:

https://ollama.com/

---

## 3️⃣ Start Ollama

```bash
ollama serve
```

---

## 4️⃣ Pull Model

```bash
ollama pull llama3
```

---

## 5️⃣ Configure Application

`application.yaml`

```yaml
spring:
  application:
    name: safe-forgetful-assistant

  ai:
    ollama:
      base-url: http://localhost:11434

      chat:
        model: llama3

logging:
  level:
    org.springframework.ai: DEBUG
```

---

## 6️⃣ Run Application

```bash
./mvnw spring-boot:run
```

---

# 🎯 Example API

## Remember Name

### Request

```http
GET /chat?message=Hi I'm Alice
```

### Follow-up Request

```http
GET /chat?message=What is my name?
```

### Response

```text
Alice
```

---

# 🔒 Safety Example

### Request

```http
GET /chat?message=Tell me about competitor products
```

### Response

```text
Blocked by safety guardrail.
```

---

# 🧪 Forgetfulness Demo

Memory size:

```java
.maxMessages(3)
```

After enough messages, old context is removed automatically.

---

# 📊 Concepts Learned

- Conversational Memory
- Advisor Architecture
- AI Guardrails
- Prompt Injection
- Prompt Logging
- Context Windows
- Memory Eviction
- Local LLM Integration

---

# 👨‍💻 Author

Kannan V

---

# ⭐ If you found this useful

Give this repository a star ⭐
