import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CashDesk {

    private static final String PRODUCT_BLOCK_REGEX = "[0-9]+ .*? at [0-9]+\\.[0-9]{2}";

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

    public static CashDesk build(String products, ReceiptPrinter receiptPrinter) {
        CashDesk result = new CashDesk(receiptPrinter);

        Matcher matcher = Pattern
            .compile(PRODUCT_BLOCK_REGEX)
            .matcher(products);

        while(matcher.find()) {
            result.scanProduct(matcher.group());
        }


        return result;
    }
}