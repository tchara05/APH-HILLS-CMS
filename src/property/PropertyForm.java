package property;


import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.UIManager;

import extras.*;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;

import userMenus.LogIn;
import javax.swing.Icon;
import javax.swing.border.TitledBorder;

public class PropertyForm {

	
	//Graphical input  variables //
	public static JFrame frmPropertyForm;
	
	// Text Boxes Variable: //
	public static JTextField txtPlotID;
	public static JTextField txtPlotNo;
	public static JTextField txtPlotName;
	public static JTextField txtLandUse;
	public static JTextField txtPerChange;
	public static JTextField txtPlots;
	public static JTextField txtFloors;
	public static JTextField txtBedrooms;
	public static JTextField txtBathrooms;
	public static JTextField txtDeedNo;
	
	//CheckBoxes Variable : //
	public static JCheckBox  chckbxPropertyDelivered;
	public static JCheckBox chckbxRentalGuarantee; 	
	public static JCheckBox chckbxCommited;	
	public static JCheckBox chckbxRentalPlan; 
	public static JCheckBox TitleDeed;
	public static JCheckBox chckbxPool ;
	public static JCheckBox chckbxGarden;
	public static JCheckBox chckbxParking ;
	public static JCheckBox chckbxCentralHeading ;
	public static JCheckBox chckbxPoolHeading ;
	public static JCheckBox chckbxAirCondition ;
	public static JCheckBox chckbxBasement;
	public static JTextArea txtExtraDetails;
	
	
	
	//DropDowns //
	public static JComboBox<String> AllClasses;
	public static JComboBox<String> AllStatus;
	public static JComboBox<String> AllParcels;
	
	public static boolean edit =false;
	
	
	// Buttons Variables //
	private  JButton btnBack;
	private JButton btnSave;
	private JButton btnClear;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	
	
	
	
	public PropertyForm() {
		initialize();
		addButtonsFuctionalities();
		
	}

	public static void setVisible(boolean val) {
		frmPropertyForm.setVisible(val);
	}
	
	public static void setPlotID() {

		ResultSet rs;
		try {
			rs = LogIn.database.getStatement().executeQuery("SELECT MAX(plotID)  FROM Property");

			if (rs.next() && rs.getString(1)!=null) {
				
					txtPlotID.setText((rs.getInt(1) + 1)+"");

			} else {
				txtPlotID.setText("1");
			}
		} catch (SQLException e) {
			System.out.println("PlotID set query");
			e.printStackTrace();
		}
	}
	
