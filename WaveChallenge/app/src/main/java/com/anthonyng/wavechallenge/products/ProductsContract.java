package com.anthonyng.wavechallenge.products;

import com.anthonyng.wavechallenge.BasePresenter;
import com.anthonyng.wavechallenge.BaseView;
import com.anthonyng.wavechallenge.model.Product;

import java.util.List;

/**
 * Created by Anthony on 2016-10-04.
 */

public interface ProductsContract {

    interface View extends BaseView<Presenter> {

        void showProducts(List<Product> productList);

    }

    interface Presenter extends BasePresenter{

    }
}
