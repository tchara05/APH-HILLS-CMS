package security;

import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class SecurityForm {

	private static JFrame frame;
	private static JPanel contentPane;
	private static JTextField txtkeyID;
	private static JTextField txtpropertyID;

	protected static boolean edit = false;

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		SecurityForm window = new SecurityForm();
		window.frame.setVisible(true);
	}

	public SecurityForm() {

		initialize();
	}

	public void initialize() {

		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			// If Nimbus is not available, you can set the GUI to another look
			// and feel.
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

		JPanel mainPanel = new JPanel();
		mainPanel.setBorder(new TitledBorder(new LineBorder(
				new Color(0, 0, 128)), "Add New Key Contract",
				TitledBorder.LEFT, TitledBorder.TOP, null, null));
		mainPanel.setBounds(357, 143, 635, 447);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);

		JPanel insertPanel = new JPanel();
		insertPanel.setBounds(30, 34, 371, 384);
		mainPanel.add(insertPanel);
		insertPanel.setBackground(new Color(204, 204, 255));
		insertPanel.setBorder(new LineBorder(new Color(0, 0, 128)));
		insertPanel.setLayout(null);

		JPanel btnPanel = new JPanel();
		btnPanel.setBounds(427, 34, 178, 384);
		mainPanel.add(btnPanel);
		btnPanel.setBackground(new Color(204, 204, 255));
		btnPanel.setBorder(new LineBorder(new Color(0, 0, 102)));
		btnPanel.setLayout(null);

		JLabel lblKey = new JLabel("Key ID :");
		lblKey.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblKey.setBounds(36, 40, 86, 17);
		insertPanel.add(lblKey);

		JLabel lblProperty = new JLabel("Property ID :");
		lblProperty.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblProperty.setBounds(36, 122, 79, 14);
		insertPanel.add(lblProperty);

		JLabel lblNewLabel_2 = new JLabel(
				"*\u03A4his field is automatically filled");
		lblNewLabel_2.setFont(new Font("Calibri", Font.ITALIC, 12));
		lblNewLabel_2.setBounds(132, 69, 199, 14);
		insertPanel.add(lblNewLabel_2);

		JLabel lblNotes = new JLabel("Customer Pop up Notes :");
		lblNotes.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNotes.setBounds(36, 198, 168, 14);
		insertPanel.add(lblNotes);

		ImageIcon image = new ImageIcon("Aphrodite-Hills-wp.png");

		JLabel lblimage = new JLabel(image);
		lblimage.setBounds(10, 57, 158, 120);
		btnPanel.add(lblimage);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 223, 295, 127);
		insertPanel.add(scrollPane);

		JTextArea txtAreaNotes = new JTextArea();
		scrollPane.setViewportView(txtAreaNotes);

		txtkeyID = new JTextField();
		txtkeyID.setEnabled(false);
		txtkeyID.setEditable(false);
		txtkeyID.setBounds(132, 33, 199, 30);
		insertPanel.add(txtkeyID);
		txtkeyID.setColumns(10);

		txtpropertyID = new JTextField();
		txtpropertyID.setBounds(132, 114, 199, 30);
		insertPanel.add(txtpropertyID);
		txtpropertyID.setColumns(10);

		JButton btnAdd = new JButton("Add Contract");
		btnAdd.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnAdd.setBounds(32, 230, 116, 31);
		btnPanel.add(btnAdd);

		JButton btnBack = new JButton("Go Back");
		btnBack.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnBack.setBounds(32, 319, 116, 31);
		btnPanel.add(btnBack);

		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnClear.setBounds(32, 277, 116, 31);
		btnPanel.add(btnClear);
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