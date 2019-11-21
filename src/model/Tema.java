package model;

public enum Tema {
	Terror(0), Fantasia(1), Comic(2), Infantil(3), Juvenil(4), Novela(5);
	
	private int valor;
	
	private Tema (int valor) {
		this.valor=valor;
	}

	public int getValor() {
		return valor;
	}
}
