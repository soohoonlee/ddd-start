package com.ssoon.myshop.order.command.domain;

import com.ssoon.myshop.catalog.domain.product.ProductId;
import com.ssoon.myshop.common.model.Money;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class OrderLine {

  @Embedded
  private ProductId productId;
  @Column(name = "price")
  private Money price;
  @Column(name = "quantity")
  private int quantity;
  @Column(name = "amounts")
  private Money amounts;

  public OrderLine(ProductId productId, Money price, int quantity) {
    this.productId = productId;
    this.price = price;
    this.quantity = quantity;
    this.amounts = calculateAmounts();
  }

  private Money calculateAmounts() {
    return price.multiply(quantity);
  }
}
