package com.anthonyng.wavechallenge.retrofit;

import com.anthonyng.wavechallenge.model.Product;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface ProductService {

    @GET("/businesses/{business_id}/products/")
    Observable<List<Product>> getProducts(@Path("business_id")String businessId);
}
