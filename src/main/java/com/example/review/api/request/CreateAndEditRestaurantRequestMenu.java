package com.example.review.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CreateAndEditRestaurantRequestMenu {

  private final String name;
  private final Integer price;
}
