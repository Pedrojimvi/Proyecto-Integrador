package com.dam.view;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.dam.control.InicioControl;
import com.dam.db.persistencia.FarmaciaPersistencia;
import com.dam.db.persistencia.MedicamentoContract;
import com.dam.model.Medicamento;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextField;

public class PVenta extends JPanel {
	public static final int ANCHO_PANEL = VPrincipal.ANCHO - 25;
	public static final int ALTO_PANEL = VPrincipal.ALTO - 100;
	public static final String BTN_FILTRAR = "Filtrar";
	public static final String BTN_ANADIR = "Añadir Producto";
	public static final String BTN_LIMPIAR = "Limpiar";
	public static final String BTN_QUITAR = "Quitar Producto";
	public static final String BTN_VENTA = "Realizar Venta";
	private static final String COL_NOMBRE = "NOMBRE";
	private static final String COL_TIPO = "TIPO";
	private static final String COL_CANTIDAD = "CANTIDAD";
	private static final String COL_PRECIO = "PRECIO";
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
	private DefaultTableModel dtmMed;
	private DefaultTableModel dtmMed2;
	private JScrollPane scrpTblPr;
	private ArrayList<Medicamento> listMed;
	private JScrollPane scrpTblPe;
	
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
		tblProd.setBounds(59, 138, 270, 123);
		add(tblProd);
		
		tblVenta = new JTable();
		tblVenta.setBounds(412, 69, 270, 192);
		add(tblVenta);
		
		setSize(ANCHO_PANEL, ALTO_PANEL);
		
		txtNom = new JTextField();
		txtNom.setBounds(113, 104, 114, 21);
		add(txtNom);
		txtNom.setColumns(10);
	}
	
	private void configurarTabla() {
		dtmMed = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		tblProd.setModel(dtmMed);
		
		dtmMed.addColumn(COL_NOMBRE);
		dtmMed.addColumn(COL_TIPO);
		dtmMed.addColumn(COL_CANTIDAD);
		
	}
	
	private void configurarTabla2() {
		dtmMed2 = new DefaultTableModel() {
			
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		tblVenta.setModel(dtmMed2);
		
		dtmMed2.addColumn(COL_NOMBRE);
		dtmMed2.addColumn(COL_TIPO);
		dtmMed2.addColumn(COL_CANTIDAD);
		dtmMed2.addColumn(COL_PRECIO);
		
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
	
	public void filtrarVenta(FarmaciaPersistencia fP) {
		dtmMed.getDataVector().clear();
    	tblVenta.setSelectionMode(0);
    	
    	String nom = txtNom.getText().trim();
        String tipo = (String) cmbTipo.getSelectedItem();
        
        boolean esValido = true;
        
        String where = "";
        
        if (!nom.isBlank()) {
			where += MedicamentoContract.NOMBRE + " LIKE ? ";
		}
        
        if (!tipo.equals("Todos")) {			
			if (!where.isBlank()) {
				where += " AND ";
			}
			
			where += MedicamentoContract.TIPO + " = ? ";
		}
        
        if (esValido) {
        	listMed = fP.seleccionarMed(nom, tipo, where, where);
            
            if (!listMed.isEmpty()) {
            	for (Medicamento med : listMed) {
    				dtmMed.addRow(med.getRowData());
    			}
			}
            else {
				mostrarMensaje("No hay ningún medicamento con esos filtros", "Error de búsqueda", 1);
			}
		}
        
	}
	
	private void mostrarMensaje(String mensaje, String titulo, int tipo) {
		JOptionPane.showMessageDialog(this,mensaje, titulo, tipo);
	}
	
	public void asignarTipos(InicioControl c) {
        FarmaciaPersistencia rP = c.getfPersistencia();
        
        DefaultComboBoxModel<String> modelo = (DefaultComboBoxModel<String>) cmbTipo.getModel();
            for (String region : rP.getTipos()) {
                modelo.addElement(region);
            }
    }
	
	public void anadir() {		
		Medicamento med;
		try {
			med = (Medicamento) listMed.toArray()[tblProd.getSelectedRow()];
			
			dtmMed2.addRow(med.getRowData2((int) spnCantidad.getValue()));
		}
		catch (ArrayIndexOutOfBoundsException e) {
			mostrarMensaje("No hay ningún medicamento seleccionado", "Error al Añadir", 0);
		}
		catch (NullPointerException e) {
			mostrarMensaje("No hay ningún medicamento seleccionado", "Error al Añadir", 0);
		}
	}
	
	public void quitar() {
		try {
			dtmMed2.removeRow(tblVenta.getSelectedRow());
		}
			catch (ArrayIndexOutOfBoundsException e) {
			mostrarMensaje("No hay ningún medicamento seleccionado", "Error al Quitar", 0);
		}
	}
	
	public void pedir(FarmaciaPersistencia fP) {
		String nombre = null;
		int cantidad = 0;
		
		if (dtmMed2.getRowCount() != 0) {
			for (int i = 0; i < dtmMed2.getRowCount(); i++) {
				nombre = (String) tblVenta.getModel().getValueAt(i, 0);
				cantidad = (int) tblVenta.getModel().getValueAt(i, 5);
				
				fP.hacerPedido(cantidad, nombre);
				
				fP.modificarTblPedido(fP.obtenerIdMed(nombre, cantidad));
			}
			dtmMed2.getDataVector().clear();
			mostrarMensaje("¡¡¡ Pedido realizado con éxito !!!", "Resultado de operación", 1);
		}
		else {
			mostrarMensaje("No se puede hacer el pedido sin medicamentos", "Error al Hacer Pedido", 0);
		}
	}
}
