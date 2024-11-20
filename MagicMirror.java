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
                case 1 -> useSecondSkill(player);
                case 2 -> useThirdSkill(player);
            }
        }
    }

    private void useFirstSkill(Character player) {
        Random random = new Random();
        int damage = random.nextInt(100);
        System.out.println(Text.centerText(80, name + " uses Reflective Glare!\n" + name + " reflects " + damage + " damage back to " + player.getName()));
        player.receiveDamage(damage);
        mana -= 20;
        setMana(mana);
    }

    private void useSecondSkill(Character player) {
        Random random = new Random(); 
        int damage = random.nextInt(75);
        if (mana >= 10) {
            System.out.println(Text.centerText(80, name + " uses Mirror's Blessing to heal!"));
            System.out.println(Text.centerText(80, name + " reflects " + damage + " damage back to " + player.getName()));
            heal(20); // Assuming the Enemy class has a heal method
            player.receiveDamage(damage);
            mana -= 10;
            setMana(mana);
            
        } else {
            useFirstSkill(null); // Default to first skill if not enough mana
        }
    }

    private void useThirdSkill(Character player) {
        Random random = new Random(); 
        int damage = random.nextInt(75);
        if (mana >= 30) {
            System.out.println(Text.centerText(80, name + " uses Mirror's Embrace!\n" + name + " creates a protective barrier, reducing incoming damage for 1 turn!"));
            System.out.println(Text.centerText(80, name + " creates impact on the battlefield!\n" + "Mystery damage will be given to " + player.getName()));
            player.receiveDamage(player.getLastSkillDamage(1) - 15); // Damage reduced by 15
            player.receiveDamage(damage);
            mana -= 30;
            setMana(mana);
           
        }
    }

    @Override
    public int getMana() {
        return mana;
    }

    @Override
    public void setMana(int mana) {
        this.mana = mana;
    }

    public static int getMaxMana() {
        return MAX_MANA;
    }
}
