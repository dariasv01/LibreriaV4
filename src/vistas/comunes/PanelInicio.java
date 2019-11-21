package vistas.comunes;
import java.awt.Color;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Dimension;

public class PanelInicio extends JPanel{

	/**
	 * Create the panel.
	 */
	public PanelInicio() {
		setBackground(new Color(240, 230, 140));
		
		JLabel lblNombreUno = new JLabel("LIBRERIA");
		lblNombreUno.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNombreUno.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreUno.setFont(new Font("Arial Black", Font.BOLD, 40));
		
		JLabel lblNombreDos = new JLabel("HARNINA");
		lblNombreDos.setVerticalAlignment(SwingConstants.TOP);
		lblNombreDos.setForeground(Color.RED);
		lblNombreDos.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreDos.setFont(new Font("Arial Black", Font.BOLD, 40));
		
		JLabel lblImagen = new JLabel("");
		lblImagen.setIcon(new ImageIcon(PanelInicio.class.getResource("/imagenes/inicio.png")));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(17)
					.addComponent(lblImagen, GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE)
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNombreUno, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
						.addComponent(lblNombreDos, GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNombreUno, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNombreDos, GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE))
						.addComponent(lblImagen, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(26))
		);
		setLayout(groupLayout);


	}
}
