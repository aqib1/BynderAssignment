package com.unsplash.sdk.unit.dto.base;

import com.unsplash.sdk.dto.base.Base;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BaseUnitTest {
    @Test
    public void baseMethods() throws NoSuchMethodException, SecurityException {
        Class<?> c = Base.class;
        String methodName = "hashCode";
        Method method = c.getDeclaredMethod(methodName);
        assertNotNull(method);

        methodName = "equals";
        method = c.getDeclaredMethod(methodName, Object.class);
        assertNotNull(method);

        methodName = "toString";
        method = c.getDeclaredMethod(methodName);
        assertNotNull(method);
    }
}
