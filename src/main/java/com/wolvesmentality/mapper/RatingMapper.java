package com.wolvesmentality.mapper;

import com.wolvesmentality.domain.dto.RatingDTO;
import com.wolvesmentality.domain.entity.Rating;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RatingMapper {

    Rating toRating(RatingDTO ratingDTO);

    RatingDTO toRatingDTO(Rating rating);
}
