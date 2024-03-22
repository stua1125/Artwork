package lezhin.lezhinproject.artwork.domain;

public class Price {
    private Double price;

    // domain logic
    // pirce must be between 100 and 500 or price must be 0
    public Price(Double price) {
        if (price == 0 || price >= 100 && price <= 500) {
            this.price = price;
        } else {
            throw new IllegalArgumentException("Price must be between 100 and 500 or Price must be 0.");
        }

        this.price = price;
    }

    public static Price of(Double price) {
        return new Price(price);
    }
}
