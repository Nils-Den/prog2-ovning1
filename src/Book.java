//package se.su.ovning1;

public class Book extends Item implements PriceableWithVAT6 {

    private final double price;
    private final boolean bound;
    private final String author;

    public Book(String name, String author, double price, boolean bound) {
        super(name);
        this.author = author;
        this.price = price;
        this.bound = bound;
    }

    public double getPrice() {
        return bound ? price * 1.3 : price;
    }

    @Override
    public String toString() {
        return "Book { name =" + getName() + "author=" + author + "bound=" + bound + "price=" + getPrice() + "price+VAT="
                + getPriceWithVAT() + "}";
    }
}
