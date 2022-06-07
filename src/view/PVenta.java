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
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;

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
	private JButton btnFiltrar;
	private JSpinner spnCantidad;
	private JButton btnAnadir;
	private JButton btnLimpiar;
	private JTextField txtNom;
	
	public PVenta() {
		setBackground(SystemColor.window);
		setLayout(null);
		
		JLabel lblVenta = new JLabel("VENTA PRODUCTOS");
		lblVenta.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		lblVenta.setBounds(289, 24, 174, 22);
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
		
		btnFiltrar = new JButton(BTN_FILTRAR);
		btnFiltrar.setBounds(230, 78, 89, 23);
		add(btnFiltrar);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(57, 273, 95, 14);
		add(lblCantidad);
		
		spnCantidad = new JSpinner();
		spnCantidad.setBorder(null);
		spnCantidad.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spnCantidad.setBounds(103, 270, 56, 20);
		add(spnCantidad);
		
		btnAnadir = new JButton(BTN_ANADIR);
		btnAnadir.setBounds(49, 303, 140, 23);
		add(btnAnadir);
		
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
		tblProd.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tblProd.setBackground(SystemColor.scrollbar);
		tblProd.setBounds(59, 138, 270, 123);
		add(tblProd);
		
		tblVenta = new JTable();
		tblVenta.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tblVenta.setBackground(SystemColor.scrollbar);
		tblVenta.setBounds(412, 69, 270, 192);
		add(tblVenta);
		
		setSize(ANCHO_PANEL, ALTO_PANEL);
		
		txtNom = new JTextField();
		txtNom.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtNom.setBounds(92, 104, 114, 21);
		add(txtNom);
		txtNom.setColumns(10);
	}
	
	public void setControladorBotones(InicioControl  c) {
		btnAnadir.addActionListener(c);
		btnFiltrar.addActionListener(c);
		btnVenta.addActionListener(c);
		btnQuitar.addActionListener(c);
		btnLimpiar.addActionListener(c);
	}
	
	public void resetearValores() {
		tblProd.setSelectionMode(0);
		txtNom.setText(null);
		cmbTipo.setSelectedIndex(0);
		spnCantidad.setValue(0);
	}
}