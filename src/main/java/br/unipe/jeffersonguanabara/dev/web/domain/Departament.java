package br.unipe.jeffersonguanabara.dev.web.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Departament {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String departamentName;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDepartamentName() {
		return departamentName;
	}
	public void setDepartamentName(String departamentName) {
		this.departamentName = departamentName;
	}	
}
