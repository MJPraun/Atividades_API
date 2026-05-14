package org.serratec.aula03.domain;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "A descrição é obrigatória.")
	@Size(max = 40, message = "A descrição deve conter no máximo 40 caracteres.")
	@Column(name = "descricao", nullable = false, length = 40)
	private String descricao;
	
	@DecimalMin(value = "0.01", message = "O valor deve ser maior que zero.")
	@Column(name = "valor", nullable = false, precision = 10, scale = 2)
	private BigDecimal valor;
	
	@Column(name = "data_cadastro")
	private String dataCadastro;
	
	public Produto() {
		super();
	}

	public Produto(Long id, String descricao, BigDecimal valor, String dataCadastro) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
		this.dataCadastro = dataCadastro;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
}
