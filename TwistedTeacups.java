import java.util.Random;

public class TwistedTeacups extends Enemy {
    private int mana;
    private static final int MAX_MANA = 150;

    public TwistedTeacups() {
        super("Twisted Teacups", 100, 20);
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
        System.out.println(Text.centerText(80, name + " spins wildly, creating a whirlwind of chaos!\n" + name + " deals " + getAttackPower() + " damage to " + player.getName()));
        player.receiveDamage(getAttackPower());
    }

    private void useSecondSkill(Character player) {
        if (mana >= 30) {
            System.out.println(Text.centerText(80, name + " unleashes a torrent of scalding tea!\n" + name + " deals " + (getAttackPower() + 15) + " damage to " + player.getName()));
            player.receiveDamage(getAttackPower() + 15); // More damage
            mana -= 30; // Reduce mana for using this attack
        } else {
            useFirstSkill(player); // Default to first skill if no mana
        }
    }

    private void useThirdSkill(Character player) {
        if (mana >= 50) {
            System.out.println(Text.centerText(80, name + " throws a wave of enchanted teacups!\n" + name + " deals " + (getAttackPower() + 25) + " damage to " + player.getName()));
            player.receiveDamage(getAttackPower() + 25); // Even more damage
            mana -= 50; // Reduce mana for using this attack
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
