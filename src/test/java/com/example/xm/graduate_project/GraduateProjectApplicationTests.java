package com.example.xm.graduate_project;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@SpringBootTest
public class GraduateProjectApplicationTests {

    @MockBean // 模拟ServerEndpointExporter，避免真实初始化
    private ServerEndpointExporter serverEndpointExporter;

    @Test
    public void contextLoads() {
        // 测试通过
    }
}