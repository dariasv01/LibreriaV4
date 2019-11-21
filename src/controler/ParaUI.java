package controler;

import vistas.UI;
import vistas.controler.ControladorMensaje;
import vistas.controler.ControladorPanelConsulta;
import vistas.controler.ControladorPanelLibro;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import listener.ComboBox.ActionComboLibro;
import model.acceso.AccesoBBDD;
import modelo.vista.LibroMV;

public class ParaUI extends UI {
	private ControladorPanelLibro controladorPanelLibro = new ControladorPanelLibro();
	private ControladorMensaje controladorMensaje = new ControladorMensaje();
	private ControladorPanelConsulta contraladorPanelConsulta = new ControladorPanelConsulta();
	private Control control = new Control();

	public ParaUI() {
		query();
		rellenarComboBox();
		setActionListener();
	}

	KeyListener ComprobraISBN = new KeyListener() {

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyReleased(KeyEvent e) {
			String isbn = añadirLibro.panelLibro.getTxtISBN().getText();
			LibroMV libro = new LibroMV();
			libro.setIsbn(isbn);
			if (isbn.length() == 13) {
				try {
					if (control.isbnExiste(libro)) {
						controladorPanelLibro.hacerVisible(añadirLibro.panelLibro);
//						controladorPanelLibro.hacerVisible(añadirLibro.panelLibro);
					} else {
						controladorMensaje.mostrarMensajes(añadirLibro.panelMensaje, "ISBN existente");
					}
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			} else {
				controladorPanelLibro.bloquear(añadirLibro.panelLibro);
				controladorMensaje.mostrarMensajes(añadirLibro.panelMensaje, "");
			}
		}
	};

	ActionListener AnadirLibro = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				if (control.guardarLibro(controladorPanelLibro.obtenerDatos(añadirLibro.panelLibro))) {
					controladorMensaje.mostrarMensajes(añadirLibro.panelMensaje, "Añadido correctamente");
					controladorPanelLibro.vaciarLibro(añadirLibro.panelLibro);
				} else {
					controladorMensaje.mostrarMensajes(añadirLibro.panelMensaje, "Error en los campos");
				}
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

	};

	ActionListener ComprarLibro = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				if (control.comprarLibro(controladorPanelLibro.obtenerDatos(comprarLibro.panelLibro))) {
					controladorMensaje.mostrarMensajes(comprarLibro.panelMensaje, "Libros Comprados");
					controladorPanelLibro.vaciarLibro(comprarLibro.panelLibro);
				} else {
					controladorMensaje.mostrarMensajes(comprarLibro.panelMensaje, "Error en los campos");
				}
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

	};

	ActionListener VenderLibro = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				if (control.venderLibro(controladorPanelLibro.obtenerDatos(venderLibro.panelLibro))) {
					controladorMensaje.mostrarMensajes(venderLibro.panelMensaje, "Libros Vendidos");
					controladorPanelLibro.vaciarLibro(venderLibro.panelLibro);
				} else {
					controladorMensaje.mostrarMensajes(venderLibro.panelMensaje, "Error en los campos");
				}
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

	};

	ActionListener EliminarLibro = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				if (control.eliminarLibro(controladorPanelLibro.obtenerDatos(eliminarLibro.panelLibro))) {
					controladorMensaje.mostrarMensajes(eliminarLibro.panelMensaje, "Eliminado correctamente");
					controladorPanelLibro.vaciarLibro(eliminarLibro.panelLibro);
				} else {
					controladorMensaje.mostrarMensajes(eliminarLibro.panelMensaje, "Error en los campos");
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

	};
	ActionListener ModificarLibro = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				if (control.modificarLibro(controladorPanelLibro.obtenerDatos(modificarLibro.getPanelLibro()))) {
					controladorMensaje.mostrarMensajes(modificarLibro.getPanelMensaje(), "Modificado correctamente");
					controladorPanelLibro.vaciarLibro(modificarLibro.getPanelLibro());
				} else {
					controladorMensaje.mostrarMensajes(modificarLibro.getPanelMensaje(), "Error en los campos");
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

	};

	private void setActionListener() {
		añadirLibro.panelMensaje.getBtnAplicr().addActionListener(AnadirLibro);
		eliminarLibro.panelMensaje.getBtnAplicr().addActionListener(EliminarLibro);
		modificarLibro.getPanelMensaje().getBtnAplicr().addActionListener(ModificarLibro);
		comprarLibro.getPanelMensaje().getBtnAplicr().addActionListener(ComprarLibro);
		venderLibro.getPanelMensaje().getBtnAplicr().addActionListener(VenderLibro);
		añadirLibro.panelLibro.getTxtISBN().addKeyListener(ComprobraISBN);
	}

	private void rellenarComboBox() {
		ActionComboLibro actionCombo;
		actionCombo = new ActionComboLibro(eliminarLibro.getPanelCombo().getComboBoxID(),
				eliminarLibro.getPanelCombo().getComboBoxNombre(), control, controladorPanelLibro,
				eliminarLibro.panelLibro);
		eliminarLibro.getPanelCombo().getComboBoxID().addActionListener(actionCombo);
		eliminarLibro.getPanelCombo().getComboBoxNombre().addFocusListener(actionCombo);
		eliminarLibro.getPanelCombo().getComboBoxNombre().addActionListener(actionCombo);
		ActionComboLibro actionComboDos;
		actionComboDos = new ActionComboLibro(modificarLibro.panelCombo.getComboBoxID(),
				modificarLibro.panelCombo.getComboBoxNombre(), control, controladorPanelLibro,
				modificarLibro.getPanelLibro());
		modificarLibro.panelCombo.getComboBoxID().addActionListener(actionComboDos);
		modificarLibro.panelCombo.getComboBoxNombre().addFocusListener(actionComboDos);
		modificarLibro.panelCombo.getComboBoxNombre().addActionListener(actionComboDos);
		ActionComboLibro actionComboComprar;
		actionComboComprar = new ActionComboLibro(comprarLibro.getPanelCombo().getComboBoxID(),
				comprarLibro.getPanelCombo().getComboBoxNombre(), control, controladorPanelLibro,
				comprarLibro.getPanelLibro());
		comprarLibro.getPanelCombo().getComboBoxID().addActionListener(actionComboComprar);
		comprarLibro.getPanelCombo().getComboBoxNombre().addFocusListener(actionComboComprar);
		comprarLibro.getPanelCombo().getComboBoxNombre().addActionListener(actionComboComprar);
		ActionComboLibro actionComboVender;
		actionComboVender = new ActionComboLibro(venderLibro.getPanelCombo().getComboBoxID(),
				venderLibro.getPanelCombo().getComboBoxNombre(), control, controladorPanelLibro,
				venderLibro.getPanelLibro());
		venderLibro.getPanelCombo().getComboBoxID().addActionListener(actionComboVender);
		venderLibro.getPanelCombo().getComboBoxNombre().addFocusListener(actionComboVender);
		venderLibro.getPanelCombo().getComboBoxNombre().addActionListener(actionComboVender);
	}

	private void query() {
		mntmConsultaLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					contraladorPanelConsulta.rellenarTablaLibro(consultaLibro, control);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				asociarPanel("PanelConsultaCamion");
			}
		});
	}

	private void asociarPanel(String string) {
		((CardLayout) contentPane.getLayout()).show(contentPane, string);
	}
}
