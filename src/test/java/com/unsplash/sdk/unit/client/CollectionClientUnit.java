package com.unsplash.sdk.unit.client;

import com.unsplash.sdk.client.CollectionClient;
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
public class CollectionClientUnit {

    @Autowired
    private DataHelper dataHelper;

    @Mock
    private CollectionClient client;

    @Test
    public void testCreate() {
        when(client.create(any(CollectionRequest.class)))
                .thenReturn(dataHelper.collectionResponse());

        CollectionResponse response = client.create(dataHelper.collectionRequest());

        assertNotNull(response);
        verify(client, times(1)).create(any(CollectionRequest.class));
    }

    @Test
    public void testAddPhoto() {
        when(client.addPhotoToCollection(any(AddPhotoRequest.class)))
                .thenReturn(dataHelper.addPhotoResponse());

        AddPhotoResponse response = client.addPhotoToCollection(dataHelper.addPhotoRequest());

        assertNotNull(response);
        verify(client, times(1)).addPhotoToCollection(any(AddPhotoRequest.class));
    }
}
