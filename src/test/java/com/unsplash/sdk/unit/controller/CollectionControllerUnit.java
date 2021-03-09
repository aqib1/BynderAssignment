package com.unsplash.sdk.unit.controller;

import com.unsplash.sdk.controller.CollectionController;
import com.unsplash.sdk.dto.request.AddPhotoRequest;
import com.unsplash.sdk.dto.request.CollectionRequest;
import com.unsplash.sdk.dto.response.AddPhotoResponse;
import com.unsplash.sdk.dto.response.CollectionResponse;
import com.unsplash.sdk.helper.DataHelper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class CollectionControllerUnit {

    @Autowired
    private DataHelper dataHelper;

    @Mock
    private CollectionController controller;

    @Test
    public void createCollectionTest() {
        when(controller.create(any(CollectionRequest.class)))
                .thenReturn(dataHelper.collectionResponse());

        CollectionResponse response = controller.create(dataHelper.collectionRequest());

        assertNotNull(response);
        verify(controller, times(1)).create(any(CollectionRequest.class));
    }

    @Test
    public void addPhotoToCollectionTest() {
        when(controller.addPhotoToCollection(any(AddPhotoRequest.class)))
                .thenReturn(dataHelper.addPhotoResponse());

        AddPhotoResponse response = controller.addPhotoToCollection(dataHelper.addPhotoRequest());

        assertNotNull(response);
        verify(controller, times(1)).addPhotoToCollection(any(AddPhotoRequest.class));
    }
}
