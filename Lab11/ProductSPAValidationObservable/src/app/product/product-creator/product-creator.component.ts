import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Product } from '../shared/product';
import { ProductDataService } from '../shared/product-data.service';
import { Subject } from 'rxjs';
import { finalize } from '../../../../node_modules/rxjs/operators';
import { Category } from '../shared/category';
import { CategoryDataService } from '../shared/category-data-service';

@Component({
  templateUrl: './product-creator.component.html',
  styleUrls: ['../../app.component.css']
})
export class ProductCreatorComponent {
  product: Product = new Product();
  productForm: FormGroup;
  categories: Category[];
  category: Category;
  private subscription: any;
  
  constructor(private router: Router, 
              private productDataService: ProductDataService,           
              private categoryService: CategoryDataService,
              private formBuilder: FormBuilder) {}


  ngOnInit() {
    this.categories = this.categoryService.getCategories();
    this.productForm = this.formBuilder.group({
     name: ['',[Validators.required, Validators.minLength(5)]],
     description: '',
     price: ''
    });
   }
    get name() { return this.productForm.get('name'); }
    get description() { return this.productForm.get('description'); }
   
    saveProduct(product: Product) {
      product.category = this.category;
       this.subscription = this.productDataService.save(product).pipe(finalize(() => this.router.navigate(['/products']))).subscribe(product => this.product =  product);
    }
    ngOnDestroy() {
      this.subscription.unsubscribe;
    }
}
