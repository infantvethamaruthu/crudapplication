package com.ivm.crudapplication.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class PersonDto {

	private Integer id;
	private String firstName;
	private String lastName;
	private Integer age;
	private String favouriteColour;
	private List<String> hobby;
}
