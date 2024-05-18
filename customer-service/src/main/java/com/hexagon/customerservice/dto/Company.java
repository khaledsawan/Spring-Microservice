package com.hexagon.customerservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    private int id;
    private String comapnyName;
    private String location;
    private String principalName;
}
