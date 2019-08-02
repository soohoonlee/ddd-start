package com.ssoon.myshop.order.command.application;

import com.ssoon.myshop.order.NoOrderException;
import com.ssoon.myshop.order.command.domain.Order;
import com.ssoon.myshop.order.command.domain.OrderNo;
import com.ssoon.myshop.order.command.domain.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CancelOrderService {

  private final OrderRepository orderRepository;

  @Transactional
  public void cancel(OrderNo orderNo) {
    Order order = orderRepository.findById(orderNo);
    if (order == null) {
      throw new NoOrderException();
    }
    order.cancel();
  }
}
