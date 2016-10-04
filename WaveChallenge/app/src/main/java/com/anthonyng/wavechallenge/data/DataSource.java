package com.anthonyng.wavechallenge.data;

import com.anthonyng.wavechallenge.model.Product;

import java.util.List;

import rx.Observable;


public interface DataSource {

    Observable<List<Product>> getProducts(String businessId);
}
