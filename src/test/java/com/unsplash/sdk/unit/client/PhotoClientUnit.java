package com.unsplash.sdk.unit.client;

import com.unsplash.sdk.client.PhotoClient;
import com.unsplash.sdk.dto.request.LikePhotoRequest;
import com.unsplash.sdk.dto.request.PhotoRequest;
import com.unsplash.sdk.dto.request.RandomPhotoRequest;
import com.unsplash.sdk.dto.response.LikePhotoResponse;
import com.unsplash.sdk.dto.response.PhotoResponse;
import com.unsplash.sdk.helper.DataHelper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@SpringBootTest
public class PhotoClientUnit {

    @Autowired
    private DataHelper dataHelper;

    @Mock
    private PhotoClient client;

    @Test
    public void getAllPhotosTest() {
        when(client.getAll(any(PhotoRequest.class)))
                .thenReturn(dataHelper.getPhotos());

        PhotoResponse[] response = client.getAll(dataHelper.photoRequest());

        assertNotNull(response);
        verify(client, times(1)).getAll(any(PhotoRequest.class));
    }

    @Test
    public void getRandomPhotoTest() {
        when(client.random(any(RandomPhotoRequest.class)))
                .thenReturn(dataHelper.getPhoto());

        PhotoResponse response = client.random(dataHelper.randomPhotoRequest());

        assertNotNull(response);
        verify(client, times(1)).random(any(RandomPhotoRequest.class));
    }

    @Test
    public void likeTest() {
        when(client.like(any(LikePhotoRequest.class)))
                .thenReturn(dataHelper.likePhotoResponse());

        LikePhotoResponse response = client.like(dataHelper.likePhotoRequest());

        assertNotNull(response);
        verify(client, times(1)).like(any(LikePhotoRequest.class));
    }
}
