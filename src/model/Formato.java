package model;

public enum Formato {
	Cartone(1), Rustica(2), Espiral(3), Grapada(4);
	
	private int valor;
	
	private Formato (int valor) {
		this.valor=valor;
	}

	public int getValor() {
		return valor;
	}
}
