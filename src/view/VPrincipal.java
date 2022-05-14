package com.dam.view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.SwingConstants;

import com.dam.control.InicioControl;

import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class VPrincipal extends JFrame {
	static final int ANCHO = 400;
	static final int ALTO = 250;
	public static final String MNTM_PEDIDO = "Pedido";
	public static final String MNTM_VENTA = "Venta";
	public static final String MNTM_CERRAR = "Cerrar Sesion";
	
	private JMenuItem mntmCerrar;
	private JMenuItem mntmVenta;
	private JMenuItem mntmPedido;
	
	public VPrincipal() {
		init();
	}

	private void init() {
		setTitle("PharmaLand");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 12, 376, 170);
		getContentPane().add(scrollPane);
		
		setSize(ANCHO, ALTO);
		centrarVentana();
	}
	
	private void centrarVentana() {
		setPreferredSize(new Dimension(ANCHO,ALTO));
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension ventana = this.getPreferredSize();
		setLocation((pantalla.width - ventana.width) / 2,  (pantalla.height - ventana.height) / 2);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mntmPedido = new JMenuItem(MNTM_PEDIDO);
		menuBar.add(mntmPedido);
		
		mntmVenta = new JMenuItem(MNTM_VENTA);
		menuBar.add(mntmVenta);
		
		mntmCerrar = new JMenuItem(MNTM_CERRAR);
		mntmCerrar.setHorizontalAlignment(SwingConstants.RIGHT);
		menuBar.add(mntmCerrar);
	}
	
	public void setControlador(InicioControl control) {
		mntmPedido.addActionListener(control);
		mntmVenta.addActionListener(control);
		mntmCerrar.addActionListener(control);
	}
	
	public void hacerVisible() {
		setVisible(true);
	}
}