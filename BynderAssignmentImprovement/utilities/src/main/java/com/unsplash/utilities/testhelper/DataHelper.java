package com.unsplash.utilities.testhelper;

import com.unsplash.domain.exceptions.ErrorResponseException;
import com.unsplash.domain.request.*;
import com.unsplash.domain.response.*;
import com.unsplash.utilities.Helper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;

import java.io.InputStream;
import java.util.Properties;


public class DataHelper {

    private final Helper helper = Helper.getInstance();

    private final String accessAuthToken;

    public MultiValueMap<String, String> accessMap() {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("accessToken", accessAuthToken);
        return params;
    }

    public MultiValueMap<String, String> invalidAccessMap() {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("accessToken", "invalid");
        return params;
    }

    public MultiValueMap<String, String> photoRequestMapEmpty() {
        return new LinkedMultiValueMap<>();
    }

    public CollectionRequest collectionRequest() {
        return CollectionRequest.builder()
                .accessToken(accessAuthToken)
                .title(String.valueOf(helper.getRandom().nextInt()))
                .description("Its temp collection for testing")
                .isPrivate(false)
                .build();
    }

    public CollectionRequest collectionRequestInvalidAuth() {
        return CollectionRequest.builder()
                .accessToken("invalid")
                .title(String.valueOf(helper.getRandom().nextInt()))
                .description("Its temp collection for testing")
                .isPrivate(false)
                .build();
    }

    public CollectionRequest collectionRequestWithoutTitle() {
        return CollectionRequest.builder()
                .accessToken(accessAuthToken)
                .description("Its temp collection for testing")
                .isPrivate(false)
                .build();
    }

    public AddPhotoRequest addPhotoRequest(String photoId, String collectionId) {
        return AddPhotoRequest.builder()
                .photoId(photoId)
                .accessToken(accessAuthToken)
                .collectionId(collectionId)
                .build();
    }

    public AddPhotoRequest addPhotoRequestInvalidToken(String photoId, String collectionId) {
        return AddPhotoRequest.builder()
                .photoId(photoId)
                .accessToken("invalid")
                .collectionId(collectionId)
                .build();
    }

    public PhotoRequest photoRequest() {
        return PhotoRequest.builder()
                .accessToken(accessAuthToken)
                .build();
    }

    public RandomPhotoRequest randomPhotoRequest() {
        return RandomPhotoRequest.builder()
                .accessToken(accessAuthToken)
                .contentFilter("high")
                .build();
    }

    public LikePhotoRequest likePhotoRequest(String photoId){
        return LikePhotoRequest.builder()
                .accessToken(accessAuthToken)
                .photoId(photoId)
                .build();
    }

    public LikePhotoRequest likePhotoRequestWithoutToken(String photoId){
        return LikePhotoRequest.builder()
                .photoId(photoId)
                .build();
    }

    public LikePhotoRequest likePhotoRequestWithoutPhotoId(){
        return LikePhotoRequest.builder()
                .accessToken(accessAuthToken)
                .build();
    }

    public LikePhotoRequest likePhotoRequestInvalidToken(String photoId){
        return LikePhotoRequest.builder()
                .accessToken("invalid")
                .photoId(photoId)
                .build();
    }

    public PhotoResponse getPhoto() {
        return PhotoResponse.builder()
                .id("1")
                .color("#FFF")
                .height(12)
                .width(11)
                .likedByUser(true)
                .build();
    }

    public LikePhotoResponse likePhotoResponse() {
        return LikePhotoResponse.builder()
                .photo(photoResponse())
                .build();
    }

    public LikePhotoRequest likePhotoRequest() {
        return LikePhotoRequest.builder()
                .accessToken(accessAuthToken)
                .photoId("abc")
                .build();
    }

    public PhotoResponse[] getPhotos() {
        return new PhotoResponse[]{
                getPhoto()
        };
    }

    public CollectionResponse collectionResponse() {
        return CollectionResponse.builder()
                .id("123")
                .description("test collection")
                .isPrivate(true)
                .curated(true)
                .shareKey("142876598w1u2kuw")
                .build();
    }

    public PhotoResponse photoResponse() {
        return PhotoResponse.builder()
                .id("qe1")
                .color("#e1a4c2")
                .height(12)
                .width(89)
                .altDescription("this is temp photo")
                .likes(2)
                .build();
    }

    public AddPhotoResponse addPhotoResponse() {
        return AddPhotoResponse.builder()
                .collection(collectionResponse())
                .photo(photoResponse())
                .build();
    }

    public AddPhotoRequest addPhotoRequest() {
        return AddPhotoRequest.builder()
                .accessToken(accessAuthToken)
                .photoId("qe1")
                .collectionId("123")
                .build();
    }

    public ResponseError responseError() {
        return ResponseError.builder()
                .errorCode(1)
                .errorMessage("")
                .createdAt("")
                .detailedMessage("")
                .exceptionName("")
                .build();
    }

    public ResponseEntity<ResponseError> errorResponseEntity() {
        return new ResponseEntity<>(responseError(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ErrorResponseException errorResponseException() {
        return new ErrorResponseException("");
    }

    public HttpClientErrorException httpClientErrorException() {
        return new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public RuntimeException httpRuntimeException() {
        return new RuntimeException();
    }

    public HttpEntity<String> httpEntity() {
        return new HttpEntity<>(null, null);
    }

    /**
     * Initialization on demand pattern
     * this pattern is alternative of double check locking pattern
     * which not even support lazy loading but also safe to use in
     * multi-processor distributed instances
     */

    private static class InstanceHolder {
        private static final DataHelper INSTANCE = new DataHelper();

        private InstanceHolder() {

        }
    }


    public static DataHelper getInstance() {
        return DataHelper.InstanceHolder.INSTANCE;
    }

    private DataHelper() {
        try (InputStream input = DataHelper.class.getClassLoader().getResourceAsStream("application.properties")) {
            if (input == null) {
                throw new RuntimeException("Sorry, unable to find application.properties");
            }
            Properties prop = new Properties();
            prop.load(input);
            accessAuthToken = prop.getProperty("access.auth.token");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
