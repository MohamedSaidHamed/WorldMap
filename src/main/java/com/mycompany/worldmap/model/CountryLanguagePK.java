package com.mycompany.worldmap.model;

import lombok.Data;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
public class CountryLanguagePK implements Serializable {
  @Column(name = "country_code")
  private String countryCode;

  @Column(name = "language")
  private String language;
}
