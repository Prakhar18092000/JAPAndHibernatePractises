package com.prakhar.springboot.jpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.prakhar.springboot.jpaandhibernate.course.Course;

@Component
public class CommandLinerRunner implements CommandLineRunner{
	
	@Autowired
private  CourseJdbcRepository repository;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		repository.insert(new Course(1,"Learn AWS","Prakhar"));
		repository.insert(new Course(2,"Learn SpringBoot","Prakhar"));
		repository.insert(new Course(3,"Learn JPA","Prakhar"));
		repository.deleteById(2);
		System.out.println(repository.selectById(1));
		System.out.println(repository.selectById(3));
		
	}
	

}
