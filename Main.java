public class Main {
    public static void main(String[] args) {
        System.out.println();
        String message = "Dive into a race against time in 'WordRescue,' where your words save a sinking man. Guess right, defy the odds, and be the hero he desperately needs";

        // Find the length of the longest line
        int maxLength = 0;
        for (String line : message.split("\n")) {
            maxLength = Math.max(maxLength, line.length());
        }

        // Create the top border
        System.out.println("+" + "-".repeat(maxLength + 4) + "+");

        // Print each line with side borders
        for (String line : message.split("\n")) {
            System.out.printf("| %-" + maxLength + "s |\n", line);
        }

        // Create the bottom border
        System.out.println("+" + "-".repeat(maxLength + 4) + "+");
        System.out.println();
        GuessTheWord game = new GuessTheWord();
        game.start();
        game.end();
    }
}