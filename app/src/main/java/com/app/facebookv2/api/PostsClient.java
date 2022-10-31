package com.app.facebookv2.api;

import com.app.facebookv2.model.PostModel;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Lobna Babker on 10/30/2022.
 */
public class PostsClient {
    private static final String BASE_URL = "http://jsonplaceholder.typicode.com/";
    private PostInterface postInterface;
    private static PostsClient INSTANCE;

    public PostsClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                //convert call to observable
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
        postInterface = retrofit.create(PostInterface.class);
    }

    public static PostsClient getINSTANCE() {
        if (null == INSTANCE){
            INSTANCE = new PostsClient();
        }
        return INSTANCE;
    }

    public Observable<List<PostModel>> getPosts(){
        return postInterface.getPosts();
    }
}
