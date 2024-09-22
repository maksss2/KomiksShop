package com.example.comksi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private final List<Product> productList;

    public ProductAdapter(List<Product> productList) {
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product_card, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.comicTitle.setText(product.getTitle());
        holder.comicDescription.setText(product.getDescription());
        holder.comicImage.setImageResource(product.getImageResId());
        holder.buyButton.setOnClickListener(v -> {
            // Handle "buy" action
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView comicTitle, comicDescription;
        ImageView comicImage;
        Button buyButton;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            comicTitle = itemView.findViewById(R.id.comic_title);
            comicDescription = itemView.findViewById(R.id.comic_description);
            comicImage = itemView.findViewById(R.id.comic_image);
            buyButton = itemView.findViewById(R.id.buy_button);
        }
    }
}
