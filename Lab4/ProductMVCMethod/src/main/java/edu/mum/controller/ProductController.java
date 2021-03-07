package edu.mum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.domain.Category;
import edu.mum.domain.Product;
import edu.mum.service.CategoryService;
import edu.mum.service.ProductService;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {
 
	ProductService productService;
 	
	CategoryService categoryService;
	
	ProductController() {
		
	}
 	
	// Setter based injection....
	@Autowired
	ProductController(ProductService productService,CategoryService categoryService) {
		this.categoryService =  categoryService;
		this.productService = productService;
	}

	//Enkhjargal - added newProduct attribute in model
    @RequestMapping(value={"/","/product"}, method = RequestMethod.GET)
    public String inputProduct(@ModelAttribute("newProduct") Product product, Model model) {
		model.addAttribute("categories", categoryService.getAll());
		model.addAttribute("newProduct", new Product());
        return "ProductForm";
    }

     //Enkhjargal - add Product Model Attribute
	 @RequestMapping(value="/product", method = RequestMethod.POST)
	 public String saveProduct(@ModelAttribute("product") Product product ) {
    	Category category = categoryService.getCategory(product.getCategory().getId());
        product.setCategory(category);
    	productService.save(product);
        return "ProductDetails";
     }
    
    
    @RequestMapping(value="/listproducts")
    public String listProducts(Model model) {
		List<Product> list = productService.getAll();
		model.addAttribute("products",  list);
        return "ListProducts";
    }
    
  /*  @RequestMapping(value={"/","/product"}, method = RequestMethod.GET)
    public String inputProduct(Product oldProduct, Product newProduct, Model model) {
 
    	// Which "product" "survives in model [ both can NOT be in Map...?
        newProduct.setDescription("NEW");
        oldProduct.setDescription("OLD");         
        Product product = (Product)model.asMap().get("product");
        System.out.println(product.getDescription() );
  
        // NOW which one ???!!?? Still only ONE in Map
         product = new Product();
         product.setDescription("EXTRA");
        model.addAttribute(product);
        
        List<Category> categories = categoryService.getAll();
        model.addAttribute("categories", categories);
     
     
   	return "ProductForm";
    }
 */
    
}
