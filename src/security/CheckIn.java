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
	private JTextField txtSearch;
	private JTextField txtPerson;
	private JTextField txtTime;
	private JTextField txtDate;

	public static void main(String[] args) {
		CheckIn window = new CheckIn();
		window.frmCheckIn.setVisible(true);
	}

	public CheckIn() {
		initialize();
	}

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
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 128)), "Check in a Key", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		mainPanel.setBounds(338, 80, 674, 573);
		frmCheckIn.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		
		JPanel listPanel = new JPanel();
		listPanel.setBackground(new Color(204, 204, 255));
		listPanel.setBorder(new LineBorder(new Color(0, 0, 128)));
		listPanel.setBounds(35, 37, 277, 310);
		mainPanel.add(listPanel);
		listPanel.setLayout(null);
		
		JPanel searchPanel = new JPanel();
		searchPanel.setBackground(new Color(204, 204, 255));
		searchPanel.setBorder(new LineBorder(new Color(0, 0, 128)));
		searchPanel.setBounds(35, 376, 277, 168);
		mainPanel.add(searchPanel);
		searchPanel.setLayout(null);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(new Color(204, 204, 255));
		buttonPanel.setBorder(new LineBorder(new Color(0, 0, 128)));
		buttonPanel.setBounds(340, 37, 302, 507);
		mainPanel.add(buttonPanel);
		buttonPanel.setLayout(null);
		
		JList listKeys = new JList();
		listKeys.setBounds(25, 53, 223, 179);
		listPanel.add(listKeys);
		
		JLabel lblList = new JLabel("List of Check out Keys :");
		lblList.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblList.setBounds(25, 28, 164, 14);
		listPanel.add(lblList);
		
		JLabel lblSearch = new JLabel("Search a Key manually :");
		lblSearch.setBounds(28, 26, 159, 17);
		searchPanel.add(lblSearch);
		lblSearch.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblInfo = new JLabel("Information about this Key :");
		lblInfo.setBounds(27, 129, 203, 17);
		buttonPanel.add(lblInfo);
		lblInfo.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblPerson = new JLabel("Pick up person :");
		lblPerson.setBounds(27, 165, 93, 14);
		buttonPanel.add(lblPerson);
		lblPerson.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblCheckInTime = new JLabel("Check in time :");
		lblCheckInTime.setBounds(27, 203, 93, 14);
		buttonPanel.add(lblCheckInTime);
		lblCheckInTime.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblCheckInDate = new JLabel("Check in date :");
		lblCheckInDate.setBounds(27, 243, 93, 14);
		buttonPanel.add(lblCheckInDate);
		lblCheckInDate.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JTextArea txtInfo = new JTextArea();
		txtInfo.setBounds(27, 277, 244, 77);
		txtInfo.setText("These fields are automatically filled\r\nwhen you press the check in button :\r\n       - Check in time\r\n       - Check in date");
		txtInfo.setFont(new Font("Calibri", Font.PLAIN, 14));
		txtInfo.setEditable(false);
		buttonPanel.add(txtInfo);
		
		txtSearch = new JTextField();
		txtSearch.setBounds(28, 54, 220, 31);
		searchPanel.add(txtSearch);
		txtSearch.setColumns(10);
		
		txtPerson = new JTextField();
		txtPerson.setBounds(122, 157, 149, 31);
		txtPerson.setEditable(false);
		buttonPanel.add(txtPerson);
		txtPerson.setColumns(10);
		
		txtTime = new JTextField();
		txtTime.setBounds(122, 195, 149, 31);
		txtTime.setEditable(false);
		txtTime.setColumns(10);
		buttonPanel.add(txtTime);
		
		txtDate = new JTextField();
		txtDate.setBounds(122, 235, 149, 31);
		txtDate.setEditable(false);
		txtDate.setColumns(10);
		buttonPanel.add(txtDate);
		
		ImageIcon image = new ImageIcon("Aphrodite-Hills-wp.png");
		
		JButton btnCheckIn = new JButton("Check in this Key");
		btnCheckIn.setBounds(77, 365, 149, 33);
		buttonPanel.add(btnCheckIn);
		btnCheckIn.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblimage = new JLabel(image);
		lblimage.setBounds(56, 11, 195, 107);
		buttonPanel.add(lblimage);
		
		JButton btnSelect = new JButton("View info of the selected Key");
		btnSelect.setBounds(25, 255, 223, 31);
		listPanel.add(btnSelect);
		btnSelect.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JButton btnSearch = new JButton("View info of the given Key");
		btnSearch.setBounds(28, 108, 220, 31);
		searchPanel.add(btnSearch);
		btnSearch.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(77, 409, 149, 33);
		buttonPanel.add(btnClear);
		btnClear.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JButton btnBack = new JButton("Go Back");
		btnBack.setBounds(77, 450, 149, 33);
		buttonPanel.add(btnBack);
		btnBack.setFont(new Font("Calibri", Font.PLAIN, 14));
	}
}
