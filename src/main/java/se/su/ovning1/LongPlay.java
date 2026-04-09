package se.su.ovning1;

public class LongPlay extends Recording {
    public LongPlay(String name, String artist, int year, int condition, double price) {
        super(name, artist, year, condition, price);
    }

    @Override
    public String getType() {
        return "LP";
    }

    public double getPrice() {
        return Math.max(10, getOriginalPrice() * getCondition() / 10.0 + (2026 - getYear()) * 5);

    }
}
