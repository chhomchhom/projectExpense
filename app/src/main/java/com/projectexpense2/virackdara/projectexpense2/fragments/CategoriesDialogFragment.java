package com.projectexpense2.virackdara.projectexpense2.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.projectexpense2.virackdara.projectexpense2.R;
import com.projectexpense2.virackdara.projectexpense2.adapters.CategoriesAdapter;
import com.projectexpense2.virackdara.projectexpense2.objects.Categories;

import java.util.ArrayList;

import static com.projectexpense2.virackdara.projectexpense2.objects.Categories.listOfCategories;

public class CategoriesDialogFragment extends DialogFragment {
    private EditText editTextTitle;
    Button save;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_add_categories, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(view);


        save = view.findViewById(R.id.addCategoryButton);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = editTextTitle.getText().toString();

                Bundle b = new Bundle();
                b.putString("category", title);
                CategoriesFragment test = new CategoriesFragment();
                test.setArguments(b);
                Categories myCategory = new Categories(title);
                boolean addOrNot=ifContains(myCategory,listOfCategories);
                if ( addOrNot== true) {
                    Toast.makeText(getContext(), "Category already exist", Toast.LENGTH_SHORT).show();
                } else {
                    listOfCategories.add(myCategory);
                    Toast.makeText(getContext(), "Category added", Toast.LENGTH_SHORT).show();
                }
                dismiss();
            }
        });

        editTextTitle = view.findViewById(R.id.categoryToAdd);
        return builder.create();
    }

    private boolean ifContains(Categories cat, ArrayList<Categories> thisList){
        boolean ifContains = false;
        int j = 0;
        while(j<thisList.size()){
            if(thisList.get(j).equals(cat)){
                ifContains=true;
                return ifContains;
            }
            j++;
        }
        return ifContains;
    }

}
