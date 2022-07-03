package Onlinehandel.entities;

import Onlinehandel.provided.Costumer;

public class RegionalOrder extends Order{
    private boolean express;

    public RegionalOrder(long id, Costumer customer, Iterable<Item> items) {
        super(id, customer, items);
    }

    public RegionalOrder(long id, Costumer customer, Iterable<Item> items, boolean express) {
        super(id, customer, items);
        this.express = express;
    }

    @Override
    int getTotal() {
        int total=0;
        if(getItems().size() > 0){
            for(Item i :getItems()) {
                total +=i.totalValue();
            }
        }
        if(express) {
            return total * 120 / 100;
        }
        else {
            return total;
        }
    }
}
