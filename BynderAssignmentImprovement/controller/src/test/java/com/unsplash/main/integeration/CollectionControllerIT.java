package com.unsplash.main.integeration;

import com.unsplash.domain.request.AddPhotoRequest;
import com.unsplash.domain.response.CollectionResponse;
import com.unsplash.domain.response.PhotoResponse;
import com.unsplash.main.BynderServerApplication;
import com.unsplash.utilities.Helper;
import com.unsplash.utilities.testhelper.DataHelper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static com.unsplash.utilities.testhelper.Constants.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest(classes = BynderServerApplication.class)
public class CollectionControllerIT {

    private final Helper helper = Helper.getInstance();

    private final DataHelper dataHelper = DataHelper.getInstance();

    @Autowired
    private MockMvc mvc;

    @Test
    public void testCreate() throws Exception {
        mvc.perform(post(BASE_COLLECTIONS)
                .content(helper.asJsonString(dataHelper.collectionRequest()))
                .contentType(MEDIA_TYPE_JSON_UTF8))
                .andDo(print())
                .andExpect(content().contentType(MEDIA_TYPE_JSON_UTF8))
                .andExpect(status().isCreated());
    }

    @Test
    public void testCreateWithInvalidToken() throws Exception {
        mvc.perform(post(BASE_COLLECTIONS)
                .content(helper.asJsonString(dataHelper.collectionRequestInvalidAuth()))
                .contentType(MEDIA_TYPE_JSON_UTF8))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void testCreateWithoutTitle() throws Exception {
        mvc.perform(post(BASE_COLLECTIONS)
                .content(helper.asJsonString(dataHelper.collectionRequestWithoutTitle()))
                .contentType(MEDIA_TYPE_JSON_UTF8))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void testAddPhoto() throws Exception {
        PhotoResponse randomPhoto = getRandomPhoto();
        CollectionResponse collectionResponse = createRandomCollection();
        AddPhotoRequest request = dataHelper.addPhotoRequest(randomPhoto.getId(), collectionResponse.getId());

        mvc.perform(post(ADD_PHOTO_TO_COLLECTION)
                .content(helper.asJsonString(request))
                .contentType(MEDIA_TYPE_JSON_UTF8))
                .andDo(print())
                .andExpect(content().contentType(MEDIA_TYPE_JSON_UTF8))
                .andExpect(status().isCreated());
    }

    @Test
    public void testAddPhotoInvalidToken() throws Exception {
        AddPhotoRequest request = dataHelper.addPhotoRequestInvalidToken("1", "a");

        mvc.perform(post(ADD_PHOTO_TO_COLLECTION)
                .content(helper.asJsonString(request))
                .contentType(MEDIA_TYPE_JSON_UTF8))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    private CollectionResponse createRandomCollection() throws Exception {
        return helper.jsonToObject(mvc.perform(post(BASE_COLLECTIONS)
                .content(helper.asJsonString(dataHelper.collectionRequest()))
                .contentType(MEDIA_TYPE_JSON_UTF8))
                .andReturn()
                .getResponse()
                .getContentAsString(), CollectionResponse.class);
    }

    private PhotoResponse getRandomPhoto() throws Exception {
        return helper.jsonToObject(mvc.perform(get(PHOTOS_RANDOM)
                .params(dataHelper.accessMap())
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn()
                .getResponse()
                .getContentAsString(), PhotoResponse.class);
    }
}
