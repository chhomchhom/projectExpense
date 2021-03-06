package com.projectexpense2.virackdara.projectexpense2.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.projectexpense2.virackdara.projectexpense2.R;
import com.projectexpense2.virackdara.projectexpense2.activities.MainActivity;
import com.projectexpense2.virackdara.projectexpense2.objects.ExpenseCard;

import java.util.List;

public class ExpenseCardAdapter extends RecyclerView.Adapter<ExpenseCardAdapter.ViewHolder> {

    private List<ExpenseCard> myList;
    private Context context;

    public ExpenseCardAdapter(List<ExpenseCard> myList, Context context) {
        this.myList = myList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ExpenseCard list = myList.get(position);
        holder.textViewHead.setText(list.getTitle());
        holder.textViewPrice.setText(list.getAmount());
        holder.textViewDescription.setText(list.getDescription());
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textViewHead;
        public TextView textViewPrice;
        public TextView textViewDescription;

        public ViewHolder(View itemView) {

            super(itemView);

            textViewHead = itemView.findViewById(R.id.expenseTitle);

            textViewPrice = itemView.findViewById(R.id.expensePrice);

            textViewDescription = itemView.findViewById(R.id.expenseDescription);

        }
    }

}
