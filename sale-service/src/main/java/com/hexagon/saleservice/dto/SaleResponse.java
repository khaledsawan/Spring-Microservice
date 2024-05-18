package com.hexagon.saleservice.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaleResponse {
    private int id;
    private String name;
    private int age;
    private String gender;
    private Company company;
}
