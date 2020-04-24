package br.unipe.jeffersonguanabara.dev.web.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unipe.jeffersonguanabara.dev.web.domain.Task;
import br.unipe.jeffersonguanabara.dev.web.repository.TaskRepository;
import br.unipe.jeffersonguanabara.dev.web.service.dto.TaskDatesDTO;
import br.unipe.jeffersonguanabara.dev.web.service.dto.TaskDatesStatusDTO;

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

	public List<Task> findByDateBetween(TaskDatesDTO taskDates) {
		List<Task> tasks = taskReposiroty.findByDateBetween(taskDates.getDataInicio(), taskDates.getDataFim());
		return tasks;
	}
	
	public List<Task> findByStatusDateBetween(TaskDatesStatusDTO taskStatusDates) {
		List<Task> tasks = taskReposiroty.findByStatusAndDateBetween(taskStatusDates.getStatus(), taskStatusDates.getDataInicio(), taskStatusDates.getDataFim());
		return tasks;
	}
	
	public List<Task> findByStatusDateBetween(Long status,TaskDatesDTO taskDates) {
		List<Task> tasks = taskReposiroty.findByStatusAndDateBetween(status, taskDates.getDataInicio(), taskDates.getDataFim());
		return tasks;
	}
	
	public List<Task> findByStatusDateBetween(Long status, LocalDate dateOne, LocalDate dateTwo) {
		List<Task> tasks = taskReposiroty.findByStatusAndDateBetween(status, dateOne, dateTwo);
		return tasks;
	}
}