package com.library.librarymanagement.model;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Loan {
    private Integer loanId;
    private Integer copyId;
    private Integer memberId;
    private Integer staffId;
    private Date loanDate;
    private Date dueDate;
    private Date returnDate;
    private String status;
}

