package com.wolvesmentality.repository.custom;

import com.wolvesmentality.domain.entity.Rating;
import com.wolvesmentality.repository.jpa.RatingJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class RatingRepository {

    private final RatingJpaRepository ratingJpaRepository;

    public List<Rating> findByBookId(final Long bookId) {
        return this.ratingJpaRepository.findByBookId(bookId);
    }

}
