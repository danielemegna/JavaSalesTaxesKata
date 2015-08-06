package Category;

public class FunnyTownProductCataloger implements ProductCataloger {

    @Override
    public Category fromProductName(String name) {

        if(name.contains("book"))
            return Category.Book;

        if(name.contains("chocolate"))
            return Category.Food;

        if(name.contains("headache"))
            return Category.Medical;

        return Category.Generic;
    }

}
