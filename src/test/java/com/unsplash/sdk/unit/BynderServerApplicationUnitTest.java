package com.unsplash.sdk.unit;

import com.unsplash.sdk.BynderServerApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class BynderServerApplicationUnitTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void contextLoads() {
        assertThat(applicationContext).isNotNull();
    }

    @Test
    public void mainMethodTest() throws NoSuchMethodException, SecurityException {
        String methodName = "main";
        Class<?> c = BynderServerApplication.class;
        Method method = c.getDeclaredMethod(methodName, String[].class);
        assertNotNull(method);
    }
}
