package com.gift.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Box {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  private String name;
  private Double height;
  private Double width;
  private Double length;
  private String image;

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
   * @return the id
   */
  public Integer getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(Integer id) {
    this.id = id;
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

}
