package com.anthonyng.wavechallenge.products;

import com.anthonyng.wavechallenge.data.DataSource;
import com.anthonyng.wavechallenge.model.Product;
import com.anthonyng.wavechallenge.util.schedulers.BaseSchedulerProvider;

import java.util.List;

import rx.Subscription;
import rx.functions.Action1;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Anthony on 2016-10-04.
 */

public class ProductsPresenter implements ProductsContract.Presenter {

    private final String businessId;
    private final ProductsContract.View productsView;
    private final DataSource dataSource;
    private final BaseSchedulerProvider schedulerProvider;

    private CompositeSubscription subscriptions = new CompositeSubscription();

    public ProductsPresenter(String businessId,
                             ProductsContract.View productsView,
                             DataSource dataSource,
                             BaseSchedulerProvider schedulerProvider) {
        this.businessId = businessId;
        this.productsView = productsView;
        this.dataSource = dataSource;
        this.schedulerProvider = schedulerProvider;
        this.productsView.setPresenter(this);
    }

    @Override
    public void subscribe() {
        Subscription subscription = dataSource.getProducts(businessId)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribe(new Action1<List<Product>>() {
                    @Override
                    public void call(List<Product> products) {
                        productsView.showProducts(products);
                    }
                });

        subscriptions.add(subscription);
    }

    @Override
    public void unsubscribe() {
        subscriptions.unsubscribe();
    }
}
