package vistas;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import vistas.comunes.PanelComboBox;
import vistas.comunes.PanelInicio;
import vistas.comunes.PanelLibro;
import vistas.comunes.PanelMensaje;
import vistas.consultas.PanelConsultaLibro;
import vistas.libro.PanelComprar;
import vistas.libro.PanelEliminar;
import vistas.libro.PanelModificar;
import vistas.libro.PanelNuevoLibro;
import vistas.libro.PanelVender;

import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

public class UI extends JFrame {

	protected JPanel contentPane;
	protected JTextField fecha;
	protected JTextField hora;
	protected PanelLibro panelLibro;
	protected PanelConsultaLibro consultaLibro = new PanelConsultaLibro("CONSULT BOOK");
	protected PanelNuevoLibro añadirLibro = new PanelNuevoLibro("ADD BOOK");
	protected PanelEliminar eliminarLibro = new PanelEliminar("DELETE BOOK");
	protected PanelModificar modificarLibro = new PanelModificar("MODIFY BOOK");
	protected PanelVender venderLibro = new PanelVender("SELL BOOK");
	protected PanelComprar comprarLibro = new PanelComprar("BUY BOOK");
	
	protected PanelInicio inicio = new PanelInicio();
	protected JOptionPane salida = new JOptionPane();
	protected JMenuItem mntmConsultaLibro;

	public UI() {
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		setTitle("LIBRERIA HARNINA");
		setMaximumSize(new Dimension(2047483647, 2047483647));
		setMinimumSize(new Dimension(1300, 850));
		setAutoRequestFocus(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(90, 50, 1200, 660);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(218, 165, 32));
		contentPane.setForeground(new Color(240, 230, 140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));

		contentPane.add(inicio);
		// CONDUCTOR
		contentPane.add(añadirLibro, "PanelNuevoLibro");
		contentPane.add(eliminarLibro, "PanelEliminar");
		contentPane.add(modificarLibro, "PanelModificar");
		contentPane.add(venderLibro, "PanelVender");
		contentPane.add(comprarLibro, "PanelComprar");
		// RUTA
		contentPane.add(consultaLibro, "PanelConsultaLibro");

		JPanel panelinicio = new JPanel();
		panelinicio.setBackground(new Color(204, 204, 51));
		contentPane.add(panelinicio, "name_969325539976868");
		panelinicio.setLayout(new CardLayout(0, 0));

		JLabel lblLibreriaHarnina = new JLabel("LIBRERIA HARNINA");
		lblLibreriaHarnina.setBackground(new Color(204, 204, 51));
		lblLibreriaHarnina.setFont(new Font("Tahoma", Font.BOLD, 41));
		lblLibreriaHarnina.setHorizontalAlignment(SwingConstants.CENTER);
		panelinicio.add(lblLibreriaHarnina, "inicio");

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		menuBar.setBackground(new Color(218, 165, 32));
		menuBar.setForeground(new Color(0, 0, 0));
		setJMenuBar(menuBar);

		JMenu mnStore = new JMenu("STORE");
		mnStore.setMargin(new Insets(2, 2, 2, 2));
		mnStore.setFont(new Font("Dialog", Font.PLAIN, 32));
		mnStore.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		mnStore.setBackground(new Color(218, 165, 32));
		menuBar.add(mnStore);

		JMenuItem mntmSell = new JMenuItem("SELL");
		mntmSell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				asociarPanel("PanelVender");
			}
		});
		mntmSell.setHorizontalAlignment(SwingConstants.CENTER);
		mntmSell.setFont(new Font("Dialog", Font.BOLD, 20));
		mntmSell.setBackground(new Color(204, 102, 102));
		mnStore.add(mntmSell);

		JMenuItem mntmBuy = new JMenuItem("BUY");
		mntmBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				asociarPanel("PanelComprar");
			}
		});
		mntmBuy.setHorizontalAlignment(SwingConstants.CENTER);
		mntmBuy.setFont(new Font("Dialog", Font.BOLD, 20));
		mntmBuy.setBackground(new Color(204, 102, 102));
		mnStore.add(mntmBuy);

		JMenu mnAcciones = new JMenu("BOOK");
		mnAcciones.setMnemonic('X');
		mnAcciones.setMargin(new Insets(2, 2, 2, 2));
		mnAcciones.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		mnAcciones.setBackground(new Color(218, 165, 32));
		mnAcciones.setFont(new Font("Alef", Font.PLAIN, 32));
		menuBar.add(mnAcciones);
		JMenuItem mntmNuevo = new JMenuItem("ADD BOOK");
		KeyStroke ctrlXKeyStroke = KeyStroke.getKeyStroke("control E");
		mntmNuevo.setAccelerator(ctrlXKeyStroke);
		mntmNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				asociarPanel("PanelNuevoLibro");
			}
		});
		mntmNuevo.setHorizontalAlignment(SwingConstants.CENTER);
		mntmNuevo.setFont(new Font("Alef", Font.BOLD, 20));
		mntmNuevo.setBackground(new Color(204, 102, 102));
		mnAcciones.add(mntmNuevo);
		JMenuItem mntmDespedir = new JMenuItem("DELETE BOOK");
		KeyStroke ctrlDKeyStroke = KeyStroke.getKeyStroke("control D");
		mntmDespedir.setAccelerator(ctrlDKeyStroke);
		mntmDespedir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				asociarPanel("PanelEliminar");
			}
		});
		mntmDespedir.setHorizontalAlignment(SwingConstants.CENTER);
		mntmDespedir.setFont(new Font("Alef", Font.BOLD, 20));
		mntmDespedir.setBackground(new Color(204, 102, 102));
		mnAcciones.add(mntmDespedir);
		JMenuItem mntmConsultasConductor = new JMenuItem("MODIFY BOOK");
		KeyStroke ctrlMKeyStroke = KeyStroke.getKeyStroke("control M");
		mntmConsultasConductor.setAccelerator(ctrlMKeyStroke);
		mntmConsultasConductor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				asociarPanel("PanelModificar");
			}
		});
		mntmConsultasConductor.setHorizontalAlignment(SwingConstants.CENTER);
		mntmConsultasConductor.setFont(new Font("Alef", Font.BOLD, 20));
		mntmConsultasConductor.setBackground(new Color(204, 102, 102));
		mnAcciones.add(mntmConsultasConductor);


		JMenu mnConsulta = new JMenu("QUERY");
		mnConsulta.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		mnConsulta.setBackground(new Color(139, 69, 19));
		mnConsulta.setFont(new Font("Alef", Font.PLAIN, 32));
		menuBar.add(mnConsulta);
		mntmConsultaLibro = new JMenuItem("QUERY BOOK");
		mntmConsultaLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				asociarPanel("PanelConsultaLibro");
			}
		});
		mntmConsultaLibro.setHorizontalAlignment(SwingConstants.CENTER);
		mntmConsultaLibro.setFont(new Font("Dialog", Font.BOLD, 22));
		mntmConsultaLibro.setBackground(new Color(255, 204, 153));
		mnConsulta.add(mntmConsultaLibro);
