package com.dam.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;

import com.dam.view.VInicio;
import com.dam.view.VPrincipal;
import com.dam.view.VCrear;

public class InicioControl implements ActionListener {
	
	private VInicio vInicio;
	private VPrincipal vPrincipal;
	private VCrear vCrear;
	
	public InicioControl(VInicio vInicio, VPrincipal vPrincipal, VCrear vCrear) {
		this.vInicio = vInicio;
		this.vPrincipal = vPrincipal;
		this.vCrear = vCrear;
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		if (ev.getSource() instanceof JButton) {
			if (ev.getActionCommand().equals(VInicio.BTN_INICIAR)) {
				abrirPrincipal();
			}
			else if (ev.getActionCommand().equals(VInicio.BTN_CREAR)) {
				abrirCrear();
			}
			else if (ev.getActionCommand().equals(VCrear.BTN_CREAR)) {
				crearUsuario();
			}
			else if (ev.getActionCommand().equals(VCrear.BTN_VOLVER)) {
				volverInicio();
			}
		}
		else if (ev.getSource() instanceof JMenuItem) {
			if (ev.getActionCommand().equals(VPrincipal.MNTM_PEDIDO)) {
				mostrarPedido();
			}
			if (ev.getActionCommand().equals(VPrincipal.MNTM_VENTA)) {
				mostrarVenta();
			}
			if (ev.getActionCommand().equals(VPrincipal.MNTM_CERRAR)) {
				volverInicio();
			}
		}
	}

	private void mostrarVenta() {
		
	}

	private void mostrarPedido() {
		
	}

	private void crearUsuario() {
		volverInicio();
	}

	private void abrirPrincipal() {
		vInicio.dispose();
		vInicio.limpiarDatos();
		vPrincipal.hacerVisible();
	}

	private void volverInicio() {
		vCrear.dispose();
		vCrear.limpiarDatos();
		vInicio.hacerVisible();
	}

	private void abrirCrear() {
		vInicio.dispose();
		vInicio.limpiarDatos();
		vCrear.hacerVisible();
	}
}