package com.productmapper.productmapper.controller;

import com.productmapper.productmapper.entity.manytomany.Employees;
import com.productmapper.productmapper.entity.manytomany.EmployeesDto;
import com.productmapper.productmapper.entity.manytomany.ProjectListDto;
import com.productmapper.productmapper.entity.manytomany.Projects;
import com.productmapper.productmapper.entity.manytomany.ProjectsDto;
import com.productmapper.productmapper.mapper.EmployeesMapper;
import com.productmapper.productmapper.repository.EmployeesRepository;
import com.productmapper.productmapper.repository.ProjectsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectAndEmployeeController {

    @Autowired
    private ProjectsRepository projectsRepository;

    @Autowired
    private EmployeesRepository employeesRepository;

    @Autowired
    private EmployeesMapper employeesMapper;

    @PostMapping("/add-employee")
    public ResponseEntity<Employees> addEmployees(@RequestBody EmployeesDto employeesDto) {

        Employees employee = this.employeesMapper.dtoToEmployees(employeesDto);

        if (employee == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } else {
            Employees employee1 = this.employeesRepository.save(employee);
            return ResponseEntity.status(HttpStatus.OK).body(employee1);
        }

    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<EmployeesDto> getBYId(@PathVariable int id) {

        Employees employee = this.employeesRepository.findByEid(id);

        if (employee == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            EmployeesDto employeesDto = this.employeesMapper.employeesToDto(employee);
            return ResponseEntity.status(HttpStatus.OK).body(employeesDto);
        }

    }

    @PostMapping("/add-project")
    public ResponseEntity<Projects> addProject(@RequestBody ProjectsDto projectsDto) {
        Projects project = this.employeesMapper.dtoToProjects(projectsDto);

        if (project == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(this.projectsRepository.save(project));
        }
    }

    @GetMapping("/project/{id}")
    public ResponseEntity<ProjectsDto> getProjectById(@PathVariable int id) {
        Projects project = this.projectsRepository.findByPid(id);

        if (project == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            ProjectsDto projectsDto = this.employeesMapper.projectsToDto(project);
            return ResponseEntity.status(HttpStatus.OK).body(projectsDto);
        }
    }

    @PutMapping("/{pid}/emp/{eid}")
    public ResponseEntity<ProjectListDto> assigProjectToEmp(@PathVariable int pid, @PathVariable int eid) {
        Employees employee = this.employeesRepository.findByEid(eid);
        Projects project = this.projectsRepository.findByPid(pid);

        if (employee == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            project.assigEmp(employee);

            Projects project1 = this.projectsRepository.save(project);
            // ProjectsDto projectsDto = this.employeesMapper.projectsToDto(project1);
            ProjectListDto projectsListDto = this.employeesMapper.projectToListDto(project1);

            return ResponseEntity.status(HttpStatus.OK).body(projectsListDto);
        }
    }

    // @GetMapping("/employee-allproject/{id}")
    // public ResponseEntity<EmployeesAllDto> getBYIdAllProject(@PathVariable int
    // id) {

    // Employees employee = this.employeesRepository.findByEid(id);

    // if (employee == null) {
    // return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    // } else {
    // EmployeesAllDto employeesAllDto =
    // this.employeesMapper.employeesToAllDto(employee);

    // return ResponseEntity.status(HttpStatus.OK).body(employeesAllDto);
    // }

    // }

    @DeleteMapping("/delete-emp/{id}")
    public ResponseEntity<?> deleteEmp(@PathVariable int id) {

        Employees employees = this.employeesRepository.findByEid(id);

        if (employees == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            this.employeesRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("successfully deleted");
        }

    }

    @DeleteMapping("/delete-project/{id}")
    public ResponseEntity<?> deleteProject(@PathVariable int id) {

        Projects projects = this.projectsRepository.findByPid(id);

        if (projects == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            this.projectsRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("successfully deleted");
        }

    }
}
