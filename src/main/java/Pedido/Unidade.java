package Pedido;

public class Unidade {
	// f = Fábrica || a = Armazém
	private String f;
	private String a;
	
	public Unidade() {
	}

	public void setFab(int i) {
		f = String.format("F%d", i);
	}
	
	public String getFab() {
		return f;
	}
	
	public void setArm(int i) {
		a = String.format("A%d", i);
	}
	
	public String getArm() {
		return a;
	}
}
