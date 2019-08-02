package com.ssoon.myshop.order.command.domain;

public interface OrderRepository {

  Order findById(OrderNo id);
  void save(Order order);
  void remove(Order order);
}
