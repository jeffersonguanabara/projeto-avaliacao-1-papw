package br.unipe.jeffersonguanabara.dev.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unipe.jeffersonguanabara.dev.web.domain.ProjectHistory;
import br.unipe.jeffersonguanabara.dev.web.repository.ProjectHistoryRepository;

@Service
public class ProjectHistoryService {

	@Autowired
	private ProjectHistoryRepository projectHistoryReposiroty;
	
	public ProjectHistory save(ProjectHistory projectHistory) {
		return projectHistoryReposiroty.save(projectHistory);
	}
	
	public ProjectHistory findById(Long id) {
		return projectHistoryReposiroty.findById(id).get();
	}
	
	public List<ProjectHistory> findAll() {
		return projectHistoryReposiroty.findAll();
	}
	
	public void deleteById(Long id) {
		projectHistoryReposiroty.deleteById(id);
	}
	
	public void delete(ProjectHistory projectHistory) {
		projectHistoryReposiroty.delete(projectHistory);
	}
	
	public ProjectHistory update(ProjectHistory projectHistory) {
		if(projectHistory != null)
			return projectHistoryReposiroty.save(projectHistory);
		throw new RuntimeException("Erro ao atualizar o histórico de projetos");
	}
}
