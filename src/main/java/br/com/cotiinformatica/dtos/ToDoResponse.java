package br.com.cotiinformatica.dtos;

import lombok.Data;

@Data
public class ToDoResponse {

	private Long id;
	private String title;
	private String description;
	private boolean completed;
	
}