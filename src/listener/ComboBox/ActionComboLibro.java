package listener.ComboBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JComboBox;

import controler.Control;
import controler.Item;
import vistas.comunes.PanelLibro;
import vistas.controler.ControladorPanelLibro;

public class ActionComboLibro implements FocusListener, ActionListener {

	private JComboBox comboID, comboNombre;
	private Control control;
	private PanelLibro panel;
	private ControladorPanelLibro controlador;

	public ActionComboLibro(JComboBox comboNombre,JComboBox comboID,  Control control,
			ControladorPanelLibro controlador, PanelLibro panel) {
		this.comboID = comboID;
		this.comboNombre = comboNombre;
		this.control = control;
		this.panel = panel;
		this.controlador=controlador; 
	}

	@Override
	public void focusGained(FocusEvent arg0) {
		comboNombre.removeAllItems();
		comboID.removeAllItems();
	
		HashMap<String, String> mapa = null;
		try {
			mapa = control.obtenerMapaISBNTitulo();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Map.Entry<String, String> entry : mapa.entrySet()) {
			comboNombre.addItem(new Item(entry.getKey(), String.valueOf(entry.getKey())));
			comboID.addItem(new Item(entry.getKey(), entry.getValue()));
		}
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub

	}

	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JComboBox combo=(JComboBox)arg0.getSource();
		if(null!=combo.getSelectedItem()&&comboID.getItemCount()>0&&comboNombre.getItemCount()>0) {
		Item item= (Item) combo.getSelectedItem();
		comboNombre.setSelectedIndex(combo.getSelectedIndex());
		comboID.setSelectedIndex(combo.getSelectedIndex());
		try {
			controlador.rellenarDatos(panel, control.obtenerLibro(item.getId()));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}

}
