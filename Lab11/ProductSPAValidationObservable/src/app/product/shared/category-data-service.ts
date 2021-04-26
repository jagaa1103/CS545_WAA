import { Injectable } from '@angular/core';


import {Observable} from 'rxjs';
import { map } from 'rxjs/operators';
import { catchError } from 'rxjs/operators';
import { Category } from "./category";

@Injectable()
export class CategoryDataService {

  categories: Category[] = [new Category("Book"), new Category("Clothes"), new Category("Home Electronics")];

  constructor() { }
   getCategories(): Category[] {
      return this.categories;
   }
   private handleError(error: any) {
    console.log('An error occured: ', error);
    return Observable.throw(error);
  }
}
