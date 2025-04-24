import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class Dictionary {
    private final Languages language;

    public Dictionary(Languages language) {
        this.language = language;
    }

    public String getDescription() {
        return language.getDescription();
    }

    public Path getLanguageFilePath() {
        Path rootDir = Paths.get("").toAbsolutePath();
        return rootDir.resolve("src", "dictionary", language.getFileName());
    }

    public String generateRandomWord() throws FileNotFoundException {
        Path filePath = getLanguageFilePath();

        if (!Files.exists(filePath))
            throw new FileNotFoundException("Language file not found :( \n!");

        try {
            List<String> words = Files.readAllLines(filePath);
            Random random = new Random();

            return words.get(random.nextInt(words.size()));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}