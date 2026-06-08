package com.library.librarymanagement.controller;

import com.library.librarymanagement.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @PostMapping("/issue")
    public String issueBook(@RequestParam int copyId, @RequestParam int memberId, 
                            @RequestParam int staffId, @RequestParam String dueDate) {
        return loanService.issueBook(copyId, memberId, staffId, dueDate);
    }

    @PostMapping("/return")
    public String returnBook(@RequestParam int loanId, @RequestParam int copyId) {
        return loanService.returnBook(loanId, copyId);
    }

    @GetMapping("/overdue")
    public List<Map<String, Object>> getOverdueBooks() {
        return loanService.getOverdueBooks();
    }
    
    @GetMapping("/history")
    public List<Map<String, Object>> getMemberLoans() {
        return loanService.getMemberLoans();
    }
}

