package com.example.retrofit;

import android.content.ClipData;

import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class BloggerAPI {

    private static final String Key = "AIzaSyAI13g6mQ9dg1Obgvd6SrfjfC9YYf9Y4VI";
    private static final String url = "https://www.googleapis.com/blogger/v3/blogs/191761765004033960/";

    public static PostService postService=null;
    public static PostService getService()
    {
        if (postService==null)
        {
            Retrofit retrofit=new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            postService=retrofit.create(PostService.class);
        }
    return postService;
    }



    public interface PostService {
        @GET("key=" + Key)
        Call<PostList> getPostList();


    }


}
