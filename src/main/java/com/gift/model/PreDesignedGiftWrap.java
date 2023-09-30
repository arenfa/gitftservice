package com.gift.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PreDesignedGiftWrap {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String name;
  private String image;
  private String size;
  private Double height;
  private Double width;
  private Double length;
  private Double price;
  private Integer quantity;
  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }


  /**
   * @return the image
   */
  public String getImage() {
    return image;
  }

  /**
   * @param image the image to set
   */
  public void setImage(String image) {
    this.image = image;
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
   * @return the size
   */
  public String getSize() {
    return size;
  }

  /**
   * @param size the size to set
   */
  public void setSize(String size) {
    this.size = size;
  }

  /**
   * @return the height
   */
  public Double getHeight() {
    return height;
  }

  /**
   * @param height the height to set
   */
  public void setHeight(Double height) {
    this.height = height;
  }

  /**
   * @return the width
   */
  public Double getWidth() {
    return width;
  }

  /**
   * @param width the width to set
   */
  public void setWidth(Double width) {
    this.width = width;
  }

  /**
   * @return the length
   */
  public Double getLength() {
    return length;
  }

  /**
   * @param length the length to set
   */
  public void setLength(Double length) {
    this.length = length;
  }

  /**
   * @return the price
   */
  public Double getPrice() {
    return price;
  }

  /**
   * @param price the price to set
   */
  public void setPrice(Double price) {
    this.price = price;
  }

  /**
   * @return the quantity
   */
  public Integer getQuantity() {
    return quantity;
  }

  /**
   * @param quantity the quantity to set
   */
  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

}
