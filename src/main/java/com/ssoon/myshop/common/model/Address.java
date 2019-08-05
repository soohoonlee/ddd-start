package com.ssoon.myshop.common.model;

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
public class Address {

  @Column(name = "address1")
  private String address1;
  @Column(name = "address2")
  private String address2;
  @Column(name = "zip_code")
  private String zipCode;
}
