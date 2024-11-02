import java.util.Random;

public class FairyGodMother extends Enemy {
    private int mana;
    private static final int MAX_MANA = 150;

    public FairyGodMother() {
        super("Fairy Godmother", 150, 20);
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
        System.out.println(Text.centerText(80, name + " uses Bewitching Wand!\n" + name + " deals " + getAttackPower() + " damage to " + player.getName()));
        player.receiveDamage(getAttackPower() +20);
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

    // Skill 3: Mirror of Deception - Makes the player attack itself
    private void useThirdSkill(Character player) {
        if (mana >= 20) {
            int selfDamage = (player.getSkillDamage(1) + player.getSkillDamage(2))/ 2; // Half the player's attack power which is the sum of all its attack damage
            System.out.println(Text.centerText(100, name + " uses Mirror of Deception!\n" + player.getName() + " is forced to attack themselves, dealing " + selfDamage + " damage!"));
            player.receiveDamage(selfDamage);
            mana -= 20;
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
