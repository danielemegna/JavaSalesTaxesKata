import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductParser {

    private static final String PRODUCTSTRING_COMPOSITION_REGEX = "([0-9]+) (.*?) at ([0-9]+\\.[0-9]{2})";

    public List<String> splitProductsString(String products) {
        List<String> result = new ArrayList<>();

        Matcher matcher = Pattern
            .compile(PRODUCTSTRING_COMPOSITION_REGEX)
            .matcher(products);

        while(matcher.find())
            result.add(matcher.group());

        return result;
    }

    public Product productFromString(String product) {
        Matcher matcher = Pattern
            .compile(PRODUCTSTRING_COMPOSITION_REGEX)
            .matcher(product);

        matcher.matches();

        String quantity     = matcher.group(1);
        String name         = matcher.group(2);
        BigDecimal price    = new BigDecimal(matcher.group(3));

        return new Product(quantity, name, price);
    }
}
