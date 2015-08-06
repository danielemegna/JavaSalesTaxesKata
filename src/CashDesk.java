import Category.ProductCataloger;
import Tax.TaxRule;

import java.util.ArrayList;
import java.util.List;

public class CashDesk {

    private ReceiptPrinter receiptPrinter;
    private ProductParser productParser;
    private TaxRule taxRule;
    private ProductCataloger productCataloger;

    private List<Product> scannedProducts;

    public CashDesk(ReceiptPrinter rp, ProductParser pp, TaxRule tr, ProductCataloger pc) {
        this.receiptPrinter = rp;
        this.productParser = pp;
        this.taxRule = tr;
        this.productCataloger = pc;

        this.scannedProducts = new ArrayList<>();
    }

    public String produceReceipt() {
        return receiptPrinter.produce(scannedProducts);
    }

    public void scanProducts(String productsString) {
        for(String product : productParser.splitProductsString(productsString))
            scanSingleProduct(product);
    }

    private void scanSingleProduct(String product) {
        Product p = productParser
            .productFromString(product)
            .applyCategory(productCataloger)
            .applyTaxRule(taxRule);

        this.scannedProducts.add(p);
    }
}