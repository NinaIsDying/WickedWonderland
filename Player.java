/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author loqui
 */


public class Player extends Character {
    private int gold;

    // Constructor
    public Player(String name, int health, int mana, int gold) {
        super(name, health, mana);  // Pass health and mana to the Character class
        this.gold = gold;
    }

    // Getters and setters for gold
    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void decreaseGold(int amount) {
        if (this.gold >= amount) {
            this.gold -= amount;
        } else {
            System.out.println(Text.centerText("Not enough gold!"));
        }
    }

    // Heal the player (override if healing logic is different for Player)
    @Override
    public void heal(int amount) {
        setHealth(getHealth() + amount);
    }

    // Increase player's attack (optional feature depending on your design)
    public void increaseAttack(int amount) {
        // Assuming attack can be increased in the game
    }

    // Implement the special skills of the player
    @Override
    public void specialSkill1(Enemy enemy) {
        System.out.println(Text.centerText("Using special skill 1 on " + enemy.getName()));
        enemy.receiveDamage(20); // Example damage value, you can customize it
    }

    @Override
    public void specialSkill2(Enemy enemy) {
        System.out.println(Text.centerText("Using special skill 2 on " + enemy.getName()));
        enemy.receiveDamage(30);  // Another example, customize as needed
    }

    @Override
    public void specialSkill3(Enemy enemy) {
        System.out.println(Text.centerText("Using special skill 3 on " + enemy.getName()));
        enemy.receiveDamage(50);  // Another example, customize as needed
    }

}






