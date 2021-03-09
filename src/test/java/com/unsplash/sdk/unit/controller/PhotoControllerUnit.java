package com.unsplash.sdk.unit.controller;

import com.unsplash.sdk.controller.PhotoController;
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

@SpringBootTest
public class PhotoControllerUnit {

    @Autowired
    private DataHelper dataHelper;

    @Mock
    private PhotoController controller;

    @Test
    public void getAllPhotosTest() {
        when(controller.getAll(any(PhotoRequest.class)))
                .thenReturn(dataHelper.getPhotos());

        PhotoResponse[] response = controller.getAll(dataHelper.photoRequest());

        assertNotNull(response);
        verify(controller, times(1)).getAll(any(PhotoRequest.class));
    }

    @Test
    public void getRandomPhotoTest() {
        when(controller.random(any(RandomPhotoRequest.class)))
                .thenReturn(dataHelper.getPhoto());

        PhotoResponse response = controller.random(dataHelper.randomPhotoRequest());

        assertNotNull(response);
        verify(controller, times(1)).random(any(RandomPhotoRequest.class));
    }

    @Test
    public void likeTest() {
        when(controller.like(any(LikePhotoRequest.class)))
                .thenReturn(dataHelper.likePhotoResponse());

        LikePhotoResponse response = controller.like(dataHelper.likePhotoRequest());

        assertNotNull(response);
        verify(controller, times(1)).like(any(LikePhotoRequest.class));
    }
}
