package vistas.controler;

import java.sql.SQLException;

import facade.Facade;
import model.Estado;
import model.Formato;
import model.Libro;
import model.Tema;
import model.Tema01;
import modelo.vista.LibroMV;
import vistas.comunes.PanelLibro;

public class ControladorPanelLibro {

	Facade facade = new Facade();

	public void rellenarDatos(PanelLibro panel, Libro libro) throws ClassNotFoundException, SQLException {
		panel.getTxtTitulo().setText(libro.getTitulo());
		panel.getTxtISBN().setText(libro.getIsbn());
		panel.getTxtFormato().setText(libro.getFormato().toString());
		panel.getTxtNumeroPag().setText(libro.getPaginas());
		panel.getTxtTema().setText(libro.getTema().toString());
		panel.getTxtAutor().setText(libro.getAutor().toString());
		panel.getTxtPrecio().setText(Float.toString(libro.getPrecio()));
		panel.getLblUnidades().setText(Integer.toString(libro.getUnidades()));
		panel.getTxtUnidades().setText("");
		for (int i = 0; i < facade.listadoFormato().size()/2; i++) {
			panel.getCboxFormato().addItem(facade.listadoFormato().get(i).getFormato());
		}
		for (int i = 0; i < facade.listadoTema().size()/2; i++) {
			panel.getCboxTema().addItem(facade.listadoTema().get(i).getTema());
		}
	}

	public LibroMV obtenerDatos(PanelLibro panel) {
		LibroMV modelo = new LibroMV();
		modelo.setAutor(panel.getTxtAutor().getText());
		modelo.setIsbn(panel.getTxtISBN().getText());
		if (panel.getCboxFormato().isVisible()) {
			modelo.setFormato(String.valueOf(panel.getCboxFormato().getSelectedIndex() + 1));
		} else {
			modelo.setFormato((panel.getTxtFormato().getText()));
		}
		if (panel.getCboxTema().isVisible()) {
			modelo.setTema(String.valueOf(panel.getCboxTema().getSelectedIndex() + 1));
		} else {
			modelo.setTema((panel.getTxtTema().getText()));
		}
		modelo.setEstado(btnSelection(panel));
		modelo.setPaginas(panel.getTxtNumeroPag().getText());
		modelo.setPrecio(Float.parseFloat(panel.getTxtPrecio().getText()));
		modelo.setTitulo(panel.getTxtTitulo().getText());
		if (panel.getTxtUnidades().isVisible()) {
			modelo.setUnidades(Integer.parseInt(panel.getTxtUnidades().getText()));
		} else {
			modelo.setUnidades(Integer.parseInt(panel.getLblUnidades().getText()));
		}

		return modelo;
	}

	private String btnSelection(PanelLibro panel) {
		if (panel.getBtnNovedad().isSelected()) {
			return "1";
		}
		return "2";
	}

	public void vaciarLibro(PanelLibro panel) throws ClassNotFoundException, SQLException {
		panel.getTxtTitulo().setText("");
		panel.getTxtISBN().setText("");
		panel.getTxtAutor().setText("");
		panel.getTxtNumeroPag().setText("");
		panel.getTxtPrecio().setText("");
		panel.getTxtUnidades().setText("");
		panel.getLblUnidades().setText("");
		panel.getTxtFormato().setText("");
		panel.getTxtTema().setText("");
		panel.getCboxFormato().removeAllItems();
		panel.getCboxTema().removeAllItems();

	}

	public void hacerVisible(PanelLibro panel) throws ClassNotFoundException, SQLException {
		panel.getTxtTitulo().setEditable(true);
		panel.getTxtAutor().setEditable(true);
		panel.getTxtNumeroPag().setEditable(true);
		panel.getCboxFormato().setVisible(true);
		panel.getCboxTema().setVisible(true);
		panel.getCboxTema().setVisible(true);
		panel.getTxtTema().setVisible(false);
		panel.getTxtFormato().setVisible(false);
		panel.getLblEstado().setVisible(true);
		panel.getBtnNovedad().setVisible(true);
		panel.getBtnRee().setVisible(true);
		panel.getTxtPrecio().setEditable(true);
		panel.getTxtUnidades().setEditable(true);
		for (int i = 0; i < facade.listadoFormato().size(); i++) {
			panel.getCboxFormato().addItem(facade.listadoFormato().get(i).getFormato());
		}
		for (int i = 0; i < facade.listadoTema().size(); i++) {
			panel.getCboxTema().addItem(facade.listadoTema().get(i).getTema());
		}
	}

	public void bloquear(PanelLibro panel) {
		panel.getTxtTitulo().setEditable(false);
		panel.getTxtAutor().setEditable(false);
		panel.getTxtNumeroPag().setEditable(false);
		panel.getCboxFormato().setVisible(false);
		panel.getCboxTema().setVisible(false);
		panel.getCboxTema().setVisible(false);
		panel.getTxtTema().setVisible(true);
		panel.getTxtFormato().setVisible(true);
		panel.getLblEstado().setVisible(false);
		panel.getBtnNovedad().setVisible(false);
		panel.getBtnRee().setVisible(false);
		panel.getTxtPrecio().setEditable(false);
		panel.getTxtUnidades().setEditable(false);
	}
}
