package com.everis.demo.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.everis.demo.model.Product;


@RestController
public class ProductServiceController {
   private static Map<String, Product> productRepo = new HashMap<>();   
   static {      
      Product honey = new Product();
      honey.setId("1");
      honey.setName("Honey");
      productRepo.put(honey.getId(), honey);      
      Product almond = new Product();
      almond.setId("2");
      almond.setName("Almond");
      productRepo.put(almond.getId(), almond);      
   }
   @RequestMapping(value = "/products")
   public ResponseEntity<Collection<Product>> getProduct() {
      return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
   }
}