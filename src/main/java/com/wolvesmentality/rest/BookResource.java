package com.wolvesmentality.rest;

import com.wolvesmentality.domain.dto.BookDTO;
import com.wolvesmentality.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/book")
@RequiredArgsConstructor
public class BookResource {

    private final BookService bookService;

    @GetMapping
    public List<BookDTO> getAll() {
        return this.bookService.getAll_1();
    }
}
