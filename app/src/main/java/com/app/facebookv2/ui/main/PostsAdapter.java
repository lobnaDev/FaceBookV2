package com.app.facebookv2.ui.main;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.facebookv2.R;
import com.app.facebookv2.model.PostModel;

import java.util.ArrayList;
import java.util.List;


public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostViewHolder> {
    private List<PostModel> model = new ArrayList<>();


    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PostViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false));

    }

    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {
        holder.titleTV.setText(model.get(position).getTitle());
        holder.userTV.setText(model.get(position).getUserId()+"");
        holder.bodyTV.setText(model.get(position).getBody());

    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    public void setList(List<PostModel> List) {
        this.model = List;
        notifyDataSetChanged();

    }

    public class PostViewHolder extends RecyclerView.ViewHolder {
        TextView titleTV, userTV, bodyTV;

        public PostViewHolder(View itemView) {
            super(itemView);

            titleTV = itemView.findViewById(R.id.titleTV);
            userTV = itemView.findViewById(R.id.userIDTV);
            bodyTV = itemView.findViewById(R.id.bodyTV);


        }
    }
}
