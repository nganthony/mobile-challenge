package com.anthonyng.wavechallenge.data;

import com.anthonyng.wavechallenge.model.Product;
import com.anthonyng.wavechallenge.retrofit.ProductService;

import java.io.IOException;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

public class RemoteDataSource implements DataSource {

    private static final String BASE_URL = "https://api.waveapps.com/";
    private static final String ACCESS_TOKEN = "6W9hcvwRvyyZgPu9Odq7ko8DSY8Nfm";
    private static RemoteDataSource INSTANCE;

    private ProductService productService;

    private RemoteDataSource() {
        OkHttpClient httpClient = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request().newBuilder()
                        .addHeader("Authorization", "Bearer " + ACCESS_TOKEN).build();
                return chain.proceed(request);
            }
        }).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        productService = retrofit.create(ProductService.class);
    }

    public static RemoteDataSource getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new RemoteDataSource();
        }

        return INSTANCE;
    }

    @Override
    public Observable<List<Product>> getProducts(String businessId) {
        return productService.getProducts(businessId);
    }
}
