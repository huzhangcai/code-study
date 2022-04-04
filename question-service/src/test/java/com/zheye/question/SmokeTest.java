package com.zheye.question;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author shkstart
 * 冒烟测试
 * @create 2022-03-31 20:06
 */
@SpringBootTest
@AutoConfigureMockMvc
public class SmokeTest {

    //可模拟mvc请求的mock类
    @Autowired
    private MockMvc mockMvc;

    /**
     * 关于actuator，的健康检查测试
     */
    @Test
    void shold_return_ok_when_request_endpoint_of_health() throws Exception {
        mockMvc
                .perform(get("/actuator/health"))
                .andExpect(status().isOk())//断言请求状态是否正常
                .andExpect(jsonPath( "$.status").value("UP"))//断言请求报文的“status”的值是否为“UP”

        ;
    }
}
