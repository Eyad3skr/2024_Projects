import java.util.Scanner;

public class GuessTheWord {
    private boolean isPlaying = true;
    private words randomWord = new words();
    private Scanner scanner = new Scanner(System.in);
    private Man man = new Man();

    public void start() {
        while (isPlaying) {
            showWord();
            getInput();
            checkInput();
        }
    }

    private void showWord() {
        System.out.println(randomWord);
    }

    private void getInput() {
        System.out.println("Enter a letter to guess the word: ");
        String userGuess = scanner.nextLine().toLowerCase();
        if (!userGuess.isEmpty()) {
            randomWord.guess(userGuess.charAt(0), man);
        } else {
            System.out.println("Please enter a valid letter.");
        }
    }

    private void checkInput() {
        if (randomWord.isGuessedRight()) {
            handleGameEnd("╭────────────────────────────────╮\n" +
                    "│            You Won!            │\n" +
                    "│                                │\n" +
                    "│     \uD83C\uDF86\uD83C\uDF87\uD83C\uDF1F\uD83C\uDF86\uD83C\uDF87\uD83C\uDF1F\uD83C\uDF86\uD83C\uDF87          │\n" +
                    "│     \uD83C\uDF86\uD83C\uDF87\uD83C\uDF1F\uD83C\uDF86\uD83C\uDF87\uD83C\uDF1F\uD83C\uDF86\uD83C\uDF87          │\n" +
                    "│                                │\n" +
                    "╰────────────────────────────────╯\n");
        }
        else {
            man.displayCurrent();
            if(man.mistakes > 3){
                handleGameEnd("╔════════════════════════╗\n" +
                        "║        Game Over       ║\n" +
                        "╚════════════════════════╝\n");
            }
        }
    }

    private void handleGameEnd(String message) {
        System.out.println(message);
        System.out.println("The Word is " + randomWord.word);
        System.out.println("Want to play again? (yes/no)");
        String playAgain = scanner.nextLine().toLowerCase();
        if ("yes".equals(playAgain)) {
            resetGame();
        } else {
            end();
        }
    }

    private void resetGame() {
        randomWord = new words();
        Man.mistakes = 0;
        man.reset();
    }

    public void end() {
        isPlaying = false;
        scanner.close();
    }

    public static void main(String[] args) {
        GuessTheWord game = new GuessTheWord();
        game.start();
        game.end();
    }
}
