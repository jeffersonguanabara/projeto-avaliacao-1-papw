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

import br.unipe.jeffersonguanabara.dev.web.domain.Person;
import br.unipe.jeffersonguanabara.dev.web.service.PersonService;

@RestController
@RequestMapping("/jeffersonguanabara/api")
public class PersonRest {

	@Autowired
	private PersonService personService;
	
	@GetMapping("/person")
	public ResponseEntity<Person> save(Person person){
		return ResponseEntity.ok(personService.save(person));
	}
	
	@GetMapping("person/list")
	public ResponseEntity<List<Person>> findAll() {
		return ResponseEntity.ok().body(personService.findAll());
	}
	
	@GetMapping("person/delete/{id}")
	public ResponseEntity deleteById(@PathVariable @Validated Long id) {
		try {
			personService.deleteById(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PostMapping("person/delete")
	public ResponseEntity deleteById(@RequestBody @Validated Person person) {
		try {
			personService.delete(person);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@GetMapping("person/{id}")
	public ResponseEntity<Person> findById(@PathVariable @Validated Long id) {
		return ResponseEntity.ok(personService.findById(id));
	}
	
	@PostMapping("person/update")
	public ResponseEntity<Person> update(@RequestBody @Validated Person person) {
		return ResponseEntity.ok(personService.update(person));
	}
}
