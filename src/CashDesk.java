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

        return new ReceiptPrinter().print(products);
    }

    public void scanProduct(String product) {
        Product p = Product.build(product);
        this.products.add(p);
    }
}