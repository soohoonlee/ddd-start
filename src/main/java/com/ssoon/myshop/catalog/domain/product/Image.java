package com.ssoon.myshop.catalog.domain.product;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "image_type")
@Table(name = "image")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class Image {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "image_id")
  private Long id;

  @Column(name = "image_path")
  @Getter(AccessLevel.PROTECTED)
  private String path;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "upload_time")
  @Getter
  private LocalDateTime uploadTime;

  public Image(String path) {
    this.path = path;
    this.uploadTime = LocalDateTime.now();
  }

  public abstract String getUrl();
  public abstract boolean hasThumbnail();
  public abstract String getThumbnailUrl();
}
