import java.util.Random;

public class DarkSnowWhite extends Enemy {
    private int mana;
    private static final int MAX_MANA = 200;
    private boolean damageReductionActive; // Track if damage reduction is active
    private final int damageReductionPercentage = 20; // Set damage reduction percentage

    public DarkSnowWhite() {
        super("Dark Snow White", 400, 25); // 400 health, attack power 25
        this.mana = MAX_MANA;
        this.damageReductionActive = false; // Initially inactive
    }

    @Override
    public void attack(Character player) {
        if (player.isInvisible()) { // Check if invisible
            return;
        }

        Random random = new Random();
        int skillChoice = random.nextInt(3);

        if (mana == 0) {
            useFirstSkill(player);
        } else {
            switch (skillChoice) {
                case 0 -> useFirstSkill(player); // Poisoned Apple Strike
                case 1 -> useSecondSkill(player); // Enchanted Healing
                case 2 -> useThirdSkill(); // Forest's Aid
            }
        }
    }

    private void useFirstSkill(Character player) {
        System.out.println(Text.centerText(80, name + " uses Poisoned Apple Strike!\n" + name + " commands birds to peck " + player.getName() + ", dealing 30 damage!"));
        player.receiveDamage(30);
        mana -= 0;
        setMana(mana);
    }

    private void useSecondSkill(Character player) {
        if (mana >= 40) {
            int healAmount = 20;
            System.out.println(Text.centerText(120, name + " uses Enchanted Healing!\n" + name + " summons woodland creatures for an area attack,\n healing allies for " + healAmount + " health points and dealing 40 damage to " + player.getName() + "!"));
            player.receiveDamage(40); // Damage dealt to the player
            heal(healAmount); // Assuming the Enemy class has a heal method
            mana -= 40;
            setMana(mana);
        } else {
            useFirstSkill(player); 
        }
    }

    private void useThirdSkill() {
        if (mana >= 20) {
            System.out.println(Text.centerText(80, name + " uses Forest's Aid!\n" + name + " raises a protective barrier, reducing damage taken for one turn!"));
            activateDamageReduction(); // Activate damage reduction
            mana -= 20;
            setMana(mana);
        } else {
            System.out.println(Text.centerText(60,"Dark Snow White is out of mana!"));
        }
    }

    public void activateDamageReduction() {
        this.damageReductionActive = true; // Activate damage reduction
        System.out.println(Text.centerText(80, name + " has activated damage reduction!")); // Feedback for activation
    }

    public int applyDamageReduction(int damage) {
        if (damageReductionActive) {
            int reducedDamage = damage * (100 - damageReductionPercentage) / 100; // Calculate reduced damage
            System.out.println(Text.centerText(120, name + " reduces damage by " + damageReductionPercentage + "%, taking " + reducedDamage + " damage instead of " + damage + "."));
            return reducedDamage; // Return reduced damage
        }
        return damage; // No reduction if not active
    }

    public void deactivateDamageReduction() {
        this.damageReductionActive = false; // Deactivate damage reduction
        System.out.println(name + "'s damage reduction has ended."); // Feedback for deactivation
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
