import java.math.BigDecimal;

public class Product {


    private String quantity;
    private String name;
    private BigDecimal netPrice;

    public Product(String quantity, String name, BigDecimal netPrice) {
        this.quantity = quantity;
        this.name = name;
        this.netPrice = netPrice;
    }

    public BigDecimal getTaxes() {
        return setDecimalScale(
            isTaxable() ? netPrice.divide(BigDecimal.TEN) : BigDecimal.ZERO
        );
    }

    public BigDecimal getTaxedPrice() {
        return setDecimalScale(
            netPrice.add(getTaxes())
        );
    }

    @Override
    public String toString() {
        return quantity + " " + name + ": " + getTaxedPrice();
    }

    private static BigDecimal setDecimalScale(BigDecimal amount) {
        return amount.setScale(2, BigDecimal.ROUND_HALF_EVEN);
    }

    private boolean isTaxable() {
        return name.equals("music CD");
    }
}
