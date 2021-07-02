package com.exercicio.OpsFactor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import Pedido.Unidade;

@Entity
@Table(name="ORDEM_EXPEDICAO")
public class OrdemExped {
	
	@Transient
	private Carteira_Pedido cp;
	@Transient
	private Unidade uni;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_exped;
	
	@Column(name="NUM_PEDIDO")
	private int num_pedido;
	
	@Column(name="UNIDADE")
	private String unidade;
	
	@Column(name="QUANTIDADE_PROD")
	private long quantidade_prod;
	
	public OrdemExped(Carteira_Pedido cp) {
		this.cp = cp;
		Unidade uni = new Unidade();
		uni.setFab(1);
		
		// Arm = Armazém  ||
		Cliente cli = cp.getCli();
		if (cli.getPrioridade() < 3) uni.setArm(2);
		else uni.setArm(1);
		
		this.uni = uni;
		
		num_pedido = cp.getNum_pedido();
		unidade = uni.getArm();
		quantidade_prod = cp.getQuantidade();
	}
	
	public OrdemExped() {
		
	}

	public Carteira_Pedido getCp() {
		return cp;
	}

	public Unidade getUni() {
		return uni;
	}
	
	public long getQuant() {
		return quantidade_prod;
	}
	
	public String getNameProd() {
		return cp.getProd_nome();
	}
	
	public int getNum_pedido() {
		return num_pedido;
	}

	public String toString() {
		return String.format("Pedido %d - Armazém %s - quantidade atendida = %d", num_pedido, unidade, quantidade_prod);
	}
}
