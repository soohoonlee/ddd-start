package com.ssoon.myshop.order.command.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Receiver {

  @Column(name = "receiver_name")
  private String name;
  @Column(name = "receiver_phone")
  private String phone;
}
