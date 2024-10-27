/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author loqui
 */

public class Item {
    private String name;
    private int price;
    private String effect;  // Can be 'heal' or 'attackBoost'
    private int value;      // Represents how much health or attack to boost

    // Constructor
    public Item(String name, int price, String effect, int value) {
        this.name = name;
        this.price = price;
        this.effect = effect;
        this.value = value;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getEffect() {
        return effect;
    }

    public int getValue() {
        return value;
    }

    // Display item info
    public String displayItem() {
        return name + " - " + price + " gold";
    }
}
