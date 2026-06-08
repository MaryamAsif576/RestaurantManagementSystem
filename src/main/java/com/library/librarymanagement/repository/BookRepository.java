package com.library.librarymanagement.repository;

import com.library.librarymanagement.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Book> findAll() {
        String sql = "SELECT * FROM Book";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Book.class));
    }

    public int save(Book book) {
        String sql = "INSERT INTO Book (title, category_id, publisher_id, isbn, publish_year, total_copies) VALUES (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, book.getTitle(), book.getCategoryId(), book.getPublisherId(), book.getIsbn(), book.getPublishYear(), book.getTotalCopies());
    }
}

