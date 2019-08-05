package com.ssoon.myshop.order.command.domain;

import com.ssoon.myshop.member.domain.MemberId;
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
public class Orderer {

  @Embedded
  @AttributeOverrides(@AttributeOverride(name = "id", column = @Column(name = "orderer_id")))
  private MemberId memberId;
  @Column(name = "orderer_name")
  private String name;
}
