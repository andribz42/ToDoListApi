package br.com.cotiinformatica.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.dtos.ToDoRequest;
import br.com.cotiinformatica.dtos.ToDoResponse;
import br.com.cotiinformatica.services.ToDoService;

@RestController
@RequestMapping("/api/todos")
public class ToDoController {

	@Autowired ToDoService toDoService;
	
	@PostMapping
	public ResponseEntity<ToDoResponse> post(@RequestBody ToDoRequest request) throws Exception {
		return ResponseEntity.status(201).body(toDoService.create(request));
	}
	
	@PutMapping("{id}")
	public ResponseEntity<ToDoResponse> put(@PathVariable("id") Long id, @RequestBody ToDoRequest request) throws Exception {
		return ResponseEntity.status(200).body(toDoService.update(id, request));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<ToDoResponse> delete(@PathVariable("id") Long id) throws Exception {
		return ResponseEntity.status(200).body(toDoService.delete(id));
	}
	
	@GetMapping
	public ResponseEntity<List<ToDoResponse>> getAll() throws Exception {
		return ResponseEntity.status(200).body(toDoService.getAll());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ToDoResponse> get(@PathVariable("id") Long id) throws Exception {
		return ResponseEntity.status(200).body(toDoService.getById(id));
	}
}
