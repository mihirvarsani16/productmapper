package com.productmapper.productmapper.repository;

import com.productmapper.productmapper.entity.manytomany.Projects;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectsRepository extends JpaRepository<Projects, Integer> {

    public Projects findByPid(int id);
}
