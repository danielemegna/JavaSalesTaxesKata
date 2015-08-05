import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class ReceiptPrinter {

    public String print(List<Product> products) {
        String productsDescriptions = products.stream()
            .map(Product::toString)
            .collect(Collectors.joining(" "));

        BigDecimal salesTaxes = products.stream()
            .map(Product::getTaxes)
            .reduce(new BigDecimal(0), (a, b) -> a = a.add(b));

        BigDecimal total = products.stream()
            .map(Product::getPrice)
            .reduce(new BigDecimal(0), (a, b) -> a = a.add(b));

        return String.format(
            "%s Sales Taxes: %s Total: %s",
            productsDescriptions,
            salesTaxes,
            total
        );
    }

}
