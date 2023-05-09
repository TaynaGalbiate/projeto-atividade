package br.com.pro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pro.domain.Tarefa;


@Repository
public interface TarefaRepository<Estado> extends JpaRepository<Tarefa, Integer>   {
	
	List<Tarefa> findByTitulo(String titulo);
	List<Tarefa> findByEstado(Estado estado);

}
