package br.com.cotiinformatica.dtos;

import lombok.Data;

@Data
public class ToDoRequest {

	private String title;
	private String description;
	private boolean completed;
	
}