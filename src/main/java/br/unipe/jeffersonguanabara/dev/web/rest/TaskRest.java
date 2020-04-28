package br.unipe.jeffersonguanabara.dev.web.rest;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unipe.jeffersonguanabara.dev.web.domain.Task;
import br.unipe.jeffersonguanabara.dev.web.service.TaskService;
import br.unipe.jeffersonguanabara.dev.web.service.dto.TaskDatesDTO;
import br.unipe.jeffersonguanabara.dev.web.service.dto.TaskDatesStatusDTO;

@RestController
@RequestMapping("/jeffersonguanabara/api")
public class TaskRest {
	
	@Autowired
	private TaskService taskService;
	
	@PostMapping("/task")
	public ResponseEntity<Task> saveTask(@RequestBody @Validated Task task){
		return ResponseEntity.ok(taskService.save(task));
	}
	
	@GetMapping("task/list")
	public ResponseEntity<List<Task>> findAllTasks() {
		return ResponseEntity.ok().body(taskService.findAll());
	}
	
	@GetMapping("task/delete/{id}")
	public ResponseEntity deleteTaskById(@PathVariable @Validated Long id) {
		try {
			taskService.deleteById(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PostMapping("task/delete")
	public ResponseEntity deleteTask(@RequestBody @Validated Task task) {
		try {
			taskService.delete(task);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@GetMapping("task/{id}")
	public ResponseEntity<Task> findTaskById(@PathVariable @Validated Long id) {
		return ResponseEntity.ok(taskService.findById(id));
	}
	
	@PutMapping("task/update")
	public ResponseEntity<Task> updateTask(@RequestBody @Validated Task task) {
		return ResponseEntity.ok(taskService.update(task));
	}
	
	@PostMapping("task/dates")
	public ResponseEntity<List<Task>> findTaskByDates(@RequestBody @Validated TaskDatesDTO taskDates) {
		return ResponseEntity.ok().body(taskService.findByDateBetween(taskDates));
	}
	
	@PostMapping("task/dates/status")
	public ResponseEntity<List<Task>> findTaskByStatusAndDates(@RequestBody @Validated TaskDatesStatusDTO taskDatesStatus) {
		return ResponseEntity.ok().body(taskService.findByStatusDateBetween(taskDatesStatus));
	}
	
//	@PostMapping("task/dates/{status}")
//	public ResponseEntity<List<Task>> findTaskByStatusAndDates(@PathVariable @Validated Long status, @RequestBody @Validated TaskDatesDTO taskDates) {
//		return ResponseEntity.ok().body(taskService.findByStatusDateBetween(status, taskDates));
//	}
	
	@GetMapping("task/{status}/{dateOne}/{dateTwo}")
	public ResponseEntity<List<Task>> findTaskByStatusAndDates(@PathVariable @Validated Long status, LocalDate dateOne, LocalDate dateTwo) {
		return ResponseEntity.ok().body(taskService.findByStatusDateBetween(status, dateOne, dateTwo));
	}
}
