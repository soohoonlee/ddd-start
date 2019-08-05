package com.ssoon.myshop.catalog.domain.product;

import com.ssoon.myshop.catalog.domain.category.CategoryId;
import java.util.List;

public interface ProductRepository {

  List<Product> findByCategoryId(CategoryId categoryId, int page, int size);
}
