package com.unsplash.sdk.unit.exception;

import com.unsplash.sdk.exception.ErrorResponseException;
import com.unsplash.sdk.helper.DataHelper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;

@SpringBootTest
public class ErrorResponseExceptionUnitTest {

    @Autowired
    private DataHelper dataHelper;

    @Mock
    private ErrorResponseException errorResponseException;

    @Test
    public void testGetResponse() {
        when(errorResponseException.getResponse())
                .thenReturn(dataHelper.responseEntity());

        errorResponseException.getResponse();
        verify(errorResponseException, times(1)).getResponse();
    }
}
