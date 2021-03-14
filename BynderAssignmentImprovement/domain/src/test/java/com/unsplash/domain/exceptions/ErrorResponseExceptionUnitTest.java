package com.unsplash.domain.exceptions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ErrorResponseExceptionUnitTest {

    @Mock
    private ErrorResponseException errorResponseException;

    @Test
    public void testGetResponse() {
        when(errorResponseException.getResponse())
                .thenReturn(ResponseEntity.ok("ok"));

        errorResponseException.getResponse();
        verify(errorResponseException, times(1)).getResponse();
    }
}
