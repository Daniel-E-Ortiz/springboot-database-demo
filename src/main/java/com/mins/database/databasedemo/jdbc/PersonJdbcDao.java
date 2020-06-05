package com.mins.database.databasedemo.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mins.database.databasedemo.entity.Person;

@Repository
public class PersonJdbcDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	class PersonRowMapper implements RowMapper<Person> {

		@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			Person person = new Person();
			person.setId(rs.getInt("id"));
			person.setName(rs.getString("name"));
			person.setLocation(rs.getString("location"));
			person.setBirthdate(rs.getTimestamp("birth_date"));
			return person;
		}
	}
	// Find a person in the DB using id.
	// Uses custom PersonRowMapper() class.
	public Person findById(int id){
		return jdbcTemplate.queryForObject
				("select * from person where id=?", new Object[] {id}, 
				new PersonRowMapper());
	}
	
	// deletes a person and returns how many rows were deleted.
	public int deleteById(int id){
		return jdbcTemplate.update
				("delete from person where id = ?", new Object[] {id});
	} 
	// inserts a new person into DB
	public int insert(Person person){
		return jdbcTemplate.update
				("insert into person (id, name, location, birth_date) "
						+ "values(?,?,?,?)", 
						new Object[] {person.getId(),person.getName(),
								person.getLocation(),new Timestamp(person.getBirthdate().getTime())});
	}
	// updates a current person to the passed imported person into the DB
	public int update(Person person){
		return jdbcTemplate.update
				("update person "
						+ "set name=?, location=?, birth_date=? "
						+ "where id=?", 
						new Object[] {
							person.getName(),
							person.getLocation(),
							new Timestamp(person.getBirthdate().getTime()),
							person.getId()
						}
				);
	}
	
	public List<Person> findAll(){
		return jdbcTemplate.query("select * from person", 
				new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	public List<Person> findByName(String name){
		String sql = "select * from person where name = ?";
		return jdbcTemplate.query
				(sql, new Object[] {name}, new BeanPropertyRowMapper<Person>(Person.class));
		
	}
}
