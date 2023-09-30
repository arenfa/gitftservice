package com.gift.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "orders")
public class Order {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  
  @Transient
  private List<GiftWrap> giftWraps;
  
  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="users_id")
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  private User user;
  
  private Date createdDate;
  
  private Date wrapDateStart;
  
  private Date wrapDateEnd;
  
  private Date modifiedDate;
  
  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="address_id")
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  private Address address;
  private String notes;
  private BigDecimal amount;
  
  @Transient
  private String pickedDate;
  @Transient
  private String pickedTime;
  
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
   * @return the giftWraps
   */
  public List<GiftWrap> getGiftWraps() {
    return giftWraps;
  }
  /**
   * @param giftWraps the giftWraps to set
   */
  public void setGiftWraps(List<GiftWrap> giftWraps) {
    this.giftWraps = giftWraps;
  }
  /**
   * @return the user
   */
  public User getUser() {
    return user;
  }
  /**
   * @param user the user to set
   */
  public void setUser(User user) {
    this.user = user;
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
  /**
   * @return the address
   */
  public Address getAddress() {
    return address;
  }
  /**
   * @param address the address to set
   */
  public void setAddress(Address address) {
    this.address = address;
  }
  /**
   * @return the wrapDateStart
   */
  public Date getWrapDateStart() {
    return wrapDateStart;
  }
  /**
   * @param wrapDateStart the wrapDateStart to set
   */
  public void setWrapDateStart(Date wrapDateStart) {
    this.wrapDateStart = wrapDateStart;
  }
  /**
   * @return the wrapDateEnd
   */
  public Date getWrapDateEnd() {
    return wrapDateEnd;
  }
  /**
   * @param wrapDateEnd the wrapDateEnd to set
   */
  public void setWrapDateEnd(Date wrapDateEnd) {
    this.wrapDateEnd = wrapDateEnd;
  }
  /**
   * @return the notes
   */
  public String getNotes() {
    return notes;
  }
  /**
   * @param notes the notes to set
   */
  public void setNotes(String notes) {
    this.notes = notes;
  }
  /**
   * @return the amount
   */
  public BigDecimal getAmount() {
    return amount;
  }
  /**
   * @param amount the amount to set
   */
  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }
  /**
   * @return the pickedDate
   */
  public String getPickedDate() {
    return pickedDate;
  }
  /**
   * @param pickedDate the pickedDate to set
   */
  public void setPickedDate(String pickedDate) {
    this.pickedDate = pickedDate;
  }
  /**
   * @return the pickedTime
   */
  public String getPickedTime() {
    return pickedTime;
  }
  /**
   * @param pickedTime the pickedTime to set
   */
  public void setPickedTime(String pickedTime) {
    this.pickedTime = pickedTime;
  }
  

}
