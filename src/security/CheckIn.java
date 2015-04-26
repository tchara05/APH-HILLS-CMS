package security;

/**
 * 
 * Graphics for the check-in form of the Security department.
 * 
 * @author TeamD
 *
 */

import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import extras.DatabaseConnection;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class CheckIn {

	public static JFrame frmCheckIn;
	public static JPanel contentPane;
	public static JTextField txtSearch;
	public static JTextField txtPerson;
	public static JTextField txtTime;
	public static JTextField txtDate;
	public static JTextField txtSpecificKey;
	public static DatabaseConnection database;
	public static JComboBox<String> allKeys;
	public static int isList = 0;
	public static String inList = "";

	@SuppressWarnings("static-access")
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
		}

		frmCheckIn = new JFrame();
		frmCheckIn.getContentPane().setBackground(new Color(255, 255, 255));
		frmCheckIn.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		frmCheckIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCheckIn.getContentPane().setLayout(null);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frmCheckIn.setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);

		JPanel outerPanel = new JPanel();
		outerPanel.setBorder(new TitledBorder(new LineBorder(
				new Color(0, 0, 0), 2), "SECURITY DEPARTMENT",
				TitledBorder.CENTER, TitledBorder.TOP, null, null));
		outerPanel.setBackground(Color.WHITE);
		outerPanel.setBounds(70, 60, 1216, 618);
		contentPane.add(outerPanel);
		outerPanel.setLayout(null);

		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(new Color(255, 255, 255));
		mainPanel.setBorder(new TitledBorder(new LineBorder(
				new Color(0, 0, 128), 3), "Check in a Key",
				TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		mainPanel.setBounds(280, 34, 674, 549);
		outerPanel.add(mainPanel);
		mainPanel.setLayout(null);

		JPanel listPanel = new JPanel();
		listPanel.setBackground(new Color(173, 216, 230));
		listPanel.setBorder(new LineBorder(new Color(0, 0, 128)));
		listPanel.setBounds(35, 37, 277, 265);
		mainPanel.add(listPanel);
		listPanel.setLayout(null);

		JPanel searchPanel = new JPanel();
		searchPanel.setBackground(new Color(173, 216, 230));
		searchPanel.setBorder(new LineBorder(new Color(0, 0, 128)));
		searchPanel.setBounds(35, 329, 277, 191);
		mainPanel.add(searchPanel);
		searchPanel.setLayout(null);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(new Color(211, 211, 211));
		buttonPanel.setBorder(new LineBorder(new Color(0, 0, 128)));
		buttonPanel.setBounds(340, 37, 302, 483);
		mainPanel.add(buttonPanel);
		buttonPanel.setLayout(null);

		JLabel lblList = new JLabel("List of Check out Keys :");
		lblList.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblList.setBounds(25, 28, 164, 14);
		listPanel.add(lblList);

		JLabel lblSearch = new JLabel("Search a Key manually :");
		lblSearch.setBounds(28, 26, 159, 17);
		searchPanel.add(lblSearch);
		lblSearch.setFont(new Font("Calibri", Font.PLAIN, 14));

		JLabel lblInfo = new JLabel("Information about this Key :");
		lblInfo.setBounds(27, 149, 203, 17);
		buttonPanel.add(lblInfo);
		lblInfo.setFont(new Font("Calibri", Font.PLAIN, 14));

		JLabel lblPerson = new JLabel("Pick up person :");
		lblPerson.setBounds(27, 187, 93, 14);
		buttonPanel.add(lblPerson);
		lblPerson.setFont(new Font("Calibri", Font.PLAIN, 14));

		JLabel lblCheckInTime = new JLabel("Check out time :");
		lblCheckInTime.setBounds(27, 225, 93, 14);
		buttonPanel.add(lblCheckInTime);
		lblCheckInTime.setFont(new Font("Calibri", Font.PLAIN, 14));

		JLabel lblCheckInDate = new JLabel("Check out date :");
		lblCheckInDate.setBounds(27, 265, 93, 14);
		buttonPanel.add(lblCheckInDate);
		lblCheckInDate.setFont(new Font("Calibri", Font.PLAIN, 14));

		txtSearch = new JTextField();
		txtSearch.setText("key ID");
		txtSearch.setBounds(28, 54, 220, 31);
		searchPanel.add(txtSearch);
		txtSearch.setColumns(10);

		txtPerson = new JTextField();
		txtPerson.setBounds(130, 179, 149, 31);
		txtPerson.setEditable(false);
		buttonPanel.add(txtPerson);
		txtPerson.setColumns(10);

		txtTime = new JTextField();
		txtTime.setBounds(130, 217, 149, 31);
		txtTime.setEditable(false);
		txtTime.setColumns(10);
		buttonPanel.add(txtTime);

		txtDate = new JTextField();
		txtDate.setBounds(130, 257, 149, 31);
		txtDate.setEditable(false);
		txtDate.setColumns(10);
		buttonPanel.add(txtDate);

		txtSpecificKey = new JTextField();
		txtSpecificKey.setText("specific key (A,B,C)");
		txtSpecificKey.setBounds(28, 96, 220, 29);
		searchPanel.add(txtSpecificKey);
		txtSpecificKey.setColumns(10);

		ImageIcon image = new ImageIcon("Aphrodite-Hills-wp.png");

		JButton btnCheckIn = new JButton("Check in this Key");
		btnCheckIn.setBackground(Color.WHITE);
		btnCheckIn.setForeground(new Color(0, 0, 128));
		btnCheckIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CheckInButton().start();
			}
		});
		btnCheckIn.setBounds(75, 336, 149, 33);
		buttonPanel.add(btnCheckIn);
		btnCheckIn.setFont(new Font("Calibri", Font.PLAIN, 14));

		JLabel lblimage = new JLabel(image);
		lblimage.setBounds(56, 11, 195, 127);
		buttonPanel.add(lblimage);

		JButton btnSelect = new JButton("View info of the selected Key");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				inList = (String) allKeys.getSelectedItem();
				isList = 1;
				new CheckInSearchInfo().start();
			}
		});
		btnSelect.setBounds(25, 210, 223, 31);
		listPanel.add(btnSelect);
		btnSelect.setFont(new Font("Calibri", Font.PLAIN, 14));

		allKeys = new JComboBox<String>();
		allKeys.setBounds(25, 51, 223, 31);
		listPanel.add(allKeys);

		JButton btnSearch = new JButton("View info of the given Key");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isList = 0;
				new CheckInSearchInfo().start();
			}
		});
		btnSearch.setBounds(28, 136, 220, 31);
		searchPanel.add(btnSearch);
		btnSearch.setFont(new Font("Calibri", Font.PLAIN, 14));

		JButton btnClear = new JButton("Clear");
		btnClear.setBackground(Color.WHITE);
		btnClear.setForeground(new Color(0, 0, 128));
		btnClear.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				new CheckInClearButton().start();
			}
		});
		btnClear.setBounds(75, 380, 149, 33);
		buttonPanel.add(btnClear);
		btnClear.setFont(new Font("Calibri", Font.PLAIN, 14));

		JButton btnBack = new JButton("Go Back");
		btnBack.setBackground(Color.WHITE);
		btnBack.setForeground(new Color(0, 0, 128));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCheckIn.setVisible(false);
			}
		});
		btnBack.setBounds(75, 424, 149, 33);
		buttonPanel.add(btnBack);
		btnBack.setFont(new Font("Calibri", Font.PLAIN, 14));

		database = new DatabaseConnection();
		setUpContractList();
	}
	
	
	
	/**
	 * 
	 * This method is used to set up the list which it shows
	 * the key contracts that already exist in the the security 
	 * department.
	 * 
	 * @author TeamD
	 *
	 */
	public static void setUpContractList() {

		Statement stment = database.getStatement();

		ResultSet rset = null;
		ArrayList<String> List = new ArrayList<String>();
		try {
			rset = stment
					.executeQuery(extras.Query.KEYID_SPECIFICKEY);

			while (rset.next() && (rset.getString(1) != null)) {

				String s = rset.getString(1);
				String s1 = rset.getString(2);

				List.add(s);
				List.add(s1);
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		rset = null;
		try {
			rset = stment
					.executeQuery(extras.Query.KEYID_PLOTNAME_PLOTNUMBER);
			while (rset.next() && (rset.getString(1) != null)) {
				String s = rset.getString(1);
				String s1 = rset.getString(2);
				String s3 = rset.getString(3);
				
				for (int i = 0; i < List.size(); i = i + 2) {
					String word = List.get(i).toString();
					String word1 = List.get(i + 1).toString();

					if (word.equals(s)) {
						allKeys.addItem(word + " " + word1 + " " + " | " + s1
								+ " " + s3);
					}

				}

			}

		} catch (SQLException e1) {
			System.out.println("Can execute the query in setUpContractList");
			e1.printStackTrace();
		}
	}
}
