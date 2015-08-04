import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Product {

    private static final String PRODUCT_FIELDS_EXTRACTION_REGEX = "([0-9]+) (.*) at (.*)";

    private String quantity;
    private String name;
    private BigDecimal price;

    public static Product build(String product) {
        Matcher matcher = Pattern
            .compile(PRODUCT_FIELDS_EXTRACTION_REGEX)
            .matcher(product);

        matcher.matches();

        Product result = new Product();
        result.quantity = matcher.group(1);
        result.name = matcher.group(2);
        result.price = new BigDecimal(matcher.group(3));
        return result;
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

    private Product() { }
}
