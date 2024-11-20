import java.util.Random;

public class MadHatter extends Enemy {
    private int mana;
    private static final int MAX_MANA = 150;
    private int healingUsedCount; // Counter to track how many times healing is used

    public MadHatter() {
        super("Mad Hatter", 200, 25); // Enemy with initial health and attack power
        this.mana = MAX_MANA;
        this.healingUsedCount = 0; // Initialize healing counter
    }

    @Override
    public void attack(Character player) {
        if (player.isInvisible()) {
            System.out.println(Text.centerText(90, name + " attempts to attack, but " + player.getName() + " is in the air and cannot be attacked!"));
            return;
        }

        Random random = new Random();
        int skillChoice = random.nextInt(10); // Decide which skill to use (0-9)

        if (mana == 0) {
            useFirstSkill(player); // Default to first skill if no mana
        } else {
            if (skillChoice < 7) { // 70% chance for the first skill
                useFirstSkill(player);
            } else if (skillChoice < 9) { // 20% chance for the third skill
                if (mana >= 60) useThirdSkill(player);
                else useFirstSkill(player);
            } else { // 10% chance for the second skill
                if (mana >= 20 && healingUsedCount < 2) {
                    useSecondSkill(player); // Use healing only if allowed
                } else {
                    useFirstSkill(player);
                }
            }
        }
    }

    private void useFirstSkill(Character player) {
        int damage = randomizeDamage(25, 35); // Min: 10, Max: 35
        System.out.println(Text.centerText(80, name + " invites you to a wild tea party!\n" + name + " deals " + damage + " damage to " + player.getName()));
        player.receiveDamage(damage);
    }

    private void useSecondSkill(Character player) {
        System.out.println(Text.centerText(80, name + " uses Hatter's Healing and recovers 10 HP!"));
        heal(10);
        mana -= 15; // Mana cost for healing
        setMana(mana);
        healingUsedCount++; // Increment healing usage counter
    }

    private void useThirdSkill(Character player) {
        int damage = randomizeDamage(35, 45); // Min: 20, Max: 45
        System.out.println(Text.centerText(80, name + " uses Madness Inducer!\n" + name + " confuses you, dealing " + damage + " damage!"));
        player.receiveDamage(damage);
        mana -= 30; // Mana cost for this skill
        setMana(mana);
    }

    private int randomizeDamage(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min; // Random number between min and max (inclusive)
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }
}
