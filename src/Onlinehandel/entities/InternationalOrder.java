package Onlinehandel.entities;

import Onlinehandel.provided.Costumer;

public class InternationalOrder extends Order {

    private float custom=1;

    public InternationalOrder(long id, Costumer customer, Iterable<Item> items) {
        super(id, customer, items);
    }

    public InternationalOrder(long id, Costumer customer, Iterable<Item> items, float custom) {
        super(id, customer, items);
        this.custom=custom;
    }

    @Override
    int getTotal() {
        int total=0;
        if(getItems().size() > 0){
            for(Item i :getItems()) {
                total +=i.totalValue();
            }
        }
        return total;
    }
}
