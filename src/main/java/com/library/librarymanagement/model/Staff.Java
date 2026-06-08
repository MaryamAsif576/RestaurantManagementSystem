package com.library.librarymanagement.model;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Staff {
    private Integer staffId;
    private Integer branchId;
    private String name;
    private String role;
    private String email;
    private String password;
}
