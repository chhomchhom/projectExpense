package com.projectexpense2.virackdara.projectexpense2.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.projectexpense2.virackdara.projectexpense2.R;
import com.projectexpense2.virackdara.projectexpense2.objects.Categories;

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
                listOfCategories.add(myCategory);
                dismiss();
            }
        });

        editTextTitle = view.findViewById(R.id.categoryToAdd);
        return builder.create();
    }

}
