package com.ssoon.myshop.catalog.domain.product;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("EI")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExternalImage extends Image {

  public ExternalImage(String path) {
    super(path);
  }

  @Override
  public String getUrl() {
    return getPath();
  }

  @Override
  public boolean hasThumbnail() {
    return false;
  }

  @Override
  public String getThumbnailUrl() {
    return null;
  }
}
