package com.unsplash.main.integeration;

import com.unsplash.domain.response.PhotoResponse;
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
@SpringBootTest
public class PhotoControllerIT {

    private final Helper helper = Helper.getInstance();

    private final DataHelper dataHelper = DataHelper.getInstance();

    @Autowired
    private MockMvc mvc;

    @Test
    public void testGetAll() throws Exception {
        mvc.perform(get(BASE_PHOTOS)
                .params(dataHelper.accessMap()))
                .andDo(print())
                .andExpect(content().contentType(MEDIA_TYPE_JSON_UTF8))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetAllWithNullParams() throws Exception {
        mvc.perform(get(BASE_PHOTOS)
                .params(dataHelper.photoRequestMapEmpty()))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void testGetAllWithInvalidParams() throws Exception {
        mvc.perform(get(BASE_PHOTOS)
                .params(dataHelper.invalidAccessMap()))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void testRandom() throws Exception {
        mvc.perform(get(PHOTOS_RANDOM)
                .params(dataHelper.accessMap()))
                .andDo(print())
                .andExpect(content().contentType(MEDIA_TYPE_JSON_UTF8))
                .andExpect(status().isOk());
    }

    @Test
    public void testRandomWithNullParams() throws Exception {
        mvc.perform(get(PHOTOS_RANDOM)
                .params(dataHelper.photoRequestMapEmpty()))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void testRandomWithInvalidParams() throws Exception {
        mvc.perform(get(PHOTOS_RANDOM)
                .params(dataHelper.invalidAccessMap()))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void testLike() throws Exception {
        PhotoResponse randomPhoto = getRandomPhoto();
        mvc.perform(post(PHOTOS_LIKE)
                .content(helper.asJsonString(dataHelper.likePhotoRequest(randomPhoto.getId())))
                .contentType(MEDIA_TYPE_JSON_UTF8))
                .andDo(print())
                .andExpect(content().contentType(MEDIA_TYPE_JSON_UTF8))
                .andExpect(status().isCreated());
    }

    @Test
    public void testLikeWithoutToken() throws Exception {
        PhotoResponse randomPhoto = getRandomPhoto();
        mvc.perform(post(PHOTOS_LIKE)
                .content(helper.asJsonString(dataHelper.likePhotoRequestWithoutToken(randomPhoto.getId())))
                .contentType(MEDIA_TYPE_JSON_UTF8))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void testLikeWithoutPhotoId() throws Exception {
        mvc.perform(post(PHOTOS_LIKE)
                .content(helper.asJsonString(dataHelper.likePhotoRequestWithoutPhotoId()))
                .contentType(MEDIA_TYPE_JSON_UTF8))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void testLikeInvalidAuth() throws Exception {
        PhotoResponse randomPhoto = getRandomPhoto();
        mvc.perform(post(PHOTOS_LIKE)
                .content(helper.asJsonString(dataHelper.likePhotoRequestInvalidToken(randomPhoto.getId())))
                .contentType(MEDIA_TYPE_JSON_UTF8))
                .andDo(print())
                .andExpect(status().is4xxClientError());
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
