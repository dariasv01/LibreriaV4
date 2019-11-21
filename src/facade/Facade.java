package facade;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;

import model.Estado01;
import model.Formato01;
import model.Libro;
import model.Tema01;
import model.acceso.AccesoBBDD;
import modelo.vista.LibroMV;

public class Facade {

	static AccesoBBDD dao;

	public Facade() {
		dao = new AccesoBBDD();
	}

	public boolean añadirLibro(LibroMV libro) throws ClassNotFoundException, SQLException {

		if (isISBN(libro) && isNumber(libro.getPaginas()) && isbnExiste(libro)) {
			return dao.guardarLibro(libro);
		}

		return false;
	}

	public boolean modificarLibro(LibroMV libro) throws SQLException {
		return dao.modificarLibro(libro);
	}

	public boolean comprarLibro(LibroMV libro) throws ClassNotFoundException, SQLException {
		Libro libroAntiguo = obtenerLibro(libro.getIsbn());
		int canti = libroAntiguo.getUnidades() + libro.getUnidades();
		return dao.cambiarCantidad(libro, canti);
	}

	public boolean venderLibro(LibroMV libro) throws ClassNotFoundException, SQLException {
		Libro libroAntiguo = obtenerLibro(libro.getIsbn());
		if (libro.getUnidades() >= libroAntiguo.getUnidades()) {
			return dao.borrarLibro(libro);
		}
		int canti = libroAntiguo.getUnidades() - libro.getUnidades();
		return dao.cambiarCantidad(libro, canti);
	}

	public boolean eliminarLibro(LibroMV libro) throws SQLException {
		return dao.borrarLibro(libro);
	}

	public static boolean isNumber(String string) {
		boolean retorno = true;
		try {
			Double.parseDouble(string);
			char charAt = string.charAt(string.length() - 1);
			if (charAt == 'f' || charAt == 'd')
				retorno = false;
		} catch (NumberFormatException e) {
			retorno = false;
		}
		return retorno;
	}

	public boolean isISBN(LibroMV libro) {
		if (Pattern.matches("[0-9]\\d{12}", libro.getIsbn()) && isNumber(libro.getIsbn())) {
			return true;
		}
		return false;
	}

	public ArrayList<Libro> listadoISBNLibros() throws ClassNotFoundException, SQLException {
		return dao.sacarListaLibros();
	}

	public ArrayList<Estado01> listadoEstado() {
		return dao.sacarListaEstado();
	}

	public ArrayList<Formato01> listadoFormato() throws ClassNotFoundException, SQLException {
		return dao.sacarListaFormato();
	}

	public ArrayList<Tema01> listadoTema() throws ClassNotFoundException, SQLException {
		return dao.sacarListaTema();
	}

	public boolean isbnExiste(LibroMV libro) throws ClassNotFoundException, SQLException {
		for (Libro libroEntrante : listadoISBNLibros()) {
			if (libro.getIsbn().equals(libroEntrante.getIsbn())) {
				return false;
			}
		}
		return true;
	}

	public Libro obtenerLibro(String isbn) throws ClassNotFoundException, SQLException {
		for (Libro libro : listadoISBNLibros()) {
			if (libro.getIsbn().equals(isbn)) {
				return libro;
			}
		}
		return null;
	}

	public HashMap<String, String> obtenerMapaISBNTitulo() throws ClassNotFoundException, SQLException {
		HashMap<String, String> mapa = new HashMap<String, String>();
		for (Libro libro : listadoISBNLibros()) {
			mapa.put(libro.getIsbn(), libro.getTitulo());
		}
		return mapa;
	}

}