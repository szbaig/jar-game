
public class Game {
    private Jar jar;
    private String userPrompt;
    private int attempts;

    public Game(Jar jar) {
        this.jar = jar;
        this.userPrompt = "";
        this.attempts = 0;
    }

    public Jar getJar() {
        return jar;
    }

    public String getUserPrompt() {
        return userPrompt;
    }

    public void setUserPrompt(String userPrompt) {
        this.userPrompt = userPrompt;
    }

    public void startNewGame() {
        jar.fill();
        this.setUserPrompt("How many " + jar.getItem_name() + " are in the jar? Pick a number between 1 and " + jar.getMax_number_of_items() + ". ");
        boolean hasWon = this.promptForGuess();
        if(hasWon) {
            this.endGame();
        }
    }

    public void endGame() {
        String attemptsText = this.attempts == 1 ? "attempt" : "attempts";
        String message = "Congratulations you correctly guessed the number of " + jar.getItem_name() + " that were in the jar. It took you " + this.getAttempts() + " " + attemptsText + ".";
        System.out.println(message);
    }

    public boolean applyGuess(int number) {
        if(number > jar.getMax_number_of_items()) {
            String guessTooHighMessage = "Your guess must be less than " + jar.getMax_number_of_items();
            throw new IllegalArgumentException(guessTooHighMessage);
        }
        this.attempts += 1;
        boolean isCorrect = this.jar.getItem_count() == number;
        return isCorrect;
    }

    public boolean applyGuess(String guess) {
        if(guess.length() == 0){
            throw new IllegalArgumentException("No number found");
        }
        return applyGuess(Integer.parseInt(guess));
    }

    public boolean promptForGuess() {
        boolean isCorrect = false;
        Prompter prompter = new Prompter();

        do {
            String guessInput = prompter.promptUserForValue(this.userPrompt);
            try {
                isCorrect = this.applyGuess(guessInput);
                if(!isCorrect) {
                    String deltaText = Integer.parseInt(guessInput) > jar.getItem_count() ? "high" : "low";
                    System.out.printf("Your guess was too %s. Please try again.", deltaText);
                }
            } catch(IllegalArgumentException iae){
                System.out.printf("%s. Please try again. %n", iae.getMessage());
            }

        } while (!isCorrect);


        return isCorrect;
    }

    public int getAttempts() {
        return this.attempts;
    }
}
