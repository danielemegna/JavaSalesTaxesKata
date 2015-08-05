import java.util.ArrayList;
import java.util.List;

public class CashDesk {

    private ReceiptPrinter receiptPrinter;
    private List<Product> products;

    public CashDesk(ReceiptPrinter receiptPrinter) {
        this.receiptPrinter = receiptPrinter;
        this.products = new ArrayList<>();
    }

    public String produceReceipt() {
        return receiptPrinter.print(products);
    }

    public void scanProduct(String product) {
        Product p = Product.build(product);
        this.products.add(p);
    }

    public static CashDesk build(String products) {
        return null;
    }
}