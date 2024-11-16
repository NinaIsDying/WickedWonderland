import java.util.Random;

public class MagicMirror extends Enemy {
    private int mana;
    private static final int MAX_MANA = 200;

    public MagicMirror() {
        super("Magic Mirror", 200, 25);
        this.mana = MAX_MANA;
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
                case 0 -> useFirstSkill(player);
                case 1 -> useSecondSkill();
                case 2 -> useThirdSkill(player);
            }
        }
    }

    private void useFirstSkill(Character player) {
        int damage = player.getLastSkillDamage(1);
        System.out.println(Text.centerText(80, name + " uses Reflective Glare!\n" + name + " reflects " + damage + " damage back to " + player.getName()));
        player.receiveDamage(damage);
        mana -= 20;
        setMana(mana);
    }

    private void useSecondSkill() {
        if (mana >= 10) {
            System.out.println(Text.centerText(80, name + " uses Mirror's Blessing to heal!"));
            heal(20); // Assuming the Enemy class has a heal method
            mana -= 10;
            setMana(mana);
        } else {
            useFirstSkill(null); // Default to first skill if not enough mana
        }
    }

    private void useThirdSkill(Character player) {
        if (mana >= 30) {
            System.out.println(Text.centerText(80, name + " uses Mirror's Embrace!\n" + name + " creates a protective barrier, reducing incoming damage for 1 turn!"));
            player.receiveDamage(player.getLastSkillDamage(1) - 15); // Damage reduced by 15
            mana -= 30;
            setMana(mana);
        } else {
            useSecondSkill(); // Default to second skill if not enough mana
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
