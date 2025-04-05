// src/main/java/com/example/xm/graduate_project/config/condition/WebSocketCondition.java
package com.example.xm.graduate_project.config.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import javax.servlet.ServletContext;

public class WebSocketCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        try {
            Class.forName("javax.websocket.server.ServerContainer");
            ServletContext servletContext = context.getBeanFactory().getBean(ServletContext.class);
            return servletContext != null;
        } catch (Exception e) {
            return false;
        }
    }
}