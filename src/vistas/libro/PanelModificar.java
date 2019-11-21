package vistas.libro;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import vistas.comunes.PanelComboBox;
import vistas.comunes.PanelLibro;
import vistas.comunes.PanelMensaje;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelModificar extends JPanel {
	private PanelLibro panelLibro;
	private PanelMensaje panelMensaje;
	public PanelComboBox panelCombo;

	public PanelModificar(String nombre) {

		setBackground(new Color(240, 230, 140));

		JLabel lblNewLabel = new JLabel(nombre);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		panelMensaje = new PanelMensaje();

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(PanelModificar.class.getResource("/imagenes/modificarLibro.png")));
		panelLibro = new PanelLibro();
		panelLibro.setBackground(new Color(240, 230, 140));
		
		panelCombo = new PanelComboBox("TITULO", "ISBN");
		panelCombo.getComboBoxID().setEnabled(true);
		panelCombo.setBackground(new Color(240, 230, 140));

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(461))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panelLibro, GroupLayout.PREFERRED_SIZE, 589, Short.MAX_VALUE)
							.addGap(4))
						.addComponent(panelMensaje, GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
						.addComponent(panelCombo, GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 423, Short.MAX_VALUE)
					.addGap(0))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(18)
					.addComponent(panelCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelLibro, GroupLayout.PREFERRED_SIZE, 407, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelMensaje, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(101, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addComponent(label, GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
					.addGap(89))
		);
		setLayout(groupLayout);
		panelLibro.getBtnNovedad().setVisible(false);
		panelLibro.getBtnRee().setVisible(false);
		panelLibro.getTxtTitulo().setEditable(true);
		panelLibro.getTxtAutor().setEditable(true);
		panelLibro.getTxtNumeroPag().setEditable(true);
		panelLibro.getTxtISBN().setEditable(false);
		panelLibro.getCboxFormato().setVisible(true);
		panelLibro.getCboxTema().setVisible(true);
		panelLibro.getCboxTema().setVisible(true);
		panelLibro.getTxtTema().setVisible(false);
		panelLibro.getTxtFormato().setVisible(false);
		panelLibro.getLblEstado().setVisible(false);
		panelLibro.getTxtPrecio().setEditable(true);
		panelLibro.getTxtUnidades().setVisible(false);

	}
	
	public JTextField getTxtUnidades() {
		return panelLibro.getTxtUnidades();
	}

	public PanelLibro getPanelLibro() {
		return panelLibro;
	}

	public void setPanelLibro(PanelLibro panelLibro) {
		this.panelLibro = panelLibro;
	}

	public PanelMensaje getPanelMensaje() {
		return panelMensaje;
	}

	public void setPanelMensaje(PanelMensaje panelMensaje) {
		this.panelMensaje = panelMensaje;
	}
	public JTextField getTxtTitulo() {
		return panelLibro.getTxtTitulo();
	}


	public JComboBox getCboxFormato() {
		return panelLibro.getCboxFormato();
	}

	public JTextField getTxtEspecialidad() {
		return panelLibro.getTxtEspecialidad();
	}

	public JTextField getTxtFormato() {
		return panelLibro.getTxtFormato();
	}
	
	public JTextField getTxtPrecio() {
		return panelLibro.getTxtPrecio();
	}

	public JTextField getTxtTema() {
		return panelLibro.getTxtTema();
	}


	public JTextField getTxtAutor() {
		return panelLibro.getTxtAutor();
	}


	public JTextField getTxtNumeroPag() {
		return panelLibro.getTxtNumeroPag();
	}



	public JTextField getTxtISBN() {
		return panelLibro.getTxtISBN();
	}



	public JComboBox getCboxTema() {
		return panelLibro.getCboxTema();
	}


	public JLabel getLblEstado() {
		return panelLibro.getLblEstado();
	}



	public JRadioButton getBtnNovedad() {
		return panelLibro.getBtnNovedad();
	}


	public JRadioButton getBtnRee() {
		return panelLibro.getBtnRee();
	}
	
	public ButtonGroup getGroup() {
		return panelLibro.getGroup();
	}
	
	public JComboBox getComboBoxID() {
		return panelCombo.getComboBoxID();
	}

	public JComboBox getComboBoxNombre() {
		return panelCombo.getComboBoxNombre();
	}
	
}
