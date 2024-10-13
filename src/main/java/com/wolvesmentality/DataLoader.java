package com.wolvesmentality;


import com.wolvesmentality.domain.entity.Book;
import com.wolvesmentality.domain.entity.Rating;
import com.wolvesmentality.repository.jpa.BookJpaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataLoader.class);

    private final BookJpaRepository bookRepository;
    
    @Override
    @Transactional
    public void onApplicationEvent(final ContextRefreshedEvent contextRefreshedEvent) {
        LOGGER.info("add books");
        this.addBooks();
    }

    private void addBooks() {
        final Book book1 = new Book();
        book1.setTitle("Java Book");
        book1.setPublicationDate(LocalDate.parse("2017-12-11", DateTimeFormatter.ISO_DATE));
        book1.setAuthor("Simon");
        book1.setRatings(Arrays.asList(new Rating(4), new Rating(5)));
        book1.setTags(Arrays.asList("Java", "Hibernate"));

        final Book book2 = new Book();
        book2.setTitle("Php Book");
        book2.setPublicationDate(LocalDate.parse("2018-12-11", DateTimeFormatter.ISO_DATE));
        book2.setAuthor("Chris");
        book2.setRatings(Arrays.asList(new Rating(3), new Rating(4)));

        this.bookRepository.saveAll(Arrays.asList(book1, book2));
    }

}
