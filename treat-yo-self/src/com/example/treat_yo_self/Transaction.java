package com.example.treat_yo_self;

import java.sql.Date;


public class Transaction {
    /** The name. */
    private String name;

    /** The amount. */
    private double amount;

    /** The task related to the transaction. */
    private Task task;

    /** The date. */
    private Date date;

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
     */
    public Transaction(Task task, String name, double amount, Date date) {
        try {
            this.name = name;
            this.task = task;
            this.amount = amount;
            this.date = date;
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
     * Gets the task.
     * 
     * @return the task
     */
    public Task getTask() {
        return task;
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

}
