package com.prakhar.springboot.jpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.prakhar.springboot.jpaandhibernate.course.Course;

@Repository
public class CourseJdbcRepository {
	
	@Autowired
	private JdbcTemplate springJdbcTemplate;
	private static String INSERT_QUERY=
			"""
			INSERT INTO COURSE(ID,NAME,AUTHOR)
			VALUES(?,?,?);
			
			""";
	
	private static String DELETE_QUERY=
			"""
			DELETE FROM COURSE WHERE ID=?;
			
			""";
	private static String SELECT_QUERY=
			"""
			SELECT * FROM COURSE WHERE ID=?;
			
			""";
	
	public void insert(Course course) {
		springJdbcTemplate.update(INSERT_QUERY,course.getId(),course.getName(),course.getAuthor());
	}
	
	public Course selectById(long id) {
		return springJdbcTemplate.queryForObject(SELECT_QUERY,
				new BeanPropertyRowMapper<>(Course.class),id);
	}
	public void  deleteById(long id) {
		springJdbcTemplate.update(DELETE_QUERY,id);
	}


}
