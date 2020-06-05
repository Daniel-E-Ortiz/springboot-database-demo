package com.mins.database.databasedemo.springdata;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mins.database.databasedemo.entity.Person;

public interface PersonSpringDataRepository extends JpaRepository<Person,Integer>{

}
