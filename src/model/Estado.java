package model;

public enum Estado {
	
	nuevo(1), reedicion(2);
	
	private int valor;
	
	private Estado (int valor) {
		this.valor=valor;
	}

	public int getValor() {
		return valor;
	}

}
