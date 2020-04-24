package br.unipe.jeffersonguanabara.dev.web.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.unipe.jeffersonguanabara.dev.web.domain.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{

	public List<Task> findByDateBetween(LocalDate dateOne, LocalDate dateTwo);
	
	public List<Task> findByStatusAndDateBetween(Long status, LocalDate dateOne, LocalDate dateTwo);
}
