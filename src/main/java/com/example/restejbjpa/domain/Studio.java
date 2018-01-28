package com.example.restejbjpa.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "studio.all", query = "Select s from Studio s"),
        @NamedQuery(name = "studio.deleteAll", query = "Delete from Studio ")
})
public class Studio {


  private long id;
  private String name;
  private String country;

  public Studio(){
    super();
  }

  public Studio(String name, String country){
    this.name = name;
    this.country = country;
  }
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }
}
