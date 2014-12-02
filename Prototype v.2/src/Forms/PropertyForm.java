package Forms;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;

import Threads.BtnAddProperty;

public class PropertyForm {
	private JPanel contentPane;
	private static JTextField PlotID;
	private static JTextField PlotNumber;
	private static JTextField PlotName;
	private static JTextField PropertyClass;
	private static JTextField Parcel;
	private static JTextField LandUse;
	private static JTextField PerChance;
	private static JTextField Plots;
	private static JTextField Details;
	private static JTextField PropertyStatus;
	private static JTextField DeedNumber;
	private static JTextField NumberOfRooms;
	private static JTextField NumberOfBathrooms;
	private static JTextField NumberOfFloors;
	private static JTextField NumberOfAirConditionUnits;
	private static JCheckBox PropertyDelivered; 
	private static JCheckBox RentalGuarantee;
	private static JCheckBox Commited;
	private static JCheckBox RentalPlan;
	private static JCheckBox GrandView;
	private static JCheckBox TitleDeed;
	private static JCheckBox Pool;
	private static JCheckBox Garden;
	private static JCheckBox Parking; 
	private static JCheckBox PoolHeading;
	private static JCheckBox CentralHeading; 
	private static JCheckBox AirCond;
	private static JCheckBox Basement;
	public static int plotID = 0;
	
	
	
	private static JFrame PropertyForm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		PropertyForm  proform= new PropertyForm();
		proform.initialize();
		PropertyForm.setVisible(true);
		
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

