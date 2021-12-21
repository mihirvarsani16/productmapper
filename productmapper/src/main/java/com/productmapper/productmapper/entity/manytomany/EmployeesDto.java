package com.productmapper.productmapper.entity.manytomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeesDto {

    @Id
    private int eid;
    private String e_name;

    private List<ProjectsDto> projectsDtos = new ArrayList<>();

}
