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
		JPanel panel_1 = new JPanel();
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
		
			// Panels //
			JPanel panel = new JPanel();
			panel.setBackground(new Color(173, 216, 230));
			panel.setBorder(new LineBorder(Color.GRAY));
			JPanel panelDetails = new JPanel();
			panel_3.add(panelDetails);
			panelDetails.setBackground(new Color(173, 216, 230));
			panelDetails.setBorder(new LineBorder(new Color(0, 0, 128)));
			
					// DropDownList: //
					AllClasses = new JComboBox<String>();
					ListManager.setUpTwoColumnsList(AllClasses, Query.CLASS_NO_NAME);
					
					
					// Labels For Panel 1: //
					JLabel lblPlotID = new JLabel("Plot ID:");
					lblPlotID.setFont(new Font("Calibri", Font.PLAIN, 14));
					JLabel lblNo = new JLabel("Plot Number:");
					lblNo.setFont(new Font("Calibri", Font.PLAIN, 14));
					JLabel lblName = new JLabel("Plot Name:");
					lblName.setFont(new Font("Calibri", Font.PLAIN, 14));
					JLabel lblClass = new JLabel("Property Class:");	
					lblClass.setFont(new Font("Calibri", Font.PLAIN, 14));
					JLabel lblParcel = new JLabel("Parcel:");
					lblParcel.setFont(new Font("Calibri", Font.PLAIN, 14));
					JLabel lblLand = new JLabel("Land Use:");
					lblLand.setFont(new Font("Calibri", Font.PLAIN, 14));
					JLabel lblN = new JLabel("Percentage");
					lblN.setFont(new Font("Calibri", Font.PLAIN, 14));
					JLabel lblPlots = new JLabel("Plots:");
					lblPlots.setFont(new Font("Calibri", Font.PLAIN, 14));
					JLabel lblDetails = new JLabel("Details:");
					lblDetails.setFont(new Font("Calibri", Font.PLAIN, 14));
					JLabel lblOtherInfo = new JLabel("Other Info:");
					lblOtherInfo.setFont(new Font("Calibri", Font.PLAIN, 14));
					
					
					// Text Boxes For Panel 1 : //
					txtPlotID = new JTextField();
					txtPlotID.setEditable(false);
					txtPlotID.setColumns(15);
					
					
					txtPlotNo = new JTextField();
					txtPlotNo.setColumns(15);
					
						txtPlotName = new JTextField();
						txtPlotName.setColumns(15);
						
						txtLandUse = new JTextField();
						txtLandUse.setColumns(15);
						
						txtPerChange = new JTextField();
						txtPerChange.setColumns(15);
						
						txtPlots = new JTextField();
						txtPlots.setColumns(15);
						
						txtExtraDetails = new JTextArea();
						txtExtraDetails.setLineWrap(true);
						
						 AllParcels = new JComboBox<String>();
						 ListManager.setUpTwoColumnsList(AllParcels, Query.PARCEL_NO_NAME);
						 
	
						 // Panel 1 Positions: //
						 GroupLayout gl_panelDetails = new GroupLayout(panelDetails);
						 gl_panelDetails.setHorizontalGroup(
						 	gl_panelDetails.createParallelGroup(Alignment.LEADING)
						 		.addGroup(gl_panelDetails.createSequentialGroup()
						 			.addGap(21)
						 			.addGroup(gl_panelDetails.createParallelGroup(Alignment.LEADING)
						 				.addComponent(lblDetails)
						 				.addGroup(gl_panelDetails.createSequentialGroup()
						 					.addGroup(gl_panelDetails.createParallelGroup(Alignment.LEADING)
						 						.addComponent(lblNo)
						 						.addComponent(lblName)
						 						.addComponent(lblClass)
						 						.addComponent(lblPlotID)
						 						.addComponent(lblParcel)
						 						.addComponent(lblLand)
						 						.addComponent(lblN)
						 						.addComponent(lblPlots))
						 					.addPreferredGap(ComponentPlacement.RELATED)
						 					.addGroup(gl_panelDetails.createParallelGroup(Alignment.LEADING)
						 						.addComponent(txtPlots)
						 						.addGroup(gl_panelDetails.createParallelGroup(Alignment.LEADING, false)
						 							.addComponent(AllParcels, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						 							.addComponent(txtPerChange)
						 							.addComponent(txtPlotName)
						 							.addComponent(txtPlotNo)
						 							.addComponent(txtLandUse)
						 							.addComponent(txtPlotID)
						 							.addComponent(AllClasses, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						 					.addGap(62)
						 					.addGroup(gl_panelDetails.createParallelGroup(Alignment.LEADING)
						 						.addComponent(lblOtherInfo)
						 						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)))
						 				.addComponent(txtExtraDetails, GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE))
						 			.addGap(36))
						 );
						 gl_panelDetails.setVerticalGroup(
						 	gl_panelDetails.createParallelGroup(Alignment.LEADING)
						 		.addGroup(gl_panelDetails.createSequentialGroup()
						 			.addGap(24)
						 			.addGroup(gl_panelDetails.createParallelGroup(Alignment.BASELINE)
						 				.addComponent(lblPlotID)
						 				.addComponent(txtPlotID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						 				.addComponent(lblOtherInfo))
						 			.addPreferredGap(ComponentPlacement.UNRELATED)
						 			.addGroup(gl_panelDetails.createParallelGroup(Alignment.LEADING)
						 				.addGroup(gl_panelDetails.createSequentialGroup()
						 					.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						 					.addGap(32))
						 				.addGroup(gl_panelDetails.createSequentialGroup()
						 					.addGroup(gl_panelDetails.createParallelGroup(Alignment.BASELINE)
						 						.addComponent(lblNo)
						 						.addComponent(txtPlotNo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						 					.addPreferredGap(ComponentPlacement.UNRELATED)
						 					.addGroup(gl_panelDetails.createParallelGroup(Alignment.BASELINE)
						 						.addComponent(lblName)
						 						.addComponent(txtPlotName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						 					.addPreferredGap(ComponentPlacement.UNRELATED)
						 					.addGroup(gl_panelDetails.createParallelGroup(Alignment.BASELINE)
						 						.addComponent(lblClass)
						 						.addComponent(AllClasses, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						 					.addGap(12)
						 					.addGroup(gl_panelDetails.createParallelGroup(Alignment.BASELINE)
						 						.addComponent(lblParcel)
						 						.addComponent(AllParcels, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						 					.addPreferredGap(ComponentPlacement.UNRELATED)
						 					.addGroup(gl_panelDetails.createParallelGroup(Alignment.LEADING)
						 						.addComponent(lblLand, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						 						.addComponent(txtLandUse, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						 					.addPreferredGap(ComponentPlacement.UNRELATED)
						 					.addGroup(gl_panelDetails.createParallelGroup(Alignment.BASELINE)
						 						.addComponent(txtPerChange, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						 						.addComponent(lblN))
						 					.addGap(18)
						 					.addGroup(gl_panelDetails.createParallelGroup(Alignment.BASELINE)
						 						.addComponent(lblPlots)
						 						.addComponent(txtPlots, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						 			.addPreferredGap(ComponentPlacement.UNRELATED)
						 			.addComponent(lblDetails)
						 			.addGap(18)
						 			.addComponent(txtExtraDetails, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
						 			.addContainerGap())
						 );
						 
						 //Labels For Inner Panel: //
						 JLabel lblPropertyStatus = new JLabel("Property Status:");
						 lblPropertyStatus.setFont(new Font("Calibri", Font.PLAIN, 14));
						 
						 //Check Boxes For Inner Panel : //
						  chckbxPropertyDelivered = new JCheckBox("Property Delivered");
						  chckbxPropertyDelivered.setBackground(new Color(173, 216, 230));
						  chckbxPropertyDelivered.setFont(new Font("Calibri", Font.PLAIN, 14));
						  chckbxRentalGuarantee = new JCheckBox("Rental Guarantee");
						  chckbxRentalGuarantee.setBackground(new Color(173, 216, 230));
						  chckbxRentalGuarantee.setFont(new Font("Calibri", Font.PLAIN, 14));
						  chckbxCommited = new JCheckBox("Committed");
						  chckbxCommited.setBackground(new Color(173, 216, 230));
						  chckbxCommited.setFont(new Font("Calibri", Font.PLAIN, 14));
						  chckbxRentalPlan = new JCheckBox("Rental Plan");
						  chckbxRentalPlan.setBackground(new Color(173, 216, 230));
						  chckbxRentalPlan.setFont(new Font("Calibri", Font.PLAIN, 14));
						  
						  AllStatus = new JComboBox<String>();
						  ListManager.setUpTwoColumnsList(AllStatus, Query.STATUS_NO_NAME);
						  // Positions: //
						  GroupLayout gl_panel = new GroupLayout(panel);
						  gl_panel.setHorizontalGroup(
						  	gl_panel.createParallelGroup(Alignment.LEADING)
						  		.addGroup(gl_panel.createSequentialGroup()
						  			.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						  				.addGroup(gl_panel.createSequentialGroup()
						  					.addGap(25)
						  					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						  						.addComponent(chckbxRentalGuarantee)
						  						.addComponent(chckbxCommited)
						  						.addComponent(chckbxRentalPlan)
						  						.addComponent(chckbxPropertyDelivered)))
						  				.addGroup(gl_panel.createSequentialGroup()
						  					.addGap(17)
						  					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						  						.addComponent(AllStatus, 0, 155, Short.MAX_VALUE)
						  						.addComponent(lblPropertyStatus))))
						  			.addGap(32))
						  );
						  gl_panel.setVerticalGroup(
						  	gl_panel.createParallelGroup(Alignment.LEADING)
						  		.addGroup(gl_panel.createSequentialGroup()
						  			.addGap(22)
						  			.addComponent(chckbxPropertyDelivered)
						  			.addPreferredGap(ComponentPlacement.RELATED)
						  			.addComponent(chckbxRentalGuarantee)
						  			.addPreferredGap(ComponentPlacement.RELATED)
						  			.addComponent(chckbxCommited)
						  			.addPreferredGap(ComponentPlacement.RELATED)
						  			.addComponent(chckbxRentalPlan)
						  			.addGap(12)
						  			.addComponent(lblPropertyStatus)
						  			.addGap(18)
						  			.addComponent(AllStatus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						  			.addContainerGap(21, Short.MAX_VALUE))
						  );
						  panel.setLayout(gl_panel);
						  panelDetails.setLayout(gl_panelDetails);
						  AllParcels.setSelectedIndex(0);
						  AllStatus.setSelectedIndex(0);
						  AllClasses.setSelectedIndex(0);
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
	





