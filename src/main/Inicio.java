package com.dam.main;

import java.awt.EventQueue;

import com.dam.control.InicioControl;
import com.dam.view.VInicio;
import com.dam.view.VPrincipal;
import com.dam.view.PPedido;
import com.dam.view.PVenta;
import com.dam.view.VCrear;

public class Inicio {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				VInicio vInicio= new VInicio();
				VPrincipal vPpal = new VPrincipal();
				VCrear vCrear = new VCrear();
				PPedido pPedido = new PPedido();
				PVenta pVenta = new PVenta();
				
				InicioControl control = new InicioControl(vInicio, vPpal, vCrear, pPedido, pVenta);
				
				vInicio.setControlador(control);
				vCrear.setControlador(control);
				vPpal.setControlador(control);
				pPedido.setControladorBotones(control);
				pVenta.setControladorBotones(control);
				
				vInicio.hacerVisible();
			}
		});
	}
}