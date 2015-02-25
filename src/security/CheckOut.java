package security;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JEditorPane;

public class CheckOut {

	private JFrame frmService;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		CheckOut window = new CheckOut();
		window.frmService.setVisible(true);
				
		
	}

	/**
	 * Create the application.
	 */
	public CheckOut() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, you can set the GUI to another look and feel.
		}
		
		
		frmService = new JFrame();
		frmService.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		frmService.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmService.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 128)), "Check out a Service", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(132, 82, 1085, 569);
		frmService.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 204, 255));
		panel_1.setBorder(new LineBorder(new Color(0, 0, 128)));
		panel_1.setBounds(458, 34, 384, 503);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Key ID :");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNewLabel.setBounds(32, 37, 60, 14);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Specific Key :");
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(32, 92, 88, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Pick up Person :");
		lblNewLabel_2.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(32, 197, 101, 14);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("More Details :");
		lblNewLabel_3.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(32, 360, 101, 14);
		panel_1.add(lblNewLabel_3);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"key ID - A", "key ID - B", "key ID - C"}));
		comboBox.setBounds(130, 84, 223, 30);
		panel_1.add(comboBox);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBounds(130, 137, 223, 30);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Availability :");
		lblNewLabel_4.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(32, 145, 101, 14);
		panel_1.add(lblNewLabel_4);
		
		textField_1 = new JTextField();
		textField_1.setBounds(130, 29, 223, 30);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(130, 189, 223, 30);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 385, 321, 88);
		panel_1.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JLabel lblNote = new JLabel("Note :");
		lblNote.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNote.setBounds(32, 252, 73, 14);
		panel_1.add(lblNote);
		
		JTextArea txtrTheseFieldsAre = new JTextArea();
		txtrTheseFieldsAre.setFont(new Font("Calibri", Font.PLAIN, 14));
		txtrTheseFieldsAre.setEditable(false);
		txtrTheseFieldsAre.setText("These fields are automatically filled\r\nwhen you press the save button:\r\n- Your login username\r\n- Check out time\r\n- Check out date");
		txtrTheseFieldsAre.setBounds(129, 247, 224, 102);
		panel_1.add(txtrTheseFieldsAre);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(204, 204, 255));
		panel_2.setBorder(new LineBorder(new Color(0, 0, 128)));
		panel_2.setBounds(38, 34, 392, 503);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Please, check any pop up Notes given by the customer:");
		lblNewLabel_5.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_5.setBounds(28, 25, 338, 14);
		panel_2.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Search pop up Notes using one of the two search methdos");
		lblNewLabel_6.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(38, 50, 341, 14);
		panel_2.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel(" as shown below:");
		lblNewLabel_7.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(36, 67, 259, 14);
		panel_2.add(lblNewLabel_7);
		
		JLabel lblPropertyId = new JLabel("Property ID :");
		lblPropertyId.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblPropertyId.setBounds(43, 113, 88, 14);
		panel_2.add(lblPropertyId);
		
		JLabel lblNewLabel_8 = new JLabel("Key ID :");
		lblNewLabel_8.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNewLabel_8.setBounds(43, 170, 69, 14);
		panel_2.add(lblNewLabel_8);
		
		textField_3 = new JTextField();
		textField_3.setBounds(141, 105, 211, 30);
		panel_2.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(141, 154, 211, 30);
		panel_2.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnSearchPopUp = new JButton("Search pop up Notes");
		btnSearchPopUp.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnSearchPopUp.setBounds(141, 206, 211, 30);
		panel_2.add(btnSearchPopUp);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(43, 258, 309, 212);
		panel_2.add(scrollPane_1);
		
		JTextArea textArea_1 = new JTextArea();
		scrollPane_1.setViewportView(textArea_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(204, 204, 255));
		panel_3.setBorder(new LineBorder(new Color(0, 0, 128)));
		panel_3.setBounds(871, 34, 183, 503);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnNewButton = new JButton("Insert Service");
		btnNewButton.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnNewButton.setBounds(33, 354, 114, 33);
		panel_3.add(btnNewButton);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnClear.setBounds(33, 398, 114, 33);
		panel_3.add(btnClear);
		
		JButton btnNewButton_1 = new JButton("Go Back");
		btnNewButton_1.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnNewButton_1.setBounds(33, 442, 114, 33);
		panel_3.add(btnNewButton_1);
		
		ImageIcon image = new ImageIcon("Aphrodite-Hills-wp.png");
		
		JLabel lblNewLabel_9 = new JLabel(image);
		lblNewLabel_9.setBounds(25, 126, 134, 115);
		panel_3.add(lblNewLabel_9);
	}
}
