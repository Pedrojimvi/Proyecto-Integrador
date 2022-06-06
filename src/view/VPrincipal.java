package com.dam.view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.SwingConstants;

import com.dam.control.InicioControl;

import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class VPrincipal extends JFrame {
	static final int ANCHO = 750;
	static final int ALTO = 550;
	public static final String MNTM_PEDIDO = "Pedido";
	public static final String MNTM_VENTA = "Venta";
	public static final String MNTM_CERRAR = "Cerrar Sesión";
	
	private JMenuItem mntmCerrar;
	private JMenuItem mntmVenta;
	private JMenuItem mntmPedido;
	private JScrollPane scrpContenedor;
	
	public VPrincipal() {
		init();
	}

	private void init() {
		setTitle("PharmaLand");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		scrpContenedor = new JScrollPane();
		scrpContenedor.setBounds(12, 12, PPedido.ANCHO_PANEL, PPedido.ALTO_PANEL);
		getContentPane().add(scrpContenedor);
		
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
	
	public void cargarPanel(JPanel panel) {
		scrpContenedor.setViewportView(panel);
	}
	
	public void setControlador(InicioControl control) {
		mntmPedido.addActionListener(control);
		mntmVenta.addActionListener(control);
		mntmCerrar.addActionListener(control);
	}
	
	public int mostrarConfirmación(String mensaje, int tipo) {
		int resp = JOptionPane.showConfirmDialog(this, mensaje, "Confirmación", JOptionPane.YES_NO_OPTION, tipo);
		
		return resp;
	}
	
	public void hacerVisible() {
		setVisible(true);
	}

	public void borrarCont() {
		scrpContenedor.setViewportView(null);
	}
}