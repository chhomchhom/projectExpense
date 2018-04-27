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


public class TodayTabFragment extends Fragment implements ExpenseDialogFragment.OnInputSelected{
    public RecyclerView recyclerView;
    public RecyclerView.Adapter adapter;

    public Context mContext;
    public Button save;
    public List<ExpenseCard> expenseCards= new ArrayList<>();
    public EditText editTextTitle;
    public EditText editTextAmount;
    public EditText editTextDescription;

    static String v;
    String data;
    private static final String TAG = "TodayTabFragment";

    public  TodayTabFragment(){

    }

    @Override
    public void sendInput(String input) {
        Toast.makeText(getContext(), input, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        this.getFragmentManager().putFragment(outState, this.TAG, new TodayTabFragment());
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        ExpenseDialogFragment b = new ExpenseDialogFragment();
//        b.setTargetFragment(mContext , 1);
        View rootView = inflater.inflate(R.layout.fragment_today_tab, container,false);
        final View rootView1 = inflater.inflate(R.layout.expense_dialog,null);


        mContext = getActivity();
//        createList();

        buildRecycleerView(rootView);

        if (getArguments() != null) {
            data = getArguments().getString("title");
            Toast.makeText(getActivity(), data, Toast.LENGTH_SHORT).show();
            expenseCards.add(0, new ExpenseCard(data, data, new Date(), new Categories("fsddf")));
            refreshEvents(expenseCards);

        }

//
//        save = rootView1.findViewById(R.id.saveButton);
//        save.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                insertItem(0);
//                Toast.makeText(getContext(), "sdfsdfsd", Toast.LENGTH_SHORT).show();
//            }
//        });
//        insertItem(0);

//        editTextTitle = rootView1.findViewById(R.id.Title);
//        editTextAmount = rootView1.findViewById(R.id.Amount);
//        editTextDescription = rootView1.findViewById(R.id.Description);
//        String title = editTextTitle.getText().toString();
//        if (getArguments() != null) {
//            String data = getArguments().getString("title");
//
//            String data2 = getArguments().getString("amount");
//
//            Toast.makeText(getContext(), data, Toast.LENGTH_SHORT).show();
//        }

//        ExpenseCardAdapter.GetList getList = new ExpenseCardAdapter.GetList(getContext());
//        if (getArguments() != null) {
//            String data = getArguments().getString("title");
//
//            String data2 = getArguments().getString("amount");
//            ExpenseCard passed = addExpense(data, data2, "ffsdfsf", new Categories("fsf"));
//
//            expenseCards.add(passed);
//
//            adapter = new ExpenseCardAdapter(expenseCards, getContext());
//            adapter.notifyDataSetChanged();
//            recyclerView.setAdapter(adapter);
//            recyclerView.invalidate();
//            Toast.makeText(getContext(), expenseCards.size()+"", Toast.LENGTH_SHORT).show();
//        }else{
//
//
//        }

//        adapter = new ExpenseCardAdapter(expenseCards, getContext());
//        adapter.notifyDataSetChanged();
//        Toast.makeText(getContext(), expenseCards.size()+"", Toast.LENGTH_SHORT).show();
//        adapter.notifyDataSetChanged();
//        adapter.setMyList(expenseCards);

//        recyclerView.invalidate();
//        recyclerView.setAdapter(adapter);
        if (getArguments() != null) {
            String data = getArguments().getString("title");
            Toast.makeText(getContext(), expenseCards.size()+"This is onCreate", Toast.LENGTH_SHORT).show();
//            this.insertItem(0, "moh");
            expenseCards.add(0, new ExpenseCard(data, "moh", new Date(), new Categories("fsddf")));

            adapter.notifyItemInserted(0);
//            setUserVisibleHint(false);
        }
        refreshEvents(expenseCards);
//        insertItem(0,"Mohamed");

        return rootView;
    }

    public  void insertItem(int position, String data){

        if(getActivity()!=null) {
//            Toast.makeText(getActivity(), expenseCards.size()+"", Toast.LENGTH_SHORT).show();
            expenseCards.add(position, new ExpenseCard(data, data, new Date(), new Categories("fsddf")));
            adapter.notifyItemInserted(position);
        }
//        adapter.notifyItemInserted(position);
        //        try {
//        adapter.notifyDataSetChanged();
//        recyclerView.invalidate();
//    }catch (Exception e){
//        Toast.makeText(getContext(), expenseCards.size()+"", Toast.LENGTH_SHORT).show();
//    }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser)
            getFragmentManager().beginTransaction().detach(this).attach(this).commit();
    }

    public void refreshEvents(List<ExpenseCard> v) {
        List<ExpenseCard> test = new ArrayList<>();
        test.addAll(v);
        expenseCards.clear();
        expenseCards.addAll(test);
        test.clear();
        adapter.notifyItemInserted(0);
        adapter.notifyDataSetChanged();
    }

//    @Override
//    public void onResume() {
//        super.onResume();
//        if (getArguments() != null) {
//            String data = getArguments().getString("title");
//            Toast.makeText(getActivity(), data, Toast.LENGTH_SHORT).show();
//
//            expenseCards.add(0, new ExpenseCard(data, data, new Date(), new Categories("fsddf")));
//
//            refreshEvents(expenseCards);
//
//             }
//    }
//
//    @Override
//    public void onStart() {
//        super.onStart();
//        refreshEvents(expenseCards);
//    }

    public void createList(){
        expenseCards= new ArrayList<>();
        mContext=getContext();
        for(int i = 0; i<=2;i++){
            Categories cat = new Categories("Food");
            ExpenseCard expenseCard = new ExpenseCard("Title"+i+1,i+"",new Date(),cat);
            expenseCards.add(expenseCard);
        }

    }

    public void buildRecycleerView(View rootView){
        mContext=getContext();
        recyclerView = rootView.findViewById(R.id.todayRecyclerView);
        recyclerView.setHasFixedSize(true);
        adapter = new ExpenseCardAdapter(expenseCards, getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
    }


    //description is optional
    //call based on if description is null or not
    public void addExpense(String title, String amount, String description, Categories cat) {
        Date myDate = new Date();
//        Toast.makeText(getContext(), title+"", Toast.LENGTH_SHORT).show();
        if(title != null) {
            ExpenseCard myCard = new ExpenseCard(title, amount, myDate, cat);
//            expenseCards.add(myCard);
            recyclerView.invalidate();
        }

    }
}
