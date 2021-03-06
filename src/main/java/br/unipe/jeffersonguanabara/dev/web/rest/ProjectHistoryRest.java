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

import br.unipe.jeffersonguanabara.dev.web.domain.ProjectHistory;
import br.unipe.jeffersonguanabara.dev.web.service.ProjectHistoryService;

@RestController
@RequestMapping("jeffersonguanabara/api")
public class ProjectHistoryRest {

	@Autowired
	private ProjectHistoryService projectHistoryService;
	
	@PostMapping("/projectHistory")
	public ResponseEntity<ProjectHistory> saveProjectHistory(ProjectHistory projectHistory){
		return ResponseEntity.ok(projectHistoryService.save(projectHistory));
	}
	
	@GetMapping("projectHistory/list")
	public ResponseEntity<List<ProjectHistory>> findAllProjectsHistory() {
		return ResponseEntity.ok().body(projectHistoryService.findAll());
	}
	
	@GetMapping("projectHistory/delete/{id}")
	public ResponseEntity deleteProjectHistoryById(@PathVariable @Validated Long id) {
		try {
			projectHistoryService.deleteById(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PostMapping("projectHistory/delete")
	public ResponseEntity deleteProjectHistory(@RequestBody @Validated ProjectHistory projectHistory) {
		try {
			projectHistoryService.delete(projectHistory);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@GetMapping("projectHistory/{id}")
	public ResponseEntity<ProjectHistory> findProjectHistoryById(@PathVariable @Validated Long id) {
		return ResponseEntity.ok(projectHistoryService.findById(id));
	}
	
	@PutMapping("projectHistory/update")
	public ResponseEntity<ProjectHistory> updateProjectHistory(@RequestBody @Validated ProjectHistory projectHistory) {
		return ResponseEntity.ok(projectHistoryService.update(projectHistory));
	}
}
