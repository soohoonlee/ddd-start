package com.ssoon.myshop.common.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Money {

  private int value;

  public Money multiply(int multiplier) {
    return new Money(value * multiplier);
  }
}
