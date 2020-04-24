package br.unipe.jeffersonguanabara.dev.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unipe.jeffersonguanabara.dev.web.domain.Project;
import br.unipe.jeffersonguanabara.dev.web.repository.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectReposiroty;
	
	public Project save(Project project) {
		return projectReposiroty.save(project);
	}
	
	public Project findById(Long id) {
		return projectReposiroty.findById(id).get();
	}
	
	public List<Project> findAll() {
		return projectReposiroty.findAll();
	}
	
	public void deleteById(Long id) {
		projectReposiroty.deleteById(id);
	}
	
	public void delete(Project project) {
		projectReposiroty.delete(project);
	}
	
	public Project update(Project project) {
		if(project != null)
			return projectReposiroty.save(project);
		throw new RuntimeException("Erro ao atualizar o projeto");
	}
}
