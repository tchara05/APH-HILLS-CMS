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
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class CheckIn {

	private JFrame frmCheckIn;
	private JTextField textField;

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
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 128)), "Check In a Key", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(477, 229, 554, 474);
		frmCheckIn.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblService = new JLabel("Pick up person :");
		lblService.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblService.setBounds(414, 248, 93, 14);
		panel.add(lblService);
		
		JLabel lblInfoAboutThis = new JLabel("Info about this Key :");
		lblInfoAboutThis.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblInfoAboutThis.setBounds(356, 223, 168, 14);
		panel.add(lblInfoAboutThis);
		
		textField = new JTextField();
		textField.setBounds(76, 292, 171, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnCheckInThis = new JButton("Check In this Key");
		btnCheckInThis.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnCheckInThis.setBounds(368, 432, 139, 31);
		panel.add(btnCheckInThis);
		
		JButton btnViewInfoOf = new JButton("View info of the given Key");
		btnViewInfoOf.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnViewInfoOf.setBounds(76, 381, 192, 31);
		panel.add(btnViewInfoOf);
		
		JLabel lblNewLabel = new JLabel("Search a Key manually :");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNewLabel.setBounds(41, 248, 171, 14);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 204, 255));
		panel_1.setBorder(new LineBorder(new Color(0, 0, 128)));
		panel_1.setBounds(26, 30, 242, 176);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblListOfCheck = new JLabel("List of Check Out Keys :");
		lblListOfCheck.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblListOfCheck.setBounds(10, 11, 144, 14);
		panel_1.add(lblListOfCheck);
		
		JButton btnSelectedKeyInfo = new JButton("View info of the selected Key");
		btnSelectedKeyInfo.setBounds(10, 134, 222, 31);
		panel_1.add(btnSelectedKeyInfo);
		btnSelectedKeyInfo.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnSelectedKeyInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JLabel lblCheckInTime = new JLabel("Check in time :");
		lblCheckInTime.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblCheckInTime.setBounds(350, 273, 93, 14);
		panel.add(lblCheckInTime);
		
		JLabel lblCheckInTime_1 = new JLabel("Check in time :");
		lblCheckInTime_1.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblCheckInTime_1.setBounds(387, 298, 93, 14);
		panel.add(lblCheckInTime_1);
		
		JLabel lblPickUpPerson = new JLabel("Details :");
		lblPickUpPerson.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblPickUpPerson.setBounds(432, 336, 75, 14);
		panel.add(lblPickUpPerson);
	}
}
