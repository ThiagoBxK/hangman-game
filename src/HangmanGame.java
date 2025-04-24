import java.io.FileNotFoundException;
import java.util.*;

public class HangmanGame extends GameUI {
    private Scanner scanner = new Scanner(System.in);
    private Languages language;
    private Dictionary dictionary;
    private HashSet<Character> attemps;
    private int totalAttemps;
    private String word;

    public HangmanGame() throws FileNotFoundException {
        Languages language = selectLanguageUI();

        this.dictionary = new Dictionary(language);
        this.word = generateRandomWord();
        this.attemps = new HashSet<>();
        this.totalAttemps = 5;
    }

    public String generateRandomWord() throws FileNotFoundException {
        return dictionary.generateRandomWord().toLowerCase();
    }

    public boolean isCorrectGuess(Character character) {
        return word.indexOf(character) >= 0;
    };

    public String getMaskaredWords(String word) {
        ArrayList<Character> maskared = new ArrayList<>();

        for (Character character : this.word.toCharArray()) {
            if (attemps.contains(character)) {
                maskared.add(character);
            } else {
                maskared.add('_');
            }
        }

        return maskared.toString();
    }

    public void guessWords(String word) {
        if (totalAttemps < 1) {
            System.out.println("Lose!");
            return;
        }

        System.out.println(getMaskaredWords(this.word));
        System.out.print("\n 🎯 Your guess (one letter): ");
        Character character = scanner.next().charAt(0);

        if (attemps.contains(character)) {
            System.out.printf("⚠️ You already tried '%s'. Try another one.", character);
            guessWords(this.word);
        }

        attemps.add(character);
        if (isCorrectGuess(character)) {
            System.out.println("Correct!");
        } else {
            System.out.println("Wrong guess :(");
            this.totalAttemps--;
        }

        System.out.println(getMaskaredWords(this.word));
        System.out.printf("\n Your attemps: %s \n", attemps.toString());
        System.out.printf("\n Total attemps: %s \n", totalAttemps);

        guessWords(word);
    }

    public void start() {
        guessWords(this.word);
    }
}
