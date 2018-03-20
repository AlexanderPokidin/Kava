package com.pokidin.a.kava;


public class Kava {

    private String name;
    private String description;
    private String size;
    private int imageResourceId;
    private int price;

    public static final Kava[] kavas = {
            new Kava("Espresso", "Small koffee drink",
                    "30 ml", R.drawable.espresso_item, 12),
            new Kava("Espresso with milk", "Small koffee drink with milk",
                    "30 ml", R.drawable.espresso_item, 14),
            new Kava("Americano", "Middle coffee drink",
                    "175 ml", R.drawable.kava_item, 12),
            new Kava("Americano with milk" , "Middle coffee drink with milk",
                    "175 ml", R.drawable.kava_item, 14),
            new Kava("Americano", "Middle coffee drink",
                    "270 ml", R.drawable.kava_item, 20),
            new Kava("Americano with milk" , "Middle coffee drink with milk",
                    "270 ml", R.drawable.kava_item, 22),
            new Kava("Americano", "Middle coffee drink",
                    "400 ml", R.drawable.kava_item, 22),
            new Kava("Americano with milk" , "Middle coffee drink with milk",
                    "400 ml", R.drawable.kava_item, 24),
            new Kava("Raf", "Koffee drink with cream",
                    "175 ml", R.drawable.kava_item, 25),
            new Kava("Raf", "Koffee drink with cream",
                    "270 ml", R.drawable.kava_item, 30),
            new Kava("Raf", "Koffee drink with cream",
                    "400 ml", R.drawable.kava_item, 40),
            new Kava("Latte", "Long koffee drink with milk",
                    "270 ml", R.drawable.kava_item, 20),
            new Kava("Latte", "Long koffee drink with milk",
                    "400 ml", R.drawable.kava_item, 22),
            new Kava("Latte", "Long koffee drink with milk",
                    "500 ml", R.drawable.kava_item, 30),
            new Kava("Lav_Latte", "Long koffee drink with milk",
                    "270 ml", R.drawable.kava_item, 25),
            new Kava("Lav_Latte", "Long koffee drink with milk",
                    "400 ml", R.drawable.kava_item, 30),
            new Kava("Cappuccino", "Koffee drink with milk and cream", "300", R.drawable.kava_item, 18)
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
