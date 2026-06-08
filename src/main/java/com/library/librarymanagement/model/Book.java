package com.library.librarymanagement.model;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data // Generates getters, setters, toString automatically
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private Integer bookId;
    private String title;
    private Integer categoryId;
    private Integer publisherId;
    private String isbn;
    private Integer publishYear;
    private Integer totalCopies;
}

