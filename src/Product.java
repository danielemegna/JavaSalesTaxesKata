public class Product {
    private String quantity;
    private String name;
    private String price;

    public static Product build(String product) {
        Product p = new Product();

        String[] splittedProduct = product.split(" ");
        p.quantity = splittedProduct[0];

        p.name = "";
        for(int i = 1; i < splittedProduct.length - 2; i++)
            p.name += splittedProduct[i] + " ";
        p.name = p.name.trim();

        p.price = splittedProduct[splittedProduct.length-1];

        return p;
    }

    public String getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return quantity + " " + name + ": " + price;
    }
}
