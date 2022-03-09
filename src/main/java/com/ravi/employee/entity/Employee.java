package com.ravi.employee.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
//@EntityScan
public class Employee {

    private Integer id;
    private String name;
    private String address;
    private String email;
    private String mobile;

}
