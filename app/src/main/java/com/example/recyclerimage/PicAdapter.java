package com.example.recyclerimage;

import android.content.Context;
import android.content.Intent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class PicAdapter extends RecyclerView.Adapter<PicAdapter.MyViewHolder> {
    private List<Model_Pic> pic_list;
    Context con;
    int [] imageId;
    String[] result;

    public static int[] osImages = {
            R.drawable.a,
            R.drawable.a1,
            R.drawable.a2,
            R.drawable.a3};

//    public PicAdapter(int[] osImages,String[] osNameList, Context context) {
//        this.con = context;
//        result=osNameList;
//        imageId=osImages;
//    }

public PicAdapter(Context context,int[] osImages) {
        this.con = context;
        imageId=osImages;
    }

    @NonNull
    @Override
    public PicAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_pic, viewGroup, false);
        return new PicAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PicAdapter.MyViewHolder holder, final int ii) {
        holder.pic_id.setImageResource(osImages[ii]);
//        holder.pic_title.setText(result[ii]);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Sending image id to FullScreenActivity
                Intent i = new Intent(con, FullImage.class);
//                // passing array index
//                i.putExtra("id",osImages[ii]);
                i.putExtra("index", ii);
                con.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return osImages.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
//        ImageView pic_id;
        CircleImageView pic_id;
        TextView pic_title;
        CardView cardView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            pic_id=(CircleImageView)itemView.findViewById(R.id.pic_id);
            pic_title=(TextView)itemView.findViewById(R.id.ptitle);
            cardView=(CardView)itemView.findViewById(R.id.card_view_pic);
        }
    }
}
