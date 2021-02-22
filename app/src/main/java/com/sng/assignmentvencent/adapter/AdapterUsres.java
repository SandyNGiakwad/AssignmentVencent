package com.sng.assignmentvencent.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sng.assignmentvencent.R;
import com.sng.assignmentvencent.model.Users;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterUsres extends RecyclerView.Adapter<AdapterUsres.MyViewHolder> {
    ArrayList<Users> usersList;
    Context context;

    public AdapterUsres(Context context,ArrayList<Users> users) {
        this.context = context;
        this.usersList = users;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_user;
        TextView tv_name, tv_eamil;
        LinearLayout pg_layout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_user = itemView.findViewById(R.id.iv_user);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_eamil = itemView.findViewById(R.id.tv_email);
            pg_layout=itemView.findViewById(R.id.pg_layout);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_item_user, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Users users = usersList.get(position);
        holder.tv_eamil.setText(users.getEmail());
        holder.tv_name.setText(users.getName());
        Picasso.get().load(users.getAvatar()).error(R.mipmap.ic_user).into(holder.iv_user, new Callback() {
            @Override
            public void onSuccess() {
                holder.pg_layout.setVisibility(View.GONE);
            }

            @Override
            public void onError(Exception e) {
                holder.pg_layout.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }
    public void updateUsers(ArrayList<Users> users)
    {
        this.usersList=users;
        notifyDataSetChanged();
    }


}
