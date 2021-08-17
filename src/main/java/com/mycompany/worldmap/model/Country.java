package com.mycompany.worldmap.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "country")
@Data
public class Country implements Serializable {
  @Id
  @Column(name = "code")
  private String code;
  @Column(name = "name")
  private String name;
  @Column(name = "continent")
  private String continent;
  @JsonIgnore
  @Column(name = "region")
  private String region;
  @Column(name = "surface_area")
  @JsonIgnore
  private float surfaceArea;
  @JsonIgnore
  @Column(name = "indep_year")
  private Short indepYear;
  @Column(name = "population")
  private int population;
  @Column(name = "life_expectancy")
  private Float lifeExpectancy;
  @JsonIgnore
  @Column(name = "gnp")
  private BigDecimal gnp;
  @JsonIgnore
  @Column(name = "gnp_old")
  private BigDecimal gnpOld;
  @JsonIgnore
  @Column(name = "local_name")
  private String localName;
  @JsonIgnore
  @Column(name = "government_form")
  private String governmentForm;
  @JsonIgnore
  @Column(name = "head_of_state")
  private String headOfState;
  @JsonIgnore
  @Column(name = "code2")
  private String code2;
  @JsonIgnore
  @JoinColumn(name = "capital", referencedColumnName = "id")
  @ManyToOne
  private City capital;
  @JsonIgnore
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "countryCode")
  private List<City> cityList;
  @JsonIgnore
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "country")
  private List<CountryLanguage> countryLanguageList;


  @Transient
  private String countryLanguage;

  public String getCountryLanguage() {
    return this.getCountryLanguageList()
        .stream().filter(CountryLanguage::isOfficial)
        .findFirst().get().getLanguage();
  }
}
