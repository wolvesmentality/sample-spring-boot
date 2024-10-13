package com.wolvesmentality.domain.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class BookDTOTest {

    @Test
    void testConstructor() {
        final BookDTO bookDTO = new BookDTO(1L);
        Assertions.assertEquals(1L, bookDTO.id());
    }
}
