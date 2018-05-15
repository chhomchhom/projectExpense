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

//    public boolean ifContains(Categories cat){
//        boolean ifContains = false;
//        int j = 0;
//        while(j<listOfCategories.size()){
//            if(listOfCategories.get(j).equals(cat)){
//                ifContains=true;
//                break;
//            }
//            j++;
//        }
//
//        return ifContains;
//    }
//
    //these two methods are used to check if a category has been added already
    @Override
    public boolean equals(Object object)
    {
        boolean isEqual= false;

        if (object != null && object instanceof Categories)
        {
            isEqual = (this.name.equals (((Categories) object).name));
        }

        return isEqual;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

}