		PropertyForm = new JFrame();
		PropertyForm.setBounds(100, 100, 928, 660);
		PropertyForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		JLabel lblInsertNewProperty = new JLabel("Insert New Property");
		lblInsertNewProperty.setBounds(358, 30, 220, 36);
		lblInsertNewProperty.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblInsertNewProperty);

		JLabel lblNewLabel = new JLabel("Plot ID :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(15, 101, 97, 14);
		contentPane.add(lblNewLabel);

		PlotID = new JTextField();
		PlotID.setEditable(false);
		PlotID.setBounds(175, 95, 220, 20);
		contentPane.add(PlotID);
		PlotID.setColumns(10);
		PlotID.setText(plotID+"");

		JLabel lblGrand = new JLabel("Grand View Rights to BRM ");
		lblGrand.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGrand.setBounds(481, 101, 170, 20);
		contentPane.add(lblGrand);

		JLabel lblNewLabel_1 = new JLabel("Plot Number :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(15, 126, 97, 14);
		contentPane.add(lblNewLabel_1);

		PlotNumber = new JTextField();
		PlotNumber.setBounds(175, 126, 220, 20);
		contentPane.add(PlotNumber);
		PlotNumber.setColumns(10);

		JLabel lblTitleDeed = new JLabel("Title Deed");
		lblTitleDeed.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTitleDeed.setBounds(481, 126, 87, 14);
		contentPane.add(lblTitleDeed);

		JLabel lblPlotName = new JLabel("Plot Name :");
		lblPlotName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPlotName.setBounds(15, 158, 97, 14);
		contentPane.add(lblPlotName);

		PlotName = new JTextField();
		PlotName.setBounds(175, 157, 220, 20);
		contentPane.add(PlotName);
		PlotName.setColumns(10);

		JLabel lblDateOfTransfer = new JLabel("Date of Transfer :");
		lblDateOfTransfer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDateOfTransfer.setBounds(481, 153, 147, 14);
		contentPane.add(lblDateOfTransfer);

		String[] daysStrings = { "1", "2", "3", "4", "5", "6", "7", "8", "9",
				"10", "11", "12", "13", "14", "15", "16", "17", "18", "19",
				"20", "21", "22", "23", "24", "25", "26", "27", "28", "29",
				"30", "31" };
		JComboBox comboBox_2 = new JComboBox(daysStrings);
		comboBox_2.setBounds(697, 147, 55, 20);
		comboBox_2.setToolTipText("Day");
		contentPane.add(comboBox_2);

		comboBox_2.setSelectedIndex(4);
		String[] monthsStrings = { "January", "February", "March", "April",
				"May", "June", "July", "August", "September", "October",
				"November", "December" };
		JComboBox comboBox = new JComboBox(monthsStrings);
		comboBox.setBounds(758, 147, 81, 20);
		comboBox.setToolTipText("Month");
		contentPane.add(comboBox);

		String[] yearStrings = { "1997", "1998", "1999", "2000", "2001",
				"2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009",
				"2010", "2011", "2012", "2013", "2014" };

		JComboBox comboBox_1 = new JComboBox(yearStrings);

		comboBox_1.setBounds(849, 147, 55, 20);
		comboBox_1.setToolTipText("Year");
		contentPane.add(comboBox_1);

		JLabel lblPropertyClass = new JLabel("Property Class :");
		lblPropertyClass.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPropertyClass.setBounds(15, 189, 97, 14);
		contentPane.add(lblPropertyClass);

		PropertyClass = new JTextField();
		PropertyClass.setBounds(175, 188, 220, 20);
		contentPane.add(PropertyClass);
		PropertyClass.setColumns(10);

		JLabel lblParcel = new JLabel("Parcel :");
		lblParcel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblParcel.setBounds(15, 220, 84, 14);
		contentPane.add(lblParcel);

		Parcel = new JTextField();
		Parcel.setBounds(175, 219, 220, 20);
		contentPane.add(Parcel);
		Parcel.setColumns(10);

		JLabel lblDeedNumber = new JLabel("Deed Number :");
		lblDeedNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDeedNumber.setBounds(481, 178, 147, 14);
		contentPane.add(lblDeedNumber);

		DeedNumber = new JTextField();
		DeedNumber.setBounds(697, 178, 76, 20);
		contentPane.add(DeedNumber);
		DeedNumber.setColumns(10);

		JLabel lblLandUse = new JLabel("Land Use :");
		lblLandUse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLandUse.setBounds(15, 251, 97, 14);
		contentPane.add(lblLandUse);

		LandUse = new JTextField();
		LandUse.setBounds(175, 250, 220, 20);
		contentPane.add(LandUse);
		LandUse.setColumns(10);

		JLabel lblNumberOfRooms = new JLabel("Number of Rooms :");
		lblNumberOfRooms.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumberOfRooms.setBounds(481, 203, 147, 14);
		contentPane.add(lblNumberOfRooms);

		NumberOfRooms = new JTextField();
		NumberOfRooms.setBounds(697, 203, 76, 20);
		contentPane.add(NumberOfRooms);
		NumberOfRooms.setColumns(10);

		JLabel lblPerChance = new JLabel("Per Chance :");
		lblPerChance.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPerChance.setBounds(15, 282, 97, 14);
		contentPane.add(lblPerChance);

		PerChance = new JTextField();
		PerChance.setBounds(175, 281, 220, 20);
		contentPane.add(PerChance);
		PerChance.setColumns(10);

		JLabel lblNumberOfBathrooms = new JLabel("Number of Bathrooms :");
		lblNumberOfBathrooms.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumberOfBathrooms.setBounds(481, 225, 147, 14);
		contentPane.add(lblNumberOfBathrooms);

		NumberOfBathrooms = new JTextField();
		NumberOfBathrooms.setBounds(697, 227, 76, 20);
		contentPane.add(NumberOfBathrooms);
		NumberOfBathrooms.setColumns(10);

		JLabel lblPlots = new JLabel("Plots :");
		lblPlots.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPlots.setBounds(15, 313, 97, 14);
		contentPane.add(lblPlots);

		Plots = new JTextField();
		Plots.setBounds(175, 312, 220, 20);
		contentPane.add(Plots);
		Plots.setColumns(10);

		JLabel lblPool = new JLabel("Pool :");
		lblPool.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPool.setBounds(481, 260, 87, 14);
		contentPane.add(lblPool);

		JLabel lblDetails = new JLabel("Details :");
		lblDetails.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDetails.setBounds(15, 478, 97, 14);
		contentPane.add(lblDetails);

		Details = new JTextField();
		Details.setBounds(15, 503, 380, 105);
		contentPane.add(Details);
		Details.setColumns(10);

		JLabel lblGarden = new JLabel("Garden :");
		lblGarden.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGarden.setBounds(481, 282, 129, 14);
		contentPane.add(lblGarden);

		JLabel lblNumberOfFloors = new JLabel("Number of Floors :");
		lblNumberOfFloors.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumberOfFloors.setBounds(481, 313, 147, 14);
		contentPane.add(lblNumberOfFloors);

		NumberOfFloors = new JTextField();
		NumberOfFloors.setBounds(697, 315, 76, 20);
		contentPane.add(NumberOfFloors);
		NumberOfFloors.setColumns(10);

		JLabel lblPropertyDelivered = new JLabel("Property Delivered :");
		lblPropertyDelivered.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPropertyDelivered.setBounds(15, 343, 141, 14);
		contentPane.add(lblPropertyDelivered);

		JLabel lblParking = new JLabel("Parking :");
		lblParking.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblParking.setBounds(481, 340, 120, 21);
		contentPane.add(lblParking);

		JLabel lblRentalGuarantee = new JLabel("Rental Guarantee :");
		lblRentalGuarantee.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRentalGuarantee.setBounds(15, 368, 120, 14);
		contentPane.add(lblRentalGuarantee);

		JLabel lblPoolHeading = new JLabel("Pool Heading :");
		lblPoolHeading.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPoolHeading.setBounds(481, 365, 129, 20);
		contentPane.add(lblPoolHeading);

		JLabel lblCommitted = new JLabel("Committed :");
		lblCommitted.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCommitted.setBounds(15, 393, 120, 14);
		contentPane.add(lblCommitted);

		JLabel lblCentralHeading = new JLabel("Central Heading :");
		lblCentralHeading.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCentralHeading.setBounds(481, 393, 147, 14);
		contentPane.add(lblCentralHeading);

		JLabel lblPropertyStatus = new JLabel("Property Status :");
		lblPropertyStatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPropertyStatus.setBounds(15, 419, 117, 19);
		contentPane.add(lblPropertyStatus);

		PropertyStatus = new JTextField();
		PropertyStatus.setBounds(175, 418, 76, 20);
		contentPane.add(PropertyStatus);
		PropertyStatus.setColumns(10);

		JLabel lblAirconditionUnits = new JLabel("Air-condition Units :");
		lblAirconditionUnits.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAirconditionUnits.setBounds(481, 421, 147, 14);
		contentPane.add(lblAirconditionUnits);

		JLabel lblRentalPlan = new JLabel("Rental Plan :");
		lblRentalPlan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRentalPlan.setBounds(15, 449, 120, 14);
		contentPane.add(lblRentalPlan);

		JLabel lblNumberOfAircondition = new JLabel(
				"Number of Air-condition Units :");
		lblNumberOfAircondition.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumberOfAircondition.setBounds(481, 448, 206, 14);
		contentPane.add(lblNumberOfAircondition);

		NumberOfAirConditionUnits = new JTextField();
		NumberOfAirConditionUnits.setBounds(697, 447, 76, 20);
		contentPane.add(NumberOfAirConditionUnits);
		NumberOfAirConditionUnits.setColumns(10);

		JLabel lblBasement = new JLabel("Basement:");
		lblBasement.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBasement.setBounds(481, 473, 129, 14);
		contentPane.add(lblBasement);

		JButton btnOk = new JButton("ADD PROPERTY");
		btnOk.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new BtnAddProperty().start();
			}
		});
		btnOk.setBounds(630, 571, 129, 23);
		btnOk.setBackground(UIManager.getColor("Button.light"));
		contentPane.add(btnOk);

		JButton btnBack = new JButton("GO TO MENU");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				setVisible(false);
			}
		});
		btnBack.setBounds(773, 503, 119, 23);
		btnBack.setBackground(UIManager.getColor("Button.light"));
		contentPane.add(btnBack);

		JButton btnNewButton = new JButton("HELP");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(773, 537, 120, 23);
		contentPane.add(btnNewButton);

		JButton btnExit = new JButton("EXIT");
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnExit.setBounds(773, 571, 119, 23);
		contentPane.add(btnExit);

		PropertyForm.getContentPane().add(contentPane);
		
	     PropertyDelivered = new JCheckBox("Included");
		 PropertyDelivered.setBounds(175, 341, 97, 23);
		contentPane.add(PropertyDelivered);
		
		 RentalGuarantee = new JCheckBox("Included");
		RentalGuarantee.setBounds(175, 366, 97, 23);
		contentPane.add(RentalGuarantee);
		

		Commited = new JCheckBox("Included");
		Commited.setBounds(175, 391, 97, 23);
		contentPane.add(Commited);
		
		 RentalPlan = new JCheckBox("Included");
		RentalPlan.setBounds(175, 445, 97, 23);
		contentPane.add(RentalPlan);
		
		 GrandView = new JCheckBox("Included");
		 GrandView.setBounds(697, 99, 97, 23);
		contentPane.add(GrandView);
		
	    TitleDeed = new JCheckBox("Included");
		TitleDeed.setBounds(697, 124, 97, 23);
		contentPane.add(TitleDeed);
		
		 Pool = new JCheckBox("Included");
		 Pool.setBounds(697, 258, 97, 23);
		contentPane.add( Pool);
		
		 Garden = new JCheckBox("Included");
		Garden.setBounds(697, 280, 97, 23);
		contentPane.add(Garden);
		
		

		
		
		 Parking = new JCheckBox("Included");
		Parking.setBounds(697, 341, 97, 23);
		contentPane.add(Parking);
		
		PoolHeading = new JCheckBox("Included");
		PoolHeading.setBounds(697, 366, 97, 23);
		contentPane.add(PoolHeading);
		
	    CentralHeading= new JCheckBox("Included");
		CentralHeading.setBounds(697, 391, 97, 23);
		contentPane.add(CentralHeading);
		
		AirCond = new JCheckBox("Included");
		AirCond.setBounds(697, 419, 97, 23);
		contentPane.add(AirCond);
		
        Basement = new JCheckBox("Included");
		Basement.setBounds(697, 476, 97, 23);
		contentPane.add(Basement);

	}
	
	
	 public static void setVisible(boolean f){
		 
		 PropertyForm.setVisible(f);
	} 
	 
		
		/******************************* All Getters Here *****************************/
	 public static String getPlotID(){
			return PlotID.getText();
		}
	 
	 
		public static String getPlotNumber(){
			return PlotNumber.getText();
		}
		
		public static String getPlotName(){
			return PlotName.getText();
		}
		
		public static String getPropertyClass(){
			return PropertyClass.getText();
		}
		
		public static String getParcel(){
			return Parcel.getText();
		}
		
		public static String getLandUse(){
			return LandUse.getText();
		}
		
		public static String getPerChance(){
			return PerChance.getText();
		}
		
		public static String getPlots(){
			return Plots.getText();
		}
		
		public static String getDetails(){
			return Details.getText();
		}
		
		public static String getPropertyStatus(){
			return PropertyStatus.getText();
		}
		
		public static String getDeedNumber(){
			return DeedNumber.getText();
		}
		
		public static String getNumberOfRooms(){
			return NumberOfRooms.getText();
		}
		
		public static String getNumberOfBathrooms(){
			return NumberOfBathrooms.getText();
		}
		
		public static String getNumberOfFloors(){
			return NumberOfFloors.getText();
		}
		
		public static String getNumberOfAirConditionUnits(){
			return NumberOfAirConditionUnits.getText();
		}
		
		public static boolean getPropertyDeli() {
			return PropertyDelivered.isSelected();
		}
		
		public static boolean getRentalGuarantee() {
			return RentalGuarantee.isSelected();
		}
		
		public static boolean getCommited() {
			return Commited.isSelected();
		}
		
		public static boolean getRentalPlan() {
			return RentalPlan.isSelected();
		}
		
		public static boolean getGrandeView() {
			return GrandView.isSelected();
		}
		
		public static boolean getTitleDeed() {
			return TitleDeed.isSelected();
		}
		
		public static boolean getPool() {
			return Pool.isSelected();
		}
		
		public static boolean getGarden() {
			return Garden.isSelected();
		}
		public static boolean getParking() {
			return Parking.isSelected();
		}
		public static boolean getPoolHeading() {
			return PoolHeading.isSelected();
		}
		
		public static boolean getCentralHeading() {
			return CentralHeading.isSelected();
		}
		
		public static boolean getAirCond() {
			return AirCond.isSelected();
		}
		public static boolean getBasement(){
			return Basement.isSelected();
		}
		
		
		/******************************* All Setters Here *****************************/

		public static void setPlotID(String f){
			
			PlotID.setText(f);
		}
		
		public static void setPlotNumber(String srt){
			PlotNumber.setText(srt);
		}

		public static void setPlotName(String srt){
			PlotName.setText(srt);
		}
		
		public static void setPropertyClass(String srt){
			PropertyClass.setText(srt);
		}
		
		public static void setParcel(String srt){
			Parcel.setText(srt);
		}
		
		public static void setLandUse(String srt){
			LandUse.setText(srt);
		}
		
		public static void setPerChance(String srt){
			PerChance.setText(srt);
		}
		
		public static void setPlots(String srt){
			Plots.setText(srt);
		}
		
		public static void setDetails(String srt){
			Details.setText(srt);
		}
		
		public static void setPropertyStatus(String srt){
			PropertyStatus.setText(srt);
		}
		
		public static void setDeedNymber(String srt){
			DeedNumber.setText(srt);
		}
		
		public static void setNumberOfRooms(String srt){
			NumberOfRooms.setText(srt);
		}
		
		public static void setNumberOfBathrooms(String srt){
			NumberOfBathrooms.setText(srt);
		}
		
		public static void setNumberOfFloors(String srt){
			NumberOfFloors.setText(srt);
		}
		
		public static void setNumberOfAirConditionUnits(String srt){
			NumberOfAirConditionUnits.setText(srt);
		}
		
		public static void setPropertyDeli(boolean f) {
			 PropertyDelivered.setSelected(f);
		}
		
		public static void setRentalGuarantee(boolean f) {
			 RentalGuarantee.setSelected(f);
		}
		
		public static void setCommited(boolean f) {
			 Commited.setSelected(f);
		}	 
		
		public static void setRentalPlan(boolean f) {
			  RentalPlan.setSelected(f);
		}
		
		public static void setGrandeView(boolean f) {
			 GrandView.setSelected(f);
		}
		
		public static void setTitleDeed(boolean f) {
			TitleDeed.setSelected(f);
		}
		
		public static void setPool(boolean f) {
			Pool.setSelected(f);
		}
		
		public static void getGarden(boolean f) {
			 Garden.setSelected(f);
		}
		public static void getParking(boolean f) {
		     Parking.setSelected(f);
		}
		public static void setPoolHeading(boolean f) {
			PoolHeading.setSelected(f);
		}
		
		public static void setCentralHeading(boolean f) {
			 CentralHeading.setSelected(f);
		}
		public static void setAirCond(boolean f) {
			 AirCond.setSelected(f);
		}
		public static void setBasement(boolean f){
			Basement.setSelected(f);
		}
		public static void setGarden(boolean f){
			Garden.setSelected(f);
		}
		public static void setParking(boolean f){
			Parking.setSelected(f);
		}
		public static void setClass(String t){
			PropertyClass.setText("");
		}
		
		

		
}
