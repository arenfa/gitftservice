package com.gift.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class GiftWrap {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private Integer boxId;
  private Integer wrappingPaperId;
  private Integer ribonId;
  
  @Transient
  private Map<String, Object> accessories;
  
  @OneToOne(cascade = {CascadeType.ALL})
  @JoinColumn(name="order_id")
  private Order order;
  
  private Date createdDate;
  
  private Date modifiedDate;
  /**
   * PRE_DESIGNED, CUSTOM, NO_MATERIAL
   */
  private String style;
  
  @OneToOne
  @JoinColumn(name="pre_designed_gift_wrap_id")
  private PreDesignedGiftWrap preDesignedGiftWrap;
  
  private BigDecimal amount;
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
   * @return the accessories
   */
  public Map<String, Object> getAccessories() {
    return accessories;
  }
  /**
   * @param accessories the accessories to set
   */
  public void setAccessories(Map<String, Object> accessories) {
    this.accessories = accessories;
  }
  /**
   * @return the order
   */
  public Order getOrder() {
    return order;
  }
  /**
   * @param order the order to set
   */
  public void setOrder(Order order) {
    this.order = order;
  }
  /**
   * @return the style
   */
  public String getStyle() {
    return style;
  }
  /**
   * @param style the style to set
   */
  public void setStyle(String style) {
    this.style = style;
  }
  /**
   * @return the boxId
   */
  public Integer getBoxId() {
    return boxId;
  }
  /**
   * @param boxId the boxId to set
   */
  public void setBoxId(Integer boxId) {
    this.boxId = boxId;
  }
  /**
   * @return the wrappingPaperId
   */
  public Integer getWrappingPaperId() {
    return wrappingPaperId;
  }
  /**
   * @param wrappingPaperId the wrappingPaperId to set
   */
  public void setWrappingPaperId(Integer wrappingPaperId) {
    this.wrappingPaperId = wrappingPaperId;
  }
  /**
   * @return the ribonId
   */
  public Integer getRibonId() {
    return ribonId;
  }
  /**
   * @param ribonId the ribonId to set
   */
  public void setRibonId(Integer ribonId) {
    this.ribonId = ribonId;
  }
  /**
   * @return the preDesignedGiftWrap
   */
  public PreDesignedGiftWrap getPreDesignedGiftWrap() {
    return preDesignedGiftWrap;
  }
  /**
   * @param preDesignedGiftWrap the preDesignedGiftWrap to set
   */
  public void setPreDesignedGiftWrap(PreDesignedGiftWrap preDesignedGiftWrap) {
    this.preDesignedGiftWrap = preDesignedGiftWrap;
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
