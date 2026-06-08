package com.library.librarymanagement.model;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookCopy {
    private Integer copyId;
    private Integer bookId;
    private Integer branchId;
    private String status;
}

