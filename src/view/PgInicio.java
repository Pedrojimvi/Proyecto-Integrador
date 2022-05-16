package pInView;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.DropMode;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class PgInicio extends JFrame {
	private JTextField introdUsuario;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JPasswordField introdContra;
	public PgInicio() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("INICIO");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(196, 11, 202, 36);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("USUARIO:");
		lblNewLabel_1.setBounds(198, 106, 57, 20);
		getContentPane().add(lblNewLabel_1);
		
		introdUsuario = new JTextField();
		introdUsuario.setBounds(265, 106, 131, 20);
		getContentPane().add(introdUsuario);
		introdUsuario.setColumns(10);
		
		lblNewLabel_2 = new JLabel("CONTRASE\u00D1A:");
		lblNewLabel_2.setBounds(176, 161, 79, 17);
		getContentPane().add(lblNewLabel_2);
		
		JButton btnIniciarSesion = new JButton("INICIAR SESION");
		btnIniciarSesion.setBounds(137, 224, 131, 23);
		getContentPane().add(btnIniciarSesion);
		
		JButton btnCrearUsuario = new JButton("CREAR USUARIO");
		btnCrearUsuario.setBounds(309, 224, 131, 23);
		getContentPane().add(btnCrearUsuario);
		
		introdContra = new JPasswordField();
		introdContra.setBounds(265, 159, 136, 20);
		getContentPane().add(introdContra);
	}
}
