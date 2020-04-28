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

import br.unipe.jeffersonguanabara.dev.web.domain.Departament;
import br.unipe.jeffersonguanabara.dev.web.service.DepartamentService;

@RestController
@RequestMapping("/jeffersonguanabara/api")
public class DepartamentRest {

	@Autowired
	private DepartamentService departamentService;
	
	@PostMapping("/departament")
	public ResponseEntity<Departament> saveDepartament(Departament departament){
		return ResponseEntity.ok(departamentService.save(departament));
	}
	
	@GetMapping("departament/list")
	public ResponseEntity<List<Departament>> findAllDepartaments() {
		return ResponseEntity.ok().body(departamentService.findAll());
	}
	
	@GetMapping("departament/delete/{id}")
	public ResponseEntity deleteDepartamentById(@PathVariable @Validated Long id) {
		try {
			departamentService.deleteById(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PostMapping("departament/delete")
	public ResponseEntity deleteDepartament(@RequestBody @Validated Departament department) {
		try {
			departamentService.delete(department);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@GetMapping("departament/{id}")
	public ResponseEntity<Departament> findDepartamentById(@PathVariable @Validated Long id) {
		return ResponseEntity.ok(departamentService.findById(id));
	}
	
	@PutMapping("departament/update")
	public ResponseEntity<Departament> updateDepartament(@RequestBody @Validated Departament departament) {
		return ResponseEntity.ok(departamentService.update(departament));
	}
}
