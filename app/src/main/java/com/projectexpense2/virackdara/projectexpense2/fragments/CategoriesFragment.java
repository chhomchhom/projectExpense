package com.projectexpense2.virackdara.projectexpense2.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.projectexpense2.virackdara.projectexpense2.R;
import com.projectexpense2.virackdara.projectexpense2.activities.SettingsActivity;
import com.projectexpense2.virackdara.projectexpense2.adapters.CategoriesAdapter;
import com.projectexpense2.virackdara.projectexpense2.objects.Categories;

public class CategoriesFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter categoryAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_categories,container,false);
        Toolbar toolbar = rootView.findViewById(R.id.toolbarCategories);
        toolbar.setTitle("");
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        setHasOptionsMenu(true);

        recyclerView = rootView.findViewById(R.id.categoriesRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        categoryAdapter = new CategoriesAdapter(Categories.listOfCategories,getContext());
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(categoryAdapter);

        return rootView;
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_with_addbtn, menu);  // Use filter.xml from step 1
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.settings:
                Intent myIntent = new Intent(getContext(), SettingsActivity.class);
                getContext().startActivity(myIntent);
                return true;

            case R.id.add_button:
                openCategoryDialog();
                return true;

            default:
                break;
        }

        return false;
    }

    public void openCategoryDialog(){
        CategoriesDialogFragment categoriesDialogFragment = new CategoriesDialogFragment();
        categoriesDialogFragment.show(getFragmentManager(),"Example");
    }

}
