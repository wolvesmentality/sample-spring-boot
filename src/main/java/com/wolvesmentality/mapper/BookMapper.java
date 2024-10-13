package com.wolvesmentality.mapper;

import com.wolvesmentality.domain.dto.BookDTO;
import com.wolvesmentality.domain.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BookMapper {
    Book toBook(BookDTO bookDTO);

    BookDTO toBookDTO(Book book);
}
