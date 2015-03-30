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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class SecurityForm {

	public JFrame frame;
	public static JPanel contentPane;
	public static JTextField txtkeyID;
	public static JTextArea txtAreaNotes;
	public static JTextField txtPropertyID;
	protected static boolean edit = false;

	
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
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);

		ImageIcon image = new ImageIcon("Aphrodite-Hills-wp.png");

		JPanel outerPanel = new JPanel();
		outerPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "SECURITY DEPARTMENT", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		outerPanel.setBackground(Color.WHITE);
		outerPanel.setBounds(70, 58, 1216, 618);
		contentPane.add(outerPanel);
		outerPanel.setLayout(null);

		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(287, 87, 635, 447);
		outerPanel.add(mainPanel);
		mainPanel.setBackground(new Color(255, 255, 255));
		mainPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 128), 2), "Add New Key Contract", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		mainPanel.setLayout(null);

		JPanel insertPanel = new JPanel();
		insertPanel.setBounds(30, 34, 371, 384);
		mainPanel.add(insertPanel);
		insertPanel.setBackground(new Color(173, 216, 230));
		insertPanel.setBorder(new LineBorder(new Color(0, 0, 128)));
		insertPanel.setLayout(null);

		JPanel btnPanel = new JPanel();
		btnPanel.setBounds(427, 34, 178, 384);
		mainPanel.add(btnPanel);
		btnPanel.setBackground(new Color(211, 211, 211));
		btnPanel.setBorder(new LineBorder(new Color(0, 0, 102)));
		btnPanel.setLayout(null);

		JLabel lblKey = new JLabel("Key ID :");
		lblKey.setForeground(Color.BLACK);
		lblKey.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblKey.setBounds(36, 40, 86, 17);
		insertPanel.add(lblKey);

		JLabel lblProperty = new JLabel("Property ID* :");
		lblProperty.setForeground(Color.BLACK);
		lblProperty.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblProperty.setBounds(36, 122, 79, 14);
		insertPanel.add(lblProperty);

		JLabel lblNewLabel_2 = new JLabel(
				"*\u03A4his field is automatically filled");
		lblNewLabel_2.setFont(new Font("Calibri", Font.ITALIC, 12));
		lblNewLabel_2.setBounds(132, 69, 199, 14);
		insertPanel.add(lblNewLabel_2);

		JLabel lblNotes = new JLabel("Customer Pop up Notes :");
		lblNotes.setForeground(Color.BLACK);
		lblNotes.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNotes.setBounds(36, 198, 168, 14);
		insertPanel.add(lblNotes);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 223, 295, 127);
		insertPanel.add(scrollPane);

		txtAreaNotes = new JTextArea();
		scrollPane.setViewportView(txtAreaNotes);

		txtkeyID = new JTextField();
		txtkeyID.setEnabled(false);
		txtkeyID.setEditable(false);
		txtkeyID.setBounds(132, 33, 199, 30);
		insertPanel.add(txtkeyID);
		txtkeyID.setColumns(10);

		txtPropertyID = new JTextField();
		txtPropertyID.setBounds(132, 114, 199, 30);
		insertPanel.add(txtPropertyID);
		txtPropertyID.setColumns(10);

		JButton btnAdd = new JButton("Add Contract");
		btnAdd.setBackground(Color.WHITE);
		btnAdd.setForeground(new Color(0, 0, 128));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SecuritySaveButton().start();
			}
		});
		btnAdd.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnAdd.setBounds(32, 235, 116, 31);
		btnPanel.add(btnAdd);

		JButton btnBack = new JButton("Go Back");
		btnBack.setForeground(new Color(0, 0, 128));
		btnBack.setBackground(Color.WHITE);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnBack.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnBack.setBounds(32, 319, 116, 31);
		btnPanel.add(btnBack);

		JButton btnClear = new JButton("Clear");
		btnClear.setForeground(new Color(0, 0, 128));
		btnClear.setBackground(Color.WHITE);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SecurityClearButton.start();
			}
		});
		btnClear.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnClear.setBounds(32, 277, 116, 31);
		btnPanel.add(btnClear);
		
				JLabel lblimage = new JLabel(image);
				lblimage.setBounds(10, 35, 158, 120);
				btnPanel.add(lblimage);

	}
}