package com.mcp.mcpapp;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import java.util.concurrent.atomic.AtomicReference;

class NameMcpClientRunner implements ApplicationRunner, BeanNameAware {

    private final AtomicReference<String> beanName = new AtomicReference<>();
    private final ChatClient.Builder builder;

    NameMcpClientRunner(ChatClient.Builder builder) {
        this.builder = builder;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        var prompt = """
            what files are in the tmp folder, and of those file 
            which have the name that corresponds to a chinese greeting?
            """;
        var response = this.builder
			.build()
			.prompt(prompt)
			.call()
			.entity(ChineseFile.class);
		System.out.println("Bean name: " + this.beanName.get() + ": " + response);

    }

    @Override
    public void setBeanName(String name) {
        this.beanName.set(name);
    }
}
