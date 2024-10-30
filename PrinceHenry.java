import java.util.Random;

public class PrinceHenry extends Enemy {
    private int mana;
    private static final int MAX_MANA = 210;
    private boolean isInvincible; // Tracks invincibility status
    private int invincibilityDuration; // Turns left for invincibility
    private int shieldHealth; // Second health bar (shield)

    public PrinceHenry() {
        super("Prince Henry", 350, 50);
        this.mana = MAX_MANA;
        this.isInvincible = false; // Initially not invincible
        this.invincibilityDuration = 0; // No invincibility at start
        this.shieldHealth = 150; // Initialize shield health
    }

    @Override
    public void attack(Character player) {
        Random random = new Random();
        int skillChoice = random.nextInt(4); // Updated to include the invincibility skill

        if (isInvincible) {
            System.out.println(Text.centerText(80, name + " is invincible this turn! No damage taken."));
            invincibilityDuration--; // Decrement duration
            if (invincibilityDuration <= 0) {
                isInvincible = false; // Reset invincibility after the turn
            }
            return; // Skip attack if invincible
        }

        if (mana == 0) {
            useFirstSkill(player);
        } else {
            switch (skillChoice) {
                case 0 -> useFirstSkill(player);
                case 1 -> useSecondSkill(player);
                case 2 -> useThirdSkill(player);
                case 3 -> useInvincibility(); // Use invincibility skill
            }
        }
    }

    // Invincibility Skill
    private void useInvincibility() {
        if (mana >= 15) { // Cost for using invincibility
            isInvincible = true;
            invincibilityDuration = 1; // Invincible for one turn
            mana -= 15; // Deduct mana
            System.out.println(Text.centerText(80, name + " uses Princely Shield! He cannot take damage for two turns."));
        } else {
            System.out.println(Text.centerText(80, name + " does not have enough mana to use invincibility!"));
        }
    }

    // Method to receive damage, considering shield health first
    public void receiveDamage(int damage) {
        if (shieldHealth > 0) {
            shieldHealth -= damage;
            if (shieldHealth < 0) {
                int remainingDamage = Math.abs(shieldHealth); // Get the remaining damage
                shieldHealth = 0; // Set shield health to 0
                currentHealth -= remainingDamage; // Apply remaining damage to main health
                currentHealth = Math.max(currentHealth, 0); // Ensure main health doesn't go below zero
            }
            System.out.println(Text.centerText(80, name + " takes " + damage + " damage! Shield health: " + shieldHealth + ", Current health: " + currentHealth + "/" + maxHealth));
        } else {
            currentHealth -= damage; // Directly reduce main health if shield is down
            currentHealth = Math.max(currentHealth, 0); // Ensure main health doesn't go below zero
            System.out.println(Text.centerText(80, name + " takes " + damage + " damage! Current health: " + currentHealth + "/" + maxHealth));
        }
    }

    private void useFirstSkill(Character player) {
        System.out.println(Text.centerText(80, name + " attacks with Shattered Vow!\n" + name + " deals " + (getAttackPower() + 30) + " damage to " + player.getName()));
        player.receiveDamage(getAttackPower() + 30);
        mana -= 5;
    }

    private void useSecondSkill(Character player) {
        if (mana >= 5) {
            System.out.println(Text.centerText(80, name + " uses Royal Dust!\n" + name + " deals " + (getAttackPower() + 45) + " damage to " + player.getName()));
            player.receiveDamage(getAttackPower() + 45); // More damage
            mana -= 5;
        } else {
            useFirstSkill(player); // Default to first skill if no mana
        }
    }

    private void useThirdSkill(Character player) {
        if (mana >= 10) {
            System.out.println(Text.centerText(80, name + " uses Madman's Kiss!\n" + name + " deals " + (getAttackPower() + 90) + " damage to " + player.getName()));
            player.receiveDamage(getAttackPower() + 90); // Even more damage
            mana -= 10;
        } else {
            useSecondSkill(player); // Default to second skill if not enough mana
        }
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public static int getMaxMana() {
        return MAX_MANA;
    }
}
