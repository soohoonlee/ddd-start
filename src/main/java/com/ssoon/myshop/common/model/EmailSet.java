package com.ssoon.myshop.common.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EmailSet {

  private Set<Email> emails = new HashSet<>();

  public EmailSet(Set<Email> emails) {
    this.emails.addAll(emails);
  }

  public Set<Email> getEmails() {
    return Collections.unmodifiableSet(emails);
  }
}