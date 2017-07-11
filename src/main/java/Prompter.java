import java.util.Scanner;

public class Prompter {

    public Prompter() {
    }

    public String promptUserForValue(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        String userInput = scanner.nextLine();
        return userInput;
    }
}
