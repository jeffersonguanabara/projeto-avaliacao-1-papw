package br.unipe.jeffersonguanabara.dev.web.rest;

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

import br.unipe.jeffersonguanabara.dev.web.domain.Project;
import br.unipe.jeffersonguanabara.dev.web.service.ProjectService;

@RestController
@RequestMapping("/jeffersonguanabara/api")
public class ProjectRest {
	
	@Autowired
	private ProjectService projectService;
	
	@GetMapping("/project")
	public ResponseEntity<Project> save(Project project){
		return ResponseEntity.ok(projectService.save(project));
	}
	
	@GetMapping("project/list")
	public ResponseEntity<List<Project>> findAll() {
		return ResponseEntity.ok().body(projectService.findAll());
	}
	
	@GetMapping("departament/delete/{id}")
	public ResponseEntity deleteById(@PathVariable @Validated Long id) {
		try {
			projectService.deleteById(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PostMapping("project/delete")
	public ResponseEntity deleteById(@RequestBody @Validated Project project) {
		try {
			projectService.delete(project);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@GetMapping("project/{id}")
	public ResponseEntity<Project> findById(@PathVariable @Validated Long id) {
		return ResponseEntity.ok(projectService.findById(id));
	}
	
	@PostMapping("project/update")
	public ResponseEntity<Project> update(@RequestBody @Validated Project project) {
		return ResponseEntity.ok(projectService.update(project));
	}
}
