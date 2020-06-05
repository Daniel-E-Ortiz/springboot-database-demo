package com.mins.database.databasedemo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mins.database.databasedemo.entity.Person;
import com.mins.database.databasedemo.jdbc.PersonJdbcDao;


//@SpringBootApplication
public class SpringJdbcDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJdbcDao dao;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
/*		logger.info("All users -> {} ", dao.findAll());
		logger.info("User ID 10001 -> {} ", dao.findById(10001));
		logger.info("User Name Dan -> {} ", dao.findByName("Dan"));
		logger.info("Deleting 10002 -> Number of rows deleted {}.", dao.deleteById(10002));
		logger.info("Inserting 10007 -> {}.", dao.insert(new Person(10007, "Amber", "Wisconsin",new Date())));
		logger.info("Updating 10003 -> {}.", dao.update(new Person(10003, "Pieter", "Heck",new Date())));
		
*/		
	}

}
