package com.ssoon.myshop.order.query.dto;

import com.ssoon.myshop.catalog.domain.product.Product;
import com.ssoon.myshop.member.domain.Member;
import com.ssoon.myshop.order.command.domain.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class OrderView {

  private Order order;
  private Member member;
  private Product product;
}
