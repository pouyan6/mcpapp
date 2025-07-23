# MCP App - Spring Boot Model Context Protocol Integration

A Spring Boot application demonstrating integration with the Model Context Protocol (MCP) for AI-powered filesystem analysis.

## Overview

This application showcases how to integrate Spring AI with MCP (Model Context Protocol) to create intelligent applications that can interact with external tools and services. The demo specifically demonstrates:

- Connecting to MCP filesystem servers
- Using AI to analyze file contents and names
- Identifying files with Chinese greeting names in a specified directory

## Features

- **MCP Integration**: Seamless connection to MCP servers using Spring AI's MCP client
- **Filesystem Analysis**: Intelligent file analysis using AI tools
- **Chinese Language Recognition**: Demonstrates AI's ability to identify Chinese greetings in filenames
- **Spring Boot**: Built on Spring Boot 3.4.4 with Java 21
- **Native Support**: Includes GraalVM native compilation support

## Technology Stack

- **Java 21**
- **Spring Boot 3.4.4**
- **Spring AI 1.0.0-M6**
  - OpenAI integration
  - MCP Client support
- **Maven** for dependency management
- **GraalVM** for native compilation

## Prerequisites

- Java 21 or higher
- Maven 3.6+
- Node.js and npm (for MCP filesystem server)
- OpenAI API key (optional, configured in application.properties)

## Configuration

### MCP Server Configuration

The application is configured to use the MCP filesystem server in `fs-config.json`:

```json
{
  "mcpServers": {
    "filesystem": {
      "command": "npx",
      "args": [
        "-y",
        "@modelcontextprotocol/server-filesystem",
        "/Users/pouyan/tmp"
      ]
    }
  }
}
```

### Application Properties

Configure your OpenAI API key in `application.properties`:

```properties
spring.application.name=mcpapp
spring.ai.openai.api-key=your-openai-api-key-here
spring.ai.mcp.client.stdio.servers-config=classpath:fs-config.json
```

## Getting Started

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd mcpapp
   ```

2. **Install MCP filesystem server**
   ```bash
   npm install -g @modelcontextprotocol/server-filesystem
   ```

3. **Configure OpenAI API Key**
   - Edit `src/main/resources/application.properties`
   - Add your OpenAI API key

4. **Update filesystem path**
   - Edit `src/main/resources/fs-config.json`
   - Update the path to point to your desired directory

5. **Run the application**
   ```bash
   ./mvnw spring-boot:run
   ```

## How It Works

1. **MCP Client Setup**: The `BootMcpClientRunner` configures and initializes the MCP sync client
2. **Tool Integration**: Spring AI's `SyncMcpToolCallbackProvider` integrates MCP tools with the chat client
3. **AI Analysis**: The application sends a prompt asking the AI to:
   - List files in the configured directory
   - Identify files with names corresponding to Chinese greetings
4. **Response Mapping**: Results are mapped to the `ChineseFile` record for structured output

## Project Structure

```
src/
├── main/
│   ├── java/com/mcp/mcpapp/
│   │   ├── McpappApplication.java          # Main Spring Boot application
│   │   ├── BootMcpClientRunner.java        # MCP client configuration
│   │   ├── NameMcpClientRunner.java        # Application runner with AI logic
│   │   └── ChineseFile.java                # Record for response mapping
│   └── resources/
│       ├── application.properties          # Spring configuration
│       └── fs-config.json                 # MCP server configuration
└── test/
    └── java/com/mcp/mcpapp/
        └── McpappApplicationTests.java     # Basic tests
```

## Building and Running

### Standard JAR
```bash
./mvnw clean package
java -jar target/mcpapp-0.0.1-SNAPSHOT.jar
```


## Example Output

When running, the application will analyze files in the configured directory and output something like:

```
Bean name: bootifulMcpClientRunner: ChineseFile[fileName=nihao.txt, word=你好]
```

## Customization

To adapt this application for your use case:

1. **Change the filesystem path** in `fs-config.json`
2. **Modify the AI prompt** in `NameMcpClientRunner.java`
3. **Update the response record** (`ChineseFile.java`) to match your data structure
4. **Add additional MCP servers** to the configuration as needed

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests if applicable
5. Submit a pull request

## License

This project is a demo/educational application. Please refer to the respective licenses of Spring Boot, Spring AI, and other dependencies.

## Resources

- [Spring AI Documentation](https://docs.spring.io/spring-ai/docs/current/reference/html/)
- [Model Context Protocol](https://modelcontextprotocol.io/)
- [MCP Filesystem Server](https://github.com/modelcontextprotocol/servers)
- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
