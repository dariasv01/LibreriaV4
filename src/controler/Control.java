package controler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import facade.Facade;
import model.Formato01;
import model.Libro;
import model.Tema01;
import modelo.vista.LibroMV;

public class Control {

	private Facade facade = new Facade();

	public boolean guardarLibro(LibroMV Libro) throws ClassNotFoundException, SQLException {
		return facade.añadirLibro(Libro);
	}

	public boolean eliminarLibro(LibroMV Libro) throws SQLException {
		return facade.eliminarLibro(Libro);
	}

	public boolean modificarLibro(LibroMV Libro) throws SQLException {
		return facade.modificarLibro(Libro);
	}

	public boolean comprarLibro(LibroMV Libro) throws ClassNotFoundException, SQLException {
		return facade.comprarLibro(Libro);
	}

	public boolean venderLibro(LibroMV Libro) throws ClassNotFoundException, SQLException {
		return facade.venderLibro(Libro);
	}

	public ArrayList<Libro> listadoIdLibros() throws ClassNotFoundException, SQLException {
		return facade.listadoISBNLibros();
	}
	public ArrayList<Tema01> listadoTema() throws ClassNotFoundException, SQLException {
		return facade.listadoTema();
	}
	public ArrayList<Formato01> listadoFormato() throws ClassNotFoundException, SQLException {
		return facade.listadoFormato();
	}

	public boolean isbnExiste(LibroMV Libro) throws ClassNotFoundException, SQLException {
		return facade.isbnExiste(Libro);
	}
	public HashMap<String, String> obtenerMapaISBNTitulo() throws ClassNotFoundException, SQLException {
		return facade.obtenerMapaISBNTitulo();
	}

	public Libro obtenerLibro(String id) throws ClassNotFoundException, SQLException {
		return facade.obtenerLibro(id);
	}
}
