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

    public BigDecimal getPrice() {
        if(isTaxable())
            return calcolateTaxedPrice();

        return price;
    }

    public BigDecimal getTaxes() {
        if(isTaxable())
            return calcolateTaxAmount();

        return roundAmount(new BigDecimal(0));
    }

    @Override
    public String toString() {
        return quantity + " " + name + ": " + getPrice();
    }

    private BigDecimal calcolateTaxAmount() {
        BigDecimal taxAmount = price.divide(new BigDecimal(10));
        return roundAmount(taxAmount);
    }

    private BigDecimal calcolateTaxedPrice() {
        BigDecimal taxedPrice = price.add(calcolateTaxAmount());
        return roundAmount(taxedPrice);
    }

    private static BigDecimal roundAmount(BigDecimal amount) {
        return amount.setScale(2, BigDecimal.ROUND_HALF_EVEN);
    }

    private boolean isTaxable() {
        return name.equals("music CD");
    }
}
