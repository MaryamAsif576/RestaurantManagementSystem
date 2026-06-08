package com.library.librarymanagement.service;

import com.library.librarymanagement.model.Book;
import com.library.librarymanagement.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private static final Logger logger = LoggerFactory.getLogger(BookService.class);

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        logger.info("Fetching all books");
        return bookRepository.findAll();
    }

    public String addBook(Book book) {
        // VALIDATOR: Check if title is empty
        if (book.getTitle() == null || book.getTitle().trim().isEmpty()) {
            throw new IllegalArgumentException("Book title cannot be empty!");
        }
        // VALIDATOR: Check if total copies is valid
        if (book.getTotalCopies() == null || book.getTotalCopies() < 1) {
            throw new IllegalArgumentException("Book must have at least 1 copy!");
        }

        bookRepository.save(book);
        logger.info("Book added successfully: {}", book.getTitle());
        return "Book added successfully!";
    }
}

