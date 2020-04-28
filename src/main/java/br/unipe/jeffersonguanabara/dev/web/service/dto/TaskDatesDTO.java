package br.unipe.jeffersonguanabara.dev.web.service.dto;

import java.time.LocalDate;

import br.unipe.jeffersonguanabara.dev.web.domain.Task;

public class TaskDatesDTO {

	private LocalDate dataInicio;
	private LocalDate dataFim;
	
	public TaskDatesDTO(LocalDate dateOne, LocalDate dateTwo) {
		this.dataInicio = dateOne;
		this.dataFim = dateTwo;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}
	
	
}
