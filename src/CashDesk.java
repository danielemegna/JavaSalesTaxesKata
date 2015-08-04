import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CashDesk {
    private List<Product> products = new ArrayList<>();

    public static CashDesk build(String products) {
        return null;
    }

    public String produceReceipt() {
        StringBuilder productsDescriptions = new StringBuilder();
        BigDecimal salesTaxes = new BigDecimal(0);
        BigDecimal total = new BigDecimal(0);

        for(Product p : products) {
            productsDescriptions.append(p.toString() + " ");
            salesTaxes = salesTaxes.add(p.getTaxes());
            total = total.add(p.getPrice());
        }

        StringBuilder receipt = new StringBuilder()
            .append(productsDescriptions)
            .append("Sales Taxes: " + salesTaxes + " ")
            .append("Total: " + total);

        return receipt.toString();
    }

    public void scanProduct(String product) {
        Product p = Product.build(product);
        this.products.add(p);
    }
}