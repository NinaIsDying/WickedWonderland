import java.util.Random;

public class SevenDwarves extends Enemy {
    private static final String[] DWARF_NAMES = {"Doc", "Grumpy", "Happy", "Sleepy", "Sneezy", "Bashful", "Dopey"};
    private int currentDwarfIndex;
    private int mana;
    private static final int MAX_MANA = 100;

    public SevenDwarves() {
        super("Seven Dwarves", 120, 12); // Adjust health and attack power as needed
        this.currentDwarfIndex = 0; // Start with the first dwarf
        this.mana = MAX_MANA;
    }

    @Override
    public void attack(Character player) {
        Random random = new Random();
        int skillChoice = random.nextInt(7); // Choose a dwarf skill

        // Alternate to the next dwarf after each attack
        currentDwarfIndex = (currentDwarfIndex + 1) % DWARF_NAMES.length;

        switch (skillChoice) {
            case 0 -> useDocSkill(player);
            case 1 -> useGrumpySkill(player);
            case 2 -> useHappySkill(player);
            case 3 -> useSleepySkill(player);
            case 4 -> useSneezySkill(player);
            case 5 -> useBashfulSkill(player);
            case 6 -> useDopeySkill(player);
        }
    }

    private void useDocSkill(Character player) {
        System.out.println(Text.centerText(80, "Doc heals allies, restoring 20 health points!"));
        heal(20);
        mana -= 20;
        setMana(mana);
    }

    private void useGrumpySkill(Character player) {
        if (mana >= 5) {
            System.out.println(Text.centerText(80, "Grumpy throws a tantrum!\n" + "Grumpy deals " + (getAttackPower() + 5) + " damage to " + player.getName()));
            player.receiveDamage(getAttackPower() + 5);
            mana -= 5;
            setMana(mana);
        } else {
            attack(player); // No mana, use the next skill
        }
    }

    private void useHappySkill(Character player) {
        if (mana >= 10) {
            System.out.println(Text.centerText(80, "Happy sings a cheerful song!\n" + "Happy deals " + (getAttackPower() + 10) + " damage to " + player.getName()));
            player.receiveDamage(getAttackPower() + 10);
            mana -= 10;
            setMana(mana);
        } else {
            attack(player); // No mana, use the next skill
        }
    }

    private void useSleepySkill(Character player) {
        System.out.println(Text.centerText(80, "Sleepy grabs a pillow for a shield!\n" + player.getName() + "'s attack is blocked!"));
        mana -= 20;
        setMana(mana);
    }

    private void useSneezySkill(Character player) {
        System.out.println(Text.centerText(80, "Sneezy sneezes a powerful sneeze!\n" + "Sneezy deals " + (getAttackPower() + 15) + " damage to " + player.getName()));
        player.receiveDamage(getAttackPower() + 15);
        mana -= 10;
        setMana(mana);
    }

    private void useBashfulSkill(Character player) {
        if (mana >= 15) {
            System.out.println(Text.centerText(80, "Bashful throws a bashful attack!\n" + "Bashful deals " + (getAttackPower() + 20) + " damage to " + player.getName()));
            player.receiveDamage(getAttackPower() + 20);
            mana -= 15;
            setMana(mana);
        } else {
            attack(player); // No mana, use the next skill
        }
    }

    private void useDopeySkill(Character player) {
        System.out.println(Text.centerText(80, "Dopey confuses the enemy!\n" + player.getName() + " trips, receiving " + (getAttackPower()+10) + " damage."));
        player.receiveDamage(getAttackPower() + 10);
        mana -= 10;
        setMana(mana);
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
