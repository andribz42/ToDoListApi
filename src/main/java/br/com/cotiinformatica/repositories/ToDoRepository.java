package br.com.cotiinformatica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cotiinformatica.entities.ToDo;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Long> {

}
