package com.example.review.service;

import com.example.review.model.ReviewEntity;
import com.example.review.repository.RestaurantRepository;
import com.example.review.repository.ReviewRepository;
import com.example.review.service.dto.ReviewDto;
import java.time.ZonedDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ReviewService {

  private final RestaurantRepository restaurantRepository;
  private final ReviewRepository reviewRepository;

  @Transactional
  public void createReview(Long restaurantId, String content, Double score) {
    restaurantRepository.findById(restaurantId).orElseThrow();

    ReviewEntity review = ReviewEntity.builder()
        .restaurantId(restaurantId)
        .content(content)
        .score(score)
        .createdAt(ZonedDateTime.now())
        .build();

    reviewRepository.save(review);
  }

  @Transactional
  public void deleteReview(Long reviewId) {
    ReviewEntity review = reviewRepository.findById(reviewId).orElseThrow();

    reviewRepository.delete(review);
  }

  public ReviewDto getRestaurantReview(Long restaurantId, Pageable page) {
    Double avgScroe = reviewRepository.getAvgScoreByRestaurantId(restaurantId);
    Slice<ReviewEntity> reviews = reviewRepository.findSliceByRestaurantId(restaurantId, page);

    return ReviewDto.builder()
        .avgScore(avgScroe)
        .reviews(reviews.getContent())
        .page(
            ReviewDto.ReviewDtoPage.builder()
                .offset(page.getPageNumber() * page.getPageSize())
                .limit(page.getPageSize())
                .build()
        )
        .build();
  }
}
