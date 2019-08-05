package com.ssoon.myshop.order.command.domain;

import com.ssoon.myshop.common.model.Address;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ShippingInfo {

  @Embedded
  private Receiver receiver;
  @Embedded
  @AttributeOverrides({
      @AttributeOverride(name = "zipCode", column = @Column(name = "shipping_zip_code")),
      @AttributeOverride(name = "address1", column = @Column(name = "shipping_addr1")),
      @AttributeOverride(name = "address2", column = @Column(name = "shipping_addr2"))
  })
  private Address address;
  @Column(name = "shipping_message")
  private String message;
}
