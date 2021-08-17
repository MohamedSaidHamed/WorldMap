package com.mycompany.worldmap.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "city")
@Data
public class City implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "name")
  private String name;
  @Column(name = "district")
  private String district;
  @Column(name = "population")
  private int population;

  @JoinColumn(name = "country_code", referencedColumnName = "code", nullable = false)
  @ManyToOne
  private Country countryCode;

  @OneToMany(mappedBy = "capital")
  private List<Country> countryList;

}
