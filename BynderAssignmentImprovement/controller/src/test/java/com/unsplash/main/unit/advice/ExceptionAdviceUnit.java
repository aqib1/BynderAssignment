package com.unsplash.main.unit.advice;

import com.unsplash.main.controller.advice.ExceptionAdvice;
import com.unsplash.domain.exceptions.ErrorResponseException;
import com.unsplash.domain.response.ResponseError;
import com.unsplash.utilities.testhelper.DataHelper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ExceptionAdviceUnit {

    private final DataHelper dataHelper = DataHelper.getInstance();

    @Mock
    private ExceptionAdvice advice;

    @Test
    public void testHandleEmptyStackException() {
        when(advice.handleErrorResponseException(any(ErrorResponseException.class)))
                .thenReturn(dataHelper.errorResponseEntity());

        ResponseEntity<ResponseError> response = advice.handleErrorResponseException(dataHelper.errorResponseException());

        assertEquals(dataHelper.errorResponseEntity(), response);

        Mockito.verify(advice, times(1))
                .handleErrorResponseException(any(ErrorResponseException.class));
    }

    @Test
    public void testHandleHttpClientErrorException() {
        when(advice.handleHttpClientErrorException(any(HttpClientErrorException.class)))
                .thenReturn(dataHelper.errorResponseEntity());

        ResponseEntity<ResponseError> response = advice.handleHttpClientErrorException(dataHelper.httpClientErrorException());

        assertEquals(dataHelper.errorResponseEntity(), response);

        Mockito.verify(advice, times(1))
                .handleHttpClientErrorException(any(HttpClientErrorException.class));
    }

    @Test
    public void testHandleRuntimeException() {
        when(advice.handleRuntimeException(any(RuntimeException.class)))
                .thenReturn(dataHelper.errorResponseEntity());

        ResponseEntity<ResponseError> response = advice.handleRuntimeException(dataHelper.httpRuntimeException());

        assertEquals(dataHelper.errorResponseEntity(), response);

        Mockito.verify(advice, times(1))
                .handleRuntimeException(any(RuntimeException.class));
    }
}
