import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Product {

    private static final String PRODUCT_FIELDS_EXTRACTION_REGEX = "([0-9]+) (.*) at (.*)";

    private String quantity;
    private String name;
    private String price;

    public static Product build(String product) {
        Matcher matcher = Pattern
            .compile(PRODUCT_FIELDS_EXTRACTION_REGEX)
            .matcher(product);

        matcher.matches();

        Product result = new Product();
        result.quantity = matcher.group(1);
        result.name = matcher.group(2);
        result.price = matcher.group(3);
        return result;
    }

    public String getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return quantity + " " + name + ": " + price;
    }
}
