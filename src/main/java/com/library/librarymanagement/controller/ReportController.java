package com.library.librarymanagement.controller;

import com.library.librarymanagement.repository.LoanRepository;
import com.library.librarymanagement.service.PdfReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private PdfReportService pdfReportService;

    @GetMapping("/overdue-pdf")
    public String generateOverduePdf() {
        List<Map<String, Object>> overdueBooks = loanRepository.getOverdueBooks();
        return pdfReportService.generateOverdueBooksReport(overdueBooks);
    }
}