//RELOJ
		hora = new JTextField();
		hora.setForeground(new Color(0, 0, 0));
		hora.setBackground(new Color(210, 180, 140));
		hora.setBorder(new MatteBorder(1, 2, 1, 2, (Color) new Color(0, 0, 0)));
		hora.setHorizontalAlignment(SwingConstants.CENTER);

		fecha = new JTextField();
		fecha.setForeground(new Color(0, 0, 0));
		fecha.setBackground(new Color(210, 180, 140));
		fecha.setBorder(new MatteBorder(1, 2, 1, 0, (Color) new Color(0, 0, 0)));
		fecha.setHorizontalAlignment(SwingConstants.CENTER);
		fecha.setFont(new Font("Tahoma", Font.PLAIN, 22));
		fecha.setEditable(false);
		menuBar.add(fecha);
		fecha.setColumns(10);
		hora.setFont(new Font("Tahoma", Font.BOLD, 22));
		hora.setEditable(false);
		menuBar.add(hora);
		hora.setColumns(10);

		Date sistFecha = new Date();
		SimpleDateFormat formato = new SimpleDateFormat(" dd / MM / YYYY ");
		fecha.setText(formato.format(sistFecha));
		// HORA
		Timer tiempo = new Timer(100, new UI.horas());
		tiempo.start();

	}

	private void asociarPanel(String string) {
		((CardLayout) contentPane.getLayout()).show(contentPane, string);
	}

	class horas implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			Date sistHora = new Date();
			String pmAm = "hh:mm:ss a";
			SimpleDateFormat format = new SimpleDateFormat(pmAm);
			Calendar hoy = Calendar.getInstance();
			hora.setText(String.format(format.format(sistHora), hoy));

		}
	}



}
