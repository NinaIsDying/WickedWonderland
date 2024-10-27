/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author loqui
 */

// Event class to encapsulate event data
class Event {
    private String description;
    private int healthChange; // Positive for healing, negative for damage
    private int manaChange; // Positive for mana gain, negative for mana loss

    public Event(String description, int healthChange, int manaChange) {
        this.description = description;
        this.healthChange = healthChange;
        this.manaChange = manaChange;
    }

    public String getDescription() {
        return description;
    }

    public int getHealthChange() {
        return healthChange; // Returns the change in health
    }

    public int getManaChange() {
        return manaChange; // Returns the change in mana
    }

    // Returns the health effect (use existing healthChange)
    public int getHealthEffect() {
        return healthChange; // Return the health change
    }

    // Returns the mana effect (use existing manaChange)
    public int getManaEffect() {
        return manaChange; // Return the mana change
    }
}
