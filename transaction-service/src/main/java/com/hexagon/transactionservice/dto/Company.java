package com.hexagon.transactionservice.dto;

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
    private String schoolName;
    private String location;
    private String principalName;
}
