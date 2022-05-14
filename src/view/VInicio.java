package com.dam.view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.dam.control.InicioControl;

import javax.swing.JPasswordField;
import javax.swing.JButton;

public class VInicio extends JFrame {
	private static final int ANCHO = 400;
	private static final int ALTO = 250;
	public static final String BTN_INICIAR = "Iniciar Sesión";
	public static final String BTN_CREAR = "Crear Usuario";
	
	private JTextField txtUsuario;
	private JPasswordField txtPwd;
	private JButton btnIniciarSesión;
	private JButton btnCrearUsuario;

	public VInicio() {
		init();
	}

	public void init() {
		setTitle("Inicio PharmaLand");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(86, 33, 60, 17);
		getContentPane().add(lblUsuario);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(86, 87, 69, 17);
		getContentPane().add(lblPassword);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(203, 31, 114, 21);
		getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtPwd = new JPasswordField();
		txtPwd.setBounds(203, 85, 114, 21);
		getContentPane().add(txtPwd);
		
		btnIniciarSesión = new JButton(BTN_INICIAR);
		btnIniciarSesión.setBounds(57, 148, 123, 27);
		getContentPane().add(btnIniciarSesión);
		
		btnCrearUsuario = new JButton(BTN_CREAR);
		btnCrearUsuario.setBounds(225, 148, 123, 27);
		getContentPane().add(btnCrearUsuario);
		
		setSize(ANCHO, ALTO);
		centrarVentana();
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
		btnIniciarSesión.addActionListener(control);
		btnCrearUsuario.addActionListener(control);
	}
	
	public void limpiarDatos() {
		txtUsuario.setText(null);
		txtPwd.setText(null);
	}
}