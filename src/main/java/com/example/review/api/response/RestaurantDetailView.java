package com.example.review.api.response;

import java.time.ZonedDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class RestaurantDetailView {

  private final Long id;
  private final String name;
  private final String address;
  private final ZonedDateTime createdAt;
  private final ZonedDateTime updatedAt;
  private final List<Menu> menus;

  @AllArgsConstructor
  @Builder
  @Getter
  public static class Menu {

    private final Long id;
    private final String name;
    private final Integer price;
    private final ZonedDateTime createdAt;
    private final ZonedDateTime updatedAt;
  }
}
