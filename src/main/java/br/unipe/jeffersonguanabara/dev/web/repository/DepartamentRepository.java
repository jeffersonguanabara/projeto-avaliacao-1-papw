package br.unipe.jeffersonguanabara.dev.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.unipe.jeffersonguanabara.dev.web.domain.Departament;

@Repository
public interface DepartamentRepository extends JpaRepository<Departament, Long>{

}
