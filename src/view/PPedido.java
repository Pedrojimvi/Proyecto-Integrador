package com.dam.view;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.SwingConstants;

import com.dam.control.InicioControl;

import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextField;

public class PPedido extends JPanel {
	public static final int ANCHO_PANEL = VPrincipal.ANCHO - 25;
	public static final int ALTO_PANEL = VPrincipal.ALTO - 100;
	public static final String BTN_FILTRAR = "Filtrar";
	public static final String BTN_ANADIR = "Añadir Producto";
	public static final String BTN_LIMPIAR = "Limpiar";
	public static final String BTN_QUITAR = "Quitar Producto";
	public static final String BTN_PEDIDO = "Realizar Pedido";
	private JComboBox cmbTipo;
	private JComboBox cmbFarma;
	private JSpinner spnMin;
	private JSpinner spnMax;
	private JRadioButton rdbtnStock;
	private JButton btnFiltrar;
	private JSpinner spnCantidad;
	private JButton btnAnadir;
	private JButton btnLimpiar;
	private JButton btnQuitar;
	private JButton btnPedido;
	private JTable tblProd;
	private JTable tblPed;
	private JTextField txtNom;
	
	public PPedido() {
		setLayout(null);
		
		JLabel lblPedido = new JLabel("REALIZAR PEDIDO");
		lblPedido.setHorizontalAlignment(SwingConstants.CENTER);
		lblPedido.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblPedido.setBounds(289, 23, 162, 14);
		add(lblPedido);
		
		cmbTipo = new JComboBox();
		cmbTipo.setBounds(112, 55, 77, 14);
		add(cmbTipo);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(28, 55, 46, 14);
		add(lblTipo);
		
		cmbFarma = new JComboBox();
		cmbFarma.setBounds(142, 81, 77, 14);
		add(cmbFarma);
		
		JLabel lblFarma = new JLabel("Farmacéutica:");
		lblFarma.setBounds(28, 81, 109, 14);
		add(lblFarma);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(28, 114, 60, 14);
		add(lblNombre);
		
		spnMin = new JSpinner();
		spnMin.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spnMin.setBounds(128, 151, 46, 20);
		add(spnMin);
		
		JLabel lblMin = new JLabel("Precio Min:");
		lblMin.setBounds(28, 154, 97, 14);
		add(lblMin);
		
		JLabel lblMax = new JLabel("Max:");
		lblMax.setBounds(192, 154, 33, 14);
		add(lblMax);
		
		spnMax = new JSpinner();
		spnMax.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spnMax.setBounds(243, 151, 40, 20);
		add(spnMax);
		
		rdbtnStock = new JRadioButton("Stock");
		rdbtnStock.setBounds(221, 51, 77, 23);
		add(rdbtnStock);
		
		btnFiltrar = new JButton(BTN_FILTRAR);
		btnFiltrar.setBounds(270, 81, 77, 27);
		add(btnFiltrar);
		
		spnCantidad = new JSpinner();
		spnCantidad.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spnCantidad.setBounds(196, 301, 53, 20);
		add(spnCantidad);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(38, 304, 89, 14);
		add(lblCantidad);
		
		btnAnadir = new JButton(BTN_ANADIR);
		btnAnadir.setBounds(28, 335, 136, 23);
		add(btnAnadir);
		
		btnLimpiar = new JButton(BTN_LIMPIAR);
		btnLimpiar.setBounds(192, 333, 89, 23);
		add(btnLimpiar);
		
		JSeparator sprt = new JSeparator();
		sprt.setForeground(Color.BLACK);
		sprt.setOrientation(SwingConstants.VERTICAL);
		sprt.setBounds(377, 55, 2, 303);
		add(sprt);
		
		btnQuitar = new JButton(BTN_QUITAR);
		btnQuitar.setBounds(409, 298, 141, 23);
		add(btnQuitar);
		
		btnPedido = new JButton(BTN_PEDIDO);
		btnPedido.setBounds(560, 296, 136, 23);
		add(btnPedido);
		
		tblProd = new JTable();
		tblProd.setBounds(12, 195, 335, 94);
		add(tblProd);
		
		tblPed = new JTable();
		tblPed.setBounds(409, 65, 288, 205);
		add(tblPed);
		
		setSize(ANCHO_PANEL, ALTO_PANEL);
		
		txtNom = new JTextField();
		txtNom.setBounds(111, 111, 114, 21);
		add(txtNom);
		txtNom.setColumns(10);
	}
	
	public void setControladorBotones(InicioControl  c) {
		btnAnadir.addActionListener(c);
		btnFiltrar.addActionListener(c);
		btnPedido.addActionListener(c);
		btnQuitar.addActionListener(c);
		btnLimpiar.addActionListener(c);
	}
	
	public void resetearValores() {
		tblProd.setSelectionMode(0);
		txtNom.setText(null);
		cmbTipo.setSelectedIndex(0);
		cmbFarma.setSelectedIndex(0);
		spnCantidad.setValue(0);
		spnMax.setValue(0);
		spnMin.setValue(0);
		rdbtnStock.setSelected(false);
	}
}