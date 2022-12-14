package com.app.facebookv2.api;

import com.app.facebookv2.model.PostModel;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Lobna Babker on 10/30/2022.
 */
public interface PostInterface {
    @GET("posts")
    public Observable<List<PostModel>> getPosts();
}
