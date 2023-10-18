package com.example.review.service.dto;

import com.example.review.model.ReviewEntity;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class ReviewDto {

  private Double avgScore;
  private List<ReviewEntity> reviews;
  private ReviewDtoPage page;

  @AllArgsConstructor
  @Builder
  @Getter
  public static class ReviewDtoPage {

    private Integer offset;
    private Integer limit;
  }
}
