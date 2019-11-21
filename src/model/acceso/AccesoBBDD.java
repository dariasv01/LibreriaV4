package model.acceso;

import javax.sql.*;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import model.Estado01;
import model.Formato01;
import model.Libro;
import model.Tema01;
import modelo.vista.LibroMV;

public class AccesoBBDD {
	private String usuario = "root";
	private String password = "";
	private String nombreDB = "jdbc:mysql://localhost/libreriaDavidV4";
	private String driver = "com.mysql.jdbc.Driver";

	private static Connection conexion = null;
	Statement stmt = null;

	public Connection abrirConexion() {
		if (conexion == null) {
			try {
				Runtime.getRuntime().addShutdownHook(new CerrarConexion());
				Class.forName(driver);
				conexion = (Connection) DriverManager.getConnection(nombreDB, usuario, password);
				conexion.setAutoCommit(false);
				System.out.println("Abriendo conexion...");
			} catch (Exception e) {
				conexion = null;
				try {
					conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/", usuario, password);
					System.out.println("Creating database...");
					conexion.prepareStatement("CREATE DATABASE libreriaDavidV4").executeUpdate();
					System.out.println("Database created successfully...");
					conexion = (Connection) DriverManager.getConnection(nombreDB, usuario, password);
					// ESTADO
					conexion.prepareStatement(
							"CREATE TABLE ESTADO (`id` int(11) NOT NULL, `estado` varchar(30) NOT NULL) ENGINE=InnoDB DEFAULT CHARSET=latin1; ")
							.executeUpdate();
					conexion.prepareStatement(" INSERT INTO `estado` (id, estado) VALUES(1, 'Nuevo'), (2,'Reedicion') ")
							.executeUpdate();
					conexion.prepareStatement(" ALTER TABLE ESTADO ADD  PRIMARY KEY (id); ").executeUpdate();
					conexion.prepareStatement(
							"ALTER TABLE ESTADO MODIFY id int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;")
							.executeUpdate();
					// FORMATO
					conexion.prepareStatement(
							" CREATE TABLE `formato` ( `id` int(1) NOT NULL, `formato` varchar(50) NOT NULL ) ENGINE=InnoDB DEFAULT CHARSET=latin1; ")
							.executeUpdate();
					conexion.prepareStatement(
							" INSERT INTO `formato` (`id`, `formato`) VALUES (1, 'Cartone'), (2, 'Rustica'), (3,'Espiral'), (4, 'Grapada');")
							.executeUpdate();
					conexion.prepareStatement(" ALTER TABLE `formato` ADD PRIMARY KEY (`id`); ").executeUpdate();
					conexion.prepareStatement(
							"ALTER TABLE `formato` MODIFY `id` int(1) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;")
							.executeUpdate();
					// TEMA
					conexion.prepareStatement(
							" CREATE TABLE `tema` ( `id` int(11) NOT NULL, `tema` varchar(30) NOT NULL ) ENGINE=InnoDB DEFAULT CHARSET=latin1;")
							.executeUpdate();
					conexion.prepareStatement(
							" INSERT INTO `tema` (`id`, `tema`) VALUES (1, 'Terror'), (2, 'Fantasia'), (3, 'Comic'),(4, 'Infantil'), (5, 'Juvenil'), (6, 'Novela');")
							.executeUpdate();
					conexion.prepareStatement(" ALTER TABLE `tema` ADD PRIMARY KEY (`id`); ").executeUpdate();
					conexion.prepareStatement(
							"ALTER TABLE `tema` MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;")
							.executeUpdate();
					// LIBRERIA
					conexion.prepareStatement(
							" CREATE TABLE `libreria` ( `isbn` varchar(50) NOT NULL, `autor` varchar(50) NOT NULL, `titulo` varchar(50) NOT NULL, `tema`"
									+ "int(11) NOT NULL, `ejemplares` varchar(50) NOT NULL, `paginas` varchar(50) NOT NULL, `editorial` varchar(50) NOT NULL, `formato` int(1) NOT NULL,"
									+ "`estado` int(1) NOT NULL, `precio` float NOT NULL) ENGINE=InnoDB DEFAULT CHARSET=latin1;")
							.executeUpdate();
					conexion.prepareStatement(
							" ALTER TABLE `libreria`  ADD UNIQUE KEY `isbn` (`isbn`), ADD KEY `estado` (`estado`), ADD KEY `formato` (`formato`), ADD KEY `tema` (`tema`); ")
							.executeUpdate();
					conexion.prepareStatement(
							"ALTER TABLE `libreria` ADD CONSTRAINT `libreria_ibfk_1` FOREIGN KEY (`estado`) REFERENCES `estado` (`id`), ADD CONSTRAINT"
									+ "`libreria_ibfk_2` FOREIGN KEY (`formato`) REFERENCES `formato` (`id`), ADD CONSTRAINT `libreria_ibfk_3` FOREIGN KEY (`tema`) REFERENCES `tema` (`id`);")
							.executeUpdate();
					conexion.setAutoCommit(false);

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		return conexion;
	}

	public boolean guardarLibro(LibroMV nuevoLibro) throws ClassNotFoundException, SQLException {
		abrirConexion();
		int resultado = conexion.prepareStatement(
				"INSERT INTO LIBRERIA(isbn,autor,titulo,tema,ejemplares,paginas,editorial,formato,estado,precio) VALUES ('"
						+ nuevoLibro.getIsbn() + "','" + nuevoLibro.getAutor() + "','" + nuevoLibro.getTitulo() + "','"
						+ nuevoLibro.getTema() + "','" + nuevoLibro.getUnidades() + "','" + nuevoLibro.getPaginas()
						+ "','" + nuevoLibro.getEditorial() + "','" + nuevoLibro.getFormato() + "','"
						+ nuevoLibro.getEstado() + "','" + nuevoLibro.getPrecio() + "')")
				.executeUpdate();
		return commit(resultado);
	}

	public boolean borrarLibro(LibroMV libroSeleccionado) throws SQLException {
		String sql = "DELETE FROM LIBRERIA WHERE isbn LIKE '" + libroSeleccionado.getIsbn() + "'";
		abrirConexion();
		int resultado = conexion.prepareStatement(sql).executeUpdate();
		return commit(resultado);
	}

	public boolean modificarLibro(LibroMV libro) throws SQLException {
		String sql = "UPDATE `libreria` SET `autor`='" + libro.getAutor() + "',`titulo`='" + libro.getTitulo()
				+ "',`tema`='" + libro.getTema() + "',`ejemplares`='" + libro.getUnidades() + "',`paginas`='"
				+ libro.getPaginas() + "',`formato`='" + libro.getFormato() + "',`estado`='" + libro.getEstado()
				+ "',`precio`='" + libro.getPrecio() + "' WHERE ISBN = '" + libro.getIsbn() + "' ";
		abrirConexion();
		int resultado = conexion.prepareStatement(sql).executeUpdate();
		return commit(resultado);
	}

	public boolean cambiarCantidad(LibroMV libroSeleccionado, int cantidadModificar) throws SQLException {
		String sql = "UPDATE `libreria` SET `ejemplares`='" + cantidadModificar + "' WHERE ISBN ='"
				+ libroSeleccionado.getIsbn() + "' ";
		abrirConexion();
		int resultado = conexion.prepareStatement(sql).executeUpdate();
		return commit(resultado);
	}

	public ArrayList<Libro> sacarListaLibros() throws ClassNotFoundException, SQLException {
		ArrayList<Libro> listaLibrosGrande = new ArrayList<Libro>();
		CachedRowSet cachedRowSet = obtenerCachedRowSet("SELECT * FROM LIBRERIA");
		while (cachedRowSet.next()) {
			listaLibrosGrande.add(new Libro(cachedRowSet.getString("titulo"), cachedRowSet.getString("autor"),
					cachedRowSet.getString("tema"), cachedRowSet.getString("paginas"), cachedRowSet.getString("isbn"),
					cachedRowSet.getString("formato"), cachedRowSet.getString("estado"),
					cachedRowSet.getFloat("precio"), cachedRowSet.getInt("ejemplares"),
					cachedRowSet.getString("editorial")));
		}
		return listaLibrosGrande;
	}

	public HashMap<String, Libro> obtenerMapaISBNTitulo() throws ClassNotFoundException, SQLException {
		HashMap<String, Libro> mapa = new HashMap<String, Libro>();
		for (Libro libro : sacarListaLibros()) {
			mapa.put(libro.getIsbn(), libro);
		}
		return mapa;
	}

	/*
	 * Como este proceso lo tengo que repetir en multiples metodos, me creo este
	 * metodo privado para no ser tan repetitivo, ahorrar tiempo y lineas.
	 */
	protected CachedRowSet obtenerCachedRowSet(String sql) throws ClassNotFoundException, SQLException {
		abrirConexion();
		CachedRowSet cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
		cachedRowSet.populate(conexion.prepareStatement(sql).executeQuery());
		return cachedRowSet;
	}

	/**
	 * Este metodo es para cuando vayamos a insertar modificar y borrar 1 SOLA FILA
	 * para que sea mas de una fila modificamos resultado == 1 a resultado > 0
	 * 
	 * @param resultado resultado del Update
	 * @return
	 * @throws SQLException
	 */
	private boolean commit(int resultado) throws SQLException {
		if (resultado == 1) {
			conexion.commit();
			return true;
		} else {
			conexion.rollback();
			return false;
		}
	}

	public ArrayList<Tema01> sacarListaTema() throws SQLException, ClassNotFoundException {
		ArrayList<Tema01> listaTema = new ArrayList<Tema01>();
		CachedRowSet cachedRowSet = obtenerCachedRowSet("SELECT * FROM TEMA");
		while (cachedRowSet.next()) {
			listaTema.add(new Tema01(cachedRowSet.getInt("id"), cachedRowSet.getString("tema")));
		}
		return listaTema;
	}

	public ArrayList<Formato01> sacarListaFormato() throws ClassNotFoundException, SQLException {
		ArrayList<Formato01> listaFormato = new ArrayList<Formato01>();
		CachedRowSet cachedRowSet = obtenerCachedRowSet("SELECT * FROM FORMATO");
		while (cachedRowSet.next()) {
			listaFormato.add(new Formato01(cachedRowSet.getInt("id"), cachedRowSet.getString("formato")));
		}
		return listaFormato;
	}

	public ArrayList<Estado01> sacarListaEstado() {
		ArrayList<Estado01> listaEstado = new ArrayList<Estado01>();
		try {
			CachedRowSet cachedRowSet = obtenerCachedRowSet("SELECT * FROM ESTADO");
			while (cachedRowSet.next()) {
				listaEstado.add(new Estado01(cachedRowSet.getInt("id"), cachedRowSet.getString("estado")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaEstado;
	}

	class CerrarConexion extends Thread {
		@Override
		public void run() {
			try {
				abrirConexion().close();
				System.out.println("... cerrando conexion");
			} catch (Exception e) {
				System.out.println("error al cerrar");
			}
		}
	}

}
