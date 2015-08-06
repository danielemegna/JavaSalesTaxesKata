package Category;

import java.util.HashSet;

public class FunnyTownProductCataloger extends ProductCataloger {

    @Override
    protected void fillCategoryMapper() {
        categoryMapper.put(Category.Book, new HashSet<String>() {{
            add("book");
            add("ratman comics");
        }});

        categoryMapper.put(Category.Food, new HashSet<String>() {{
            add("box of chocolates");
            add("chocolate bar");
            add("american coffee");
            add("chocolate croissant");
            add("vanilla coke bottle");
        }});

        categoryMapper.put(Category.Medical, new HashSet<String>() {{
            add("packet of headache pills");
            add("aspririna packet");
        }});
    }


}
