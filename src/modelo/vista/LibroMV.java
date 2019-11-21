package modelo.vista;

import model.Estado;
import model.Formato;
import model.Tema;

public class LibroMV {

	private String titulo;
	private String autor;
	private String tema;
	private String paginas;
	private String isbn;
	private String formato;
	private String estado;
	private float precio;
	private int unidades;
	private String editorial;

	public LibroMV() {
		// TODO Auto-generated constructor stub
	}

	public LibroMV(String titulo, String autor, String tema, String paginas, String isbn, String formato, String estado,
			float precio, int unidades, String editorial) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.tema = tema;
		this.paginas = paginas;
		this.isbn = isbn;
		this.formato = formato;
		this.estado = estado;
		this.precio = precio;
		this.unidades = unidades;
		this.editorial = editorial;
	}
	
	

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String string) {
		this.tema = string;
	}

	public String getPaginas() {
		return paginas;
	}

	public void setPaginas(String paginas) {
		this.paginas = paginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

}
