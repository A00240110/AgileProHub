package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class StudentTest2 {
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private StudentRepo repository;
	
	@Test
	public void testSaveNewStudent() {
		entityManager.persist(new Student("Jake", "Keighery", "1099"));
				
		Student student = repository.findByName("Jake");
		
		assertThat(student.getFirstName()).isEqualTo("Jake");
	}
}

