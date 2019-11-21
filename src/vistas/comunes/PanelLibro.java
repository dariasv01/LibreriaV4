package vistas.comunes;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;


import javax.swing.SwingConstants;

import model.Estado;
import model.Formato;
import model.Tema;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PanelLibro extends JPanel {

	private JTextField txtTitulo;
	private JComboBox cboxFormato;
	private JComboBox cboxTema;
	private JTextField txtEspecialidad;
	private JTextField txtFormato;
	private JTextField txtTema;
	private JTextField txtAutor;
	private JTextField txtNumeroPag;
	private JTextField txtISBN;
	private JLabel lblEstado;
	private JRadioButton btnNovedad;
	private JRadioButton btnRee;
	private ButtonGroup group;
	private JLabel lblPrecio;
	private JTextField txtPrecio;
	private JButton btnEliminar;
	private JButton btnAñadir;
	private JTextField txtUnidades;
	private JLabel lblUnidades;
	private JLabel lblTitulo;
	private JLabel lblFormato;
	private JLabel lblAutor;
	private JLabel lblNDePaginas;
	private JLabel lblIsbn;
	private JLabel lblTema;

	public PanelLibro() {
		setBackground(new Color(240, 230, 140));
		

		txtTitulo = new JTextField();
		txtTitulo.setEditable(false);
		txtTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtTitulo.setHorizontalAlignment(SwingConstants.CENTER);

		txtTitulo.setColumns(10);
		lblTitulo = new JLabel("Titulo");
		lblTitulo.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));

		lblFormato = new JLabel("Formato");
		lblFormato.setHorizontalAlignment(SwingConstants.CENTER);
		lblFormato.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));

		cboxFormato = new JComboBox();
		cboxFormato.setVisible(false);
		cboxFormato.setFont(new Font("Tahoma", Font.BOLD, 11));


		lblAutor = new JLabel("Autor");
		lblAutor.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));

		txtFormato = new JTextField();
		txtFormato.setEditable(false);
		txtFormato.setHorizontalAlignment(SwingConstants.CENTER);
		txtFormato.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtFormato.setColumns(10);
		
		lblNDePaginas = new JLabel("N\u00BA de Paginas");
		lblNDePaginas.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		
		lblIsbn = new JLabel("ISBN");
		lblIsbn.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		lblIsbn.setVisible(true);
		
		lblTema = new JLabel("Tema");
		lblTema.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		lblTema.setHorizontalAlignment(SwingConstants.LEFT);
		lblTema.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		
		cboxTema = new JComboBox();
		cboxTema.setVisible(false);
		cboxTema.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		lblEstado = new JLabel("Estado");
		lblEstado.setHorizontalAlignment(SwingConstants.LEFT);
		lblEstado.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		lblEstado.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		btnNovedad = new JRadioButton("Novedad");
		btnNovedad.setBackground(new Color(240, 230, 140));
		
		btnRee = new JRadioButton("Reedic\u00F3n");
		btnRee.setBackground(new Color(240, 230, 140));
		
		txtTema = new JTextField();
		txtTema.setEditable(false);
		txtTema.setHorizontalAlignment(SwingConstants.CENTER);
		txtTema.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtTema.setColumns(10);
		
		txtAutor = new JTextField();
		txtAutor.setEditable(false);
		txtAutor.setHorizontalAlignment(SwingConstants.CENTER);
		txtAutor.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtAutor.setColumns(10);
		
		txtNumeroPag = new JTextField();
		txtNumeroPag.setEditable(false);
		txtNumeroPag.setHorizontalAlignment(SwingConstants.CENTER);
		txtNumeroPag.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtNumeroPag.setColumns(10);
		
		txtISBN = new JTextField();
		txtISBN.setHorizontalAlignment(SwingConstants.CENTER);
		txtISBN.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtISBN.setColumns(10);
		
		lblPrecio = new JLabel("Precio");
		lblPrecio.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrecio.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		lblPrecio.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		txtPrecio.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtPrecio.setColumns(10);
		
		btnAñadir = new JButton("A\u00F1adir");
		
		btnAñadir.setVisible(false);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setVisible(false);
		
		txtUnidades = new JTextField();
		txtUnidades.setHorizontalAlignment(SwingConstants.CENTER);
		txtUnidades.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtUnidades.setEditable(false);
		txtUnidades.setColumns(10);
		
		JLabel label = new JLabel("Unidades");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		label.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		lblUnidades = new JLabel("");
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(lblAutor, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblFormato)
							.addComponent(lblTitulo, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))
						.addComponent(lblTema, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEstado, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNDePaginas, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPrecio, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblIsbn, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnAñadir, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 380, Short.MAX_VALUE)
							.addComponent(btnEliminar, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNovedad)
							.addPreferredGap(ComponentPlacement.RELATED, 418, Short.MAX_VALUE)
							.addComponent(btnRee))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txtUnidades, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblUnidades, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtAutor, GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
								.addComponent(txtNumeroPag, GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
								.addComponent(txtTitulo, GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(txtFormato, GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(cboxFormato, 0, 265, Short.MAX_VALUE)
									.addGap(0))
								.addComponent(txtISBN, GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(txtPrecio, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(txtTema, GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(cboxTema, 0, 262, Short.MAX_VALUE)))
									.addGap(0)))
							.addGap(7)))
					.addGap(45))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(17)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtISBN, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblIsbn, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTitulo, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtTitulo, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(cboxFormato, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFormato, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtFormato, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAutor, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtAutor, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNDePaginas, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNumeroPag, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtTema, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addComponent(cboxTema, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtPrecio, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPrecio, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)))
						.addComponent(lblTema, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(11)
									.addComponent(txtUnidades, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnAñadir)
										.addComponent(btnEliminar)))
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(label, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEstado, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNovedad)
								.addComponent(btnRee))
							.addContainerGap(33, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(lblUnidades)
							.addContainerGap())))
		);
		setLayout(groupLayout);
		group = new ButtonGroup();
		group.add(btnNovedad);
		group.add(btnRee);
		
		
	}
	
	

	public JLabel getLblUnidades() {
		return lblUnidades;
	}



	public void setLblUnidades(JLabel lblUnidades) {
		this.lblUnidades = lblUnidades;
	}



	public JButton getBtnEliminar() {
		return btnEliminar;
	}



	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}



	public JButton getBtnAñadir() {
		return btnAñadir;
	}



	public void setBtnAñadir(JButton btnAñadir) {
		this.btnAñadir = btnAñadir;
	}



	public JTextField getTxtUnidades() {
		return txtUnidades;
	}



	public void setTxtUnidades(JTextField txtUnidades) {
		this.txtUnidades = txtUnidades;
	}



	public void setTxtPrecio(JTextField txtPrecio) {
		this.txtPrecio = txtPrecio;
	}



	public void setGroup(ButtonGroup group) {
		this.group = group;
	}



	public JTextField getTxtPrecio() {
		return txtPrecio;
	}



	public ButtonGroup getGroup() {
		return group;
	}



	public JTextField getTxtTitulo() {
		return txtTitulo;
	}

	public void setTxtTitulo(JTextField txtTitulo) {
		this.txtTitulo = txtTitulo;
	}

	public JComboBox getCboxFormato() {
		return cboxFormato;
	}

	public void setCboxFormato(JComboBox cboxFormato) {
		this.cboxFormato = cboxFormato;
	}

	public JTextField getTxtEspecialidad() {
		return txtEspecialidad;
	}

	public void setTxtEspecialidad(JTextField txtEspecialidad) {
		this.txtEspecialidad = txtEspecialidad;
	}

	public JTextField getTxtFormato() {
		return txtFormato;
	}

	public void setTxtFormato(JTextField txtFormato) {
		this.txtFormato = txtFormato;
	}

	public JTextField getTxtTema() {
		return txtTema;
	}

	public void setTxtTema(JTextField txtTema) {
		this.txtTema = txtTema;
	}

	public JTextField getTxtAutor() {
		return txtAutor;
	}

	public void setTxtAutor(JTextField txtAutor) {
		this.txtAutor = txtAutor;
	}

	public JTextField getTxtNumeroPag() {
		return txtNumeroPag;
	}

	public void setTxtNumeroPag(JTextField txtNumeroPag) {
		this.txtNumeroPag = txtNumeroPag;
	}

	public JTextField getTxtISBN() {
		return txtISBN;
	}

	public void setTxtISBN(JTextField txtISBN) {
		this.txtISBN = txtISBN;
	}

	public JComboBox getCboxTema() {
		return cboxTema;
	}

	public void setCboxTema(JComboBox cboxTema) {
		this.cboxTema = cboxTema;
	}

	public JLabel getLblEstado() {
		return lblEstado;
	}

	public void setLblEstado(JLabel lblEstado) {
		this.lblEstado = lblEstado;
	}

	public JRadioButton getBtnNovedad() {
		return btnNovedad;
	}

	public void setBtnNovedad(JRadioButton btnNovedad) {
		this.btnNovedad = btnNovedad;
	}

	public JRadioButton getBtnRee() {
		return btnRee;
	}

	public void setBtnRee(JRadioButton btnRee) {
		this.btnRee = btnRee;
	}



	public JLabel getLblPrecio() {
		return lblPrecio;
	}



	public void setLblPrecio(JLabel lblPrecio) {
		this.lblPrecio = lblPrecio;
	}



	public JLabel getLblTitulo() {
		return lblTitulo;
	}



	public void setLblTitulo(JLabel lblTitulo) {
		this.lblTitulo = lblTitulo;
	}



	public JLabel getLblFormato() {
		return lblFormato;
	}



	public void setLblFormato(JLabel lblFormato) {
		this.lblFormato = lblFormato;
	}



	public JLabel getLblAutor() {
		return lblAutor;
	}



	public void setLblAutor(JLabel lblAutor) {
		this.lblAutor = lblAutor;
	}



	public JLabel getLblNDePaginas() {
		return lblNDePaginas;
	}



	public void setLblNDePaginas(JLabel lblNDePaginas) {
		this.lblNDePaginas = lblNDePaginas;
	}



	public JLabel getLblIsbn() {
		return lblIsbn;
	}



	public void setLblIsbn(JLabel lblIsbn) {
		this.lblIsbn = lblIsbn;
	}



	public JLabel getLblTema() {
		return lblTema;
	}



	public void setLblTema(JLabel lblTema) {
		this.lblTema = lblTema;
	}
	
}
