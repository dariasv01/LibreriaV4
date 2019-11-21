package vistas.controler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

import controler.Control;
import model.Libro;
import model.Tema01;
import modelo.vista.LibroMV;
import vistas.consultas.PanelConsultaLibro;

public class ControladorPanelConsulta {


	public void rellenarTablaLibro(PanelConsultaLibro panel, Control control) throws ClassNotFoundException, SQLException {
		String nombresColumnas[] = { "ISBN", "LIBRO", "AUTOR", "TEMA" };
		String[][] data = new String[control.listadoIdLibros().size()][4];
		for (int i = 0; i < control.listadoIdLibros().size(); i++) {
			Libro libro = control.listadoIdLibros().get(i);
			String ISBN = libro.getIsbn();
			String titulo = libro.getTitulo();
			String autor = libro.getAutor();
			Tema01 temaObj =control.listadoTema().get(Integer.parseInt(libro.getTema().toString())-1);
			String tema = temaObj.getTema();

			data[i][0] = ISBN;
			data[i][1] = titulo;
			data[i][2] = autor;
			data[i][3] = tema;
		}
		

		DefaultTableModel defaultTableModel = new DefaultTableModel(data, nombresColumnas);
		panel.getTable().setModel(defaultTableModel);

	}

}
