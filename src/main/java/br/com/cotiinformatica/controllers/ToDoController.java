package br.com.cotiinformatica.controllers;

import java.util.List;

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

@RestController
@RequestMapping("/api/todos")
public class ToDoController {

	@PostMapping
	public ResponseEntity<ToDoResponse> post(@RequestBody ToDoRequest request) {
		return ResponseEntity.status(201).body(null);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<ToDoResponse> put(@PathVariable("id") Long id, @RequestBody ToDoRequest request) {
		return ResponseEntity.status(200).body(null);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<ToDoResponse> delete() {
		return ResponseEntity.status(200).body(null);
	}
	
	@GetMapping
	public ResponseEntity<List<ToDoResponse>> getAll() {
		return ResponseEntity.status(200).body(null);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ToDoResponse> get(@PathVariable("id") Long id) {
		return ResponseEntity.status(200).body(null);
	}
}
