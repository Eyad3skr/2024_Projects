import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class words {
    private HashMap<String, String> randomWords;
    private String selectedWord;
    private char[] letters;
    private Random random = new Random();
    public String word;
    List<String> remainingRiddles;

    public words() {
        // Initialize the HashMap in the constructor
        randomWords = new HashMap<>();
        randomWords.put("A word that contains all of the twenty-six letters?", "alphabet");
        randomWords.put("A color you can eat", "orange");
        randomWords.put("I touch the earth and I touch the sky, but if I touch you, you’ll likely die.", "lightning");
     /*   randomWords.put("Forward I am heavy, but backward I am not. What am I?", "ton");
        randomWords.put("I’m tall when I’m young, and I’m short when I’m old. What am I?", "candle");
        randomWords.put("Goes up but never comes down", "age");
        randomWords.put("I shave every day, but my beard stays the same", "barber");
        randomWords.put("Has many keys but can’t open a single lock", "piano");
        randomWords.put("What can you catch, but not throw?", "cold");
        randomWords.put("Runs all around a backyard, yet never moves", "fence");
        randomWords.put("Has a head and a tail but no body", "coin");
        randomWords.put("Building that has the most stories", "library");
        randomWords.put("I am an odd number. Take away a letter and I become even. What number am I?", "seven");
        randomWords.put("What begins with an \"e\" and only contains one letter?", "envelope");
        randomWords.put("What is 3/7 chicken, 2/3 cat and 2/4 goat?", "chicago");
        randomWords.put("So fragile that saying its name breaks it", "silence");
        randomWords.put("Can fill a room but takes up no space", "light");
        randomWords.put("If you drop me I’m sure to crack, but give me a smile and I’ll always smile back.", "mirror");
        randomWords.put("I turn once, what is out will not get in. I turn again, what is in will not get out. What am I?", "key");
        randomWords.put("I have lakes with no water, mountains with no stone and cities with no buildings. What am I?", "map");
        randomWords.put("What word is pronounced the same if you take away four of its five letters?", "queue");*/

        // Initialize the selected word and letters array
        remainingRiddles = new ArrayList<>(randomWords.keySet());
        selectedWord = getRandomWord();
        letters = new char[selectedWord.length()];
    }

    private String getRandomWord() {
        if (remainingRiddles.isEmpty()) {
            // If there are no more riddles, return an empty string or handle it as needed
            return "Congratulations! You've guessed all the words!";
        }
        // Choose a random word from the remainingRiddles list
        int randomIndex = random.nextInt(remainingRiddles.size());
        String selectedRiddle = remainingRiddles.remove(randomIndex);
        System.out.println(selectedRiddle);
        word = randomWords.get(selectedRiddle);
        return word;
    }

    public String toString() {
        StringBuilder text = new StringBuilder();
        for (char letter : letters) {
            text.append(letter == '\u0000' ? '-' : letter);
            text.append(' ');
        }
        return text.toString();
    }

    public boolean isGuessedRight() {
        for (char letter : letters) {
            if (letter == '\u0000') {
                return false;
            }
        }
        return true;
    }

    public void guess(char letter, Man man) {
        boolean flag = false;
        for (int i = 0; i < selectedWord.length(); i++) {
            if (letter == selectedWord.charAt(i)) {
                letters[i] = letter;
                flag = true;
            }
        }
        if (!flag) {
            man.mistakes++;
        }
    }
}
