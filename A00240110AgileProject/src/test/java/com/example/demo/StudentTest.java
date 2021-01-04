package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@TestMethodOrder(OrderAnnotation.class)
public class StudentTest {

	@Autowired
	private StudentRepo repo;
	
	@Test
	@Rollback(false)
	@Order(1)
	public void testCreateStudent() {
		Student savedStudent = repo.save(new Student("Jake", "Keighery", "789"));
		
		assertThat(savedStudent.getId()).isGreaterThan(0);
	}
	
	@Test
	@Order(2)
	public void testFindStudentByName() {
		Student student = repo.findByName("Jake");		
		assertThat(student.getFirstName()).isEqualTo("Jake");
	}
	
	@Test
	@Order(3)
	public void testListStudents() {
		List<Student> students = (List<Student>) repo.findAll();		
		assertThat(students).size().isGreaterThan(0);
	}	
	
	@Test
	@Rollback(false)
	@Order(4)
	public void testUpdateStudent() {
		Student student = repo.findByName("Jake");
		student.setGroup("1000");
		
		repo.save(student);
		
		Student updatedStudent = repo.findByName("Jake");
		
		assertThat(updatedStudent.getGroup()).isEqualTo("1000");
	}
	
	@Test
	@Rollback(false)
	@Order(5)
	public void testDeleteStudent() {
		Student student = repo.findByName("Jake");
		
		repo.deleteById(student.getId());
		
		Student deletedStudent = repo.findByName("Jake");
		
		assertThat(deletedStudent).isNull();		
		
	}
}

