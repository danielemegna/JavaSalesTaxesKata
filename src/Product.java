import java.math.BigDecimal;

public class Product {


    private String quantity;
    private String name;
    private BigDecimal price;

    public Product(String quantity, String name, BigDecimal price) {
        this.quantity = quantity;
        this.name = name;
        this.price = price;
    }

    public BigDecimal getTaxes() {
        return setDecimalScale(
            isTaxable() ? price.divide(BigDecimal.TEN) : BigDecimal.ZERO
        );
    }

    public BigDecimal getPrice() {
        return setDecimalScale(
            price.add(getTaxes())
        );
    }

    @Override
    public String toString() {
        return quantity + " " + name + ": " + getPrice();
    }

    private static BigDecimal setDecimalScale(BigDecimal amount) {
        return amount.setScale(2, BigDecimal.ROUND_HALF_EVEN);
    }

    private boolean isTaxable() {
        return name.equals("music CD");
    }
}
