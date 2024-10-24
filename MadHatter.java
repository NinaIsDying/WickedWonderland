
public class MadHatter extends Enemy {
    
    public MadHatter() {
        super("Mad Hatter", 120, 25);  // Set name, health, and attack power
    }

    @Override
    public void attack(Character player) {
        // Randomly choose one of the three attacks to perform
        int attackChoice = (int) (Math.random() * 3);
        switch (attackChoice) {
            case 0 -> teaPartyAttack(player);
            case 1 -> hatTrickAttack(player);
            case 2 -> madDanceAttack(player);
        }
    }

    // First attack method: Tea Party Attack
    private void teaPartyAttack(Character player) {
        System.out.println(Text.centerText(name + " invites you to a tea party!"));
        int attackDamage = 30;  // Damage for the tea party attack
        player.receiveDamage(attackDamage);
        System.out.println(Text.centerText(name + " deals " + attackDamage + " damage with the tea party!"));
    }

    // Second attack method: Hat Trick Attack
    private void hatTrickAttack(Character player) {
        System.out.println(Text.centerText(name + " performs a hat trick!"));
        int attackDamage = 25;  // Damage for the hat trick attack
        player.receiveDamage(attackDamage);
        System.out.println(Text.centerText(name + " deals " + attackDamage + " damage with the hat trick!"));
    }

    // Third attack method: Mad Dance Attack
    private void madDanceAttack(Character player) {
        System.out.println(Text.centerText(name + " starts dancing madly!"));
        int attackDamage = 20;  // Damage for the mad dance attack
        player.receiveDamage(attackDamage);
        System.out.println(Text.centerText(name + " deals " + attackDamage + " damage with the mad dance!"));
    }
}
