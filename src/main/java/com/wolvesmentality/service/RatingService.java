package com.wolvesmentality.service;

import com.wolvesmentality.domain.dto.RatingDTO;
import com.wolvesmentality.domain.entity.Rating;
import com.wolvesmentality.mapper.RatingMapper;
import com.wolvesmentality.repository.custom.RatingRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RatingService {

    private final RatingMapper ratingMapper;
    private final RatingRepository ratingRepository;

    public List<RatingDTO> findByBookId(final Long bookId) {
        final List<Rating> ratings = this.ratingRepository.findByBookId(bookId);
        if (CollectionUtils.isNotEmpty(ratings)) {
            return ratings.stream().map(this.ratingMapper::toRatingDTO).toList();
        }
        return Collections.emptyList();
    }
}
