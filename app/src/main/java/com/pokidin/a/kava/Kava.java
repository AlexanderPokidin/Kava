package com.pokidin.a.kava;


public class Kava {

    private String name;
    private String description;
    private String size;
    private int imageResourceId;
    private int price;

    public static final Kava[] kavas = {
            new Kava("Espresso", "Small koffee drink", "50", R.drawable.espresso_item, 10),
            new Kava("Americano", "Middle coffee drink", "100", R.drawable.kava_item, 12),
            new Kava("Latte", "Long koffee drink with milk", "350", R.drawable.kava_item, 20),
            new Kava("Cappuccino", "Koffee drink with milk and cream", "300", R.drawable.kava_item, 18),
            new Kava("Raf", "Koffee drink with cream", "270", R.drawable.kava_item, 25)
    };

    public Kava(String name, String description, String size, int imageResourceId, int price) {
        this.name = name;
        this.description = description;
        this.size = size;
        this.imageResourceId = imageResourceId;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getSize() {
        return size;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return this.name + " " + this.size;
    }
}
