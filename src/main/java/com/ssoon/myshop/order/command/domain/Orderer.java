package com.ssoon.myshop.order.command.domain;

import com.ssoon.myshop.member.domain.MemberId;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Orderer {

  private MemberId memberId;
  private String name;
}
