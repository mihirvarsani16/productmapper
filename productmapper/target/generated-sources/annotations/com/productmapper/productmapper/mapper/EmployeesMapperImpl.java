package com.productmapper.productmapper.mapper;

import com.productmapper.productmapper.entity.manytomany.Employees;
import com.productmapper.productmapper.entity.manytomany.EmployeesDto;
import com.productmapper.productmapper.entity.manytomany.ProjectListDto;
import com.productmapper.productmapper.entity.manytomany.Projects;
import com.productmapper.productmapper.entity.manytomany.ProjectsDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-20T13:51:43+0530",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.50.v20210914-1429, environment: Java 17.0.1 (Eclipse Adoptium)"
)
@Component
public class EmployeesMapperImpl implements EmployeesMapper {

    @Override
    public EmployeesDto employeesToDto(Employees employees) {
        if ( employees == null ) {
            return null;
        }

        EmployeesDto employeesDto = new EmployeesDto();

        employeesDto.setProjectsDtos( projectsListToProjectsDtoList( employees.getProjects() ) );
        employeesDto.setE_name( employees.getE_name() );
        employeesDto.setEid( employees.getEid() );

        return employeesDto;
    }

    @Override
    public Employees dtoToEmployees(EmployeesDto employeesDto) {
        if ( employeesDto == null ) {
            return null;
        }

        Employees employees = new Employees();

        employees.setProjects( projectsDtoListToProjectsList( employeesDto.getProjectsDtos() ) );
        employees.setE_name( employeesDto.getE_name() );
        employees.setEid( employeesDto.getEid() );

        return employees;
    }

    @Override
    public ProjectsDto projectsToDto(Projects projects) {
        if ( projects == null ) {
            return null;
        }

        ProjectsDto projectsDto = new ProjectsDto();

        projectsDto.setP_name( projects.getP_name() );
        projectsDto.setPid( projects.getPid() );

        return projectsDto;
    }

    @Override
    public Projects dtoToProjects(ProjectsDto projectsDto) {
        if ( projectsDto == null ) {
            return null;
        }

        Projects projects = new Projects();

        projects.setP_name( projectsDto.getP_name() );
        projects.setPid( projectsDto.getPid() );

        return projects;
    }

    @Override
    public ProjectListDto projectToListDto(Projects projects) {
        if ( projects == null ) {
            return null;
        }

        ProjectListDto projectListDto = new ProjectListDto();

        projectListDto.setEmployeesDtos( employeesListToEmployeesDtoList( projects.getEmployees() ) );
        projectListDto.setP_name( projects.getP_name() );
        projectListDto.setPid( projects.getPid() );

        return projectListDto;
    }

    protected List<ProjectsDto> projectsListToProjectsDtoList(List<Projects> list) {
        if ( list == null ) {
            return null;
        }

        List<ProjectsDto> list1 = new ArrayList<ProjectsDto>( list.size() );
        for ( Projects projects : list ) {
            list1.add( projectsToDto( projects ) );
        }

        return list1;
    }

    protected List<Projects> projectsDtoListToProjectsList(List<ProjectsDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Projects> list1 = new ArrayList<Projects>( list.size() );
        for ( ProjectsDto projectsDto : list ) {
            list1.add( dtoToProjects( projectsDto ) );
        }

        return list1;
    }

    protected List<EmployeesDto> employeesListToEmployeesDtoList(List<Employees> list) {
        if ( list == null ) {
            return null;
        }

        List<EmployeesDto> list1 = new ArrayList<EmployeesDto>( list.size() );
        for ( Employees employees : list ) {
            list1.add( employeesToDto( employees ) );
        }

        return list1;
    }
}
