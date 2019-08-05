package com.ssoon.myshop.catalog.domain.product;

import com.ssoon.myshop.catalog.domain.category.CategoryId;
import java.util.Set;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;

@Entity
public class Product {

  @EmbeddedId
  private ProductId id;

  @ElementCollection
  @CollectionTable(name = "product_category", joinColumns = @JoinColumn(name = "product_id"))
  private Set<CategoryId> categoryIds;
}
