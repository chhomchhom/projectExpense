package com.projectexpense2.virackdara.projectexpense2.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.app.FragmentManager;
import com.projectexpense2.virackdara.projectexpense2.fragments.TodayTabFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatDialogFragment;
import android.text.Editable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.DialogFragment;
import com.projectexpense2.virackdara.projectexpense2.R;
import com.projectexpense2.virackdara.projectexpense2.objects.Categories;
import com.projectexpense2.virackdara.projectexpense2.objects.ExpenseCard;

import java.util.ArrayList;
import java.util.Date;

import static com.projectexpense2.virackdara.projectexpense2.objects.ExpenseCard.dayTotal;
import static com.projectexpense2.virackdara.projectexpense2.objects.ExpenseCard.getExpenseCardsByDate;
import static com.projectexpense2.virackdara.projectexpense2.objects.ExpenseCard.listOfExpenseCards;

/**
 * Created by moham on 2018-04-24.
 */

public class ExpenseDialogFragment extends DialogFragment {

    private EditText editTextTitle;
    private EditText editTextAmount;
    private EditText editTextDescription;

    private TextView totalTextBox;


Button save;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.expense_dialog, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setView(view);

        save = view.findViewById(R.id.saveButton);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = editTextTitle.getText().toString();
                String amount = editTextAmount.getText().toString();
                String description = editTextDescription.getText().toString();

                Bundle b = new Bundle();
                b.putString("title", title);
                TodayTabFragment test = new TodayTabFragment();
                test.setArguments(b);
                //these two lines causes the app to crash
                //when you add an expense card then press the home button
//                android.support.v4.app.FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//     fragmentManager.beginTransaction().detach(test).attach(test).commit();
                Date myDate = new Date();
                ExpenseCard myExpense = new ExpenseCard(title,amount,myDate, description,new Categories("Food"));
                listOfExpenseCards.add(0,myExpense);

                //recalculating day total expenses
                ArrayList<ExpenseCard> dayExpenseCards = getExpenseCardsByDate(new Date());
                for(int i = 0;i<dayExpenseCards.size();i++){
                    dayTotal=dayTotal+Integer.parseInt(dayExpenseCards.get(i).getAmount());
//                    dayTotal=dayTotal+5;

                }
                dismiss();
//                totalTextBox = view.findViewById(R.id.total);
//                totalTextBox.setText(dayTotal+"");

            }
        });

        editTextTitle = view.findViewById(R.id.Title);
        editTextAmount = view.findViewById(R.id.Amount);
        editTextDescription = view.findViewById(R.id.Description);

        return builder.create();
    }




}
