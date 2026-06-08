package com.library.librarymanagement.model;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Publisher {
    private Integer publisherId;
    private String name;
    private String address;
    private String phone;
}

