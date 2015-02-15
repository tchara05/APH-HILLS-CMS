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
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JButton;

import extras.*;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PropertyForm {

	
	//Graphical variables //
	
	private static JFrame frmPropertyForm;
	private static JTextField txtPlotID;
	private static JTextField txtPlotNo;
	private static JTextField txtPlotName;
	private static JTextField txtClass;
	private static JTextField txtParcel;
	private static JTextField txtLandUse;
	private static JTextField txtPerChange;
	private static JTextField txtPlots;
	private static JTextField txtStatus;
	private static JCheckBox  chckbxPropertyDelivered;
	private static JCheckBox chckbxRentalGuarantee; 	
	private static JCheckBox chckbxCommited;	
	private static JCheckBox chckbxRentalPlan; 
	private static JTextField txtFloors;
	private static JTextField txtBedrooms;
	private static JTextField txtBathrooms;
	private static JTextField txtDeedNo;
	private static JCheckBox TitleDeed;
	private static JCheckBox chckbxPool ;
	private static JCheckBox chckbxGarden;
	private static JCheckBox chckbxParking ;
	private static JCheckBox chckbxCentralHeading ;
	private static JCheckBox chckbxPoolHeading ;
	private static JCheckBox chckbxAirCondition ;
	private static JCheckBox chckbxBasement;
	private static JTextArea txtExtraDetails;
	
	protected static boolean edit =false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
					PropertyForm window = new PropertyForm();
					window.frmPropertyForm.setVisible(true);

	}

	/**
	 * Create the application.
	 */
	public PropertyForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPropertyForm = new JFrame();
		frmPropertyForm.setTitle("Property Form");
		
		frmPropertyForm.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		ImageIcon image = new ImageIcon("aphrodite-resort-logo.png");
		
		JLabel lblFormTitle = new JLabel(image);
		
		JLabel lblNewLabel = new JLabel("Insert New Property");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		
		JLabel lblPropertyDetails = new JLabel("Property Details:");
		lblPropertyDetails.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		JPanel panelDetails = new JPanel();
		panelDetails.setBorder(new LineBorder(Color.GRAY));
		
		JLabel lblFeatures = new JLabel("Features:");
		lblFeatures.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.GRAY));
		
		JButton btnSave = new JButton("Save");
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new PropertySaveButton().start();
			}
		});

		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PropertyClearButton.start();
				frmPropertyForm.setVisible(false);
			}
		});
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnClear = new JButton("Clear");
		btnClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PropertyClearButton.start();
			}
		});
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
		
		JLabel lblNumberOfFloors = new JLabel("Number of Floors:");
		
		JLabel lblBedrooms = new JLabel("Number of Bedrooms:");
		
		JLabel lblNumberOfBathrooms = new JLabel("Number of Bathrooms:");
		
		JLabel lblDeedNumber = new JLabel("Deed Number:");
		
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
		
		JLabel lblExtraFeatures = new JLabel("Extra Features:");
		lblExtraFeatures.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		
		JLabel lblStandarFeatures = new JLabel("Standart Features:");
		lblStandarFeatures.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDeedNumber)
								.addComponent(lblNumberOfBathrooms)
								.addComponent(lblBedrooms)
								.addComponent(lblNumberOfFloors))
							.addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(txtBathrooms, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtDeedNo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtBedrooms, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtFloors, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(61, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(chckbxCentralHeading)
							.addContainerGap(242, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(chckbxGarden)
							.addContainerGap(299, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(TitleDeed)
									.addPreferredGap(ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
									.addComponent(chckbxAirCondition))
								.addComponent(chckbxPool)
								.addComponent(chckbxPoolHeading)
								.addComponent(chckbxParking)
								.addComponent(chckbxBasement))
							.addContainerGap())
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblExtraFeatures)
							.addContainerGap(275, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblStandarFeatures)
							.addContainerGap(253, Short.MAX_VALUE))))
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
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtDeedNo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDeedNumber))
					.addGap(9)
					.addComponent(lblExtraFeatures)
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(TitleDeed)
						.addComponent(chckbxAirCondition))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(chckbxBasement)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(chckbxPool)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(chckbxPoolHeading)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(chckbxParking)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(chckbxCentralHeading)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(chckbxGarden)
					.addContainerGap(54, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblPlotID = new JLabel("Plot ID:");
		
		txtPlotID = new JTextField();
		txtPlotID.setEditable(false);
		txtPlotID.setColumns(15);
		
		JLabel lblNo = new JLabel("Plot Number:");
		
		txtPlotNo = new JTextField();
		txtPlotNo.setColumns(15);
		
		JLabel lblName = new JLabel("Plot Name:");
		
		txtPlotName = new JTextField();
		txtPlotName.setColumns(15);
		
		JLabel lblClass = new JLabel("Property Class:");
		
		txtClass = new JTextField();
		txtClass.setColumns(15);
		
		JLabel lblParcel = new JLabel("Parcel:");
		
		txtParcel = new JTextField();
		txtParcel.setColumns(15);
		
		JLabel lblLand = new JLabel("Land Use:");
		
		txtLandUse = new JTextField();
		txtLandUse.setColumns(15);
		
		JLabel lblN = new JLabel("Percentage");
		
		txtPerChange = new JTextField();
		txtPerChange.setColumns(15);
		
		JLabel lblPlots = new JLabel("Plots:");
		
		txtPlots = new JTextField();
		txtPlots.setColumns(15);
		
		JLabel lblDetails = new JLabel("Details:");
		
		 txtExtraDetails = new JTextArea();
		txtExtraDetails.setLineWrap(true);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.GRAY));
		
		JLabel lblOtherInfo = new JLabel("Other Info:");
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
							.addGroup(gl_panelDetails.createParallelGroup(Alignment.LEADING)
								.addComponent(txtPerChange, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtClass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtPlotName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtPlotNo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtParcel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtLandUse, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtPlots, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtPlotID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(62)
							.addGroup(gl_panelDetails.createParallelGroup(Alignment.LEADING)
								.addComponent(lblOtherInfo)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(85, Short.MAX_VALUE))
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
								.addComponent(txtClass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
		
		 chckbxPropertyDelivered = new JCheckBox("Property Delivered");
		
		 chckbxRentalGuarantee = new JCheckBox("Rental Guarantee");
		
		 chckbxCommited = new JCheckBox("Committed");
		
		 chckbxRentalPlan = new JCheckBox("Rental Plan");
		
		JLabel lblPropertyStatus = new JLabel("Property Status:");
		
		txtStatus = new JTextField();
		txtStatus.setColumns(10);
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
	
	
	/*Property Form Visibility */
	
	
	public static void setVisible(boolean val){
		
		frmPropertyForm.setVisible(val);				
	}
	
	
	
	/* All Setters for the global variables */
	
	
	public static void setPlotID(){
		 /* This is base on a query of database */
	}
	
	
	
	
	public static void setPlotNo(String val){
		txtPlotNo.setText(val);
	}
	
	public static void setPlotName (String val){
		txtPlotName.setText(val);
	}
	
	public static void setPlotClass (String val){	
		txtClass.setText(val);
	}
	
	public static void setParcel(String val){
		txtParcel.setText(val);
	}
	
	public static void setLandUse(String val){
		txtLandUse.setText(val);
	}
	
	public static void setPerChange(String val){
		txtPerChange.setText(val);
	}
	
	public static void setPlots(String val){
		txtPlots.setText(val);
	}
	
	public static void setStatus(String val){
		txtStatus.setText(val);
	}
	
	public static void setPropertyDelivered(boolean val){
	  chckbxPropertyDelivered.setSelected(val);
	}
	
	public static void setRentalGuarantte(boolean val){
		chckbxRentalGuarantee.setSelected(val); 	
	}
	public static void setCommitted(boolean val){
		chckbxCommited.setSelected(val);	
	
	}
	
	public static void setRentalPlan(boolean val){
		 chckbxRentalPlan.setSelected(val); 
	}
	
	public static void setFloors(String val){
		 txtFloors.setText(val);
		
	}
	
	public static void setBedrooms(String val){
		
		txtBedrooms.setText(val);
	}
	
	public static void setBathrooms(String val){
	 txtBathrooms.setText(val);
	}
	
	public static void setDeedNo(String val){
		txtDeedNo.setText(val);
	}
	

	public static void setTitleDeed(boolean val){
		
		TitleDeed.setSelected(val);
	}
	
		
	public static void setPool(boolean val){
		 chckbxPool.setSelected(val) ;
	}
	public static void setGarder(boolean val){
		
		chckbxGarden.setSelected(val);
		
	}
	public static void setParking(boolean val){
		chckbxParking.setSelected(val);
	}
	
	public static void setCentralHeading(boolean val){
		chckbxCentralHeading.setSelected(val);
	}
	
	public static void setPoolHeading(boolean val){
		chckbxPoolHeading.setSelected(val);
	}
	
	public static void setAirCondition(boolean val){
		chckbxAirCondition.setSelected(val);
	}
	
	public static void setBasement(boolean val){
		chckbxBasement.setSelected(val);
	}
	
	public static void settxtAreaDetails(String val){
		
		txtExtraDetails.setText(val);
		
	}
	
	
	/* All getters here */
	
	public static String getPlotID(){
		 return txtPlotID.getText();
	}
	
	
	public static String getPlotNo(){
		 return txtPlotNo.getText();
	}
	
	public static String getPlotName (){
		return txtPlotName.getText();
	}
	
	public static String getPlotClass (){	
		return txtClass.getText();
	}
	
	public static String getParcel(){
		return txtParcel.getText();
	}
	
	public static String getLandUse(){
		return  txtLandUse.getText();
	}
	
	public static String getPercentage(){
	 return	txtPerChange.getText();
	}
	
	public static String getPlots(){
		return txtPlots.getText();
	}
	
	public static String getStatus(){
		return txtStatus.getText();
	}
	
	public static boolean getPropertyDelivered(){
	  return  chckbxPropertyDelivered.isSelected();
	}
	
	public static boolean getRentalGuarantte(){
		return chckbxRentalGuarantee.isSelected(); 	
	}
	public static boolean getCommitted(){
		return chckbxCommited.isSelected();	
	
	}
	
	public static boolean getRentalPlan(){
		 return chckbxRentalPlan.isSelected(); 
	}
	
	public static String getFloors(){
		 return txtFloors.getText();
		
	}
	
	public static String getBedrooms(){
		
	 return	txtBedrooms.getText();
	}
	
	public static String getBathrooms(){
		return txtBathrooms.getText();
	}
	
	public static String getDeedNo(){
		return txtDeedNo.getText();
	}
	
	
	public static boolean getTitleDeed(){
		
		return TitleDeed.isSelected();
	}	
		
	public static boolean getPool(){
		return chckbxPool.isSelected() ;
	}
	public static boolean getGarder(){
		
		return chckbxGarden.isSelected();
		
	}
	public static boolean getParking(){
		 return chckbxParking.isSelected();
	}
	
	public static boolean getCentralHeading(){
		return chckbxCentralHeading.isSelected();
	}
	
	public static boolean getPoolHeading(){
		return chckbxPoolHeading.isSelected();
	}
	
	public static boolean getAirCondition(){
		return chckbxAirCondition.isSelected();
	}
	
	public static boolean getBasement(){
		return  chckbxBasement.isSelected();
	}
	
	public static String getDetails(){
		
		return txtExtraDetails.getText();
		
	}
	
	
	
	
	
}


	





