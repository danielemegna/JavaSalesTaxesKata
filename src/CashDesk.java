public class CashDesk {
    private String product;

    public static CashDesk build(String products) {
        return null;
    }

    public String produceReceipt() {
        String[] splittedProduct = product.split(" ");
        String quantity = splittedProduct[0];

        String name = "";
        for(int i = 1; i < splittedProduct.length - 2; i++)
            name += splittedProduct[i] + " ";
        name = name.trim();

        String price = splittedProduct[splittedProduct.length-1];

        return
            quantity + " " + name + ": " + price + " " +
            "Sales Taxes: 0.00" + " " +
            "Total: " + price;
    }

    public void scanProduct(String product) {
        this.product = product;
    }
}