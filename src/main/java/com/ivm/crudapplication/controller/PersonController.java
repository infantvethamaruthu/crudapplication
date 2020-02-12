package com.ivm.crudapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ivm.crudapplication.dto.PersonDto;
import com.ivm.crudapplication.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	PersonService personService;

	@GetMapping(value = "/load")
	public List<PersonDto> load() {
		return personService.loadAll();
	}

	@GetMapping(value = "/get/{id}")
	public PersonDto get(@PathVariable Integer id) {
		return personService.find(id);
	}

	@PostMapping(value = "/create")
	public void create(@RequestBody PersonDto person) {
		if(person == null){
			return;
		}
		personService.createPerson(person);
	}

	@PutMapping(value = "/update")
	public void update(@RequestBody PersonDto person) {
		if(person == null || person.getId() == null){
			return;
		}
		personService.updatePerson(person);
	}

	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable Integer id) {
		personService.deletePerson(id);
	}

	@DeleteMapping(value = "/deleteAll")
	public void deleteAll() {
		personService.deleteAll();
	}
}
