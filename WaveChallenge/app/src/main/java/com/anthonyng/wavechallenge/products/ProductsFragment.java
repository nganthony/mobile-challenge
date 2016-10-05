package com.anthonyng.wavechallenge.products;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anthonyng.wavechallenge.R;
import com.anthonyng.wavechallenge.model.Product;

import java.util.List;

public class ProductsFragment extends Fragment implements ProductsContract.View {

    private ProductsContract.Presenter presenter;

    private RecyclerView productsRecyclerView;
    private ProductsAdapter productsAdapter;

    public ProductsFragment() {
        // Required empty public constructor
    }

    public static ProductsFragment newInstance() {
        return new ProductsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_products, container, false);

        productsRecyclerView = (RecyclerView)view.findViewById(R.id.products_recycler_view);
        productsRecyclerView.setHasFixedSize(true);
        productsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        productsAdapter = new ProductsAdapter();
        productsRecyclerView.setAdapter(productsAdapter);

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.subscribe();
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.unsubscribe();
    }

    @Override
    public void setPresenter(ProductsContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showProducts(List<Product> productList) {
        productsAdapter.addAll(productList);
    }
}
