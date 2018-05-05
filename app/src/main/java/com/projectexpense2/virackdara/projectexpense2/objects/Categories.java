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
    public boolean ifContains(Categories cat){
        boolean ifContains = false;
        int j = 0;
        while(j<listOfCategories.size()){
            if(listOfCategories.get(j).equals(cat)){
                ifContains=true;
                break;
            }
            j++;
        }

        return ifContains;
    }

    @Override
    public boolean equals(Object v) {
        boolean retVal = false;

        if (v instanceof Categories){
            Categories ptr = (Categories) v;
            retVal = ptr.name == this.name;
        }

        return retVal;
    }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (this.name != null ? this.name.hashCode() : 0);
        return hash;
    }

}
