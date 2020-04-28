package br.unipe.jeffersonguanabara.dev.web.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.unipe.jeffersonguanabara.dev.web.domain.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{

	@Query(
			value="SELECT * FROM task t WHERE t.start_date = :dateOne AND t.end_date = :dateTwo",
			nativeQuery = true
	)
	public List<Task> findByDate(@Param("dateOne") LocalDate dateOne, @Param("dateTwo") LocalDate dateTwo);
	
	
	@Query(
			value="SELECT * FROM task t WHERE t.status = :status AND t.start_date = :dateOne AND t.end_date = :dateTwo",
			nativeQuery = true
	)
	public List<Task> findByStatusAndDate(@Param("status") Long status, @Param("dateOne") LocalDate dateOne, @Param("dateTwo") LocalDate dateTwo);
}
