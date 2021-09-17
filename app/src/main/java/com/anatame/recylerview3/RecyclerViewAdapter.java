package com.anatame.recylerview3;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.bumptech.glide.Glide;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<President> presidentList;
    Context context;

    public RecyclerViewAdapter(List<President> presidentList, Context context) {
        this.presidentList = presidentList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.one_line_president, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        holder.tvPresidentName.setText(presidentList.get(i).getName());
        holder.tvPresElectionDate.setText(String.valueOf(presidentList.get(i).getDateOfElection()));
        Glide.with(this.context).load(presidentList.get(i).getImageUrl()).into(holder.ivPresPic);

        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AddEditOne.class);
                intent.putExtra("id", presidentList.get(i).getId());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return presidentList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView ivPresPic;
        private TextView tvPresidentName;
        private TextView tvPresElectionDate;
        private ConstraintLayout constraintLayout;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivPresPic = itemView.findViewById(R.id.iv_presidentPicture);
            tvPresidentName = itemView.findViewById(R.id.tv_presidentName);
            tvPresElectionDate = itemView.findViewById(R.id.tv_date);
            constraintLayout = itemView.findViewById(R.id.constraintLayout);


        }
    }

}
