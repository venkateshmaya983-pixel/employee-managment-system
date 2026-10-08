package com.vcube.empportal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vcube.empportal.model.Employee12;

@Repository
public interface employeerepo extends JpaRepository<Employee12, Integer> {

}
