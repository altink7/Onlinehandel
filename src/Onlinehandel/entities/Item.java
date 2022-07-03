package Onlinehandel.entities;

public class Item {
    private int amount;
    private String description;
    private int value;

    public Item(String description,int amount,int value) {
        this.amount = amount;
        this.description = description;
        this.value = value;
    }

    public int totalValue(){
        return value*amount;
    }

    @Override
    public String toString() {
        return "Item{" +
                "amount=" + amount +
                ", description='" + description + '\'' +
                ", value=" + value +
                '}';
    }
}
