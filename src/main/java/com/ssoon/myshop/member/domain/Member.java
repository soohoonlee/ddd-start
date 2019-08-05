package com.ssoon.myshop.member.domain;

public class Member {

  private MemberId id;
  private String name;
  private Password password;

  public void changePassword(String currentPassword, String newPassword) {
    if (!password.match(currentPassword)) {
      throw new PasswordNotMatchException();
    }
    this.password = new Password(newPassword);
  }
}
