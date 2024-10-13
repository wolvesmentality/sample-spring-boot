package com.wolvesmentality.repository.jpa;

import com.wolvesmentality.domain.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RatingJpaRepository extends JpaRepository<Rating, Long> {

    @Query(value = "SELECT * FROM RATING r WHERE r.book_id = ?1", nativeQuery = true)
    List<Rating> findByBookId(Long bookId);
}
