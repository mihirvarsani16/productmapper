package com.productmapper.productmapper.repository;

import com.productmapper.productmapper.entity.manytomany.Employees;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesRepository extends JpaRepository<Employees, Integer> {

    public Employees findByEid(int id);
}
