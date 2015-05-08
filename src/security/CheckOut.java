package security;

import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

/**
 * 
 * Graphics for the check-out form of the Security department.
 * 
 * @author TeamD
 *
 */

public class CheckOut {

	public static JFrame frmService;
	public static JPanel contentPane;
	public static JTextField txtAvailability;
	public static JTextField txtKey;
	public static JTextField txtPerson;
	public static JTextField txtPlotNumber;
	public static JTextField txtKeyId;
	public static JComboBox<String> comboBoxKey;
	public static JTextArea txtDetails;
	public static JButton btnCheckOut;
	public static JTextArea txtNotes;
	public static JTextField txtPlotName;

	 /**
	 * Main method
	 * Useful only for testing
	 *
	 * @param  Srting[]
	 */

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		CheckOut window = new CheckOut();
		window.frmService.setVisible(true);
	}
	
	/**
	 * This is a method that hide and show the Form
	 * 
	 * 
	 * 
	 */
	public CheckOut() {
		initialize();
	}

	/**
	 * The initialize method creates and initialize
	 * all buttons, text fields, panels and everything 
	 * that the window needs to show. 
	 * 
	 * 
	 */
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
		}

		frmService = new JFrame();
		frmService.getContentPane().setBackground(new Color(255, 255, 255));
		frmService.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		frmService.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmService.getContentPane().setLayout(null);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frmService.setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);

		JPanel outerPanel = new JPanel();
		outerPanel.setBorder(new TitledBorder(new LineBorder(
				new Color(0, 0, 0), 2), "SECURITY DEPARTMENT",
				TitledBorder.CENTER, TitledBorder.TOP, null, null));
		outerPanel.setBackground(Color.WHITE);
		outerPanel.setBounds(70, 58, 1216, 618);
		contentPane.add(outerPanel);
		outerPanel.setLayout(null);

		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(new Color(255, 255, 255));
		mainPanel.setBorder(new TitledBorder(new LineBorder(
				new Color(0, 0, 128), 3), "Check out a Key",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		mainPanel.setBounds(65, 25, 1085, 569);
		outerPanel.add(mainPanel);
		mainPanel.setLayout(null);

		JPanel keyPanel = new JPanel();
		keyPanel.setBackground(new Color(173, 216, 230));
		keyPanel.setBorder(new LineBorder(new Color(0, 0, 128)));
		keyPanel.setBounds(458, 34, 384, 503);
		mainPanel.add(keyPanel);
		keyPanel.setLayout(null);

		JPanel notesPanel = new JPanel();
		notesPanel.setBackground(new Color(173, 216, 230));
		notesPanel.setBorder(new LineBorder(new Color(0, 0, 128)));
		notesPanel.setBounds(38, 34, 392, 503);
		mainPanel.add(notesPanel);
		notesPanel.setLayout(null);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(new Color(211, 211, 211));
		buttonPanel.setBorder(new LineBorder(new Color(0, 0, 128)));
		buttonPanel.setBounds(871, 34, 183, 503);
		mainPanel.add(buttonPanel);
		buttonPanel.setLayout(null);

		JLabel lblKey = new JLabel("Key ID* :");
		lblKey.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblKey.setBounds(32, 37, 60, 14);
		keyPanel.add(lblKey);

		JLabel lblSpecificKey = new JLabel("Specific Key* :");
		lblSpecificKey.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblSpecificKey.setBounds(32, 92, 88, 14);
		keyPanel.add(lblSpecificKey);

		JLabel lblPerson = new JLabel("Pick up Person* :");
		lblPerson.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblPerson.setBounds(32, 309, 101, 14);
		keyPanel.add(lblPerson);

		JLabel lblDetails = new JLabel("More Details :");
		lblDetails.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblDetails.setBounds(32, 359, 101, 14);
		keyPanel.add(lblDetails);

		JLabel lblNotes = new JLabel(
				"Please, check any pop up Notes given by the customer:");
		lblNotes.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNotes.setBounds(23, 11, 338, 28);
		notesPanel.add(lblNotes);

		JLabel lblKeyId = new JLabel("Key ID* :");
		lblKeyId.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblKeyId.setBounds(43, 182, 69, 14);
		notesPanel.add(lblKeyId);

		ImageIcon image = new ImageIcon("Aphrodite-Hills-wp.png");

		JLabel lblimage = new JLabel(image);
		lblimage.setBounds(25, 128, 134, 115);
		buttonPanel.add(lblimage);

		comboBoxKey = new JComboBox<String>();
		comboBoxKey.setModel(new DefaultComboBoxModel(new String[] { "A", "B",
				"C" }));
		comboBoxKey.setBounds(130, 84, 223, 30);
		keyPanel.add(comboBoxKey);

		txtKey = new JTextField();
		txtKey.setBounds(130, 29, 223, 30);
		keyPanel.add(txtKey);
		txtKey.setColumns(10);

		txtPerson = new JTextField();
		txtPerson.setBounds(130, 301, 223, 30);
		keyPanel.add(txtPerson);
		txtPerson.setColumns(10);

		txtPlotNumber = new JTextField();
		txtPlotNumber.setBounds(141, 79, 211, 30);
		notesPanel.add(txtPlotNumber);
		txtPlotNumber.setColumns(10);

		txtKeyId = new JTextField();
		txtKeyId.setBounds(141, 174, 211, 30);
		notesPanel.add(txtKeyId);
		txtKeyId.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 384, 321, 88);
		keyPanel.add(scrollPane);

		txtDetails = new JTextArea();
		scrollPane.setViewportView(txtDetails);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 128)));
		panel.setBackground(new Color(173, 216, 230));
		panel.setBounds(0, 141, 384, 133);
		keyPanel.add(panel);
		panel.setLayout(null);

		JButton btnNewButton = new JButton("Check Availability");
		btnNewButton.setBounds(92, 28, 193, 30);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new CheckOutAvailability().run();
			}
		});
		btnNewButton.setFont(new Font("Calibri", Font.PLAIN, 14));

		txtAvailability = new JTextField();
		txtAvailability.setBounds(92, 77, 193, 30);
		panel.add(txtAvailability);
		txtAvailability.setEnabled(false);
		txtAvailability.setColumns(10);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(43, 258, 309, 212);
		notesPanel.add(scrollPane_1);

		txtNotes = new JTextArea();
		scrollPane_1.setViewportView(txtNotes);

		JButton btnSearchNotes = new JButton("Search pop up Notes");
		btnSearchNotes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchNotesButton.searchMethod = 0;
				new SearchNotesButton().start();
			}
		});
		btnSearchNotes.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnSearchNotes.setBounds(141, 120, 211, 30);
		notesPanel.add(btnSearchNotes);

		JLabel lblOr = new JLabel("or");
		lblOr.setFont(new Font("Calibri", Font.ITALIC, 14));
		lblOr.setBounds(53, 147, 44, 24);
		notesPanel.add(lblOr);

		txtPlotName = new JTextField();
		txtPlotName.setColumns(10);
		txtPlotName.setBounds(141, 38, 211, 30);
		notesPanel.add(txtPlotName);

		JLabel lblPlotName = new JLabel("Plot Name* :");
		lblPlotName.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblPlotName.setBounds(38, 54, 101, 14);
		notesPanel.add(lblPlotName);

		JLabel lblPlotNumber = new JLabel("Plot Number* :");
		lblPlotNumber.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblPlotNumber.setBounds(38, 87, 93, 14);
		notesPanel.add(lblPlotNumber);

		JButton btnNewButton_1 = new JButton("Search pop up Notes");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SearchNotesButton.searchMethod = 1;
				new SearchNotesButton().start();
			}
		});
		btnNewButton_1.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnNewButton_1.setBounds(141, 215, 211, 32);
		notesPanel.add(btnNewButton_1);

		btnCheckOut = new JButton("Check out Key");
		btnCheckOut.setForeground(new Color(0, 0, 128));
		btnCheckOut.setBackground(Color.WHITE);
		btnCheckOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CheckOutButton().start();
			}
		});
		btnCheckOut.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnCheckOut.setBounds(33, 354, 114, 33);
		buttonPanel.add(btnCheckOut);

		JButton btnClear = new JButton("Clear");
		btnClear.setForeground(new Color(0, 0, 128));
		btnClear.setBackground(Color.WHITE);
		btnClear.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				new CheckOutClearButton().start(0);
			}
		});
		btnClear.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnClear.setBounds(33, 398, 114, 33);
		buttonPanel.add(btnClear);

		JButton btnBack = new JButton("Go Back");
		btnBack.setForeground(new Color(0, 0, 128));
		btnBack.setBackground(Color.WHITE);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmService.setVisible(false);
			}
		});
		btnBack.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnBack.setBounds(33, 442, 114, 33);
		buttonPanel.add(btnBack);

	}

	/**
	 * This method return keyID
	 * 
	 * @return key id
	 */
	public static String getKeyID() {
		return txtKey.getText();
	}
	
	/**
	 * This method return Specific key 
	 * 
	 * @return   Specific key 
	 */
	public static String getSpecificKey() {
		return (String) comboBoxKey.getSelectedItem().toString();
	}

	/**
	 *  This method return Pick up person
	 * 
	 * @return Pick up person 
	 */
	public static String getPickUpPerson() {
		return txtPerson.getText();
	}

	/**
	 *  This method return Details 
	 * 
	 * @return Details
	 */
	public static String getDetails() {
		return txtDetails.getText();
	}

	/**
	 * This is a method that hide and show the Form
	 * 
	 * @param b
	 */
	public static void setVisible(boolean b) {
		frmService.setVisible(b);
	}
}
