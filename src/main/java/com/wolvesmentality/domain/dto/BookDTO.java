package com.wolvesmentality.domain.dto;

import java.time.LocalDate;
import java.util.List;

public record BookDTO(
        Long id,
        String title,
        String author,
        LocalDate publicationDate,
        List<RatingDTO> ratings,
        List<String> tags
) {
    public BookDTO(final Long id) {
        this(id, null, null, null, null, null);
    }
}