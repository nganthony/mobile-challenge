package com.anthonyng.wavechallenge.products;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.anthonyng.wavechallenge.databinding.ItemProductBinding;
import com.anthonyng.wavechallenge.model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Recycler view adapter for products list in {@link ProductsFragment}
 */
public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductViewHolder> {

    private List<Product> productList = new ArrayList<>();

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemProductBinding binding = ItemProductBinding.inflate(LayoutInflater.from(parent.getContext()));
        return new ProductViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        holder.bind(productList.get(position));
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public void addAll(List<Product> products) {
        productList.addAll(products);
        notifyDataSetChanged();
    }

    /**
     * View holder for product item in recycler view
     */
    public static class ProductViewHolder extends RecyclerView.ViewHolder {

        public ItemProductBinding binding;

        public ProductViewHolder(ItemProductBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Product product) {
            binding.setProduct(product);
        }
    }
}
