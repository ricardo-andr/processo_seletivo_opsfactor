package com.exercicio.OpsFactor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CLIENTE")
public class Cliente {
	@Id
	private int cnpj;
	
	@Column(name="PRIORIDADE")
	private int prioridade;
	
	@Column(name="DESCRICAO")
	private String desc;
	
	public Cliente(){
	}
	
	public Cliente(int cnpj, int prioridade){
		this.cnpj = cnpj;
		this.prioridade = prioridade;
	}
	
	public Cliente(int cnpj, int prioridade, String desc){
		this.cnpj = cnpj;
		this.prioridade = prioridade;
		this.desc = desc;
	}

	public int getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}

	public int getCnpj() {
		return cnpj;
	}
	
	
	
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String toString() {
		return String.format("CNPJ %d, com prioridade %d", cnpj, prioridade);
	}
}
