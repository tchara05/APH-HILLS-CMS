package security;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JTextArea;

public class CheckIn {

	private JFrame frmCheckIn;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		CheckIn window = new CheckIn();
		window.frmCheckIn.setVisible(true);
	}

	/**
	 * Create the application.
	 */
	public CheckIn() {
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
		
		frmCheckIn = new JFrame();
		frmCheckIn.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		frmCheckIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCheckIn.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 128)), "Check in a Key", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(338, 80, 674, 573);
		frmCheckIn.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 204, 255));
		panel_1.setBorder(new LineBorder(new Color(0, 0, 128)));
		panel_1.setBounds(35, 37, 277, 310);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblListOfCheck = new JLabel("List of Check out Keys :");
		lblListOfCheck.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblListOfCheck.setBounds(25, 28, 164, 14);
		panel_1.add(lblListOfCheck);
		
		JButton btnSelectedKeyInfo = new JButton("View info of the selected Key");
		btnSelectedKeyInfo.setBounds(25, 255, 223, 31);
		panel_1.add(btnSelectedKeyInfo);
		btnSelectedKeyInfo.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JList list = new JList();
		list.setBounds(25, 53, 223, 179);
		panel_1.add(list);
		btnSelectedKeyInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(204, 204, 255));
		panel_2.setBorder(new LineBorder(new Color(0, 0, 128)));
		panel_2.setBounds(35, 376, 277, 168);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Search a Key manually :");
		lblNewLabel.setBounds(28, 26, 159, 17);
		panel_2.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		textField = new JTextField();
		textField.setBounds(28, 54, 220, 31);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JButton btnViewInfoOf = new JButton("View info of the given Key");
		btnViewInfoOf.setBounds(28, 108, 220, 31);
		panel_2.add(btnViewInfoOf);
		btnViewInfoOf.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(204, 204, 255));
		panel_3.setBorder(new LineBorder(new Color(0, 0, 128)));
		panel_3.setBounds(340, 37, 302, 507);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblInfoAboutThis = new JLabel("Information about this Key :");
		lblInfoAboutThis.setBounds(27, 148, 203, 17);
		panel_3.add(lblInfoAboutThis);
		lblInfoAboutThis.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JButton btnCheckInThis = new JButton("Check in this Key");
		btnCheckInThis.setBounds(27, 343, 244, 31);
		panel_3.add(btnCheckInThis);
		btnCheckInThis.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JTextArea txtrTheseFieldsAre = new JTextArea();
		txtrTheseFieldsAre.setBounds(27, 385, 244, 102);
		txtrTheseFieldsAre.setText("These fields are automatically filled\r\nwhen you press the check in button :\r\n- Check in time\r\n- Check in date");
		txtrTheseFieldsAre.setFont(new Font("Calibri", Font.PLAIN, 14));
		txtrTheseFieldsAre.setEditable(false);
		panel_3.add(txtrTheseFieldsAre);
		
		JLabel lblService = new JLabel("Pick up person :");
		lblService.setBounds(27, 193, 93, 14);
		panel_3.add(lblService);
		lblService.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblCheckInTime = new JLabel("Check in time :");
		lblCheckInTime.setBounds(27, 231, 93, 14);
		panel_3.add(lblCheckInTime);
		lblCheckInTime.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblCheckInTime_1 = new JLabel("Check in date :");
		lblCheckInTime_1.setBounds(27, 271, 93, 14);
		panel_3.add(lblCheckInTime_1);
		lblCheckInTime_1.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		textField_1 = new JTextField();
		textField_1.setBounds(122, 185, 149, 31);
		textField_1.setEditable(false);
		panel_3.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(122, 223, 149, 31);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		panel_3.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(122, 263, 149, 31);
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		panel_3.add(textField_3);
		
		ImageIcon image = new ImageIcon("Aphrodite-Hills-wp.png");
		
		JLabel lblNewLabel_1 = new JLabel(image);
		lblNewLabel_1.setBounds(56, 26, 195, 107);
		panel_3.add(lblNewLabel_1);
	}
}
