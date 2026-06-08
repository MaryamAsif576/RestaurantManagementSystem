package com.library.librarymanagement.model;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    private Integer memberId;
    private String name;
    private String email;
    private String phone;
    private Date dateOfBirth;
    private String address;
    private Date registrationDate;
}

