package com.pokidin.a.kava;


public class Order {

    private String name;
    private String size;
    private int count;
    private int cost;
    private String customer;

    public Order(String name, String size, int count, int cost, String customer) {
        this.name = name;
        this.size = size;
        this.count = count;
        this.cost = cost;
        this.customer = customer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }
}
