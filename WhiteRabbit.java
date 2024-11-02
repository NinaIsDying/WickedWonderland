import java.util.Random;

public class WhiteRabbit extends Enemy {
    private int mana;
    private static final int MAX_MANA = 210;

    public WhiteRabbit() {
        super("White Rabbit", 350, 35); // Set name, health, and base attack power
        this.mana = MAX_MANA; // Initialize mana
    }

    @Override
    public void attack(Character player) {
        if (player.isInvisible()) { // Check if Alice is invisible
            System.out.println(Text.centerText(90, name + " attempts to attack, but " +  player.getName() + " is in the air and cannot be attacked!"));
            return; // Exit the method if Alice is invisible
        }
        Random random = new Random();
        int skillChoice = random.nextInt(3); // Three skills to choose from

        if (mana == 0) {
            useFirstSkill(player); // Use first skill if no mana available
        } else {
            switch (skillChoice) {
                case 0 -> useFirstSkill(player); // Tick Tock Havoc
                case 1 -> useSecondSkill(player); // Tempered Dash
                case 2 -> useThirdSkill(player); // Time Loop
            }
        }
    }

    // First attack method: Tick Tock Havoc
    private void useFirstSkill(Character player) {
        System.out.println(Text.centerText(name + " strikes swiftly with a ticking fury!"));
        int attackDamage = 35; // Damage for Tick Tock Havoc attack
        player.receiveDamage(attackDamage);
        mana -= 40; // Reduce mana for using this attack
        System.out.println(Text.centerText(name + " deals " + attackDamage + " damage with Tick Tock Havoc!"));
    }

    // Second attack method: Tempered Dash
    private void useSecondSkill(Character player) {
        if (mana >= 30) {
            System.out.println(Text.centerText(name + " dodges swiftly, evading attacks and countering!"));
            int counterAttackDamage = 25; // Damage for Tempered Dash counter-attack
            player.receiveDamage(counterAttackDamage);
            mana -= 30; // Reduce mana for using this attack
            System.out.println(Text.centerText(name + " counters with " + counterAttackDamage + " damage using Tempered Dash!"));
        } else {
            useFirstSkill(player); // Default to first skill if no mana
        }
    }

    // Third attack method: Time Loop
    private void useThirdSkill(Character player) {
        System.out.println(Text.centerText(name + " reverses time, recovering health!"));
        int healAmount = 20; // Amount of health recovered
        heal(healAmount);
        System.out.println(Text.centerText(name + " restores " + healAmount + " health with Time Loop!"));
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

