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
        if (player.isInvisible()) {
            System.out.println(Text.centerText(90, name + " attempts to attack, but " + player.getName() + " is in the air and cannot be attacked!"));
            return;
        }

        Random random = new Random();
        int skillChoice = random.nextInt(3); // Randomly pick a skill (0-2)

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
        int damage = randomizeDamage(30, 35); // Min: 15, Max: 25
        System.out.println(Text.centerText(80, name + " spins wildly, creating a whirlwind of chaos!\n" + name + " deals " + damage + " damage to " + player.getName()));
        player.receiveDamage(damage);
    }

    private void useSecondSkill(Character player) {
        if (mana >= 30) {
            int damage = randomizeDamage(35, 45); // Min: 25, Max: 35
            System.out.println(Text.centerText(80, name + " unleashes a torrent of scalding tea!\n" + name + " deals " + damage + " damage to " + player.getName()));
            player.receiveDamage(damage);
            mana -= 30;
            setMana(mana);
        } else {
            useFirstSkill(player);
        }
    }

    private void useThirdSkill(Character player) {
        if (mana >= 50) {
            int damage = randomizeDamage(35, 50); // Min: 35, Max: 50
            System.out.println(Text.centerText(80, name + " throws a wave of enchanted teacups!\n" + name + " deals " + damage + " damage to " + player.getName()));
            player.receiveDamage(damage);
            mana -= 50;
            setMana(mana);
        } else {
            useSecondSkill(player);
        }
    }

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

    public static int getMaxMana() {
        return MAX_MANA;
    }
}
