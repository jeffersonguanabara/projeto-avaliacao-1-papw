package br.unipe.jeffersonguanabara.dev.web.rest;

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

import br.unipe.jeffersonguanabara.dev.web.domain.Project;
import br.unipe.jeffersonguanabara.dev.web.service.ProjectService;

@RestController
@RequestMapping("/jeffersonguanabara/api")
public class ProjectRest {
	
	@Autowired
	private ProjectService projectService;
	
	@PostMapping("/project")
	public ResponseEntity<Project> saveProject(Project project){
		return ResponseEntity.ok(projectService.save(project));
	}
	
	@GetMapping("project/list")
	public ResponseEntity<List<Project>> findAllProjects() {
		return ResponseEntity.ok().body(projectService.findAll());
	}
	
	@GetMapping("project/delete/{id}")
	public ResponseEntity deleteProjectById(@PathVariable @Validated Long id) {
		try {
			projectService.deleteById(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PostMapping("project/delete")
	public ResponseEntity deleteProject(@RequestBody @Validated Project project) {
		try {
			projectService.delete(project);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@GetMapping("project/{id}")
	public ResponseEntity<Project> findProjectById(@PathVariable @Validated Long id) {
		return ResponseEntity.ok(projectService.findById(id));
	}
	
	@PutMapping("project/update")
	public ResponseEntity<Project> updateProject(@RequestBody @Validated Project project) {
		return ResponseEntity.ok(projectService.update(project));
	}
}
