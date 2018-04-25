package com.projectexpense2.virackdara.projectexpense2.objects;

import java.util.ArrayList;

public class Categories {
    private String name;
    public static ArrayList<Categories> listOfCategories = new ArrayList<>();


    public Categories(String name){

        this.name = name;
    }

    public int getCount(){
        int count = listOfCategories.size();
        return count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name =name;
    }

    public void addCategory(String name){
        Categories newCategory = new Categories(name);
        listOfCategories.add(newCategory);
    }
}
