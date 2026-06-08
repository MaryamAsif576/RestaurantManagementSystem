package com.library.librarymanagement.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.library.librarymanagement.model.Loan;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class LoanRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // CALLING STORED PROCEDURE: Issue Book (Transaction 1)
    public void issueBook(int copyId, int memberId, int staffId, String dueDate) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_IssueBook");
        
        Map<String, Object> inParams = new HashMap<>();
        inParams.put("p_copy_id", copyId);
        inParams.put("p_member_id", memberId);
        inParams.put("p_staff_id", staffId);
        inParams.put("p_due_date", dueDate);
        
        jdbcCall.execute(inParams);
    }

    // CALLING STORED PROCEDURE: Return Book (Transaction 2)
    public void returnBook(int loanId, int copyId) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_ReturnBook");
        
        Map<String, Object> inParams = new HashMap<>();
        inParams.put("p_loan_id", loanId);
        inParams.put("p_copy_id", copyId);
        
        jdbcCall.execute(inParams);
    }

    // CALLING VIEW: Overdue Books
    public List<Map<String, Object>> getOverdueBooks() {
        String sql = "SELECT * FROM v_OverdueBooks";
        return jdbcTemplate.queryForList(sql);
    }
    
    // CALLING VIEW: Member Loans
    public List<Map<String, Object>> getMemberLoans() {
        String sql = "SELECT * FROM v_MemberLoans";
        return jdbcTemplate.queryForList(sql);
    }
}

