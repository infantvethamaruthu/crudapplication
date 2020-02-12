package com.ivm.crudapplication.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "t_person")
public class Person {

	@Id
	@GeneratedValue
	private Integer id;
	private String firstName;
	private String lastName;
	private Integer age;
	private String favouriteColour;
	
	@ElementCollection
	private List<String> hobby;

}
