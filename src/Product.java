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
        BigDecimal taxes = BigDecimal.ZERO;

        if(isStandardTaxable())
            taxes = taxes.add(netPrice.multiply(BigDecimal.valueOf(0.10)));
        if(isImported())
            taxes = taxes.add(netPrice.multiply(BigDecimal.valueOf(0.05)));

        return setDecimalScale(taxes);
    }

    private boolean isImported() {
        return name.contains("imported");
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

    private boolean isStandardTaxable() {
        return name.equals("music CD");
    }
}
