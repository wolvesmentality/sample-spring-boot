package com.wolvesmentality.service;

import com.wolvesmentality.domain.dto.BookDTO;
import com.wolvesmentality.domain.entity.Book;
import com.wolvesmentality.mapper.BookMapper;
import com.wolvesmentality.repository.custom.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookMapper bookMapper;

    private final BookRepository bookRepository;

    public List<BookDTO> getAll_1() {
        return this.toBookDTOS(this.bookRepository.getAllUsingJdbcTemplate());
    }


    public List<BookDTO> getAll_2() {
        return this.toBookDTOS(this.bookRepository.getAll());

    }

    private List<BookDTO> toBookDTOS(final List<Book> books) {
        return Optional.ofNullable(books)
                .stream()
                .flatMap(Collection::stream)
                .map(this.bookMapper::toBookDTO)
                .toList();
    }
}
