public class CashDesk {
    private Product product;

    public static CashDesk build(String products) {
        return null;
    }

    public String produceReceipt() {
        return
            product.toString() + " " +
            "Sales Taxes: 0.00" + " " +
            "Total: " + product.getPrice();
    }

    public void scanProduct(String product) {
        this.product = Product.build(product);
    }
}