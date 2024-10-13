package com.wolvesmentality.repository.custom;

import com.wolvesmentality.DataLoader;
import com.wolvesmentality.repository.config.RepositoryTestConfig;
import io.zonky.test.db.AutoConfigureEmbeddedDatabase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(SpringExtension.class)
@DataJpaTest
@Import({RepositoryTestConfig.class, DataLoader.class})
@AutoConfigureEmbeddedDatabase(provider = AutoConfigureEmbeddedDatabase.DatabaseProvider.ZONKY)
class BookRepositoryTest {

    @Autowired
    private BookRepository repository;

    @Test
    void getAllUsingJdbcTemplate() {
        assertEquals(2, this.repository.getAllUsingJdbcTemplate().size());
    }
}
