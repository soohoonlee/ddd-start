package com.ssoon.myshop.catalog.domain.product;

import com.ssoon.myshop.catalog.domain.category.CategoryId;
import com.ssoon.myshop.common.jpa.MoneyConverter;
import com.ssoon.myshop.common.model.Money;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Convert;
import javax.persistence.ElementCollection;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {

  @EmbeddedId
  @Getter
  private ProductId id;

  @ElementCollection
  @CollectionTable(name = "product_category", joinColumns = @JoinColumn(name = "product_id"))
  private Set<CategoryId> categoryIds;

  @Getter
  private String name;

  @Convert(converter = MoneyConverter.class)
  @Getter
  private Money price;

  @Getter
  private String detail;

  @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true, fetch = FetchType.EAGER)
  @JoinColumn(name = "product_id")
  @OrderColumn(name = "list_idx")
  private List<Image> images = new ArrayList<>();

  public Product(ProductId id, String name, Money price, String detail, List<Image> images) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.detail = detail;
    this.images.addAll(images);
  }

  public List<Image> getImages() {
    return Collections.unmodifiableList(images);
  }

  public void changeImages(List<Image> newImages) {
    images.clear();
    images.addAll(newImages);
  }
}
