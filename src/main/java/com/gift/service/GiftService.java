package com.gift.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gift.model.Address;
import com.gift.model.Box;
import com.gift.model.GiftWrap;
import com.gift.model.Order;
import com.gift.model.PreDesignedGiftWrap;
import com.gift.model.Ribon;
import com.gift.model.User;
import com.gift.model.WrappingPaper;
import com.gift.repository.AddressRepository;
import com.gift.repository.BoxRepository;
import com.gift.repository.GiftWrapRepository;
import com.gift.repository.OrderRepository;
import com.gift.repository.PreDesignedGiftWrapRepository;
import com.gift.repository.RibonRepository;
import com.gift.repository.UserRepository;
import com.gift.repository.WrappingPaperRepository;
import com.gift.util.DateUtil;

@Service
public class GiftService {
  
  @Autowired
  private BoxRepository boxRepository;
  
  @Autowired
  private WrappingPaperRepository wrappingPaperRepository;
  
  @Autowired
  private RibonRepository ribonRepository;
  
  @Autowired
  private OrderRepository orderRepository;
  
  @Autowired
  private GiftWrapRepository giftWrapRepository;
  
  @Autowired
  private PreDesignedGiftWrapRepository preDesignedGiftWrapRepository;
  
  @Autowired
  private UserRepository userRepository;
  
  @Autowired
  private AddressRepository addressRepository;
  
  @Transactional
  public Order orderGiftWrap(Order order) {
    if (order.getGiftWraps() == null) {
      return null;
    }
    fillUserinOrder(order);
    fillAddressinOrder(order);
    
    // wrap date and time
    if (order.getPickedDate() != null && order.getPickedTime() != null) {
      Date wrapDateStart = DateUtil.getDate(order.getPickedDate() + " " + order.getPickedTime());
      int hours = (int) (order.getGiftWraps().size() * 0.5);
      int minutes = 0;
      if (order.getGiftWraps().size() % 2 != 0) {
        // adding 30 minutes
        minutes = 30;
      }
      Date wrapDateEnd = DateUtil.addHoursToDate(wrapDateStart, hours, minutes);
      order.setWrapDateStart(wrapDateStart);
      order.setWrapDateEnd(wrapDateEnd);
    }
    
    order.setCreatedDate(new Date());
    order.setModifiedDate(new Date());
    orderRepository.save(order);
    
    // create giftwraps
    createGiftWrapsForOrder(order);
    
    Order orderToReturn = new Order();
    orderToReturn.setId(order.getId());
    orderToReturn.setCreatedDate(order.getCreatedDate());
    orderToReturn.setWrapDateStart(order.getWrapDateStart());
    orderToReturn.setWrapDateEnd(order.getWrapDateEnd());
    
    return orderToReturn;
  }
  
  public void createGiftWrapsForOrder(Order order) {
    if (order.getGiftWraps() == null) {
      return;
    }
    
    for (GiftWrap giftWrap : order.getGiftWraps()) {
      giftWrap.setOrder(order);
      if (giftWrap.getPreDesignedGiftWrap() != null) {
        giftWrap.setStyle("PRE_DESIGNED");
      }
      
      giftWrap.setCreatedDate(new Date());
      giftWrap.setModifiedDate(new Date());
      giftWrapRepository.save(giftWrap);
    }
  }
  
  public void fillUserinOrder(Order order) {
    User user = order.getUser();
    if (user != null) {
      User dbUser = userRepository.findByEmail(user.getEmail());
      if (dbUser == null) {
        // create
        dbUser = createUser(user);
      }
      order.setUser(dbUser);
    }
  }
  
  public User createUser(User orderedUser) {
    User user = new User();
    user.setEmail(orderedUser.getEmail());
    user.setPhone(orderedUser.getPhone());
    user.setCreatedDate(new Date());
    user.setModifiedDate(new Date());
    userRepository.save(user);
    
    return user; 
  }
  
  public void fillAddressinOrder(Order order) {
    Address address = order.getAddress();
    if (address != null) {
      // create address
      Address newAddress = new Address();
      newAddress.setStreet1(address.getStreet1());
      newAddress.setStreet2(address.getStreet2());
      newAddress.setCity(address.getCity());
      newAddress.setState(address.getState());
      newAddress.setZipcode(address.getZipcode());
      newAddress.setState("CA");
      newAddress.setCreatedDate(new Date());
      newAddress.setModifiedDate(new Date());
      addressRepository.save(newAddress);
      order.setAddress(newAddress);
    }
  }

  public List<Order> getOrders(String date) {
      // TODO change
    List<Order> orders = orderRepository.findAll();
    Collections.sort(orders, new Comparator<Order>() {
      @Override
      public int compare(Order o1, Order o2) {
        return o1.getWrapDateStart().compareTo(o2.getWrapDateStart());
      }
    });
    
    return orders;
  }
  
  public Order getOrder(Long orderId) {
      return orderRepository.getOne(orderId);
  }
  
  public Map<String, List<PreDesignedGiftWrap>> getPreDesignedGiftWraps() {
    List<PreDesignedGiftWrap> preDesignedGiftWraps = preDesignedGiftWrapRepository.findAll();
    Map<String, List<PreDesignedGiftWrap>> map = new HashMap<>();
    for (PreDesignedGiftWrap preDesignedGiftWrap : preDesignedGiftWraps) {
      List<PreDesignedGiftWrap> vals = map.get(preDesignedGiftWrap.getName());
      if (vals == null) {
        vals = new ArrayList<>();
        vals.add(preDesignedGiftWrap);
        map.put(preDesignedGiftWrap.getName(), vals);
      } else {
        vals.add(preDesignedGiftWrap);
      }
    }
    
    return map;
  }
  
  public List<Box> getBoxes() {
      return boxRepository.findAll();
  }
  
  public List<WrappingPaper> getPapers() {
      return wrappingPaperRepository.findAll();
  }
  
  public List<Ribon> getRibons() {
      return ribonRepository.findAll();
  }
  
  public Map<String, Object> getAccesscories() {
      return null;
  }
}
