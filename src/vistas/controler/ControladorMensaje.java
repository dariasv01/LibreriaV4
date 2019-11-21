package vistas.controler;

import vistas.comunes.PanelMensaje;

public class ControladorMensaje {
	
	public void mostrarMensajes(PanelMensaje panel,String mensaje) {
		panel.txtMensajeComun.setText(mensaje);
	}

}
