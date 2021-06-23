package com.chris.enoch.shoeshop.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ShoeRepository {
	 @Autowired
	  private JdbcTemplate jdbcTemplate;
	
	public static void main(String[] args) {
		
//		 public int deleteById(Long id) {
//		        return jdbcTemplate.update(
//		                "delete books where id = ?",
//		                id);
//		    }
		
		
		
	}
	
	public void insert() {
		jdbcTemplate.update("INSERT INTO shoe VALUES (?, ?)", 1, 2);
	}

}
