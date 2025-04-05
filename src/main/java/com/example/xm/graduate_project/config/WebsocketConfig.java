package com.example.xm.graduate_project.config;

import com.example.xm.graduate_project.config.condition.WebSocketCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Conditional;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@Configuration
public class WebsocketConfig {
    @Bean
    @Conditional(WebSocketCondition.class)
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
