package com.projectexpense2.virackdara.projectexpense2.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.projectexpense2.virackdara.projectexpense2.R;
import com.projectexpense2.virackdara.projectexpense2.objects.Categories;
import com.projectexpense2.virackdara.projectexpense2.objects.ExpenseCard;

import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.ViewHolder> {

    private List<Categories> myList;
    private Context context;

    public CategoriesAdapter(List<Categories> myList, Context context) {
        this.myList = myList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_categories,parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Categories list = myList.get(position);
        holder.textViewName.setText(list.getName());

    }

    @Override
    public int getItemCount() {

        return myList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textViewName;


        public ViewHolder(View itemView) {

            super(itemView);

            textViewName = itemView.findViewById(R.id.categoryName);


        }
    }
}
