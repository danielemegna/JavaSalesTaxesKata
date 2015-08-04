import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CashDeskTest {

    private CashDesk cashDesk;

    @Before
    public void setup() {
        cashDesk = new CashDesk();
    }

    @Test
    public void sellingOneBook() {
        cashDesk.scanProduct("1 book at 12.49");

        String expected =
            "1 book: 12.49" + " " +
            "Sales Taxes: 0.00" + " " +
            "Total: 12.49";

        assertReceipt(expected);
    }

    @Test
    public void sellingOneChocolateBar() {
        cashDesk.scanProduct("1 chocolate bar at 0.85");

        String expected =
            "1 chocolate bar: 0.85" + " " +
            "Sales Taxes: 0.00" + " " +
            "Total: 0.85";

        assertReceipt(expected);
    }

    private void assertReceipt(String expected) {
        String receipt = cashDesk.produceReceipt();
        assertEquals(expected, receipt);
    }
}
