package security;


import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JEditorPane;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class SecurityForm {

	private static JFrame frame;
	private static JPanel contentPane;
	private static JTextField txtkeyID;
	private static JTextField txtpropertyID;

	/**
	 * 
	 * 
	 * Launch the application.
	 */
	
	protected static boolean edit =false;
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) {

		SecurityForm window = new SecurityForm();
		window.frame.setVisible(true);
		
	}

	/**
	 * Create the application.
	 */
	public SecurityForm() {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @return 
	 */
	public void initialize() { 
		
		
	
		
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
		
		
		frame = new JFrame();
		frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Add New Key Contract", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panel_3.setBounds(357, 143, 635, 447);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(30, 34, 371, 384);
		panel_3.add(panel_1);
		panel_1.setBackground(new Color(204, 204, 255));
		panel_1.setBorder(new LineBorder(new Color(0, 0, 128)));
		panel_1.setLayout(null);
		
		txtkeyID = new JTextField();
		txtkeyID.setEnabled(false);
		txtkeyID.setEditable(false);
		txtkeyID.setBounds(132, 33, 199, 30);
		panel_1.add(txtkeyID);
		txtkeyID.setColumns(10);
		
		txtpropertyID = new JTextField();
		txtpropertyID.setBounds(132, 114, 199, 30);
		panel_1.add(txtpropertyID);
		txtpropertyID.setColumns(10);
		
		JLabel keyLabel = new JLabel("Key ID :");
		keyLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
		keyLabel.setBounds(36, 40, 86, 17);
		panel_1.add(keyLabel);
		
		JLabel propertyLabel = new JLabel("Property ID :");
		propertyLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
		propertyLabel.setBounds(36, 122, 79, 14);
		panel_1.add(propertyLabel);
		
		JLabel lblNewLabel_2 = new JLabel("*\u03A4his field is automatically filled");
		lblNewLabel_2.setFont(new Font("Calibri", Font.ITALIC, 11));
		lblNewLabel_2.setBounds(132, 69, 152, 14);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblPop = new JLabel("Customer Pop up Notes :");
		lblPop.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblPop.setBounds(36, 198, 168, 14);
		panel_1.add(lblPop);		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 223, 295, 127);
		panel_1.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(427, 34, 178, 384);
		panel_3.add(panel_2);
		panel_2.setBackground(new Color(204, 204, 255));
		panel_2.setBorder(new LineBorder(new Color(0, 0, 102)));
		panel_2.setLayout(null);
		
		JButton saveButton = new JButton("Add Contract");
		saveButton.setBounds(32, 238, 116, 31);
		panel_2.add(saveButton);
		
		JButton goBackButton = new JButton("Go Back");
		goBackButton.setBounds(32, 322, 116, 31);
		panel_2.add(goBackButton);
		
		JButton clearButton = new JButton("Clear");
		clearButton.setBounds(32, 280, 116, 31);
		panel_2.add(clearButton);
		
		ImageIcon image = new ImageIcon("Aphrodite-Hills-wp.png");
		
		JLabel lblNewLabel = new JLabel(image);
		lblNewLabel.setBounds(10, 57, 158, 120);
		panel_2.add(lblNewLabel);
		
	}
	
		public static String getPropertyID() {
			return txtpropertyID.getText();
		}
		
		public static void setPropertyID(String value) {
			txtpropertyID.setText(value);
		}
		
		public static void setVisible(boolean value) {
			frame.setVisible(value);
		}
}