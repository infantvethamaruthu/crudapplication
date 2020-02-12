package com.ivm.crudapplication.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ivm.crudapplication.dto.PersonDto;
import com.ivm.crudapplication.model.Person;
import com.ivm.crudapplication.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	PersonRepository personRepository;
	
	public void createPerson(PersonDto dto) {
		Person person = translateToPerson(dto);

		personRepository.save(person);
	}

	public List<PersonDto> loadAll() {
		List<Person> persons = personRepository.findAll();
		List<PersonDto> personDtos = new ArrayList<>();

		for (Person person : persons) {
			personDtos.add(translateToPersonDto(person));
		}

		return personDtos;
	}

	private PersonDto translateToPersonDto(Person person) {
		PersonDto dto = new PersonDto();
		BeanUtils.copyProperties(person, dto);
		return dto;
	}

	private Person translateToPerson(PersonDto dto) {
		Person person = new Person();
		BeanUtils.copyProperties(dto, person);
		return person;
	}

	public PersonDto find(Integer id) {
		Person person = findPerson(id);
		return translateToPersonDto(person);
	}

	public void updatePerson(PersonDto dto) {
		Person person = findPerson(dto.getId());
		BeanUtils.copyProperties(dto, person);

		personRepository.save(person);
	}
	
	public void deletePerson(Integer id) {
		personRepository.deleteById(id);
		
	}

	private Person findPerson(Integer id) {
		return personRepository.findById(id).get();
	}

	public void deleteAll() {
		personRepository.deleteAll();
	}
}
