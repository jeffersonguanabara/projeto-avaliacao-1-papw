package br.unipe.jeffersonguanabara.dev.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unipe.jeffersonguanabara.dev.web.domain.Person;
import br.unipe.jeffersonguanabara.dev.web.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personReposiroty;
	
	public Person save(Person person) {
		return personReposiroty.save(person);
	}
	
	public Person findById(Long id) {
		return personReposiroty.findById(id).get();
	}
	
	public List<Person> findAll() {
		return personReposiroty.findAll();
	}
	
	public void deleteById(Long id) {
		personReposiroty.deleteById(id);
	}
	
	public void delete(Person person) {
		personReposiroty.delete(person);
	}
	
	public Person update(Person person) {
		if(person != null)
			return personReposiroty.save(person);
		throw new RuntimeException("Erro ao atualizar a pessoa");
	}
}
