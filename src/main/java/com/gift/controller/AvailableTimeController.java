package com.gift.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gift.model.GiftWrap;

@RestController
@RequestMapping("/availableTime")
public class AvailableTimeController {

  
  @GetMapping("/test")
  public GiftWrap getAllNotes() {
      GiftWrap giftWrap = new GiftWrap();
      return giftWrap;
  }
  

}
