import java.math.BigDecimal;
import java.math.MathContext;
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

    public String getPrice() {
        if(name.equals("music CD")) {
            BigDecimal taxAmount = price.divide(new BigDecimal(10));
            BigDecimal taxedPrice = price.add(taxAmount);
            taxedPrice = taxedPrice.setScale(2, BigDecimal.ROUND_HALF_EVEN);
            return taxedPrice.toString();
        }

        return price.toString();
    }

    @Override
    public String toString() {
        return quantity + " " + name + ": " + getPrice();
    }

    public String getTaxes() {
        if(name.equals("music CD")) {
            BigDecimal taxAmount = price.divide(new BigDecimal(10));
            taxAmount = taxAmount.setScale(2, BigDecimal.ROUND_HALF_EVEN);
            return taxAmount.toString();
        }

        return "0.00";
    }
}
