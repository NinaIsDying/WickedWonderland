import java.util.Random;

public class MadHatter extends Enemy {
    private int mana;
    private static final int MAX_MANA = 150;

    public MadHatter() {
        super("Mad Hatter", 200, 25);
        this.mana = MAX_MANA;
    }

    @Override
    public void attack(Character player) {
        if (player.isInvisible()) { // Check if Alice is invisible
            System.out.println(Text.centerText(90, name + " attempts to attack, but " +  player.getName() + " is in the air and cannot be attacked!"));
            return; // Exit the method if Alice is invisible
        }
        Random random = new Random();
        int skillChoice = random.nextInt(3);

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
        System.out.println(Text.centerText(80, name + " invites you to a wild tea party!\n" + name + " deals " + (getAttackPower() + 30) + " damage to " + player.getName()));
        player.receiveDamage(getAttackPower() + 30);
    }

    private void useSecondSkill(Character player) {
        if (mana >= 10) {
            System.out.println(Text.centerText(80, name + " uses Hatter's Healing and recovers 20 HP!"));
            heal(20); // Assuming the Enemy class has a heal method
            mana -= 10;
            setMana(mana);
        } else {
            useFirstSkill(player); // Default to first skill if not enough mana
        }
    }

    private void useThirdSkill(Character player) {
        if (mana >= 20) {
            System.out.println(Text.centerText(80, name + " uses Madness Inducer!\n" + name + " confuses you, dealing " + (getAttackPower() + 40) + " damage!"));
            player.receiveDamage(getAttackPower() + 40);
            mana -= 20;
            setMana(mana);
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
