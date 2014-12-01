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


public class ManagePropForm implements Runnable {

	private static JFrame ManagePropFrame;
	private JPanel contentPane;
	public static JList list;

	/**
	 * Launch the application.
	 * @wbp.parser.entryPoint
	 */
	public static void main(String[] args) {
		ManagePropForm  viewMane= new ManagePropForm();
		EventQueue.invokeLater(viewMane);
	//	viewMane.run();
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public ManagePropForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	@SuppressWarnings({ "unchecked", "serial", "rawtypes" })
	private void initialize() {
		ManagePropFrame = new JFrame();
		ManagePropFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ManagePropFrame.setBounds(100, 100, 518, 439);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		ManagePropFrame.setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblManageProperty = new JLabel("MANAGE PROPERTIES");
		lblManageProperty.setBounds(134, 51, 205, 20);
		lblManageProperty.setForeground(Color.BLACK);
		lblManageProperty.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblManageProperty);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 140, 365, 135);
		contentPane.add(scrollPane);

		list = new JList();
		scrollPane.setViewportView(list);
		list.setModel(new AbstractListModel() {
			String[] values = new String[MainForm.getProperties().size()];
			{
				if (values.length != 0)
					for (int i = 0; i < MainForm.getProperties().size(); i++) {
						values[i] = MainForm.getProperties().get(i).getPlotID();
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

		JButton btnNewButton_2 = new JButton("DELETE SELECTED PROPERTY");
		btnNewButton_2.setBounds(53, 321, 177, 23);
	
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_1 = new JButton("EDIT SELECTED PROPERT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1.setBounds(53, 287, 177, 23);



			

		contentPane.add(btnNewButton_1);

		ImageIcon input = new ImageIcon(getClass().getResource(
				"aphrodite_small.png"));

		JLabel lblNewLabel = new JLabel(input);
		lblNewLabel.setBounds(23, 15, 96, 88);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("PlotID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(53, 115, 84, 14);
		contentPane.add(lblNewLabel_1);

		JButton btnGoBack = new JButton("GO BACK");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManagePropFrame.setVisible(false);
				
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
	
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public static void setVisible(boolean f){
		
		ManagePropFrame.setVisible(true);
		
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void run() {
		
		
			ManagePropFrame.setVisible(true);
		// TODO Auto-generated method stub
		
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public static JList getList() {
		return list;
	}
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public static void callRepaint() {
		ManagePropForm.ManagePropFrame.revalidate();
		ManagePropForm.ManagePropFrame.repaint();
	}

}

