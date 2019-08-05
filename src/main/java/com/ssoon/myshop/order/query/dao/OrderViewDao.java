package com.ssoon.myshop.order.query.dao;

import com.ssoon.myshop.order.query.dto.OrderView;
import java.util.List;

public interface OrderViewDao {

  List<OrderView> selectByOrderer(String ordererId);
}
