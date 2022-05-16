package pInView;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JSeparator;

public class PgPedido extends JFrame {
	public PgPedido() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REALIZAR PEDIDO");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(263, 11, 162, 14);
		getContentPane().add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(66, 55, 77, 14);
		getContentPane().add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("TIPO:");
		lblNewLabel_1.setBounds(28, 55, 28, 14);
		getContentPane().add(lblNewLabel_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(66, 88, 77, 14);
		getContentPane().add(comboBox_1);
		
		JLabel lblNewLabel_2 = new JLabel("FORMA:");
		lblNewLabel_2.setBounds(16, 88, 40, 14);
		getContentPane().add(lblNewLabel_2);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(209, 88, 68, 14);
		getContentPane().add(comboBox_2);
		
		JLabel lblNewLabel_3 = new JLabel("NOMBRE:");
		lblNewLabel_3.setBounds(153, 88, 46, 14);
		getContentPane().add(lblNewLabel_3);
		
		JSpinner PrecioMin = new JSpinner();
		PrecioMin.setBounds(86, 115, 46, 20);
		getContentPane().add(PrecioMin);
		
		JLabel lblNewLabel_4 = new JLabel("PRECIO MIN:");
		lblNewLabel_4.setBounds(16, 118, 71, 14);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("MAX:");
		lblNewLabel_5.setBounds(156, 118, 33, 14);
		getContentPane().add(lblNewLabel_5);
		
		JSpinner PrecioMax = new JSpinner();
		PrecioMax.setBounds(186, 115, 40, 20);
		getContentPane().add(PrecioMax);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("STOCK");
		rdbtnNewRadioButton.setBounds(183, 51, 77, 23);
		getContentPane().add(rdbtnNewRadioButton);
		
		JButton btnFiltrarPed = new JButton("FILTRAR");
		btnFiltrarPed.setBounds(301, 76, 77, 34);
		getContentPane().add(btnFiltrarPed);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(28, 161, 257, 90);
		getContentPane().add(textPane);
		
		JSpinner CantidadMed = new JSpinner();
		CantidadMed.setBounds(102, 262, 30, 20);
		getContentPane().add(CantidadMed);
		
		JLabel lblNewLabel_6 = new JLabel("CANTIDAD:");
		lblNewLabel_6.setBounds(38, 265, 65, 14);
		getContentPane().add(lblNewLabel_6);
		
		JButton btnAñadirProd = new JButton("A\u00D1ADIR PRODUCTO");
		btnAñadirProd.setBounds(153, 261, 132, 23);
		getContentPane().add(btnAñadirProd);
		
		JButton btnNewButton = new JButton("LIMPIAR");
		btnNewButton.setBounds(112, 301, 89, 23);
		getContentPane().add(btnNewButton);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(482, 76, 182, 175);
		getContentPane().add(textPane_1);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(438, 55, 2, 269);
		getContentPane().add(separator);
		
		JButton btnNewButton_1 = new JButton("QUITAR PRODUCTO");
		btnNewButton_1.setBounds(507, 261, 132, 23);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("REALIZAR PEDIDO");
		btnNewButton_2.setBounds(507, 301, 132, 23);
		getContentPane().add(btnNewButton_2);
	}
}
