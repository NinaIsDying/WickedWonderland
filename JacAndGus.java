import java.util.Random;

public class JacAndGus extends Enemy {
    private int mana;
    private static final int MAX_MANA = 100;

    public JacAndGus() {
        super("Jaq and Gus", 100, 15); // Base health and attack power
        this.mana = MAX_MANA;
    }

    @Override
    public void attack(Character player) {
        Random random = new Random();
        int skillChoice = random.nextInt(3); // Randomly choose a skill

        if (mana == 0) {
            useFirstSkill(player);
        } else {
            switch (skillChoice) {
                case 0 -> useFirstSkill(player);
                case 1 -> useSecondSkill(player);
                case 2 -> useThirdSkill(player);
            }
        }
    }

    private void useFirstSkill(Character player) {
        // Calculate damage for the first skill
        int damage = getAttackPower();
        System.out.println(Text.centerText(80, name + " distracts you with a clever ruse!\n" + name + " deals " + damage + " damage to " + player.getName()));
        player.receiveDamage(damage);
    }

    private void useSecondSkill(Character player) {
        // Ensure there's enough mana for this skill
        if (mana >= 5) {
            int damage = getAttackPower() + 15; // Increased damage for the second skill
            System.out.println(Text.centerText(80, name + " throws a flurry of tiny tools!\n" + name + " deals " + damage + " damage to " + player.getName()));
            player.receiveDamage(damage);
            mana -= 5; // Deduct mana cost for second skill
            setMana(mana);
        } else {
            // Default to first skill if not enough mana
            useFirstSkill(player);
        }
    }

    private void useThirdSkill(Character player) {
        // Ensure there's enough mana for this skill
        if (mana >= 10) {
            int damage = getAttackPower() + 20; // Increased damage for the third skill
            System.out.println(Text.centerText(80, name + " sets a trap!\n" + name + " deals " + damage + " damage to " + player.getName()));
            player.receiveDamage(damage);
            mana -= 10; // Deduct mana cost for third skill
            setMana(mana);
        } else {
            // Default to second skill if not enough mana
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
