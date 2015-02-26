package security;

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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class CheckOut {

	public static JFrame frmService;
	public static JTextField txtAvailability;
	public static JTextField txtKey;
	public static JTextField txtPerson;
	public static JTextField txtPropertyId;
	public static JTextField txtKeyId;
	public static JComboBox<String> comboBoxKey;
	public static JTextArea txtDetails;
	public static JButton btnCheckOut;

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		CheckOut window = new CheckOut();
		window.frmService.setVisible(true);
	}

	public CheckOut() {
		initialize();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {

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

		frmService = new JFrame();
		frmService.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		frmService.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmService.getContentPane().setLayout(null);

		JPanel mainPanel = new JPanel();
		mainPanel.setBorder(new TitledBorder(new LineBorder(
				new Color(0, 0, 128)), "Check out a Key", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		mainPanel.setBounds(132, 82, 1085, 569);
		frmService.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);

		JPanel keyPanel = new JPanel();
		keyPanel.setBackground(new Color(204, 204, 255));
		keyPanel.setBorder(new LineBorder(new Color(0, 0, 128)));
		keyPanel.setBounds(458, 34, 384, 503);
		mainPanel.add(keyPanel);
		keyPanel.setLayout(null);

		JPanel notesPanel = new JPanel();
		notesPanel.setBackground(new Color(204, 204, 255));
		notesPanel.setBorder(new LineBorder(new Color(0, 0, 128)));
		notesPanel.setBounds(38, 34, 392, 503);
		mainPanel.add(notesPanel);
		notesPanel.setLayout(null);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(new Color(204, 204, 255));
		buttonPanel.setBorder(new LineBorder(new Color(0, 0, 128)));
		buttonPanel.setBounds(871, 34, 183, 503);
		mainPanel.add(buttonPanel);
		buttonPanel.setLayout(null);

		JLabel lblKey = new JLabel("Key ID :");
		lblKey.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblKey.setBounds(32, 37, 60, 14);
		keyPanel.add(lblKey);

		JLabel lblSpecificKey = new JLabel("Specific Key :");
		lblSpecificKey.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblSpecificKey.setBounds(32, 92, 88, 14);
		keyPanel.add(lblSpecificKey);

		JLabel lblPerson = new JLabel("Pick up Person :");
		lblPerson.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblPerson.setBounds(32, 197, 101, 14);
		keyPanel.add(lblPerson);

		JLabel lblDetails = new JLabel("More Details :");
		lblDetails.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblDetails.setBounds(32, 360, 101, 14);
		keyPanel.add(lblDetails);

		JLabel lblAvailability = new JLabel("Availability :");
		lblAvailability.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblAvailability.setBounds(32, 145, 101, 14);
		keyPanel.add(lblAvailability);

		JLabel lblNote = new JLabel("Note :");
		lblNote.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNote.setBounds(32, 252, 73, 14);
		keyPanel.add(lblNote);

		JLabel lblNotes = new JLabel(
				"Please, check any pop up Notes given by the customer:");
		lblNotes.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNotes.setBounds(28, 25, 338, 14);
		notesPanel.add(lblNotes);

		JLabel lblNotes1 = new JLabel(
				"Search pop up Notes using one of the two search methdos");
		lblNotes1.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNotes1.setBounds(38, 50, 341, 14);
		notesPanel.add(lblNotes1);

		JLabel lblNotes2 = new JLabel(" as shown below:");
		lblNotes2.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNotes2.setBounds(36, 67, 259, 14);
		notesPanel.add(lblNotes2);

		JLabel lblPropertyId = new JLabel("Property ID :");
		lblPropertyId.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblPropertyId.setBounds(43, 113, 88, 14);
		notesPanel.add(lblPropertyId);

		JLabel lblKeyId = new JLabel("Key ID :");
		lblKeyId.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblKeyId.setBounds(43, 170, 69, 14);
		notesPanel.add(lblKeyId);

		ImageIcon image = new ImageIcon("Aphrodite-Hills-wp.png");

		JLabel lblimage = new JLabel(image);
		lblimage.setBounds(25, 126, 134, 115);
		buttonPanel.add(lblimage);

		comboBoxKey = new JComboBox<String>();
		comboBoxKey.setModel(new DefaultComboBoxModel(new String[] {
				"key ID - A", "key ID - B", "key ID - C" }));
		comboBoxKey.setBounds(130, 84, 223, 30);
		keyPanel.add(comboBoxKey);

		txtAvailability = new JTextField();
		txtAvailability.setEnabled(false);
		txtAvailability.setBounds(130, 137, 223, 30);
		keyPanel.add(txtAvailability);
		txtAvailability.setColumns(10);

		txtKey = new JTextField();
		txtKey.setBounds(130, 29, 223, 30);
		keyPanel.add(txtKey);
		txtKey.setColumns(10);

		txtPerson = new JTextField();
		txtPerson.setBounds(130, 189, 223, 30);
		keyPanel.add(txtPerson);
		txtPerson.setColumns(10);

		txtPropertyId = new JTextField();
		txtPropertyId.setBounds(141, 105, 211, 30);
		notesPanel.add(txtPropertyId);
		txtPropertyId.setColumns(10);

		txtKeyId = new JTextField();
		txtKeyId.setBounds(141, 154, 211, 30);
		notesPanel.add(txtKeyId);
		txtKeyId.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 385, 321, 88);
		keyPanel.add(scrollPane);

		txtDetails = new JTextArea();
		scrollPane.setViewportView(txtDetails);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(43, 258, 309, 212);
		notesPanel.add(scrollPane_1);

		JTextArea txtNotes = new JTextArea();
		scrollPane_1.setViewportView(txtNotes);

		JTextArea txtMessage = new JTextArea();
		txtMessage.setFont(new Font("Calibri", Font.PLAIN, 14));
		txtMessage.setEditable(false);
		txtMessage.setText("These fields are automatically filled\r\nwhen you press the save button:\r\n      - Your login username\r\n      - Check out time\r\n      - Check out date");
		txtMessage.setBounds(129, 247, 224, 102);
		keyPanel.add(txtMessage);

		JButton btnSearchNotes = new JButton("Search pop up Notes");
		btnSearchNotes.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnSearchNotes.setBounds(141, 206, 211, 30);
		notesPanel.add(btnSearchNotes);

		btnCheckOut = new JButton("Check out Key");
		btnCheckOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CheckOutButton().start();
			}
		});
		btnCheckOut.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnCheckOut.setBounds(33, 354, 114, 33);
		buttonPanel.add(btnCheckOut);

		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnClear.setBounds(33, 398, 114, 33);
		buttonPanel.add(btnClear);

		JButton btnBack = new JButton("Go Back");
		btnBack.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnBack.setBounds(33, 442, 114, 33);
		buttonPanel.add(btnBack);
		
	}
	
	public static String getKeyID() {
		return txtKey.getText();
	}
	
	public static String getSpecificKey() {
		return (String)comboBoxKey.getSelectedItem().toString();
	}
	
	public static String getPickUpPerson() {
		return txtPerson.getText();
	}
	
	public static String getDetails() {
		return txtDetails.getText();
	}

	public static void setVisible(boolean b) {
		frmService.setVisible(b);
	}
}
