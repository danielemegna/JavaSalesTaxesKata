import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CashDesk {
    private List<Product> products = new ArrayList<>();

    public static CashDesk build(String products) {
        return null;
    }

    public String produceReceipt() {

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
            productsDescriptions.toString().trim(),
            salesTaxes,
            total
        );
    }

    public void scanProduct(String product) {
        Product p = Product.build(product);
        this.products.add(p);
    }
}