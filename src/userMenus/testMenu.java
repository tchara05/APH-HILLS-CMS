package userMenus;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

import property.PropertyMenu;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class testMenu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testMenu window = new testMenu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public testMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 604, 389);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		final JPanel panel = new JPanel();
		panel.setBounds(44, 75, 112, 187);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		

		final JPanel panel_1 = new JPanel();
		panel_1.setBounds(186, 75, 335, 187);
		frame.getContentPane().add(panel_1);
		
		panel_1.setLayout(null);
		
		
		
		JButton btnNewButton = new JButton("c");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_1.show();
			//	panel_1.setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 34, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("d");
		btnNewButton_1.setBounds(10, 71, 89, 23);
		panel.add(btnNewButton_1);
		
	}
}
