package com.mins.database.databasedemo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mins.database.databasedemo.entity.Person;
import com.mins.database.databasedemo.jpa.PersonJpaRepository;


//@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJpaRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		logger.info("User ID 10001 -> {} ", repository.findById(10001));
//		logger.info("User Name Dan -> {} ", repository.findByName("Dan"));
//		repository.deleteById(10002);
//		logger.info("Inserting new Person -> {}.", repository.insert(new Person("Amber", "Wisconsin",new Date())));
//		logger.info("Updating 10003 -> {}.", repository.update(new Person(10003, "Pieter", "Heck",new Date())));
//		logger.info("All users -> {} ", repository.findAll());
		
		
	}

}
