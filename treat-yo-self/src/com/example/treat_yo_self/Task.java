package com.example.treat_yo_self;

import java.sql.Date;

public class Task {
	
	
    /** The name of task. */
    private String name;

    /** The amount. */
    private double amount;

    /** The date. */
    private Date date;

    /** The process. */
    private boolean done;

    /**
     * Instantiates a new transaction.
     * 
     * @param type
     *            the type
     * @param name
     *            the name
     * @param amount
     *            the amount
     * @param date
     *            the date
     * @param category
     *            the category
     */
    public Task(String name, double amount, Date date) {
        try {
            this.name = name;
            this.amount = amount;
            this.date = date;
            this.done = false;
        } catch (IllegalArgumentException e) {

        }
    }

    /**
     * Gets the name.
     * 
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     * 
     * @param name
     *            the new name
     */
    public void setName(String name) {
        try {
            this.name = name;
        } catch (IllegalArgumentException e) {

        }
    }

    /**
     * Gets the amount.
     * 
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Sets the amount.
     * 
     * @param amount
     *            the new amount
     */
    public void setAmount(double amount) {
        try {
            this.amount = amount;
        } catch (IllegalArgumentException e) {

        }
    }

    /**
     * Gets the date.
     * 
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the date.
     * 
     * @param date
     *            the new date
     */
    public void setDate(Date date) {
        try {
            this.date = date;
        } catch (IllegalArgumentException e) {

        }
    }

    /**
     * get the process of the task.
     * 
     * @return the category
     */
    public boolean getCategory() {
        return done;
    }

    /**
     * Sets the category.
     * 
     * @param category
     *            the new category
     */
    public void setCategory(boolean done) {
        try {
            this.done = done;
        } catch (IllegalArgumentException e) {

        }
    }

}
