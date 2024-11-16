public class SkillBoxes extends Dialogue {

    public static String getSkillDescription(String currentWorld, int skillNumber){
    Cinderella cinderella = new Cinderella();
    Alice alice = new Alice();
    SnowWhite snow = new SnowWhite();
    
        return switch (currentWorld) {
            case "Cinderella" -> switch (skillNumber) {
                case 1 -> wrapText("GLASS SHARD STRIKE:\nA powerful attack using shards from her broken glass slipper, dealing up to [" + cinderella.getSkillDamage(1) + " damage] to enemies.", 120);
                case 2 -> wrapText("ENCHANTED RESILIENCE:\nCinderella gathers her courage for her next attack, healing herself for [20 health points] and dealing up to [" + cinderella.getSkillDamage(2) + " damage] to enemies.", 120);
                case 3 -> wrapText("MIDNIGHT ESCAPE:\nGrants temporary invisibility, making her untargetable for one [1] turn; does not deal damage.", 120);
                default -> wrapText("Invalid skill choice for Cinderella!");
            };
            case "Alice" -> switch (skillNumber) {
                case 1 -> wrapText("TEA PARTY CONFUSION:\nCasts a spell to confuse enemies, disorienting the enemy and dealing up to [" + alice.getSkillDamage(1) + " damage].", 120);
                case 2 -> wrapText("WONDERLAND JUMP:\nTeleports to avoid damage and reappears behind the enemy for a surprise attack for up to [" + alice.getSkillDamage(2) + " damage].\n" + "Alice dodges attacks for one [1] turn.", 120);
                case 3 -> wrapText("REJUVENATING SIP:\nRestores [30 health points] using a magical potion; does not deal damage.", 120);
                default -> wrapText("Invalid skill choice for Alice!");
            };
            case "SnowWhite" -> switch (skillNumber) {
                case 1 -> wrapText("POISONED APPLE STRIKE:\nCommands birds to peck the enemy, dealing up to [" + snow.getSkillDamage(1) + " damage].", 120);
                case 2 -> wrapText("ENCHANTED HEALING:\nSummons woodland creatures for an area attack, healing allies for [20 health points] and dealing up to [" + snow.getSkillDamage(2) + " damage].", 120);
                case 3 -> wrapText("FOREST'S AID:\nRaises a protective barrier, reducing damage taken for one turn; does not deal damage.", 120);
                default -> wrapText("Invalid skill choice for Snow White!");
            };
            default -> wrapText("Unknown character!");
        };
    }
}

