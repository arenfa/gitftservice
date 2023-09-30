package com.gift.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String street1;
  private String street2;
  private String city;
  private String state;
  private String zipcode;
  
  private Date createdDate;
  
  private Date modifiedDate;
  
  /**
   * @return the street1
   */
  public String getStreet1() {
    return street1;
  }
  /**
   * @param street1 the street1 to set
   */
  public void setStreet1(String street1) {
    this.street1 = street1;
  }
  /**
   * @return the street2
   */
  public String getStreet2() {
    return street2;
  }
  /**
   * @param street2 the street2 to set
   */
  public void setStreet2(String street2) {
    this.street2 = street2;
  }
  /**
   * @return the city
   */
  public String getCity() {
    return city;
  }
  /**
   * @param city the city to set
   */
  public void setCity(String city) {
    this.city = city;
  }
  /**
   * @return the state
   */
  public String getState() {
    return state;
  }
  /**
   * @param state the state to set
   */
  public void setState(String state) {
    this.state = state;
  }
  /**
   * @return the zipcode
   */
  public String getZipcode() {
    return zipcode;
  }
  /**
   * @param zipcode the zipcode to set
   */
  public void setZipcode(String zipcode) {
    this.zipcode = zipcode;
  }
  /**
   * @return the id
   */
  public Long getId() {
    return id;
  }
  /**
   * @param id the id to set
   */
  public void setId(Long id) {
    this.id = id;
  }
  /**
   * @return the createdDate
   */
  public Date getCreatedDate() {
    return createdDate;
  }
  /**
   * @param createdDate the createdDate to set
   */
  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }
  /**
   * @return the modifiedDate
   */
  public Date getModifiedDate() {
    return modifiedDate;
  }
  /**
   * @param modifiedDate the modifiedDate to set
   */
  public void setModifiedDate(Date modifiedDate) {
    this.modifiedDate = modifiedDate;
  }


}
