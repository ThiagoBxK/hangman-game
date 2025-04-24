import java.io.IOException;
import java.util.Scanner;

public class HangmanGame {
    private Scanner scanner = new Scanner(System.in);

    public HangmanGame() {
    }

    public Languages selectLanguageUI() {
        System.out.println("*-------------- Language --------------*");
        System.out.println("🌐 Select game language: ");

        Languages[] languages = Languages.values();
        for (int index = 0; index < languages.length; index++) {
            System.out.printf("%d) %s \n", index + 1, languages[index].getDescription());
        }

        System.out.print("Option: ");
        int option = scanner.nextInt();

        if (option < 1 || option > languages.length) {
            System.out.println("Invalid option. Try again!");
            return selectLanguageUI();
        }

        Languages selected = languages[option - 1];
        System.out.printf("Language selected: %s \n", selected.getDescription());


        System.out.println("*--------------------------------------*");
        return selected;
    }


    public void showUI() {
        Languages language = selectLanguageUI();
        Dictionary dictionary = new Dictionary(language);

        try {
            String randomWord = dictionary.generateRandomWord();

            System.out.println(randomWord);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
