package com.mcp.mcpapp;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.atomic.AtomicReference;

@SpringBootApplication
public class McpappApplication {

	public static void main(String[] args) {
		SpringApplication.run(McpappApplication.class, args);
	}

}
