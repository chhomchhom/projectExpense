package com.projectexpense2.virackdara.projectexpense2.objects;

import java.util.ArrayList;
import java.util.Date;

public class ExpenseCard {
    private String title;
    private String amount;
    private Date date;
    private String description;
    private Categories categories;
    public static ArrayList<ExpenseCard> listOfExpenseCards = new ArrayList<>();
    public static int dayTotal;
    public static int weekTotal;
    public static int monthTotal;


    //constructor
    //description is optional
    public ExpenseCard(String title, String amount, Date date, Categories cat){
        this.title = title;
        this.amount = amount;
        this.date = date;
        this.categories=cat;
    }
    public ExpenseCard(String title, String amount, Date date, String description,Categories cat){
        this.title = title;
        this.amount = amount;
        this.date = date;
        this.categories=cat;
        this.description = description;
    }

    //description is optional
    //call based on if description is null or not
    public void addExpense(String title, String amount, Categories cat) {
        Date myDate = new Date();
        ExpenseCard myCard = new ExpenseCard(title, amount, myDate, cat);
        listOfExpenseCards.add(myCard);

        return;
    }

    //description is optional
    //call based on if description is null or not
    public void addExpense(String title, String amount, String description, Categories cat) {
        Date myDate = new Date();
        ExpenseCard myCard = new ExpenseCard(title, amount, myDate,description, cat);
        listOfExpenseCards.add(myCard);

        return;
    }

    //will be used for history tab
    public ArrayList<ExpenseCard> getAllExpenseCards(){
        ArrayList<ExpenseCard> myList = listOfExpenseCards;
        return myList;
    }

    //return list of expense cards by one date
    public static ArrayList<ExpenseCard> getExpenseCardsByDate(Date date) {
        ArrayList<ExpenseCard> myList = new ArrayList<>();
        int i =0;
        while(i<listOfExpenseCards.size()){
            if(listOfExpenseCards.get(i).getDate().equals(date)){
                myList.add(listOfExpenseCards.get(i));
            }
            i++;
        }
        return myList;
    }

    //return list of expense cards by a range of dates
    //should be used to compile list of expenses for the week and for the month
    public ArrayList<ExpenseCard> getExpenseCardsByDates(Date beginDate,Date endDate) {
        ArrayList<ExpenseCard> myList = new ArrayList<>();
        int i =0;
        while(i<listOfExpenseCards.size()){
            //checking if the date of current card is within the range
            if(listOfExpenseCards.get(i).getDate().before(endDate) && listOfExpenseCards.get(i).getDate().after(beginDate)){
                myList.add(listOfExpenseCards.get(i));
            }
            i++;
        }
        return myList;
    }


    public int getCount(){
        int count = listOfExpenseCards.size();
        return count;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAmount() {
        return this.amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDayTotal(int total){
        dayTotal=total;
    }
    public void setWeekTotal(int total){
        weekTotal=total;
    }
    public void setMonthTotal(int total){
        monthTotal=total;
    }

}
