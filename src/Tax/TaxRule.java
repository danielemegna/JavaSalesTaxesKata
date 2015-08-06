package Tax;

import java.math.BigDecimal;
import Category.Category;

public interface TaxRule {
    BigDecimal calcolateInflationRate(Category category, boolean isImported);
}
