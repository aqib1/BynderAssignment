package com.unsplash.sdk.unit.utils;

import com.unsplash.sdk.helper.DataHelper;
import com.unsplash.sdk.utils.Helper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@SpringBootTest
public class HelperUnitTest {

    @Autowired
    private DataHelper dataHelper;

    @Mock
    private Helper helper;

    @Test
    public void testGetHttpEntity() {
        when(helper.getHttpEntity(anyString(), anyString(), anyString())).thenReturn(dataHelper.httpEntity());
        helper.getHttpEntity("", "", "");
        verify(helper, times(1)).getHttpEntity("", "", "");
    }

    @Test
    public void asJsonStringTest() {
        when(helper.asJsonString(isNull())).thenReturn("abc");
        helper.asJsonString(null);
        verify(helper, times(1)).asJsonString(null);
    }

    @Test
    public void jsonToObjectTest() {
        when(helper.jsonToObject(anyString(),isNull())).thenReturn(null);
        helper.jsonToObject("", null);
        verify(helper, times(1)).jsonToObject("", null);
    }
}
