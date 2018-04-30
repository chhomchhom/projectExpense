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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.support.v4.app.DialogFragment;
import com.projectexpense2.virackdara.projectexpense2.R;
import com.projectexpense2.virackdara.projectexpense2.objects.Categories;
import com.projectexpense2.virackdara.projectexpense2.objects.ExpenseCard;

/**
 * Created by moham on 2018-04-24.
 */

public class ExpenseDialogFragment extends DialogFragment {

    private EditText editTextTitle;
    private EditText editTextAmount;
    private EditText editTextDescription;

    public OnInputSelected moninputselected;
//    private ExpenseDialogListener expenseDialogListener;

Button save;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.expense_dialog, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setView(view);

//        save = view.findViewById(R.id.saveButton);
//        save.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String title = editTextTitle.getText().toString();
//                String amount = editTextAmount.getText().toString();
//                String description = editTextDescription.getText().toString();
//
//                TodayTabFragment fragment = new TodayTabFragment();
//                Bundle b = new Bundle();
//                b.putString("title", title);
//                b.putString("amount", amount);
//                fragment.setArguments(b);
//                android.support.v4.app.FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//                fragmentManager.beginTransaction().detach(fragment).attach(fragment).commit();
//            }
//        });

        save = view.findViewById(R.id.saveButton);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(getContext(), "fsf", Toast.LENGTH_SHORT).show();
                String title = editTextTitle.getText().toString();



                Bundle b = new Bundle();
                b.putString("title", title);
                TodayTabFragment test = new TodayTabFragment();
                test.setArguments(b);
                android.support.v4.app.FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//                fragmentManager.beginTransaction().add(test, "TodayTabFragment").commit();
                test.insertItem(0, title);
                fragmentManager.beginTransaction().detach(test).attach(test).commit();


                dismiss();




//                String amount = editTextAmount.getText().toString();
//                String description = editTextDescription.getText().toString();
//                Fragment test = getActivity().getSupportFragmentManager().findFragmentByTag("TodayTabFragment");


//                moninputselected.sendInput(title);
//               test.insertItem(0);
            }
        });

//        String title = editTextTitle.getText().toString();
//                String amount = editTextAmount.getText().toString();
//                String description = editTextDescription.getText().toString();

//                android.support.v4.app.FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//                fragmentManager.beginTransaction().commit();


//        builder.setView(view).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//
//            }
//        }).setPositiveButton("Save", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                String title = editTextTitle.getText().toString();
//                String amount = editTextAmount.getText().toString();
//                String description = editTextDescription.getText().toString();
//
//                TodayTabFragment fragment = new TodayTabFragment();
//                Bundle b = new Bundle();
//                b.putString("title", title);
//                b.putString("amount", amount);
//                fragment.setArguments(b);
//                android.support.v4.app.FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//                fragmentManager.beginTransaction().commit();
//
////                expenseDialogListener.applyTexts(title, amount, description);
//            }
//        });

        editTextTitle = view.findViewById(R.id.Title);
        editTextAmount = view.findViewById(R.id.Amount);
        editTextDescription = view.findViewById(R.id.Description);

        return builder.create();
    }


    public interface OnInputSelected{
        void sendInput(String input);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            moninputselected = (OnInputSelected) context;
        }catch (Exception e){

        }
    }


    //    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        try {
//            expenseDialogListener = (ExpenseDialogListener) context;
//        }catch (ClassCastException e){
//            throw new ClassCastException(context.toString() + " must implement ExpenseDialogListener");
//        }
//    }

//    public interface ExpenseDialogListener{
//        void applyTexts(String title, String amount, String description);
//
//    }

}
