package com.unsplash.sdk.unit.config;

import com.unsplash.sdk.config.RestTemplateConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.lang.reflect.Method;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class RestTemplateConfigTest {

    @Autowired
    private RestTemplateConfig config;

    @Test
    public void configLoads() {
        assertThat(config).isNotNull();
    }

    @Test
    public void testRestTemplateConfig() throws NoSuchMethodException {
        String methodName = "init";
        Class<?> c = RestTemplateConfig.class;
        Method method = c.getDeclaredMethod(methodName);
        assertNotNull(method);
    }
}
