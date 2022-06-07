package com.dam.view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.dam.control.InicioControl;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Font;

public class VInicio extends JFrame {
	private static final int ANCHO = 400;
	private static final int ALTO = 250;
	public static final String BTN_INICIAR = "Iniciar Sesión";
	public static final String BTN_CREAR = "Crear Usuario";
	
	private JTextField txtUsuario;
	private JPasswordField txtPwd;
	private JButton btnIniciarSesion;
	private JButton btnCrearUsuario;
	private JLabel lblNewLabel;

	public VInicio() {
		getContentPane().setBackground(SystemColor.window);
		init();
	}

	public void init() {
		setTitle("Inicio PharmaLand");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(199, 92, 60, 17);
		getContentPane().add(lblUsuario);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(190, 120, 69, 17);
		getContentPane().add(lblPassword);
		
		txtUsuario = new JTextField();
		txtUsuario.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtUsuario.setBackground(SystemColor.window);
		txtUsuario.setBounds(245, 90, 114, 21);
		getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtPwd = new JPasswordField();
		txtPwd.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtPwd.setBounds(245, 116, 114, 21);
		getContentPane().add(txtPwd);
		
		btnIniciarSesion = new JButton(BTN_INICIAR);
		btnIniciarSesion.setBounds(115, 172, 123, 27);
		getContentPane().add(btnIniciarSesion);
		
		btnCrearUsuario = new JButton(BTN_CREAR);
		btnCrearUsuario.setBounds(288, 172, 123, 27);
		getContentPane().add(btnCrearUsuario);
		
		lblNewLabel = new JLabel("PHARMA MAKER");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBounds(161, 25, 223, 57);
		getContentPane().add(lblNewLabel);
		
		setSize(531, 308);
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
		btnIniciarSesion.addActionListener(control);
		btnCrearUsuario.addActionListener(control);
	}
	
	public void limpiarDatos() {
		txtUsuario.setText(null);
		txtPwd.setText(null);
	}
	
	public String getNomUser() {
		String nombre = txtUsuario.getText();
		return nombre;
	}

	public void mostrarError(String mensaje) {
		JOptionPane.showMessageDialog(this,  mensaje, "Error de datos", JOptionPane.ERROR_MESSAGE);
		
	}

	public String getContrasena() {
		return txtPwd.getText();
	}
}