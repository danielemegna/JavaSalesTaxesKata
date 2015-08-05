import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductStringParser {

    private static final String PRODUCT_FIELDS_EXTRACTION_REGEX = "([0-9]+) (.*) at (.*)";
    private static final String PRODUCT_BLOCK_REGEX = "[0-9]+ .*? at [0-9]+\\.[0-9]{2}";

    public List<String> splitProductsString(String productsString) {
        List<String> result = new ArrayList<>();

        Matcher matcher = Pattern
            .compile(PRODUCT_BLOCK_REGEX)
            .matcher(productsString);

        while(matcher.find())
            result.add(matcher.group());

        return result;
    }

    public Product productFromString(String string) {
        Matcher matcher = Pattern
            .compile(PRODUCT_FIELDS_EXTRACTION_REGEX)
            .matcher(string);

        matcher.matches();

        return new Product(
            matcher.group(1),
            matcher.group(2),
            new BigDecimal(matcher.group(3))
        );
    }
}
