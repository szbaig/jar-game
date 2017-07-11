import java.util.Random;

public class Jar {
    private String item_name;
    private int max_number_of_items;
    private int item_count;

    public Jar(String item_name, int max_number_of_items) {
        this.item_name = item_name;
        this.max_number_of_items = max_number_of_items;
        this.item_count = 0;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public int getMax_number_of_items() {
        return this.max_number_of_items;
    }

    public void setMax_number_of_items(int max_number_of_items) {
        this.max_number_of_items = max_number_of_items;
    }

    public int getItem_count() {
        return item_count;
    }

    public void setItem_count(int item_count) {
        this.item_count = item_count;
    }

    public void fill() {
        Random random = new Random();
        int maxItemsAllowed = this.max_number_of_items;
        int randomNumber = random.nextInt(maxItemsAllowed);
        randomNumber++;
        this.setItem_count(randomNumber);
    }
}