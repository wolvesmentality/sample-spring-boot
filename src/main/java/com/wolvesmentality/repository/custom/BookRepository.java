package com.wolvesmentality.repository.custom;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wolvesmentality.domain.entity.Book;
import com.wolvesmentality.exception.AppRuntimeException;
import com.wolvesmentality.repository.jpa.BookJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

@Repository
@PropertySource("classpath:sql-queries/book-queries.properties")
@RequiredArgsConstructor
public class BookRepository {

    private final BookJpaRepository bookJpaRepository;
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final ObjectMapper objectMapper;

    @Value("${get.all.books}")
    private String allBooksQuery;

    public List<Book> getAll() {
        return this.bookJpaRepository.findAll();
    }

    public List<Book> getAllUsingJdbcTemplate() {
        final String sqlQuery = this.allBooksQuery;
        return this.jdbcTemplate.query(sqlQuery, (rs, rowNum) -> {
            final Long bookId = rs.getLong("id");
            try {
                final Book book = new Book();
                book.setId(bookId);
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setPublicationDate(rs.getDate("publicationDate").toLocalDate());
                final String tagsAsString = rs.getString("tags");
                book.setTags(BookRepository.this.objectMapper.readValue(tagsAsString, new TypeReference<>() {
                }));
                final String ratingsAsString = rs.getString("ratings");
                book.setRatings(this.objectMapper.readValue(ratingsAsString, new TypeReference<>() {
                }));
                return book;
            } catch (final IOException e) {
                throw new AppRuntimeException("Cannot parse resultSet of book with id ".concat(bookId.toString()), e);
            }
        });
    }
}
