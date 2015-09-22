package com.swifta.zenith.marketplace.Adapters;import android.content.Context;import android.content.Intent;import android.support.v7.widget.RecyclerView;import android.view.LayoutInflater;import android.view.View;import android.view.ViewGroup;import android.widget.ImageView;import android.widget.LinearLayout;import android.widget.TextView;import com.koushikdutta.ion.Ion;import com.swifta.zenith.marketplace.Activities.StoreDetailsActivity;import com.swifta.zenith.marketplace.R;import com.swifta.zenith.marketplace.Utils.Dictionary;import com.swifta.zenith.marketplace.Utils.JSONParser;import java.util.List;/** * Created by moyinoluwa on 31-Aug-15. */public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.StoreViewHolder> {    List<JSONParser> stores;    Context context;    public StoreAdapter(Context context, List<JSONParser> stores) {        this.stores = stores;        this.context = context;    }    @Override    public StoreViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.store_recycler_view, parent, false);        StoreViewHolder storeViewHolder = new StoreViewHolder(view);        return storeViewHolder;    }    @Override    public void onBindViewHolder(StoreViewHolder holder, final int position) {        // Loads the image directly from the server with the Ion Library        Ion.with(holder.imageView)                .placeholder(R.drawable.home_background)                .load(stores.get(position).getProperty("store_image").toString());        holder.name.setText(stores.get(position).getProperty(Dictionary.storeName).toString());        holder.address.setText(stores.get(position).getProperty(Dictionary.storeAddress1).toString());        holder.linearLayout.setOnClickListener(new View.OnClickListener() {            @Override            public void onClick(View view) {                Intent i = new Intent(context, StoreDetailsActivity.class);                i.putExtra("store", stores.get(position).toString());                context.startActivity(i);            }        });    }    @Override    public int getItemCount() {        return this.stores.size();    }    public static class StoreViewHolder extends RecyclerView.ViewHolder {        LinearLayout linearLayout;        ImageView imageView;        TextView name;        TextView address;        StoreViewHolder(View itemView) {            super(itemView);            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);            imageView = (ImageView) itemView.findViewById(R.id.image_view);            name = (TextView) itemView.findViewById(R.id.store_name);            address = (TextView) itemView.findViewById(R.id.store_address);        }    }}