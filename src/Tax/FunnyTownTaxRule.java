package Tax;

import Category.Category;
import java.math.BigDecimal;

public class FunnyTownTaxRule implements TaxRule {

    @Override
    public BigDecimal calcolateInflationRate(Category category, boolean isImported) {
        BigDecimal inflationRate = BigDecimal.ZERO;

        if(isStandardTaxable(category))
            inflationRate = inflationRate.add(BigDecimal.valueOf(0.10));
        if(isImported)
            inflationRate = inflationRate.add(BigDecimal.valueOf(0.05));

        return inflationRate;
    }

    private boolean isStandardTaxable(Category category) {
        return category == Category.Generic;
    }

}
