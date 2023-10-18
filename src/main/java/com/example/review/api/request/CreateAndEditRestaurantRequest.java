package com.example.review.api.request;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CreateAndEditRestaurantRequest {

  private final String name;
  private final String address;
  private final List<CreateAndEditRestaurantRequestMenu> menus;
}
