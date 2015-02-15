package security;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.CompoundBorder;
import javax.swing.UIManager;
import javax.swing.JTextField;

public class SecurityForm extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SecurityForm securityFormFrame = new SecurityForm();
					securityFormFrame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
					securityFormFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SecurityForm() {
		System.out.println("edw");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 603, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(133, 60, 327, 42);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Add New Key Contract");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 20));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(133, 113, 251, 203);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(89, 27, 109, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(89, 93, 109, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Key ID :");
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(19, 30, 86, 17);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblPropertyId = new JLabel("Property ID :");
		lblPropertyId.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblPropertyId.setBounds(19, 97, 79, 14);
		panel_1.add(lblPropertyId);
		
		JLabel lblNewLabel_2 = new JLabel("*\u03A4his field is automatically filled");
		lblNewLabel_2.setFont(new Font("Calibri", Font.ITALIC, 10));
		lblNewLabel_2.setBounds(89, 52, 152, 14);
		panel_1.add(lblNewLabel_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(UIManager.getBorder("InternalFrame.border"));
		panel_2.setBounds(394, 113, 66, 203);
		contentPane.add(panel_2);
		
		
	}
}
