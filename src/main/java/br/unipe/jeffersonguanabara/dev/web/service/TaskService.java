package br.unipe.jeffersonguanabara.dev.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unipe.jeffersonguanabara.dev.web.domain.Task;
import br.unipe.jeffersonguanabara.dev.web.repository.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskReposiroty;
	
	public Task save(Task task) {
		return taskReposiroty.save(task);
	}
	
	public Task findById(Long id) {
		return taskReposiroty.findById(id).get();
	}
	
	public List<Task> findAll() {
		return taskReposiroty.findAll();
	}
	
	public void deleteById(Long id) {
		taskReposiroty.deleteById(id);
	}
	
	public void delete(Task task) {
		taskReposiroty.delete(task);
	}
	
	public Task update(Task task) {
		if(task != null)
			return taskReposiroty.save(task);
		throw new RuntimeException("Erro ao atualizar a task");
	}
}
