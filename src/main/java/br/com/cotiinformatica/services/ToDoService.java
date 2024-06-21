package br.com.cotiinformatica.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cotiinformatica.dtos.ToDoRequest;
import br.com.cotiinformatica.dtos.ToDoResponse;
import br.com.cotiinformatica.entities.ToDo;
import br.com.cotiinformatica.repositories.ToDoRepository;

@Service
public class ToDoService {

	@Autowired ToDoRepository toDoRepository;
	@Autowired ModelMapper modelMapper;
	
	public ToDoResponse create(ToDoRequest request) throws Exception {
		
		ToDo toDo = modelMapper.map(request, ToDo.class);
		toDoRepository.save(toDo);
		
		return modelMapper.map(toDo, ToDoResponse.class);
	}
	
	public ToDoResponse update(Long id, ToDoRequest request) throws Exception {
		ToDo toDo = toDoRepository.findById(id).orElseThrow(() -> new Exception("ToDo not found!"));
		toDo.setCompleted(request.isCompleted());
		toDo.setDescription(request.getDescription());
		toDo.setTitle(request.getTitle());
		toDoRepository.save(toDo);
		
		return modelMapper.map(toDo, ToDoResponse.class);
	}
	
	public ToDoResponse delete(Long id) throws Exception {
		ToDo toDo = toDoRepository.findById(id).orElseThrow(() -> new Exception("ToDo not found!"));
		
		toDoRepository.delete(toDo);
		
		return modelMapper.map(toDo, ToDoResponse.class);
	}
	
	public ToDoResponse getById(Long id) throws Exception {
		ToDo toDo = toDoRepository.findById(id).orElseThrow(() -> new Exception("ToDo not found!"));
		return modelMapper.map(toDo, ToDoResponse.class);
	}
	
	public List<ToDoResponse> getAll() throws Exception {
		List<ToDoResponse> response = toDoRepository.findAll().stream()
				.map(toDo -> modelMapper.map(toDo, ToDoResponse.class))
				.collect(Collectors.toList());
		
		return response;
	}
}
