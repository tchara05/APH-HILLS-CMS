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

public class PropertyForm implements Runnable {
	private JPanel contentPane;
	private JTextField PlotID;
	private JTextField PlotNumber;
	private JTextField PlotName;
	private JTextField PropertyClass;
	private JTextField Parcel;
	private JTextField LandUse;
	private JTextField PerChance;
	private JTextField Plots;
	private JTextField Details;
	private JTextField PropertyStatus;
	private JTextField DeedNumber;
	private JTextField NumberOfRooms;
	private JTextField NumberOfBathrooms;
	private JTextField NumberOfFloors;
	private JTextField NumberOfAirConditionUnits;

	private static JFrame PropertyForm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		PropertyForm  proform= new PropertyForm();
		proform.run();
		
		
		EventQueue.invokeLater(proform);
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
		PlotID.setBounds(175, 95, 220, 20);
		contentPane.add(PlotID);
		PlotID.setColumns(10);

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

		JRadioButton rdbtnIncludes = new JRadioButton("Included");
		rdbtnIncludes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnIncludes.setBounds(697, 122, 103, 23);
		contentPane.add(rdbtnIncludes);

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

		JRadioButton rdbtnHave = new JRadioButton("Included");
		rdbtnHave.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnHave.setBounds(697, 256, 103, 23);
		contentPane.add(rdbtnHave);

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

		JRadioButton rdbtnHave_1 = new JRadioButton("Included ");
		rdbtnHave_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnHave_1.setBounds(697, 283, 103, 23);
		contentPane.add(rdbtnHave_1);

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

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Included");
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnNewRadioButton_1.setBounds(175, 339, 147, 23);
		contentPane.add(rdbtnNewRadioButton_1);

		JLabel lblParking = new JLabel("Parking :");
		lblParking.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblParking.setBounds(481, 340, 120, 21);
		contentPane.add(lblParking);

		JRadioButton rdbtnHave_2 = new JRadioButton("Included ");
		rdbtnHave_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnHave_2.setBounds(697, 342, 97, 23);
		contentPane.add(rdbtnHave_2);

		JLabel lblRentalGuarantee = new JLabel("Rental Guarantee :");
		lblRentalGuarantee.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRentalGuarantee.setBounds(15, 368, 120, 14);
		contentPane.add(lblRentalGuarantee);

		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Included");
		rdbtnNewRadioButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnNewRadioButton_2.setBounds(175, 364, 112, 23);
		contentPane.add(rdbtnNewRadioButton_2);

		JLabel lblPoolHeading = new JLabel("Pool Heading :");
		lblPoolHeading.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPoolHeading.setBounds(481, 365, 129, 20);
		contentPane.add(lblPoolHeading);

		JRadioButton rdbtnNewRadioButton_9 = new JRadioButton("Included");
		rdbtnNewRadioButton_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnNewRadioButton_9.setBounds(697, 368, 103, 23);
		contentPane.add(rdbtnNewRadioButton_9);

		JLabel lblCommitted = new JLabel("Committed :");
		lblCommitted.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCommitted.setBounds(15, 393, 120, 14);
		contentPane.add(lblCommitted);

		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("Included");
		rdbtnNewRadioButton_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnNewRadioButton_4.setBounds(175, 389, 112, 23);
		contentPane.add(rdbtnNewRadioButton_4);

		JLabel lblCentralHeading = new JLabel("Central Heading :");
		lblCentralHeading.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCentralHeading.setBounds(481, 393, 147, 14);
		contentPane.add(lblCentralHeading);

		JRadioButton rdbtnNewRadioButton_11 = new JRadioButton("Included");
		rdbtnNewRadioButton_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnNewRadioButton_11.setBounds(697, 394, 97, 23);
		contentPane.add(rdbtnNewRadioButton_11);

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

		JRadioButton rdbtnNewRadioButton_13 = new JRadioButton("Included ");
		rdbtnNewRadioButton_13.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnNewRadioButton_13.setBounds(697, 420, 87, 23);
		contentPane.add(rdbtnNewRadioButton_13);

		JLabel lblRentalPlan = new JLabel("Rental Plan :");
		lblRentalPlan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRentalPlan.setBounds(15, 443, 120, 14);
		contentPane.add(lblRentalPlan);

		JRadioButton rdbtnNewRadioButton_6 = new JRadioButton("Included");
		rdbtnNewRadioButton_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnNewRadioButton_6.setBounds(175, 439, 112, 23);
		contentPane.add(rdbtnNewRadioButton_6);

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

		JRadioButton rdbtnNewRadioButton_15 = new JRadioButton("Included");
		rdbtnNewRadioButton_15.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnNewRadioButton_15.setBounds(697, 474, 97, 23);
		contentPane.add(rdbtnNewRadioButton_15);

		JButton btnOk = new JButton("ADD PROPERTY");
		btnOk.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int blank = 0;

				if (PlotID.getText().equals(""))
					blank = 1;

				if (PlotNumber.getText().equals(""))
					blank = 1;

				if (PlotName.getText().equals(""))
					blank = 1;

				if (PropertyClass.getText().equals(""))
					blank = 1;

				if (Parcel.getText().equals(""))
					blank = 1;

				if (LandUse.getText().equals(""))
					blank = 1;

				if (PerChance.getText().equals(""))
					blank = 1;

				if (Plots.getText().equals(""))
					blank = 1;

				if (Details.getText().equals(""))
					blank = 1;

				if (PropertyStatus.getText().equals(""))
					blank = 1;

				if (DeedNumber.getText().equals(""))
					blank = 1;

				if (NumberOfRooms.getText().equals(""))
					blank = 1;

				if (NumberOfBathrooms.getText().equals(""))
					blank = 1;

				if (NumberOfFloors.getText().equals(""))
					blank = 1;

				if (NumberOfAirConditionUnits.getText().equals(""))
					blank = 1;

				if (blank == 1) {
					JOptionPane.showMessageDialog(null,
							"There are empty fields. \nPlease, check again",
							"Warning", JOptionPane.WARNING_MESSAGE);
				}
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

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Included");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnNewRadioButton.setBounds(697, 99, 109, 23);
		contentPane.add(rdbtnNewRadioButton);

	}
	
	
	 public static void setVisible(boolean f){
		 
		 PropertyForm.setVisible(f);
	} 

	@Override
	public void run() {
		
			PropertyForm.setVisible(false);
		// TODO Auto-generated method stub
		
	}
}
