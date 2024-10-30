public class SkillBoxes extends Dialogue {

    public static String getSkillDescription(String currentWorld, int skillNumber) {
        return switch (currentWorld) {
            case "Cinderella" -> switch (skillNumber) {
                case 1 -> wrapText("GLASS SHARD STRIKE:\nA powerful attack using shards from her broken glass slipper, dealing [30 damage] to enemies.", 120);
                case 2 -> wrapText("ENCHANTED RESILIENCE:\nCinderella gathers her courage for her next attack, healing herself for [20 health points] and dealing [50 damage] to enemies.", 120);
                case 3 -> wrapText("MIDNIGHT ESCAPE:\nGrants temporary invisibility, making her untargetable for one turn; does not deal damage.", 120);
                default -> wrapText("Invalid skill choice for Cinderella!");
            };
            case "Alice" -> switch (skillNumber) {
                case 1 -> wrapText("TEA PARTY CONFUSION:\nA swipe with her Vorpal blade, disorienting the enemy and dealing [30 damage].", 120);
                case 2 -> wrapText("WONDERLAND JUMP:\nCreates illusions to confuse the enemy, dealing [50 damage] while evading attacks.", 120);
                case 3 -> wrapText("REJUVENATING SIP:\nRestores [30 health points] using a magical potion; does not deal damage.", 120);
                default -> wrapText("Invalid skill choice for Alice!");
            };
            case "SnowWhite" -> switch (skillNumber) {
                case 1 -> wrapText("POISONED APPLE STRIKE:\nCommands birds to peck the enemy, dealing [30 damage].", 120);
                case 2 -> wrapText("ENCHANTED HEALING:\nSummons woodland creatures for an area attack, healing allies for [50 health points].", 120);
                case 3 -> wrapText("FOREST'S AID:\nRaises a protective barrier, reducing damage taken for one turn; does not deal damage.", 120);
                default -> wrapText("Invalid skill choice for Snow White!");
            };
            default -> wrapText("Unknown character!");
        };
    }
}
