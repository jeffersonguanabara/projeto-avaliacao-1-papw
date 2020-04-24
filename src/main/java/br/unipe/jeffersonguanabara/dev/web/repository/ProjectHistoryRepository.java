package br.unipe.jeffersonguanabara.dev.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.unipe.jeffersonguanabara.dev.web.domain.ProjectHistory;

@Repository
public interface ProjectHistoryRepository extends JpaRepository<ProjectHistory, Long>{

}
