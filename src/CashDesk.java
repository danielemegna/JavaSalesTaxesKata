import java.util.ArrayList;
import java.util.List;

public class CashDesk {

    private ReceiptPrinter receiptPrinter;
    private ProductParser productParser;
    private List<Product> products;

    public CashDesk(ReceiptPrinter receiptPrinter, ProductParser productParser) {
        this.receiptPrinter = receiptPrinter;
        this.productParser = productParser;
        this.products = new ArrayList<>();
    }

    public String produceReceipt() {
        return receiptPrinter.print(products);
    }

    public void scanProducts(String productsString) {
        List<String> products = productParser.splitProductsString(productsString);
        for(String product : products)
            scanSingleProduct(product);
    }

    private void scanSingleProduct(String product) {
        Product p = productParser.productFromString(product);
        this.products.add(p);
    }
}