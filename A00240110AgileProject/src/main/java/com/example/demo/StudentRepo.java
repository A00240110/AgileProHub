package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface StudentRepo extends CrudRepository<Student, Integer> {
     
    public Student findByName(String fn);
}
