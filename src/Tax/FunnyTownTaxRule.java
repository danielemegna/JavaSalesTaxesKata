package Tax;

import Category.Category;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class FunnyTownTaxRule implements TaxRule {

    private static final BigDecimal STANDARD_INFLATION_RATE = BigDecimal.valueOf(0.10);
    private static final BigDecimal IMPORTED_PRODUCTS_INFLATION_RATE = BigDecimal.valueOf(0.05);

    private static final Set<Category> standardTaxableCategories = new HashSet<Category>() {{
        add(Category.Generic);
    }};


    @Override
    public BigDecimal calcolateInflationRate(Category category, boolean isImported) {
        return BigDecimal.ZERO
            .add(isStandardTaxable(category) ? STANDARD_INFLATION_RATE : BigDecimal.ZERO)
            .add(isImported ? IMPORTED_PRODUCTS_INFLATION_RATE : BigDecimal.ZERO);
    }

    private boolean isStandardTaxable(Category category) {
        return standardTaxableCategories.contains(category);
    }

}
