package com.projectexpense2.virackdara.projectexpense2.objects;

import java.util.Date;

public class ExpenseCard {
    private String title;
    private String amount;
    private Date date;
    private String description;

    //constructor
    //discription is optional
    public ExpenseCard(String title, String amount, Date date){
        this.title = title;
        this.amount = amount;
        this.date = date;
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
