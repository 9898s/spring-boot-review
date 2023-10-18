package com.example.review.api;

import com.example.review.api.request.CreateAndEditRestaurantRequest;
import com.example.review.api.response.RestaurantDetailView;
import com.example.review.api.response.RestaurantView;
import com.example.review.service.RestaurantService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class RestaurantApi {

  private final RestaurantService restaurantService;

  @GetMapping("/restaurants")
  public List<RestaurantView> getRestaurants() {
    return restaurantService.getAllRestaurants();
  }

  @GetMapping("/restaurant/{restaurantId}")
  public RestaurantDetailView getRestaurant(
      @PathVariable Long restaurantId
  ) {
    return restaurantService.getRestaurantDetail(restaurantId);
  }

  @PostMapping("/restaurant")
  public void createRestaurant(
      @RequestBody CreateAndEditRestaurantRequest request
  ) {
    restaurantService.createRestaurant(request);
  }

  @PutMapping("/restaurant/{restaurantId}")
  public void editRestaurant(
      @PathVariable Long restaurantId,
      @RequestBody CreateAndEditRestaurantRequest request
  ) {
    restaurantService.editRestaurant(restaurantId, request);
  }

  @DeleteMapping("/restaurant/{restaurantId}")
  public void deleteRestaurant(
      @PathVariable Long restaurantId
  ) {
    restaurantService.deleteRestaurant(restaurantId);
  }
}
