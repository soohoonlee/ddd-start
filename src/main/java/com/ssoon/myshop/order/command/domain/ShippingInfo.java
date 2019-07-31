package com.ssoon.myshop.order.command.domain;

import com.ssoon.myshop.common.model.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ShippingInfo {

  private Receiver receiver;
  private Address address;
}
