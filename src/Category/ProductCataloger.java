package Category;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class ProductCataloger {

    protected final Map<Category, Set<String>> categoryMapper;

    public ProductCataloger() {
        categoryMapper = new HashMap<>();
        fillCategoryMapper();
    }

    public Category fromProductName(String name) {
        for(Map.Entry<Category, Set<String>> entry : categoryMapper.entrySet()) {
            Category category = entry.getKey();
            Set<String> names = entry.getValue();

            if(names.contains(name))
                return category;
        }

        return Category.Generic;
    }

    protected abstract void fillCategoryMapper();
}
