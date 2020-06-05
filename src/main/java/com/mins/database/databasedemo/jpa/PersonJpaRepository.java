package com.mins.database.databasedemo.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.mins.database.databasedemo.entity.Person;


@Repository
@Transactional
public class PersonJpaRepository {

	//connect to the DB
	@PersistenceContext
	EntityManager entityManager;
	
	public Person findById(int id){
		return entityManager.find(Person.class, id);
	}
	
	/* Used for both insert or updates of a person object in the DB.
	 * If person has an ID set then it will try and update person in the DB.  
	 * Otherwise it will insert as a new person with newly generated ID.
	 */
	public Person update(Person person) {
		return entityManager.merge(person);	
	}
	
	public List<Person> findAll() {
		TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_persons", Person.class);
		return namedQuery.getResultList();
	}
	
	public Person insert(Person person) {
		return entityManager.merge(person);	
	}
	
	public void deleteById(int id) {
		Person person = findById(id);
		entityManager.remove(person);	
	}
}
