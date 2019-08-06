package com.ssoon.myshop.common.jpa;

import static java.util.stream.Collectors.toSet;

import com.ssoon.myshop.common.model.Email;
import com.ssoon.myshop.common.model.EmailSet;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import javax.persistence.AttributeConverter;

public class EmailSetConverter implements AttributeConverter<EmailSet, String> {

  @Override
  public String convertToDatabaseColumn(EmailSet attribute) {
    if (attribute == null) {
      return null;
    }
    return attribute.getEmails().stream()
        .map(Email::toString)
        .collect(Collectors.joining(","));
  }

  @Override
  public EmailSet convertToEntityAttribute(String dbData) {
    if (dbData == null) {
      return null;
    }
    String[] emails = dbData.split(",");
    Set<Email> emailSet = Arrays.stream(emails)
        .map(Email::new)
        .collect(toSet());
    return new EmailSet(emailSet);
  }
}
