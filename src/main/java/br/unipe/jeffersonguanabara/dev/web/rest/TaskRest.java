package br.unipe.jeffersonguanabara.dev.web.rest;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping("/task")
	public ResponseEntity<Task> save(Task task){
		return ResponseEntity.ok(taskService.save(task));
	}
	
	@GetMapping("task/list")
	public ResponseEntity<List<Task>> findAll() {
		return ResponseEntity.ok().body(taskService.findAll());
	}
	
	@GetMapping("task/delete/{id}")
	public ResponseEntity deleteById(@PathVariable @Validated Long id) {
		try {
			taskService.deleteById(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PostMapping("task/delete")
	public ResponseEntity deleteById(@RequestBody @Validated Task task) {
		try {
			taskService.delete(task);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@GetMapping("task/{id}")
	public ResponseEntity<Task> findById(@PathVariable @Validated Long id) {
		return ResponseEntity.ok(taskService.findById(id));
	}
	
	@PostMapping("task/update")
	public ResponseEntity<Task> update(@RequestBody @Validated Task task) {
		return ResponseEntity.ok(taskService.update(task));
	}
	
	@PostMapping("task/dates")
	public ResponseEntity<List<Task>> findByDateBetween(@RequestBody @Validated TaskDatesDTO taskDates) {
		return ResponseEntity.ok().body(taskService.findByDateBetween(taskDates));
	}
	
	@PostMapping("task/dates/status")
	public ResponseEntity<List<Task>> findByStatusAndDateBetween(@RequestBody @Validated TaskDatesStatusDTO taskDatesStatus) {
		return ResponseEntity.ok().body(taskService.findByStatusDateBetween(taskDatesStatus));
	}
	
	@PostMapping("task/dates/{status}")
	public ResponseEntity<List<Task>> findByStatusAndDateBetween(@PathVariable @Validated Long status, @RequestBody @Validated TaskDatesDTO taskDates) {
		return ResponseEntity.ok().body(taskService.findByStatusDateBetween(status, taskDates));
	}
	
	@PostMapping("task/{status}/{dateOne}/{dateTwo}")
	public ResponseEntity<List<Task>> findByStatusAndDateBetween(@PathVariable @Validated Long status, LocalDate dateOne, LocalDate dateTwo) {
		return ResponseEntity.ok().body(taskService.findByStatusDateBetween(status, dateOne, dateTwo));
	}
}
