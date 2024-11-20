import java.util.Random;

public class WhiteRabbit extends Enemy {
    private int mana;
    private static final int MAX_MANA = 180;

    public WhiteRabbit() {
        super("White Rabbit", 400, 40); // Balanced health and attack
        this.mana = MAX_MANA;
    }

    @Override
    public void attack(Character player) {
        if (player.isInvisible()) {
            System.out.println(Text.centerText(90, name + " attempts to attack, but " + player.getName() + " is in the air and cannot be attacked!"));
            return;
        }

        Random random = new Random();
        int skillChoice = random.nextInt(10); // Random number between 0-9

        if (mana == 0) {
            useFirstSkill(player); // Fallback to first skill if mana is depleted
        } else {
            if (skillChoice < 4) { // 40% chance for the first skill
                useFirstSkill(player);
            } else if (skillChoice < 8) { // 40% chance for the second skill
                if (mana >= 35) {
                    useSecondSkill(player);
                } else {
                    useFirstSkill(player);
                }
            } else { // 20% chance for the third skill
                if (mana >= 50) {
                    useThirdSkill(player);
                } else if (mana >= 35) {
                    useSecondSkill(player);
                } else {
                    useFirstSkill(player);
                }
            }
        }
    }

    private void useFirstSkill(Character player) {
        int attackDamage = randomizeDamage(35, 40); // Min: 15, Max: 25
        System.out.println(Text.centerText(80, name + " strikes swiftly with a ticking fury!"));
        player.receiveDamage(attackDamage);
        mana -= 30;
        System.out.println(Text.centerText(80, name + " deals " + attackDamage + " damage with Tick Tock Havoc!"));
    }

    private void useSecondSkill(Character player) {
        int counterAttackDamage = randomizeDamage(38, 48); // Min: 20, Max: 35
        System.out.println(Text.centerText(80, name + " dodges swiftly, evading attacks and countering! (Damage: " + counterAttackDamage + ")"));
        player.receiveDamage(counterAttackDamage);
        mana -= 35;
        setMana(mana);
    }

    private void useThirdSkill(Character player) {
        int healAmount = 15; // Fixed heal amount
        System.out.println(Text.centerText(80, name + " reverses time, recovering health! (Heal: " + healAmount + ")"));
        heal(healAmount);
        mana -= 50;
        setMana(mana);
    }

    // Randomizes attack damage within a min and max range
    private int randomizeDamage(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min; // Random damage between min and max (inclusive)
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }
}
