
public class Text {
 
    //this method has 'press any key to continue'
    //centerTEXt does not
    public static String centerBox(String text) {
        int boxWidth = 100;
        int terminalWidth = 200;
    
        int boxPadding = (terminalWidth - boxWidth) / 2;
        String boxPad = new String(new char[boxPadding]).replace("\0", " ");
    
        // Using thick box-drawing characters
        String horizontalBorder = "\u2554" + new String(new char[boxWidth]).replace("\0", "\u2550") + "\u2557";
    
        String[] lines = text.split("\n");
        StringBuilder sb = new StringBuilder();
    
        sb.append(boxPad).append(horizontalBorder).append("\n");
    
        for (String line : lines) {
            int paddingSizeText = (boxWidth - line.length()) / 2;
            String paddingText = new String(new char[Math.max(0, paddingSizeText)]).replace("\0", " ");
            sb.append(boxPad).append("\u2551").append(paddingText).append(line).append(paddingText);
            
            if ((line.length() % 2) != (boxWidth % 2)) {
                sb.append(" ");
            }
            
            sb.append("\u2551").append("\n");
        }
    
        String prompt = "~~Press any key to continue~~";
        int paddingSizePrompt = (boxWidth - prompt.length()) / 2;
        String paddingPrompt = new String(new char[Math.max(0, paddingSizePrompt)]).replace("\0", " ");
    
        sb.append(boxPad).append("\u2551").append(paddingPrompt).append(prompt).append(paddingPrompt);
        
        if ((prompt.length() % 2) != (boxWidth % 2)) {
            sb.append(" ");
        }
    
        sb.append("\u2551").append("\n");
        sb.append(boxPad).append("\u255A").append(new String(new char[boxWidth]).replace("\0", "\u2550")).append("\u255D");
    
        return sb.toString();
    }

    public static String centerText( String text) {
            int boxWidth = 100;
            int terminalWidth = 200;

            int boxPadding = (terminalWidth - boxWidth) / 2;
            String boxPad = new String(new char[boxPadding]).replace("\0", " ");

            String horizontalBorder = "\u2554" + new String(new char[boxWidth]).replace("\0", "\u2550") + "\u2557";

            String[] lines = text.split("\n");
            StringBuilder sb = new StringBuilder();

            sb.append(boxPad).append(horizontalBorder).append("\n");

            for (String line : lines) {
                int paddingSizeText = (boxWidth - line.length()) / 2;
                String paddingText = new String(new char[Math.max(0, paddingSizeText)]).replace("\0", " ");
                sb.append(boxPad).append("\u2551").append(paddingText).append(line).append(paddingText);

                if ((line.length() % 2) != (boxWidth % 2)) {
                    sb.append(" ");
                }

                sb.append("\u2551").append("\n");
            }

            horizontalBorder = "\u255A" + new String(new char[boxWidth]).replace("\0", "\u2550") + "\u255D";
            sb.append(boxPad).append(horizontalBorder);

            return sb.toString();
        }

        public static String centerText(int size,  String text) {
            int boxWidth = size;
            int terminalWidth = 200;
    
            int boxPadding = (terminalWidth - boxWidth) / 2;
            String boxPad = new String(new char[boxPadding]).replace("\0", " ");
    
            String horizontalBorder = "\u2554" + new String(new char[boxWidth]).replace("\0", "\u2550") + "\u2557";
    
            String[] lines = text.split("\n");
            StringBuilder sb = new StringBuilder();
    
            sb.append(boxPad).append(horizontalBorder).append("\n");
    
            for (String line : lines) {
                int paddingSizeText = (boxWidth - line.length()) / 2;
                String paddingText = new String(new char[Math.max(0, paddingSizeText)]).replace("\0", " ");
                sb.append(boxPad).append("\u2551").append(paddingText).append(line).append(paddingText);
    
                if ((line.length() % 2) != (boxWidth % 2)) {
                    sb.append(" ");
                }
    
                sb.append("\u2551").append("\n");
            }
    
            horizontalBorder = "\u255A" + new String(new char[boxWidth]).replace("\0", "\u2550") + "\u255D";
            sb.append(boxPad).append(horizontalBorder);
    
            return sb.toString();
        }

        public static String centerText(int size, int terminal, String text) {
            int boxWidth = size;
            int terminalWidth = terminal;
    
            int boxPadding = (terminalWidth - boxWidth) / 2;
            String boxPad = new String(new char[boxPadding]).replace("\0", " ");
    
            String horizontalBorder = "\u2554" + new String(new char[boxWidth]).replace("\0", "\u2550") + "\u2557";
    
            String[] lines = text.split("\n");
            StringBuilder sb = new StringBuilder();
    
            sb.append(boxPad).append(horizontalBorder).append("\n");
    
            for (String line : lines) {
                int paddingSizeText = (boxWidth - line.length()) / 2;
                String paddingText = new String(new char[Math.max(0, paddingSizeText)]).replace("\0", " ");
                sb.append(boxPad).append("\u2551").append(paddingText).append(line).append(paddingText);
    
                if ((line.length() % 2) != (boxWidth % 2)) {
                    sb.append(" ");
                }
    
                sb.append("\u2551").append("\n");
            }
    
            horizontalBorder = "\u255A" + new String(new char[boxWidth]).replace("\0", "\u2550") + "\u255D";
            sb.append(boxPad).append(horizontalBorder);
    
            return sb.toString();
        }
    }
    
