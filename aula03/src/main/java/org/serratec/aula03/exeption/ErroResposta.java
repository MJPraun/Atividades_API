package org.serratec.aula03.exeption;

import java.time.LocalDateTime;
import java.util.List;

import org.jspecify.annotations.Nullable;

public class ErroResposta {

	private Integer status;
	private String titulo;
	private LocalDateTime dataHora;
	private List<String> erros;
	
	
	public ErroResposta(String titulo, Integer status, LocalDateTime dataHora, List<String> erros) {
		super();
		this.status = status;
		this.titulo = titulo;
		this.dataHora = dataHora;
		this.erros = erros;
	}


	public ErroResposta(String titulo2, int value, LocalDateTime now, List<@Nullable String> list) {
		}


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public LocalDateTime getDataHora() {
		return dataHora;
	}


	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}


	public List<String> getErros() {
		return erros;
	}


	public void setErros(List<String> erros) {
		this.erros = erros;
	}
	
	
}
