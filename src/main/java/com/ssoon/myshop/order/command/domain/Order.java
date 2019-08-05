package com.ssoon.myshop.order.command.domain;

import static com.ssoon.myshop.order.command.domain.OrderState.*;

import com.ssoon.myshop.common.model.Money;
import java.util.List;
import lombok.Getter;

@Getter
public class Order {

  private OrderNo number;
  private Orderer orderer;
  private List<OrderLine> orderLines;
  private Money totalAmounts;
  private OrderState state;
  private ShippingInfo shippingInfo;

  public Order(Orderer orderer, List<OrderLine> orderLines, ShippingInfo shippingInfo, OrderState state) {
    setOrderer(orderer);
    setOrderLines(orderLines);
    setShippingInfo(shippingInfo);
    this.state = state;
  }

  private void setOrderer(Orderer orderer) {
    if (orderer == null) {
      throw new IllegalArgumentException("no orderer");
    }
    this.orderer = orderer;
  }

  private void setShippingInfo(ShippingInfo shippingInfo) {
    if (shippingInfo == null) {
      throw new IllegalArgumentException("no ShippingInfo");
    }
    this.shippingInfo = shippingInfo;
  }

  private void setOrderLines(List<OrderLine> orderLines) {
    verifyAtLeastOneOrMoreOrderLines(orderLines);
    this.orderLines = orderLines;
    calculateTotalAmounts();
  }

  private void calculateTotalAmounts() {
    int sum = orderLines.stream().mapToInt(x -> x.getAmounts().getValue()).sum();
    this.totalAmounts = new Money(sum);
  }

  private void verifyAtLeastOneOrMoreOrderLines(List<OrderLine> orderLines) {
    if (orderLines == null || orderLines.isEmpty()) {
      throw new IllegalArgumentException("no OrderLine");
    }
  }

  public void changeShippingInfo(ShippingInfo newShippingInfo) {
    verifyNotYetShipped();
    setShippingInfo(newShippingInfo);
  }

  private void verifyNotYetShipped() {
    if (state != PAYMENT_WAITING && state != PREPARING) {
      throw new IllegalArgumentException("already shipped");
    }
  }

  public void cancel() {
    verifyNotYetShipped();
    this.state = CANCELED;
  }

  // public void changeShippingInfo(ShippingInfo newInfo) {
  //   checkShippingInfoChangeable();
  //   this.shippingInfo = newInfo;
  // }

  private void checkShippingInfoChangeable() {
    if (!isShippingChangeable()) {
      throw new IllegalStateException("can't change shipping in " + state);
    }
  }

  private boolean isShippingChangeable() {
    return state == PAYMENT_WAITING || state == PREPARING;
  }
}
