package com.anthonyng.wavechallenge.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Product {

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("price")
    @Expose
    private double price;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("is_sold")
    @Expose
    private boolean isSold;

    @SerializedName("is_bought")
    @Expose
    private boolean isBought;

    @SerializedName("income_account")
    @Expose
    private Account incomeAccount;

    @SerializedName("expense_account")
    @Expose
    private Account expenseAccount;

    @SerializedName("active")
    @Expose
    private boolean active;

    @SerializedName("default_sales_taxes")
    @Expose
    private List<Object> defaultSalesTaxes = new ArrayList<Object>();

    @SerializedName("date_created")
    @Expose
    private String dateCreated;

    @SerializedName("date_modified")
    @Expose
    private String dateModified;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isIsSold() {
        return isSold;
    }

    public void setIsSold(boolean isSold) {
        this.isSold = isSold;
    }

    public boolean isIsBought() {
        return isBought;
    }

    public void setIsBought(boolean isBought) {
        this.isBought = isBought;
    }

    public Account getIncomeAccount() {
        return incomeAccount;
    }

    public void setIncomeAccount(Account expenseAccount) {
        this.incomeAccount = incomeAccount;
    }

    public Account getExpenseAccount() {
        return expenseAccount;
    }

    public void setExpenseAccount(Account expenseAccount) {
        this.expenseAccount = expenseAccount;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Object> getDefaultSalesTaxes() {
        return defaultSalesTaxes;
    }

    public void setDefaultSalesTaxes(List<Object> defaultSalesTaxes) {
        this.defaultSalesTaxes = defaultSalesTaxes;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDateModified() {
        return dateModified;
    }

    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }
}