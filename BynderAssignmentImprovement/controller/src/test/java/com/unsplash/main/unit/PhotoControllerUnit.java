package com.unsplash.main.unit;

import com.unsplash.main.controller.PhotoController;
import com.unsplash.domain.request.LikePhotoRequest;
import com.unsplash.domain.request.PhotoRequest;
import com.unsplash.domain.request.RandomPhotoRequest;
import com.unsplash.domain.response.LikePhotoResponse;
import com.unsplash.domain.response.PhotoResponse;
import com.unsplash.utilities.testhelper.DataHelper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class PhotoControllerUnit {

    private final DataHelper dataHelper = DataHelper.getInstance();

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
