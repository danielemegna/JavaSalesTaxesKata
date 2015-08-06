package Category;

import java.util.HashSet;

public class FunnyTownProductCataloger extends ProductCataloger {

    @Override
    protected void fillCategoryMapper() {
        categoryMapper.put(Category.Book, new HashSet<String>() {{
            add("book");
        }});

        categoryMapper.put(Category.Food, new HashSet<String>() {{
            add("box of chocolates");
            add("chocolate bar");
        }});

        categoryMapper.put(Category.Medical, new HashSet<String>() {{
            add("packet of headache pills");
        }});
    }


}
