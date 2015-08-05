import java.math.BigDecimal;
import java.math.RoundingMode;

public class Product {

    private String quantity;
    private String name;
    private BigDecimal netPrice;

    public Product(String quantity, String name, BigDecimal netPrice) {
        this.quantity = quantity;
        this.name = name;
        this.netPrice = netPrice;
    }

    @Override
    public String toString() {
        return 
            quantity + " " +
            getImportedLabel() +
            getSanitizedName() + ": "+
            getTaxedPrice();
    }

    public BigDecimal getTaxedPrice() {
        return netPrice
            .add(getTaxes())
            .setScale(2, BigDecimal.ROUND_HALF_EVEN);
    }

    public BigDecimal getTaxes() {
        BigDecimal taxes = BigDecimal.ZERO;

        if(isStandardTaxable())
            taxes = taxes.add(netPrice.multiply(BigDecimal.valueOf(0.10)));
        if(isImported())
            taxes = taxes.add(netPrice.multiply(BigDecimal.valueOf(0.05)));

        return roundAmountToTheNearestFiveCents(taxes);
    }

    private boolean isImported() {
        return name.contains("imported ");
    }

    private BigDecimal roundAmountToTheNearestFiveCents(BigDecimal taxes) {
        return taxes
            .divide(BigDecimal.valueOf(0.05), 0, RoundingMode.UP)
            .multiply(BigDecimal.valueOf(0.05))
            .setScale(2);
    }

    private boolean isStandardTaxable() {
        return
            name.contains("music CD") ||
            name.contains("perfume");
    }

    private String getImportedLabel() {
        return isImported() ? "imported " : "";
    }

    private String getSanitizedName() {
        return name.replace("imported ", "");
    }
}
