package com.projectexpense2.virackdara.projectexpense2.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.projectexpense2.virackdara.projectexpense2.R;
import com.projectexpense2.virackdara.projectexpense2.adapters.ExpenseCardAdapter;
import com.projectexpense2.virackdara.projectexpense2.objects.Categories;
import com.projectexpense2.virackdara.projectexpense2.objects.ExpenseCard;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.projectexpense2.virackdara.projectexpense2.objects.ExpenseCard.listOfExpenseCards;


public class WeekTabFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ExpenseCard> expenseCards;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_week_tab,container,false);
        recyclerView = rootView.findViewById(R.id.weekRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        expenseCards = new ArrayList<>();

        for(int i = 0; i<=10;i++){
            Categories cat = new Categories("Food");
            ExpenseCard expenseCard = new ExpenseCard("Title"+i+1,i+"",new Date(),cat);
            expenseCards.add(expenseCard);
        }

        adapter = new ExpenseCardAdapter(listOfExpenseCards,getContext());

        recyclerView.setAdapter(adapter);
        return rootView;
    }
}
