import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CashDeskTest {

    @Test
    public void sellingOneBook() {
        CashDesk cs = new CashDesk();
        cs.scanProduct("1 book at 12.49");

        String expected = "1 book: 12.49 Sales Taxes: 0.00 Total: 12.49";
        String receipt = cs.produceReceipt();

        assertEquals(expected, receipt);
    }
}
