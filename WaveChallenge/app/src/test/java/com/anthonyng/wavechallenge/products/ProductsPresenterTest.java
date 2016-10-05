package com.anthonyng.wavechallenge.products;

import com.anthonyng.wavechallenge.data.DataSource;
import com.anthonyng.wavechallenge.model.Product;
import com.anthonyng.wavechallenge.util.schedulers.ImmediateScheduler;
import com.google.common.collect.Lists;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import rx.Observable;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Unit tests for {@link ProductsPresenter}
 */
public class ProductsPresenterTest {

    private static List<Product> PRODUCTS;

    private static String BUSINESS_ID = "BUSINESS_ID";

    private ProductsPresenter productsPresenter;

    @Mock
    private ProductsContract.View productsView;

    @Mock
    private DataSource dataSource;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        productsPresenter = new ProductsPresenter(
                BUSINESS_ID,
                productsView,
                dataSource,
                new ImmediateScheduler()
        );

        // Initialize mock products list
        PRODUCTS = Lists.newArrayList(new Product(), new Product(), new Product());
    }

    @Test
    public void testSubscribe() {
        when(dataSource.getProducts(BUSINESS_ID)).thenReturn(Observable.just(PRODUCTS));

        productsPresenter.subscribe();

        verify(productsView).showProducts(PRODUCTS);
    }
}
