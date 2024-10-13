package com.wolvesmentality.rest;

import com.wolvesmentality.domain.dto.RatingDTO;
import com.wolvesmentality.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/rating")
@RequiredArgsConstructor
public class RatingResource {

    private final RatingService ratingService;
    
    @GetMapping("/{bookId}")
    public List<RatingDTO> getAll(@PathVariable final Long bookId) {
        return this.ratingService.findByBookId(bookId);
    }

}
