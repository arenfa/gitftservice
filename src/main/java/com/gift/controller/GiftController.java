package com.gift.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.gift.model.Box;
import com.gift.model.Order;
import com.gift.model.PreDesignedGiftWrap;
import com.gift.model.Ribon;
import com.gift.model.WrappingPaper;
import com.gift.service.GiftService;

@RestController
@RequestMapping("/gift")
public class GiftController {

  @Autowired
  private GiftService giftService;
  
  @PostMapping("/order")
  public Order orderGiftWrap(@RequestBody Order order) {
      return giftService.orderGiftWrap(order);
  }
  
  /**
   * Gets orders for the given date
   * @param date
   * @return
   */
  @GetMapping("/orders")
  public List<Order> getOrders(@RequestParam(required = false) String date) {
      return giftService.getOrders(date);
  }
  
  @GetMapping("/orders/{orderId}")
  public Order getOrder(@PathVariable Long orderId) {
      return giftService.getOrder(orderId);
  }
  
  @GetMapping("/predesigned-giftwraps")
  public Map<String, List<PreDesignedGiftWrap>> getPreDesignedGiftWraps() {
      return giftService.getPreDesignedGiftWraps();
  }
  
  @GetMapping("/boxes")
  public List<Box> getBoxes() {
      return giftService.getBoxes();
  }
  
  @GetMapping("/papers")
  public List<WrappingPaper> getPapers() {
      return giftService.getPapers();
  }
  
  @GetMapping("/ribons")
  public List<Ribon> getRibons() {
      return giftService.getRibons();
  }
  
  @GetMapping("/accessories")
  public Map<String, Object> getAccesscories() {
      return giftService.getAccesscories();
  }
}
