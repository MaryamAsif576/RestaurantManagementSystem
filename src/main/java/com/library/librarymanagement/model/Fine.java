package com.library.librarymanagement.model;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fine {
    private Integer fineId;
    private Integer loanId;
    private Double amount;
    private Date issuedDate;
    private String status;
}

