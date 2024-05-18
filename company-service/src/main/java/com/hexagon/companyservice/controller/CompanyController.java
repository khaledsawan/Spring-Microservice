package com.hexagon.companyservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hexagon.companyservice.entity.Company;
import com.hexagon.companyservice.service.CompanyService;

import java.util.List;

@CrossOrigin("*")
@RequestMapping(value = "/company")
@RestController
public class CompanyController {
    @Autowired
    private CompanyService comapnyService;

    @PostMapping
    public Company addCompany(@RequestBody Company comapny){
        return comapnyService.addCompany(comapny);
    }
    @GetMapping
    public List<Company> fetchCompanys(){
        return  comapnyService.fetchCompanys();
    }
    @GetMapping("/{id}")
    public Company fetchCompanyById(@PathVariable int id){
        return comapnyService.fetchCompanyById(id);
    }
}
