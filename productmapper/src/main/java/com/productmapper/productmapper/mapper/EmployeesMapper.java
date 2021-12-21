package com.productmapper.productmapper.mapper;

import com.productmapper.productmapper.entity.manytomany.Employees;
import com.productmapper.productmapper.entity.manytomany.EmployeesDto;
import com.productmapper.productmapper.entity.manytomany.ProjectListDto;
import com.productmapper.productmapper.entity.manytomany.Projects;
import com.productmapper.productmapper.entity.manytomany.ProjectsDto;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EmployeesMapper {

    EmployeesMapper INSTANCE = Mappers.getMapper(EmployeesMapper.class);

    @Mapping(target = "projectsDtos", source = "employees.projects")
    EmployeesDto employeesToDto(Employees employees);

    @InheritInverseConfiguration
    Employees dtoToEmployees(EmployeesDto employeesDto);

    // @Mapping(target = "employeesDtos", source = "projects.employees")
    ProjectsDto projectsToDto(Projects projects);

    @InheritInverseConfiguration
    Projects dtoToProjects(ProjectsDto projectsDto);

    @Mapping(target = "employeesDtos", source = "projects.employees")
    ProjectListDto projectToListDto(Projects projects);

}
