import Category.FunnyTownProductCataloger;
import Tax.FunnyTownTaxRule;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CashDeskTest {

    private CashDesk cashDesk;

    @Before
    public void setup() {
        cashDesk = new CashDesk(
            new ReceiptPrinter(),
            new ProductParser(),
            new FunnyTownTaxRule(),
            new FunnyTownProductCataloger()
        );
    }

    @Test
    public void sellingOneBook() {
        cashDesk.scanProducts("1 book at 12.49");

        String expected =
            "1 book: 12.49" + " " +
            "Sales Taxes: 0.00" + " " +
            "Total: 12.49";

        assertReceipt(expected);
    }

    @Test
    public void sellingOneChocolateBar() {
        cashDesk.scanProducts("1 chocolate bar at 0.85");

        String expected =
            "1 chocolate bar: 0.85" + " " +
            "Sales Taxes: 0.00" + " " +
            "Total: 0.85";

        assertReceipt(expected);
    }

    @Test
    public void sellingOneMusicCD() {
        cashDesk.scanProducts("1 music CD at 14.99");

        String expected =
            "1 music CD: 16.49" + " " +
            "Sales Taxes: 1.50" + " " +
            "Total: 16.49";

        assertReceipt(expected);
    }

    @Test
    public void sellingTwoProducts() {
        cashDesk.scanProducts("1 book at 12.49");
        cashDesk.scanProducts("1 music CD at 14.99");

        String expected =
            "1 book: 12.49" + " " +
            "1 music CD: 16.49" + " " +
            "Sales Taxes: 1.50" + " " +
            "Total: 28.98";

        assertReceipt(expected);
    }

    @Test
    public void sellingAnImportedFoodProduct() {
        cashDesk.scanProducts("1 imported box of chocolates at 10.00");

        String expected =
            "1 imported box of chocolates: 10.50" + " " +
            "Sales Taxes: 0.50" + " " +
            "Total: 10.50";

        assertReceipt(expected);
    }

    @Test
    public void sellingAnImportedStandardTaxableProduct() {
        cashDesk.scanProducts("1 imported bottle of perfume at 47.50");

        String expected =
            "1 imported bottle of perfume: 54.65" + " " +
            "Sales Taxes: 7.15" + " " +
            "Total: 54.65";

        assertReceipt(expected);
    }

    @Test
    public void importedProductsCouldHaveDifferentNameFormat() {
        cashDesk.scanProducts("1 box of imported chocolates at 11.25");

        String expected =
            "1 imported box of chocolates: 11.85" + " " +
            "Sales Taxes: 0.60" + " " +
            "Total: 11.85";

        assertReceipt(expected);
    }

    private void assertReceipt(String expected) {
        String receipt = cashDesk.produceReceipt();
        assertEquals(expected, receipt);
    }
}
