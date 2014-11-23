package Forms;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;


public class ManageCustForm implements Runnable {

	private static JFrame ManageCustFrame;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		ManageCustForm  viewMane= new ManageCustForm();
		EventQueue.invokeLater(viewMane);
		viewMane.run();
	}

	/**
	 * Create the application.
	 */
	public ManageCustForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ManageCustFrame = new JFrame();
		ManageCustFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ManageCustFrame.setBounds(100, 100, 518, 439);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		ManageCustFrame.setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblManageCustomers = new JLabel("MANAGE CUSTOMERS");
		lblManageCustomers.setBounds(134, 51, 205, 20);
		lblManageCustomers.setForeground(Color.BLACK);
		lblManageCustomers.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblManageCustomers);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 140, 365, 135);
		contentPane.add(scrollPane);

	/*	final JList list = new JList();
		scrollPane.setViewportView(list);
		list.setModel(new AbstractListModel() {
			String[] values = new String[CustomerForm.allCustomers.size()];
			{
				if (values.length != 0)
					for (int i = 0; i < CustomerForm.allCustomers.size(); i++) {
						values[i] = CustomerForm.allCustomers.get(i).accountCode
								+ "  "
								+ CustomerForm.allCustomers.get(i).fname
								+ "  "
								+ CustomerForm.allCustomers.get(i).lname;
					}
			}

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index]; 
			}
		});  */

		/**
		 * Skopos tou pio kato kodikas einai na emfanizete sto xristi mia lista
		 * opou periexei olous tou pelates me to onoma kai to epitheto tous.
		 * Epilegei kapoio kai sti sinexei akolouthei tis analoges energeies gia
		 * to ti thelei na kanei.
		 * 
		 */

		JButton btnRefreshListTo = new JButton("REFRESH LIST");
		btnRefreshListTo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRefreshListTo.setBounds(53, 355, 178, 23);
		btnRefreshListTo.addActionListener(new ActionListener() {

			/**
			 * Skopos tis parakato sinartisis einai to refresh. Otan o xristis
			 * kanei allages stous pelates autes den emfanizontai amesos. Ara
			 * pataei to koumpi auto gia na dei tis allages pou eginan. Gia to
			 * koumpi delete den xriazete na ginete refresh.
			 * 
			 */
			public void actionPerformed(ActionEvent e) {
		
			}
		});
		contentPane.add(btnRefreshListTo);

		JButton btnNewButton_2 = new JButton("DELETE SELECTED ITEM");
		btnNewButton_2.setBounds(53, 321, 177, 23);
	
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_1 = new JButton("EDIT SELECTED ITEM");
		btnNewButton_1.setBounds(53, 287, 177, 23);



			

		contentPane.add(btnNewButton_1);

		ImageIcon input = new ImageIcon(getClass().getResource(
				"aphrodite_small.png"));

		JLabel lblNewLabel = new JLabel(input);
		lblNewLabel.setBounds(23, 15, 96, 88);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Customer ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(53, 115, 84, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName.setBounds(147, 115, 44, 14);
		contentPane.add(lblName);

		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSurname.setBounds(201, 115, 84, 14);
		contentPane.add(lblSurname);

		JButton btnGoBack = new JButton("GO BACK");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManageCustFrame.setVisible(false);
				
			}
		});
		btnGoBack.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnGoBack.setBounds(334, 355, 84, 23);
		contentPane.add(btnGoBack);

		JButton btnNewButton = new JButton("HELP");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(334, 320, 84, 23);
		contentPane.add(btnNewButton);
	}
	
	
	public static void setVisible(boolean f){
		
		ManageCustFrame.setVisible(f);
		
	}

	@Override
	public void run() {
		
		
			ManageCustFrame.setVisible(false);
		// TODO Auto-generated method stub
		
	}

}
