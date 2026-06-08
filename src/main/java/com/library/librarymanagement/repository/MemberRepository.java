package com.library.librarymanagement.repository;

import com.library.librarymanagement.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Member> findAll() {
        String sql = "SELECT * FROM Member";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Member.class));
    }

    public int save(Member member) {
        String sql = "INSERT INTO Member (name, email, phone, date_of_birth, address) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, member.getName(), member.getEmail(), member.getPhone(), member.getDateOfBirth(), member.getAddress());
    }
}

