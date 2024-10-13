package com.wolvesmentality.repository.jpa;

import com.wolvesmentality.domain.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookJpaRepository extends JpaRepository<Book, Long> {
}
