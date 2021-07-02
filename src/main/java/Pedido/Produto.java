package Pedido;

public class Produto {
	private String name;
	private long quantidade;
	
	public Produto(String name, long quant) {
		this.name = name;
		quantidade = quant;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}
