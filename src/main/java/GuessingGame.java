public class GuessingGame {
    public static void main(String[] args) {

        Prompter prompter = new Prompter();
        // Prompt game administrator for a name for the type of item stored in the jar and the max number of items the jar can store.
        String itemType = prompter.promptUserForValue("What type of item is stored in the jar? ");
        int maxNumberOfItems = Integer.parseInt(prompter.promptUserForValue("What is the maximum amount of " + itemType + " that can be stored in the jar? "));

        // Create a new jar based on the item type and max number of items provided by the administrator.
        Jar jar = new Jar(itemType, maxNumberOfItems);
        Game game = new Game(jar);
        game.startNewGame();
    }
}
