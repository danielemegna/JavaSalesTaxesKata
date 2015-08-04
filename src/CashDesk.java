public class CashDesk {
    private String product;

    public static CashDesk build(String products) {
        return null;
    }

    public String produceReceipt() {
        String[] splittedProduct = product.split(" ");
        String quantity = splittedProduct[0];
        String name = splittedProduct[1];
        String price = splittedProduct[3];

        return
            quantity + " " + name + ": " + price + " " +
            "Sales Taxes: 0.00" + " " +
            "Total: " + price;
    }

    public void scanProduct(String product) {
        this.product = product;
    }
}
