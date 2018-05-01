package com.projectexpense2.virackdara.projectexpense2.objects;

import java.util.ArrayList;
import java.util.Date;

public class ExpenseCard {
    private String title;
    private String amount;
    private Date date;
    private String description;
    private Categories categories;
    protected ArrayList<ExpenseCard> listOfExpenseCards = new ArrayList<>();

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
