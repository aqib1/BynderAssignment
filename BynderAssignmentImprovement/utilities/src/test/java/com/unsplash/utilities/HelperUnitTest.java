package com.unsplash.utilities;

import com.unsplash.utilities.testhelper.DataHelper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class HelperUnitTest {

    private final DataHelper dataHelper = DataHelper.getInstance();

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
