import Category.Category;
import Category.ProductCataloger;
import Tax.TaxRule;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Product {

    private String quantity;
    private String name;
    private BigDecimal netPrice;
    private boolean isImported;

    private Category category;
    private BigDecimal inflationRate;

    public Product(String quantity, String name, BigDecimal netPrice, boolean isImported) {
        this.quantity = quantity;
        this.name = name;
        this.netPrice = netPrice;
        this.isImported = isImported;

        this.inflationRate = BigDecimal.ZERO;
        this.category = Category.Generic;
    }

    @Override
    public String toString() {
        return 
            quantity + " " +
            getImportedLabel() +
            name + ": "+
            getTaxedPrice();
    }

    public BigDecimal getTaxedPrice() {
        return netPrice
            .add(getTaxes())
            .setScale(2, BigDecimal.ROUND_HALF_EVEN);
    }

    public BigDecimal getTaxes() {
        BigDecimal taxes = netPrice.multiply(inflationRate);
        return roundAmountToTheNearestFiveCents(taxes);
    }

    public Product applyCategory(ProductCataloger productCataloger) {
        category = productCataloger.fromProductName(name);
        return this;
    }

    public Product applyTaxRule(TaxRule taxRule) {
        inflationRate = taxRule.calcolateInflationRate(category, isImported);
        return this;
    }

    private BigDecimal roundAmountToTheNearestFiveCents(BigDecimal taxes) {
        return taxes
            .divide(BigDecimal.valueOf(0.05), 0, RoundingMode.UP)
            .multiply(BigDecimal.valueOf(0.05))
            .setScale(2);
    }

    private String getImportedLabel() {
        return isImported ? "imported " : "";
    }
}
