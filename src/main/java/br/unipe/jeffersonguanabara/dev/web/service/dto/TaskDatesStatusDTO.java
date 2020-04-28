package br.unipe.jeffersonguanabara.dev.web.service.dto;

import java.time.LocalDate;

import br.unipe.jeffersonguanabara.dev.web.domain.Task;

public class TaskDatesStatusDTO {

	private LocalDate dataInicio;
	private LocalDate dataFim;
	private Long status;
	
	public TaskDatesStatusDTO(LocalDate dataInicio, LocalDate dataFim, Long status) {
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.status = status;
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
	public Long getStatus() {
		return status;
	}
	public void setStatus(Long status) {
		this.status = status;
	}
	
	
}
