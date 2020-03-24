package com.example.amazonapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.amazonapp.R;

public class OrderHistoryAdapter extends RecyclerView.Adapter<OrderHistoryAdapter.MyViewHolder> {

    String data1[], data2[];
    int images[];
    Context context;

    public OrderHistoryAdapter(Context ct, String s1[], String s2[], int img[]) {
        context = ct;
        data1 = s1;
        data2 = s2;
        images = img;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.mytitle.setText(data1[position]);
        holder.myDescription.setText(data2[position]);
        holder.myImage.setImageResource(images[position]);

    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        int view_type;
        //variables for list
        TextView mytitle, myDescription;
        ImageView myImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
                mytitle = itemView.findViewById(R.id.cloth_title);
                myDescription = itemView.findViewById(R.id.cloth_description);
                myImage = itemView.findViewById((R.id.image_icon));
        }
    }
}
