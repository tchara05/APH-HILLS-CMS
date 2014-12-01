package Forms;
import Threads.*;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class ManageCustForm implements Runnable{

	private static JFrame ManageCustFrame;
	private JPanel contentPane;
	public static JList list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		ManageCustForm mngCustForm = new ManageCustForm();
		EventQueue.invokeLater(mngCustForm);
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
	@SuppressWarnings({ "unchecked", "serial", "rawtypes" })
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

		
		
		
		list = new JList();
		scrollPane.setViewportView(list);
		list.setModel(new AbstractListModel() {
			String[] values = new String[MainForm.getCustomers().size()];
			{
				if (values.length != 0)
					for (int i = 0; i < MainForm.getCustomers().size(); i++) {
						values[i] = MainForm.getCustomers().get(i).getCustomerID()
								+ "  "
								+ MainForm.getCustomers().get(i).getFName()
								+ "  "
								+ MainForm.getCustomers().get(i).getLName();
					}
			}

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index]; 
			}
		});  

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


			public void actionPerformed(ActionEvent e) {
				
				new BtnRefreshCustomer().start();
		
			}
		});
		contentPane.add(btnRefreshListTo);

		JButton btnNewButton_2 = new JButton("DELETE SELECTED ITEM");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BtnDeleteCustomer().start();
			}
		});
		btnNewButton_2.setBounds(53, 321, 177, 23);
	
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_1 = new JButton("EDIT SELECTED ITEM");

		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				new BtnEditCustomer().start();
			}
		});
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

	public static JList getList() {
		return list;
	}
	
	public void run() {
		
		ManageCustFrame.setVisible(false);
		
	}
	
	public static void callRepaint() {
		ManageCustForm.ManageCustFrame.revalidate();
		ManageCustForm.ManageCustFrame.repaint();
	}

}
