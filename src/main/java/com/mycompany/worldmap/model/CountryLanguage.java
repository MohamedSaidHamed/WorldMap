package com.mycompany.worldmap.model;

import lombok.Data;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "country_language")
@Data
public class CountryLanguage implements Serializable {

  @EmbeddedId
  private CountryLanguagePK countryLanguagePK;

  @Column(name = "is_official")
  private boolean isOfficial;
  @Column(name = "percentage")
  private float percentage;
  @Column(name = "language", insertable = false, updatable = false)
  private String language;
  @JoinColumn(name = "country_code", referencedColumnName = "code", nullable = false, insertable = false, updatable =
      false)
  @ManyToOne
  private Country country;
}
