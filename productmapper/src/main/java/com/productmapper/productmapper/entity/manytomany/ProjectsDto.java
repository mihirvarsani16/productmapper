package com.productmapper.productmapper.entity.manytomany;

import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectsDto {

    @Id
    private int pid;
    private String p_name;

    // private List<EmployeesDto> employeesDtos = new ArrayList<>();
}
