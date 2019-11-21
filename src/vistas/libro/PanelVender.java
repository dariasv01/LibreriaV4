package vistas.libro;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.SwingConstants;

public class PanelVender extends JPanel {
	public PanelLibro panelLibro;
	public PanelMensaje panelMensaje;
	public PanelComboBox panelCombo;

	public PanelVender(String nombre) {

		setBackground(new Color(240, 230, 140));

		JLabel lblNewLabel = new JLabel(nombre);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		panelMensaje = new PanelMensaje();

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(PanelModificar.class.getResource("/imagenes/modificarLibro.png")));
		panelLibro = new PanelLibro();
		panelLibro.getTxtUnidades().setVisible(true);
		panelLibro.getLblUnidades().setVisible(true);
		panelLibro.getCboxFormato().setVisible(false);
		panelLibro.getCboxTema().setVisible(false);
		panelLibro.getTxtTema().setVisible(false);
		panelLibro.getTxtFormato().setVisible(false);
		panelLibro.getLblEstado().setVisible(false);
		panelLibro.getBtnNovedad().setVisible(false);
		panelLibro.getTxtTitulo().setVisible(false);
		panelLibro.getTxtAutor().setVisible(false);
		panelLibro.getTxtNumeroPag().setVisible(false);
		panelLibro.getBtnRee().setVisible(false);
		panelLibro.getLblPrecio().setVisible(false);
		panelLibro.getLblAutor().setVisible(false);
		panelLibro.getLblNDePaginas().setVisible(false);
		panelLibro.getLblTitulo().setVisible(false);
		panelLibro.getLblFormato().setVisible(false);
		panelLibro.getLblTema().setVisible(false);
		panelLibro.getTxtPrecio().setVisible(false);
		panelLibro.getTxtISBN().setEditable(false);
		panelLibro.getTxtUnidades().setEditable(true);
		panelLibro.getTxtPrecio().setHorizontalAlignment(SwingConstants.CENTER);
		panelLibro.getBtnNovedad().setSelected(true);
		
		panelCombo = new PanelComboBox("TITULO", "ISBN");
		panelCombo.getComboBoxID().setEnabled(true);
		panelCombo.setBackground(new Color(240, 230, 140));
		
		panelLibro.setBackground(new Color(240, 230, 140));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
					.addGap(879))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelMensaje, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
						.addComponent(panelCombo, GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
						.addComponent(panelLibro, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 522, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 465, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
								.addComponent(panelCombo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panelLibro, GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panelMensaje, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addGap(405))))
		);
		setLayout(groupLayout);

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

	public PanelComboBox getPanelCombo() {
		return panelCombo;
	}

	public void setPanelCombo(PanelComboBox panelCombo) {
		this.panelCombo = panelCombo;
	}


}
