package br.com.pro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.pro.domain.Estado;
import br.com.pro.domain.Tarefa;
import br.com.pro.repository.TarefaRepository;


@RestController
public class TarefasController {
	
	@Autowired
	private TarefaRepository ur;
	
	@GetMapping("/tarefa/mensagem")
	public String mensagem(){
		return "Novo texto";
	}
	
	@GetMapping("/tarefas/buscar")
	public List<Tarefa> listar(){
		return ur.findAll();
	}
	
	@GetMapping("/tarefa/listar/{titulo}")
	public List<Tarefa> listarT(@PathVariable String titulo) {
		
		return ur.findByTitulo(titulo);
	}
	

	@GetMapping("/tarefa/listar/aberto")
	public List<Tarefa> getEstadoAberto(Estado estado) {
		return ur.findByEstado(Estado.Aberto);
	
	}
	
	@GetMapping("/tarefa/listar/Finalizado")
	public List<Tarefa> getEstadoFinalizado(Estado estado) {
		return ur.findByEstado(Estado.Finalizado);
	   
	}
	
	@PostMapping("/tarefa/cadastrar")
	public String cadastrar(@RequestBody Tarefa us) {
		String msg="";
		ur.save(us);
		msg = "Cadastrou";
		return msg;
	}
	
	

	@PutMapping("/tarefa/atualizar/{id}")
	public String atualizar(@PathVariable Integer id, @RequestBody Tarefa tarefa) {
		String msg = "";
		Optional<Tarefa> t = ur.findById(id);
		
			if(t.isPresent()) {
				tarefa.setIdtarefa(id);
				ur.save(tarefa);
				msg = "Tarefa atualizada";
			}
			else {
				msg = "Tarefa não encontrada";
			}
		return msg;
	}
	
}

