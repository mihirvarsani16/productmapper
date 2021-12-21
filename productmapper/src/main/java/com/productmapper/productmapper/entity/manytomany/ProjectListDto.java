package com.productmapper.productmapper.entity.manytomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectListDto {
    @Id
    private int pid;
    private String p_name;

    private List<EmployeesDto> employeesDtos = new ArrayList<>();
}
