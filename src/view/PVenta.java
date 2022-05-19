package com.dam.view;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import com.dam.control.InicioControl;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;

public class PVenta extends JPanel {
	public static final int ANCHO_PANEL = VPrincipal.ANCHO - 25;
	public static final int ALTO_PANEL = VPrincipal.ALTO - 100;
	public static final String BTN_FILTRAR = "Filtrar";
	public static final String BTN_ANADIR = "Añadir Producto";
	public static final String BTN_LIMPIAR = "Limpiar";
	public static final String BTN_QUITAR = "Quitar Producto";
	public static final String BTN_VENTA = "Realizar Venta";
	private JTable tblProd;
	private JTable tblVenta;
	private JButton btnQuitar;
	private JButton btnVenta;
	private JComboBox cmbTipo;
	private JComboBox cmbNombre;
	private JButton btnFiltrar;
	private JSpinner spnCantidad;
	private JButton btnAñadir;
	private JButton btnLimpiar;
	
	public PVenta() {
		setLayout(null);
		
		JLabel lblVenta = new JLabel("VENTA PRODUCTOS");
		lblVenta.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblVenta.setBounds(289, 24, 140, 22);
		add(lblVenta);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(49, 69, 46, 14);
		add(lblTipo);
		
		cmbTipo = new JComboBox();
		cmbTipo.setBounds(103, 65, 78, 22);
		add(cmbTipo);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(49, 107, 73, 14);
		add(lblNombre);
		
		cmbNombre = new JComboBox();
		cmbNombre.setBounds(113, 99, 78, 22);
		add(cmbNombre);
		
		btnFiltrar = new JButton(BTN_FILTRAR);
		btnFiltrar.setBounds(230, 78, 89, 23);
		add(btnFiltrar);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(49, 273, 95, 14);
		add(lblCantidad);
		
		spnCantidad = new JSpinner();
		spnCantidad.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spnCantidad.setBounds(162, 270, 56, 20);
		add(spnCantidad);
		
		btnAñadir = new JButton(BTN_ANADIR);
		btnAñadir.setBounds(49, 303, 140, 23);
		add(btnAñadir);
		
		btnLimpiar = new JButton(BTN_LIMPIAR);
		btnLimpiar.setBounds(201, 303, 89, 23);
		add(btnLimpiar);
		
		JSeparator sprt = new JSeparator();
		sprt.setOrientation(SwingConstants.VERTICAL);
		sprt.setForeground(Color.BLACK);
		sprt.setToolTipText("");
		sprt.setBounds(381, 69, 11, 257);
		add(sprt);
		
		btnQuitar = new JButton(BTN_QUITAR);
		btnQuitar.setBounds(412, 273, 135, 23);
		add(btnQuitar);
		
		btnVenta = new JButton(BTN_VENTA);
		btnVenta.setBounds(559, 273, 125, 23);
		add(btnVenta);
		
		tblProd = new JTable();
		tblProd.setBounds(59, 138, 270, 123);
		add(tblProd);
		
		tblVenta = new JTable();
		tblVenta.setBounds(412, 69, 270, 192);
		add(tblVenta);
		
		setSize(ANCHO_PANEL, ALTO_PANEL);
	}
	
	public void setControladorBotones(InicioControl  c) {
		btnAñadir.addActionListener(c);
		btnFiltrar.addActionListener(c);
		btnVenta.addActionListener(c);
		btnQuitar.addActionListener(c);
		btnLimpiar.addActionListener(c);
	}
	
	public void resetearValores() {
		tblProd.setSelectionMode(0);
		cmbNombre.setSelectedIndex(0);
		cmbTipo.setSelectedIndex(0);
		spnCantidad.setValue(0);
	}
}