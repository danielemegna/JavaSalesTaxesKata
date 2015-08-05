import java.util.ArrayList;
import java.util.List;

public class CashDesk {

    private ReceiptPrinter receiptPrinter;
    private ProductStringParser productStringParser;
    private List<Product> products;

    public CashDesk(ReceiptPrinter receiptPrinter, ProductStringParser productStringParser) {
        this.receiptPrinter = receiptPrinter;
        this.productStringParser = productStringParser;
        this.products = new ArrayList<>();
    }

    public String produceReceipt() {
        return receiptPrinter.print(products);
    }

    public void scanProducts(String productsString) {
        List<String> products = productStringParser.splitProductsString(productsString);
        for(String product : products)
            scanSingleProduct(product);
    }

    private void scanSingleProduct(String product) {
        Product p = productStringParser.productFromString(product);
        this.products.add(p);
    }
}