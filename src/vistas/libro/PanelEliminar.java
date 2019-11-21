package vistas.libro;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import vistas.comunes.PanelComboBox;
import vistas.comunes.PanelLibro;

import javax.swing.JButton;
import javax.swing.JTextField;
import vistas.comunes.PanelMensaje;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class PanelEliminar extends JPanel {
	private PanelComboBox panelCombo;
	public PanelMensaje panelMensaje;
	public PanelLibro panelLibro;

	public PanelEliminar(String name) {
		setBackground(new Color(240, 230, 140));

		JLabel lblConsultaMedico = new JLabel(name);
		lblConsultaMedico.setFont(new Font("Tahoma", Font.BOLD, 22));
		panelCombo = new PanelComboBox("TITULO", "ISBN");
		panelCombo.getComboBoxID().setEnabled(true);
		panelCombo.setBackground(new Color(240, 230, 140));

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout(0, 0));
		panelMensaje = new PanelMensaje();
		panelLibro = new PanelLibro();
		panelLibro.getTxtTitulo().setEditable(false);
		panelLibro.getTxtAutor().setEditable(false);
		panelLibro.getTxtNumeroPag().setEditable(false);
		panelLibro.getTxtISBN().setEditable(false);
		panelLibro.getCboxFormato().setVisible(false);
		panelLibro.getCboxTema().setVisible(false);
		panelLibro.getCboxTema().setVisible(false);
		panelLibro.getTxtTema().setVisible(true);
		panelLibro.getTxtFormato().setVisible(true);
		panelLibro.getLblEstado().setVisible(false);
		panelLibro.getBtnNovedad().setVisible(false);
		panelLibro.getBtnRee().setVisible(false);
		panelLibro.getTxtPrecio().setEditable(false);
		panelLibro.getTxtUnidades().setVisible(false);
		
		panel.add(panelLibro);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(PanelEliminar.class.getResource("/imagenes/libroEliminar.png")));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblConsultaMedico, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 646, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panelCombo, GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(22)
									.addComponent(panelMensaje, GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
									.addGap(46)))
							.addGap(10)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 479, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblConsultaMedico)
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label, GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
							.addGap(33))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panelCombo, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
							.addGap(6)
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
							.addGap(34)
							.addComponent(panelMensaje, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)))
					.addGap(88))
		);
		setLayout(groupLayout);
	}

	public JComboBox getComboId() {
		return panelCombo.getComboBoxID();
	}

	public JComboBox getComboNombre() {
		return panelCombo.getComboBoxNombre();
	}

	public PanelComboBox getPanelCombo() {
		return panelCombo;
	}

	public void setPanelCombo(PanelComboBox panelCombo) {
		this.panelCombo = panelCombo;
	}

	public PanelMensaje getPanelMensaje() {
		return panelMensaje;
	}

	public void setPanelMensaje(PanelMensaje panelMensaje) {
		this.panelMensaje = panelMensaje;
	}

	public PanelLibro getPanelLibro() {
		return panelLibro;
	}

	public void setPanelDatosPersonales(PanelLibro panelLibro) {
		this.panelLibro = panelLibro;
	}
	public JComboBox getComboBoxID() {
		return panelCombo.getComboBoxID();
	}

	public JComboBox getComboBoxNombre() {
		return panelCombo.getComboBoxNombre();
	}
	
	public JTextField getTxtUnidades() {
		return panelLibro.getTxtUnidades();
	}
}

