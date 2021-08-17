package com.mycompany.worldmap.model;

import lombok.Data;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="bookmarkCountry")
@Data
public class BookmarkCountry implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "active")
  private boolean active;

  @OneToOne
  @JoinColumn(name = "countryCode", referencedColumnName = "code")
  private Country country;


}
