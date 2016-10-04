package com.anthonyng.wavechallenge.products;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.anthonyng.wavechallenge.R;
import com.anthonyng.wavechallenge.data.RemoteDataSource;
import com.anthonyng.wavechallenge.model.Product;

import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class ProductsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        RemoteDataSource
                .getInstance()
                .getProducts("89746d57-c25f-4cec-9c63-34d7780b044b")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<Product>>() {
                    @Override
                    public void call(List<Product> products) {
                        Log.d("TAG", products.toString());
                    }
                });
    }
}
