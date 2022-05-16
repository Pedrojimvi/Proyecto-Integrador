package pInView;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JSpinner;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Color;

public class PgVenta extends JFrame {
	public PgVenta() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REALIZAR VENTA");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(273, 23, 149, 22);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("TIPO:");
		lblNewLabel_1.setBounds(69, 69, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(103, 65, 78, 22);
		getContentPane().add(comboBox);
		
		JLabel lblNewLabel_2 = new JLabel("NOMBRE:");
		lblNewLabel_2.setBounds(49, 107, 46, 14);
		getContentPane().add(lblNewLabel_2);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(103, 103, 78, 22);
		getContentPane().add(comboBox_1);
		
		JButton btnNewButton = new JButton("FILTRAR");
		btnNewButton.setBounds(201, 87, 89, 23);
		getContentPane().add(btnNewButton);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(49, 147, 241, 115);
		getContentPane().add(editorPane);
		
		JLabel lblNewLabel_3 = new JLabel("CANTIDAD:");
		lblNewLabel_3.setBounds(49, 273, 56, 14);
		getContentPane().add(lblNewLabel_3);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(113, 270, 30, 20);
		getContentPane().add(spinner);
		
		JButton btnNewButton_1 = new JButton("A\u00D1ADIR PRODUCTO");
		btnNewButton_1.setBounds(153, 269, 137, 23);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("LIMPIAR");
		btnNewButton_2.setBounds(103, 303, 137, 23);
		getContentPane().add(btnNewButton_2);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setForeground(Color.GRAY);
		separator_1.setToolTipText("");
		separator_1.setBounds(381, 69, 11, 257);
		getContentPane().add(separator_1);
		
		JEditorPane editorPane_1 = new JEditorPane();
		editorPane_1.setBounds(423, 69, 177, 183);
		getContentPane().add(editorPane_1);
		
		JButton btnNewButton_3 = new JButton("QUITAR PRODUCTO");
		btnNewButton_3.setBounds(448, 269, 137, 23);
		getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("REALIZAR VENTA");
		btnNewButton_4.setBounds(448, 303, 137, 23);
		getContentPane().add(btnNewButton_4);
	}
}
