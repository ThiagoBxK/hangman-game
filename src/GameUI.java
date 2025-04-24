import java.util.Scanner;

public class GameUI {
    private Scanner scanner = new Scanner(System.in);

    public Languages selectLanguageUI() {
        System.out.println("*-------------- Language --------------*");
        System.out.println("🌐 Select game language: ");

        Languages[] languages = Languages.values();
        for (int index = 0; index < languages.length; index++) {
            System.out.printf("%d) %s \n", index + 1, languages[index].getDescription());
        }

        System.out.print("Choose an option: ");
        int option = scanner.nextInt();

        if (option < 1 || option > languages.length) {
            System.out.println("Invalid language option. Try again!");
            return selectLanguageUI();
        }

        Languages selected = languages[option - 1];
        System.out.printf("Language selected: %s \n", selected.getDescription());

        System.out.println("*--------------------------------------*");
        return selected;
    }
}
