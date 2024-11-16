import java.util.Random;

public class PrinceHenry extends Enemy {
    private int mana;
    private static final int MAX_MANA = 210;
    private boolean isInvincible;
    private int invincibilityDuration;
    private int shieldHealth;
    private final int maxShieldHealth = 100;

    public PrinceHenry() {
        super("Prince Henry", 350, 10);
        this.mana = MAX_MANA;
        this.isInvincible = false;
        this.invincibilityDuration = 0;
        this.shieldHealth = 100;
    }

    @Override
    public void attack(Character player) {
        if (player.isInvisible()) {
            return;
        }

      

        Random random = new Random();
        int skillChoice = random.nextInt(3);

        if (isInvincible) {
            invincibilityDuration--;
            if (invincibilityDuration <= 0) {
                isInvincible = false;
            }
        }


        if (mana == 0) {
            useFirstSkill(player);
        } else if(mana < 200)
            switch (skillChoice) {
                case 0 -> useFirstSkill(player);
                case 1 -> useSecondSkill(player);
                case 2 -> useThirdSkill(player);
        }else{
            useInvincibility();
        }

        if(shieldHealth > 0 && shieldHealth != 100){
            System.out.println(Text.centerText(80, name + "'s " +
            "Shield health: " + shieldHealth + "/" + maxShieldHealth));
        }
    }
    

    private void useInvincibility() {
        if (mana >= 200) {
            isInvincible = true;
            invincibilityDuration = 1; // Consider decrementing this elsewhere if necessary
            shieldHealth = maxShieldHealth; // Initialize shield health to max when invincibility is activated
            mana -= 50;
            setMana(mana); // Assuming setMana updates mana properly
            System.out.println(Text.centerText(80, name + "'s Princely Shield is Active! Damage is absorbed by the shield.\n" +
            "Shield health: " + shieldHealth + "/" + maxShieldHealth));
        } else {
            System.out.println(Text.centerText(80, name + " tries to use Princely Shield, but his mana is insufficient!"));
        }
    }
    
    @Override
    public void receiveDamage(int damage) {
        // If the shield is active, absorb damage using shield health
        if (shieldHealth > 0) {
            shieldHealth -= damage;
    
            if (shieldHealth <= 0) { // The shield breaks after absorbing some or all damage
                System.out.println(Text.centerText(80, name + "'s Shield has been broken!"));
                shieldHealth = 0; // Ensure shield health is zero after breaking
            } else { // Shield absorbs damage, still intact
            }
        } else { // If shield is broken, apply the damage to health
            currentHealth -= damage;
            currentHealth = Math.max(currentHealth, 0); // Ensure health doesn't drop below zero
        }
    }
    

    private void useFirstSkill(Character player) {
        System.out.println(Text.centerText(80, name + " attacks with Shattered Vow!\n" + name + " deals " + (getAttackPower() + 30) + " damage to " + player.getName()));
        player.receiveDamage(getAttackPower() + 20);
        mana -= 0;
        setMana(mana);
    }

    private void useSecondSkill(Character player) {
        if (mana >= 20) {
            System.out.println(Text.centerText(80, name + " uses Royal Dust!\n" + name + " deals " + (getAttackPower() + 45) + " damage to " + player.getName()));
            player.receiveDamage(getAttackPower() + 45);
            mana -= 20;
            setMana(mana);
        } else {
            useFirstSkill(player);
        }
    }

    private void useThirdSkill(Character player) {
        if (mana >= 30) {
            System.out.println(Text.centerText(80, name + " uses Madman's Kiss!\n" + name + " deals " + (getAttackPower() + 90) + " damage to " + player.getName()));
            player.receiveDamage(getAttackPower() + 90);
            mana -= 30;
            setMana(mana);
        } else {
            useSecondSkill(player);
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
