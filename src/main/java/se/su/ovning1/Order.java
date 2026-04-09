package se.su.ovning1;

import java.util.ArrayList;

public class Order {

    private static long counter;
    private final long orderNumber;

    private final ArrayList<Item> items = new ArrayList<>();

    public Order(Item... items) {
        orderNumber = counter++;
        for (Item i : items) {
            this.items.add(i);
        }
    }

    public double getTotalValue() {
        double total = 0.0;
        for (Item i : items) {
            total += i.getPrice();
        }
        return total;
    }

    public double getTotalValuePlusVAT() {
        double total = 0.0;
        for (Item i : items) {
            total += i.getPriceWithVAT();
        }
        return total;
    }

    public String getReceipt() {
        StringBuilder str = new StringBuilder("Receipt for order #" + orderNumber + "\n" +
                "        -----------\n");
        for (Item i : items) {
            str.append(i.toString()).append("\n");
        }
        str.append("Total excl. VAT: ").append(getTotalValue()).append("\n");
        str.append("Total incl. VAT: ").append(getTotalValuePlusVAT()).append("\n");
        str.append("----------------");
        return str.toString();
    }
}
