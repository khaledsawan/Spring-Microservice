package com.hexagon.companyservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexagon.companyservice.entity.Company;
import com.hexagon.companyservice.repository.CompanyRepository;

import java.util.List;
@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    public Company addCompany(Company company){
        return companyRepository.save(company);
    }
    public List<Company> fetchCompanys(){
        return companyRepository.findAll();
    }
    public Company fetchCompanyById(int id){
        return companyRepository.findById(id).orElse(null);
    }
}
