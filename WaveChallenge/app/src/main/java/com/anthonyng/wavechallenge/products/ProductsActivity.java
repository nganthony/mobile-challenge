package com.anthonyng.wavechallenge.products;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.anthonyng.wavechallenge.Injection;
import com.anthonyng.wavechallenge.R;

public class ProductsActivity extends AppCompatActivity {

    private final static String BUSINESS_ID = "89746d57-c25f-4cec-9c63-34d7780b044b";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        ProductsFragment productsFragment = (ProductsFragment)getSupportFragmentManager().findFragmentById(R.id.contents_layout);

        if(productsFragment == null) {
            productsFragment = ProductsFragment.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contents_layout, productsFragment).commit();
        }

        new ProductsPresenter(
                BUSINESS_ID,
                productsFragment,
                Injection.provideDataSource(),
                Injection.provideSchedulerProvider()
        );
    }
}
