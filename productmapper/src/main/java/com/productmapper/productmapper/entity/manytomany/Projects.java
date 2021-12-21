package com.productmapper.productmapper.entity.manytomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Projects {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int pid;
    private String p_name;

    @ManyToMany()
    @JoinTable(name = "project_employee", joinColumns = @JoinColumn(name = "project_id"), inverseJoinColumns = @JoinColumn(name = "employee_id"))
    private List<Employees> employees = new ArrayList<>();

    public void assigEmp(Employees employee) {
        employees.add(employee);
    }

}
