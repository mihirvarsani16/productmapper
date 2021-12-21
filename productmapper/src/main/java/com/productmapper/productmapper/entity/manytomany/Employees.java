package com.productmapper.productmapper.entity.manytomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int eid;
    private String e_name;

    @JsonIgnore
    @ManyToMany(mappedBy = "employees", cascade = CascadeType.ALL)
    private List<Projects> projects = new ArrayList<>();
}
