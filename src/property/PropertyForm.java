package property;


import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;

public class PropertyForm {

	
	//Graphical input  variables //
	public static JFrame frmPropertyForm;
	
	// Text Boxes Variable: //
	public static JTextField txtPlotID;
	public static JTextField txtPlotNo;
	public static JTextField txtPlotName;
	public static JTextField txtParcel;
	public static JTextField txtLandUse;
	public static JTextField txtPerChange;
	public static JTextField txtPlots;
	public static JTextField txtStatus;
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
	public static JComboBox AllClasses;
	protected static boolean edit =false;
	
	// Buttons Variables //
	private  JButton btnBack;
	private JButton btnSave;
	private JButton btnClear;
	
	
	
	
	
	
	public PropertyForm() {
		initialize();
		addButtonsFuctionalities();
		
	}

	public static void setVisible(boolean val) {
		frmPropertyForm.setVisible(val);
	}
	
	public static void setPlotID() {

		DatabaseConnection database = new DatabaseConnection();
		Statement st = database.getStatement();
		ResultSet rs;
		try {
			rs = st.executeQuery("SELECT MAX(plotID)  FROM Property");

			if (rs.next() && rs.getString(1)!=null) {
				
					txtPlotID.setText("" + (rs.getInt(1) + 1));

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
		frmPropertyForm.setTitle("Property Form");
		frmPropertyForm.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	
		// Panels //
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.GRAY));
		JPanel panelDetails = new JPanel();
		panelDetails.setBorder(new LineBorder(Color.GRAY));
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.GRAY));
		
		// Buttons : //
		btnSave = new JButton("Save");
		btnBack = new JButton("Back");
		btnClear = new JButton("Clear");

		// DropDownList: //
		AllClasses = new JComboBox<String>();
		ListManager.setUpTwoColumnsList(AllClasses, Query.CLASS_NO_NAME);
		
		
		// Labels For Outer Panel 1: //
		ImageIcon image = new ImageIcon("aphrodite-resort-logo.png");
		JLabel lblFormTitle = new JLabel(image);
		
		JLabel lblNewLabel = new JLabel("Insert New Property");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		
		JLabel lblPropertyDetails = new JLabel("Property Details:");
		lblPropertyDetails.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		JLabel lblFeatures = new JLabel("Features:");
		lblFeatures.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		
		//Outer Panel Positions : //
		
		GroupLayout groupLayout = new GroupLayout(frmPropertyForm.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 355, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPropertyDetails)
								.addComponent(panelDetails, GroupLayout.PREFERRED_SIZE, 610, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblFeatures)
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 383, GroupLayout.PREFERRED_SIZE))
							.addGap(56)
							.addComponent(lblFormTitle, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(btnBack, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSave, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnClear, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
							.addGap(979))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPropertyDetails)
								.addComponent(lblFeatures))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
								.addComponent(panelDetails, GroupLayout.PREFERRED_SIZE, 476, GroupLayout.PREFERRED_SIZE)))
						.addComponent(lblFormTitle, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBack)
						.addComponent(btnSave)
						.addComponent(btnClear))
					.addGap(265))
		);
		
		
		
		// Labels For Panel 2 //
		JLabel lblNumberOfFloors = new JLabel("Number of Floors:");
		JLabel lblBedrooms = new JLabel("Number of Bedrooms:");
		
		JLabel lblNumberOfBathrooms = new JLabel("Number of Bathrooms:");
		JLabel lblDeedNumber = new JLabel("Deed Number:");
		
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
		chckbxPool = new JCheckBox("Pool");
		chckbxGarden = new JCheckBox("Garden");
		chckbxParking = new JCheckBox("Parking");
		chckbxCentralHeading = new JCheckBox("Central Heading");
		chckbxPoolHeading = new JCheckBox("Pool Heading");
	    chckbxAirCondition = new JCheckBox("Air-Condition Units");
	    chckbxBasement = new JCheckBox("Basement");
		
		
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
		
		
		// Labels For Panel 1: //
		JLabel lblPlotID = new JLabel("Plot ID:");
		JLabel lblNo = new JLabel("Plot Number:");
		JLabel lblName = new JLabel("Plot Name:");
		JLabel lblClass = new JLabel("Property Class:");	
		JLabel lblParcel = new JLabel("Parcel:");
		JLabel lblLand = new JLabel("Land Use:");
		JLabel lblN = new JLabel("Percentage");
		JLabel lblPlots = new JLabel("Plots:");
		JLabel lblDetails = new JLabel("Details:");
		JLabel lblOtherInfo = new JLabel("Other Info:");
		
		
		// Text Boxes For Panel 1 : //
		txtPlotID = new JTextField();
		txtPlotID.setEditable(false);
		txtPlotID.setColumns(15);
		
		txtPlotNo = new JTextField();
		txtPlotNo.setColumns(15);
	
		txtPlotName = new JTextField();
		txtPlotName.setColumns(15);
			
		txtParcel = new JTextField();
		txtParcel.setColumns(15);
		
		txtLandUse = new JTextField();
		txtLandUse.setColumns(15);
		
		txtPerChange = new JTextField();
		txtPerChange.setColumns(15);
		
		txtPlots = new JTextField();
		txtPlots.setColumns(15);
		
		txtExtraDetails = new JTextArea();
		txtExtraDetails.setLineWrap(true);
		
	
		// Panel 1 Positions: //
		GroupLayout gl_panelDetails = new GroupLayout(panelDetails);
		gl_panelDetails.setHorizontalGroup(
			gl_panelDetails.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDetails.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_panelDetails.createParallelGroup(Alignment.LEADING)
						.addComponent(txtExtraDetails, GroupLayout.PREFERRED_SIZE, 441, GroupLayout.PREFERRED_SIZE)
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
							.addGroup(gl_panelDetails.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtPerChange)
								.addComponent(txtPlotName)
								.addComponent(txtPlotNo)
								.addComponent(txtParcel)
								.addComponent(txtLandUse)
								.addComponent(txtPlots)
								.addComponent(txtPlotID)
								.addComponent(AllClasses, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(62)
							.addGroup(gl_panelDetails.createParallelGroup(Alignment.LEADING)
								.addComponent(lblOtherInfo)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(25, Short.MAX_VALUE))
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
					.addGroup(gl_panelDetails.createParallelGroup(Alignment.LEADING, false)
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
								.addComponent(txtParcel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblParcel))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panelDetails.createParallelGroup(Alignment.LEADING)
								.addComponent(lblLand, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtLandUse, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panelDetails.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtPerChange, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblN)))
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(12)
					.addGroup(gl_panelDetails.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtPlots, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPlots))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblDetails)
					.addPreferredGap(ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
					.addComponent(txtExtraDetails, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		//Labels For Inner Panel: //
		JLabel lblPropertyStatus = new JLabel("Property Status:");
		
		//Check Boxes For Inner Panel : //
		 chckbxPropertyDelivered = new JCheckBox("Property Delivered");
		 chckbxRentalGuarantee = new JCheckBox("Rental Guarantee");
		 chckbxCommited = new JCheckBox("Committed");
		 chckbxRentalPlan = new JCheckBox("Rental Plan");
		
		// Text Boxes For Inner Panel: //
		txtStatus = new JTextField();
		txtStatus.setColumns(10);
		
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
								.addComponent(chckbxPropertyDelivered))
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(17)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPropertyStatus)
								.addComponent(txtStatus, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))))
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
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtStatus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(26, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		panelDetails.setLayout(gl_panelDetails);
		
		
		
		frmPropertyForm.getContentPane().setLayout(groupLayout);
		frmPropertyForm.setSize(Toolkit.getDefaultToolkit().getScreenSize());
	}
	
	public static void main(String[] args) {
		
					PropertyForm window = new PropertyForm();
					PropertyForm.setVisible(true);

	}


}
	





