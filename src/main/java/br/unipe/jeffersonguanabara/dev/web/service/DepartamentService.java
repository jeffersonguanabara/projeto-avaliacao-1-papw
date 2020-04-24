package br.unipe.jeffersonguanabara.dev.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unipe.jeffersonguanabara.dev.web.domain.Departament;
import br.unipe.jeffersonguanabara.dev.web.repository.DepartamentRepository;


@Service
public class DepartamentService {

	@Autowired
	private DepartamentRepository departamentReposiroty;
	
	public Departament save(Departament departament) {
		return departamentReposiroty.save(departament);
	}
	
	public Departament findById(Long id) {
		return departamentReposiroty.findById(id).get();
	}
	
	public List<Departament> findAll() {
		return departamentReposiroty.findAll();
	}
	
	public void deleteById(Long id) {
		departamentReposiroty.deleteById(id);
	}
	
	public void delete(Departament departament) {
		departamentReposiroty.delete(departament);
	}
	
	public Departament update(Departament departament) {
		if(departament != null)
			return departamentReposiroty.save(departament);
		throw new RuntimeException("Erro ao atualizar o departamento");
	}
}
