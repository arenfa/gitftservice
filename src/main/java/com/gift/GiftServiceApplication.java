package com.gift;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("com.gift")
public class GiftServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(GiftServiceApplication.class, args);
  }
}

