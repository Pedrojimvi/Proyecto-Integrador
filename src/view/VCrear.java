package com.dam.view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.dam.control.InicioControl;

public class VCrear extends JFrame {
	private static final int ANCHO = 400;
	private static final int ALTO = 350;
	public static final String BTN_CREAR = "Crear";
	public static final String BTN_VOLVER = "Volver";
	
	private JTextField txtUsuario;
	private JPasswordField txtPwd;
	private JButton btnCrear;
	private JButton btnVolver;
	private JPasswordField txtPwdC;

	public VCrear() {
		init();
		centrarVentana();
	}

	public void init() {
		setTitle("Crear Usuario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(70, 43, 60, 17);
		getContentPane().add(lblUsuario);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(70, 93, 94, 17);
		getContentPane().add(lblPassword);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(224, 39, 114, 21);
		getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtPwd = new JPasswordField();
		txtPwd.setBounds(224, 89, 114, 21);
		getContentPane().add(txtPwd);
		
		btnCrear = new JButton(BTN_CREAR);
		btnCrear.setBounds(74, 213, 105, 27);
		getContentPane().add(btnCrear);
		
		btnVolver = new JButton(BTN_VOLVER);
		btnVolver.setBounds(212, 213, 105, 27);
		getContentPane().add(btnVolver);
		
		JLabel lblPasswordC = new JLabel("Confirmar Password:");
		lblPasswordC.setBounds(70, 147, 136, 17);
		getContentPane().add(lblPasswordC);
		
		txtPwdC = new JPasswordField();
		txtPwdC.setBounds(224, 145, 114, 21);
		getContentPane().add(txtPwdC);
		
		setSize(400, 315);
	}
	
	private void centrarVentana() {
		setPreferredSize(new Dimension(ANCHO, ALTO));
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension ventana = this.getPreferredSize();
		setLocation((pantalla.width - ventana.width) / 2,  (pantalla.height - ventana.height) / 2);
	}
	
	public void hacerVisible() {
		setVisible(true);
	}
	
	public void setControlador(InicioControl control) {
		btnCrear.addActionListener(control);
		btnVolver.addActionListener(control);
	}
	
	public void limpiarDatos() {
		txtUsuario.setText(null);
		txtPwd.setText(null);
		txtPwdC.setText(null);
	}
	
	public String getUser() {
		return txtUsuario.getText();
	}

	public String getContrasena() {
		return txtPwd.getText();
	}

	public String getCContrasena() {
		return txtPwdC.getText();
	}
	
	public void mostrarError(String mensaje) {
		JOptionPane.showMessageDialog(this,  mensaje, "Error de datos", JOptionPane.ERROR_MESSAGE);
		
	}

	public boolean comprobarContrasenas() {
		boolean b;
		
		if (txtPwd.getText().equals(txtPwdC.getText())) {
			b = false;
		}else {
			b = true;
		}
		
		return b;
	}

	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
	}
}
