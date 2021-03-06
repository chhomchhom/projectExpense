package com.projectexpense2.virackdara.projectexpense2.fragments;


import android.app.Dialog;
import android.content.ContextWrapper;
import android.support.v4.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.projectexpense2.virackdara.projectexpense2.R;
import com.projectexpense2.virackdara.projectexpense2.activities.MainActivity;
import com.projectexpense2.virackdara.projectexpense2.adapters.ExpenseCardAdapter;
import com.projectexpense2.virackdara.projectexpense2.objects.Categories;
import com.projectexpense2.virackdara.projectexpense2.objects.ExpenseCard;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.projectexpense2.virackdara.projectexpense2.objects.ExpenseCard.listOfExpenseCards;


public class TodayTabFragment extends Fragment{
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_today_tab,container,false);
        recyclerView = rootView.findViewById(R.id.todayRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new ExpenseCardAdapter(listOfExpenseCards,getContext());

        recyclerView.setAdapter(adapter);
        return rootView;
    }

//    public void updateUI() {
//
//        if (adapter == null) {
//            adapter = new ExpenseCardAdapter(listOfExpenseCards,getContext());
//            recyclerView.setAdapter(adapter);
//        } else {
//            adapter.notifyDataSetChanged();
//        }
//    }

}