	private void addButtonsFuctionalities(){
		
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PropertyClearButton.start();
				frmPropertyForm.setVisible(false);
			}
		});
		
		btnClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PropertyClearButton.start();
			}
		});
		
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new PropertySaveButton().start();
			}
		});
		
		
	}
	
	private void initialize() {
		
		
		//Look and Feel : //
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {}
		
		frmPropertyForm = new JFrame();
		frmPropertyForm.getContentPane().setBackground(new Color(255, 255, 255));
		frmPropertyForm.setTitle("Property Form");
		frmPropertyForm.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		
		// Labels For Outer Panel 1: //
		ImageIcon image = new ImageIcon("aphrodite-resort-logo.png");
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 128)));
		panel_2.setBackground(new Color(211, 211, 211));
		
		panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 128), 3), "Property Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		panel_4.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 128), 3), "Features", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		
		//Outer Panel Positions : //
		
		GroupLayout groupLayout = new GroupLayout(frmPropertyForm.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(34)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 580, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 382, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
					.addGap(87))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(76)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE))
					.addContainerGap(133, Short.MAX_VALUE))
		);
		panel_4.setLayout(null);
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(16, 23, 350, 492);
		panel_4.add(panel_1);
		panel_1.setBackground(new Color(173, 216, 230));
		panel_1.setBorder(new LineBorder(Color.GRAY));
		
		
		
		// Labels For Panel 2 //
		JLabel lblNumberOfFloors = new JLabel("Number of Floors:");
		lblNumberOfFloors.setFont(new Font("Calibri", Font.PLAIN, 14));
		JLabel lblBedrooms = new JLabel("Number of Bedrooms:");
		lblBedrooms.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblNumberOfBathrooms = new JLabel("Number of Bathrooms:");
		lblNumberOfBathrooms.setFont(new Font("Calibri", Font.PLAIN, 14));
		JLabel lblDeedNumber = new JLabel("Deed Number:");
		lblDeedNumber.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		JLabel lblExtraFeatures = new JLabel("Extra Features:");
		lblExtraFeatures.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		
		JLabel lblStandarFeatures = new JLabel("Standart Features:");
		lblStandarFeatures.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		
		// Text - Check Boxes For Panel 2: //
		txtFloors = new JTextField();
		txtFloors.setColumns(10);
		txtBedrooms = new JTextField();
		txtBedrooms.setColumns(10);
		txtBathrooms = new JTextField();
		txtBathrooms.setColumns(10);
		txtDeedNo = new JTextField();
		txtDeedNo.setColumns(10);
		TitleDeed = new JCheckBox("TitleDeed");
		TitleDeed.setFont(new Font("Calibri", Font.PLAIN, 14));
		TitleDeed.setBackground(new Color(173, 216, 230));
		chckbxPool = new JCheckBox("Pool");
		chckbxPool.setFont(new Font("Calibri", Font.PLAIN, 14));
		chckbxPool.setBackground(new Color(173, 216, 230));
		chckbxGarden = new JCheckBox("Garden");
		chckbxGarden.setFont(new Font("Calibri", Font.PLAIN, 14));
		chckbxGarden.setBackground(new Color(173, 216, 230));
		chckbxParking = new JCheckBox("Parking");
		chckbxParking.setFont(new Font("Calibri", Font.PLAIN, 14));
		chckbxParking.setBackground(new Color(173, 216, 230));
		chckbxCentralHeading = new JCheckBox("Central Heading");
		chckbxCentralHeading.setFont(new Font("Calibri", Font.PLAIN, 14));
		chckbxCentralHeading.setBackground(new Color(173, 216, 230));
		chckbxPoolHeading = new JCheckBox("Pool Heading");
		chckbxPoolHeading.setFont(new Font("Calibri", Font.PLAIN, 14));
		chckbxPoolHeading.setBackground(new Color(173, 216, 230));
		chckbxAirCondition = new JCheckBox("Air-Condition Units");
		chckbxAirCondition.setFont(new Font("Calibri", Font.PLAIN, 14));
		chckbxAirCondition.setBackground(new Color(173, 216, 230));
		chckbxBasement = new JCheckBox("Basement");
		chckbxBasement.setFont(new Font("Calibri", Font.PLAIN, 14));
		chckbxBasement.setBackground(new Color(173, 216, 230));
		
		
		// Panel 2 Positioning: //
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNumberOfBathrooms)
								.addComponent(lblNumberOfFloors)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
									.addComponent(lblStandarFeatures)
									.addComponent(lblBedrooms))))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(29)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(chckbxBasement)
								.addComponent(lblExtraFeatures)
								.addComponent(chckbxPool)
								.addComponent(chckbxPoolHeading)
								.addComponent(chckbxParking)
								.addComponent(TitleDeed)
								.addComponent(lblDeedNumber))))
					.addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(chckbxAirCondition)
						.addComponent(txtBathrooms, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtBedrooms, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtFloors, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(chckbxGarden)
						.addComponent(txtDeedNo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(chckbxCentralHeading))
					.addContainerGap(38, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(16)
					.addComponent(lblStandarFeatures)
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtFloors, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNumberOfFloors))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtBedrooms, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBedrooms))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtBathrooms, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNumberOfBathrooms))
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(71)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(chckbxAirCondition)
								.addComponent(chckbxBasement)))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(18)
							.addComponent(lblExtraFeatures)))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(chckbxPool)
						.addComponent(chckbxGarden))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(chckbxPoolHeading)
							.addGap(18)
							.addComponent(chckbxParking)
							.addGap(18)
							.addComponent(TitleDeed))
						.addComponent(chckbxCentralHeading))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtDeedNo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDeedNumber))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
			panel_3.setLayout(null);
		
			// Panels //
			JPanel panel = new JPanel();
			panel.setBounds(333, 70, 186, 230);
			panel.setBackground(new Color(173, 216, 230));
			panel.setBorder(new LineBorder(Color.GRAY));
			JPanel panelDetails = new JPanel();
			panelDetails.setBounds(17, 23, 545, 481);
			panel_3.add(panelDetails);
			panelDetails.setBackground(new Color(173, 216, 230));
			panelDetails.setBorder(new LineBorder(new Color(0, 0, 128)));
			
					// DropDownList: //
					AllClasses = new JComboBox<String>();
					AllClasses.setBounds(111, 145, 194, 27);
					ListManager.setUpTwoColumnsList(AllClasses, Query.CLASS_NO_NAME);
					
					
					// Labels For Panel 1: //
					JLabel lblPlotID = new JLabel("Plot ID:");
					lblPlotID.setBounds(22, 30, 42, 18);
					lblPlotID.setFont(new Font("Calibri", Font.PLAIN, 14));
					JLabel lblNo = new JLabel("Plot Number:");
					lblNo.setBounds(22, 70, 75, 18);
					lblNo.setFont(new Font("Calibri", Font.PLAIN, 14));
					JLabel lblName = new JLabel("Plot Name:");
					lblName.setBounds(22, 110, 63, 18);
					lblName.setFont(new Font("Calibri", Font.PLAIN, 14));
					JLabel lblClass = new JLabel("Property Class:");	
					lblClass.setBounds(22, 148, 83, 18);
					lblClass.setFont(new Font("Calibri", Font.PLAIN, 14));
					JLabel lblParcel = new JLabel("Parcel:");
					lblParcel.setBounds(22, 187, 39, 18);
					lblParcel.setFont(new Font("Calibri", Font.PLAIN, 14));
					JLabel lblLand = new JLabel("Land Use:");
					lblLand.setBounds(22, 223, 55, 24);
					lblLand.setFont(new Font("Calibri", Font.PLAIN, 14));
					JLabel lblN = new JLabel("Percentage");
					lblN.setBounds(22, 268, 65, 18);
					lblN.setFont(new Font("Calibri", Font.PLAIN, 14));
					JLabel lblPlots = new JLabel("Plots:");
					lblPlots.setBounds(22, 314, 31, 18);
					lblPlots.setFont(new Font("Calibri", Font.PLAIN, 14));
					JLabel lblDetails = new JLabel("Details:");
					lblDetails.setBounds(22, 349, 43, 18);
					lblDetails.setFont(new Font("Calibri", Font.PLAIN, 14));
					JLabel lblOtherInfo = new JLabel("Other Info:");
					lblOtherInfo.setBounds(333, 35, 62, 18);
					lblOtherInfo.setFont(new Font("Calibri", Font.PLAIN, 14));
					
					
					// Text Boxes For Panel 1 : //
					txtPlotID = new JTextField();
					txtPlotID.setBounds(111, 25, 194, 28);
					txtPlotID.setEditable(false);
					txtPlotID.setColumns(15);
					
					
					txtPlotNo = new JTextField();
					txtPlotNo.setBounds(111, 65, 194, 28);
					txtPlotNo.setColumns(15);
					
						txtPlotName = new JTextField();
						txtPlotName.setBounds(111, 105, 194, 28);
						txtPlotName.setColumns(15);
						
						txtLandUse = new JTextField();
						txtLandUse.setBounds(111, 223, 194, 28);
						txtLandUse.setColumns(15);
						
						txtPerChange = new JTextField();
						txtPerChange.setBounds(111, 263, 194, 28);
						txtPerChange.setColumns(15);
						
						txtPlots = new JTextField();
						txtPlots.setBounds(111, 309, 194, 28);
						txtPlots.setColumns(15);
						
						txtExtraDetails = new JTextArea();
						txtExtraDetails.setBounds(22, 373, 497, 100);
						txtExtraDetails.setLineWrap(true);
						
						 AllParcels = new JComboBox<String>();
						 AllParcels.setBounds(111, 184, 194, 27);
						 ListManager.setUpTwoColumnsList(AllParcels, Query.PARCEL_NO_NAME);
						 
						 //Labels For Inner Panel: //
						 JLabel lblPropertyStatus = new JLabel("Property Status:");
						 lblPropertyStatus.setBounds(18, 145, 91, 18);
						 lblPropertyStatus.setFont(new Font("Calibri", Font.PLAIN, 14));
						 
						 //Check Boxes For Inner Panel : //
						  chckbxPropertyDelivered = new JCheckBox("Property Delivered");
						  chckbxPropertyDelivered.setBounds(26, 23, 138, 23);
						  chckbxPropertyDelivered.setBackground(new Color(173, 216, 230));
						  chckbxPropertyDelivered.setFont(new Font("Calibri", Font.PLAIN, 14));
						  chckbxRentalGuarantee = new JCheckBox("Rental Guarantee");
						  chckbxRentalGuarantee.setBounds(26, 52, 133, 23);
						  chckbxRentalGuarantee.setBackground(new Color(173, 216, 230));
						  chckbxRentalGuarantee.setFont(new Font("Calibri", Font.PLAIN, 14));
						  chckbxCommited = new JCheckBox("Committed");
						  chckbxCommited.setBounds(26, 81, 95, 23);
						  chckbxCommited.setBackground(new Color(173, 216, 230));
						  chckbxCommited.setFont(new Font("Calibri", Font.PLAIN, 14));
						  chckbxRentalPlan = new JCheckBox("Rental Plan");
						  chckbxRentalPlan.setBounds(26, 110, 96, 23);
						  chckbxRentalPlan.setBackground(new Color(173, 216, 230));
						  chckbxRentalPlan.setFont(new Font("Calibri", Font.PLAIN, 14));
						  
						  AllStatus = new JComboBox<String>();
						  AllStatus.setBounds(18, 181, 146, 27);
						  ListManager.setUpTwoColumnsList(AllStatus, Query.STATUS_NO_NAME);
						  AllParcels.setSelectedIndex(0);
						  AllStatus.setSelectedIndex(0);
						  AllClasses.setSelectedIndex(0);
						  panelDetails.setLayout(null);
						  panelDetails.add(lblDetails);
						  panelDetails.add(lblNo);
						  panelDetails.add(lblName);
						  panelDetails.add(lblClass);
						  panelDetails.add(lblPlotID);
						  panelDetails.add(lblParcel);
						  panelDetails.add(lblLand);
						  panelDetails.add(lblN);
						  panelDetails.add(lblPlots);
						  panelDetails.add(txtPlots);
						  panelDetails.add(AllParcels);
						  panelDetails.add(txtPerChange);
						  panelDetails.add(txtPlotName);
						  panelDetails.add(txtPlotNo);
						  panelDetails.add(txtLandUse);
						  panelDetails.add(txtPlotID);
						  panelDetails.add(AllClasses);
						  panelDetails.add(lblOtherInfo);
						  panelDetails.add(panel);
						  panel.setLayout(null);
						  panel.add(chckbxRentalGuarantee);
						  panel.add(chckbxCommited);
						  panel.add(chckbxRentalPlan);
						  panel.add(chckbxPropertyDelivered);
						  panel.add(AllStatus);
						  panel.add(lblPropertyStatus);
						  panelDetails.add(txtExtraDetails);
		btnClear = new JButton("Clear");
		btnClear.setBounds(52, 391, 111, 23);
		panel_2.add(btnClear);
		
		// Buttons : //
		btnSave = new JButton("Save");
		btnSave.setBounds(52, 357, 111, 23);
		panel_2.add(btnSave);
		btnBack = new JButton("Back");
		btnBack.setBounds(53, 436, 110, 23);
		panel_2.add(btnBack);
		
		
		
		frmPropertyForm.getContentPane().setLayout(groupLayout);
		frmPropertyForm.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		
		
		try{
		}catch(Exception e){
			System.out.println("Nothing");
			e.printStackTrace();
		}
	}
	
	

	
	
	
	
	public static void main(String[] args) {
		
					@SuppressWarnings("unused")
					PropertyForm window = new PropertyForm();
					PropertyForm.setVisible(true);
	}
}
	





	
	
	
	
