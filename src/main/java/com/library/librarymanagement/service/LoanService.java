package com.library.librarymanagement.service;

import com.library.librarymanagement.repository.LoanRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class LoanService {

    private static final Logger logger = LoggerFactory.getLogger(LoanService.class);

    @Autowired
    private LoanRepository loanRepository;

    // @Transactional ensures that if the stored procedure fails, it rolls back safely
    @Transactional
    public String issueBook(int copyId, int memberId, int staffId, String dueDate) {
        // VALIDATOR: Ensure IDs are positive
        if (copyId <= 0 || memberId <= 0 || staffId <= 0) {
            throw new IllegalArgumentException("IDs must be positive numbers!");
        }
        if (dueDate == null || dueDate.isEmpty()) {
            throw new IllegalArgumentException("Due date is required!");
        }

        try {
            loanRepository.issueBook(copyId, memberId, staffId, dueDate);
            logger.info("Book issued successfully to member {}", memberId);
            return "Book issued successfully!";
        } catch (Exception e) {
            logger.error("Error issuing book: ", e);
            throw new RuntimeException("Failed to issue book. Database error.");
        }
    }

    @Transactional
    public String returnBook(int loanId, int copyId) {
        if (loanId <= 0 || copyId <= 0) {
            throw new IllegalArgumentException("IDs must be positive numbers!");
        }
        loanRepository.returnBook(loanId, copyId);
        logger.info("Book returned successfully for loan {}", loanId);
        return "Book returned successfully!";
    }

    public List<Map<String, Object>> getOverdueBooks() {
        return loanRepository.getOverdueBooks();
    }
    
    public List<Map<String, Object>> getMemberLoans() {
        return loanRepository.getMemberLoans();
    }
}

