package com.unsplash.main.unit;

import com.unsplash.main.controller.CollectionController;
import com.unsplash.domain.request.AddPhotoRequest;
import com.unsplash.domain.request.CollectionRequest;
import com.unsplash.domain.response.AddPhotoResponse;
import com.unsplash.domain.response.CollectionResponse;
import com.unsplash.utilities.testhelper.DataHelper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class CollectionControllerUnit {


    private final DataHelper dataHelper = DataHelper.getInstance();

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
