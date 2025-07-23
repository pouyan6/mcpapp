package com.mcp.mcpapp;

import io.modelcontextprotocol.client.McpClient;
import io.modelcontextprotocol.client.McpSyncClient;
import io.modelcontextprotocol.client.transport.HttpClientSseClientTransport;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.mcp.SyncMcpToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Call MCP Client
 */
@Configuration
public class BootMcpClientRunner {
    @Bean
    McpSyncClient mcpSyncClient() {
        var mcp =  McpClient
            .sync(new HttpClientSseClientTransport("http://localhost:8081"))
            .build();
        mcp.initialize();
        return mcp;
    }

    @Bean
    NameMcpClientRunner bootifulMcpClientRunner(ChatClient.Builder builder,
                                                McpSyncClient mcpSyncClient){
        var syncMcpToolCallbackProvider = new SyncMcpToolCallbackProvider(mcpSyncClient);
        return new NameMcpClientRunner(builder.defaultTools(syncMcpToolCallbackProvider));
    }
}
