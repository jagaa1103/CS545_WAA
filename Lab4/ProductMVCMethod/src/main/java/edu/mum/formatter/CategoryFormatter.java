package edu.mum.formatter;

import edu.mum.domain.Category;
import edu.mum.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class CategoryFormatter implements Formatter<Category> {

    @Autowired
    CategoryService categoryService;

    @Override
    public Category parse(String id, Locale locale) throws ParseException {
        System.out.println("Category Formatter => parse");
        try {
            return categoryService.getCategory(Integer.parseInt(id));
        } catch (Exception e) {
            throw new ParseException("category is not parsable", 0);
        }
    }

    @Override
    public String print(Category category, Locale locale) {
        System.out.println("Category Formatter => print");
        return category.getName();
    }
}
