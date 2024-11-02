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
                case 2 -> useThirdSkill(player, player.getLastSkillDamage()); // Reflective glare using last skill damage
            }
        }
    }

    private void useFirstSkill(Character player) {
        System.out.println(Text.centerText(80, name + " uses Reflective Glare!\n" + name + " reflects " + player.getLastSkillDamage() + " damage back to " + player.getName()));
        player.receiveDamage(player.getLastSkillDamage()); // Reflecting damage based on last skill used
        mana -= 20; // Cost of using the skill
    }

    private void useSecondSkill() {
        if (mana >= 10) {
            int healAmount = 30;
            System.out.println(Text.centerText(80, name + " uses Cursed Blessing and heals for " + healAmount + " HP!"));
            heal(healAmount); // Assuming the Enemy class has a heal method
            mana -= 10;
        } else {
            useFirstSkill(null); // Default to first skill if not enough mana
        }
    }

    // Skill 3: Mirror of Deception - Makes the player attack themselves
    private void useThirdSkill(Character player, int lastSkillDamage) {
        if (mana >= 20) {
            int selfDamage = lastSkillDamage; // Use the last skill damage for self-damage
            System.out.println(Text.centerText(100, name + " uses Mirror of Deception!\n" + player.getName() + " is forced to attack themselves, dealing " + selfDamage + " damage!"));
            player.receiveDamage(selfDamage);
            mana -= 20; // Cost of using the skill
        } else {
            useFirstSkill(player); // Default to first skill if not enough mana
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
