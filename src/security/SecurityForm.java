package security;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class SecurityForm {

	private JFrame frame;

	/**
	 * 
	 * 
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SecurityForm window = new SecurityForm();
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
	public SecurityForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
        JPanel panel_2 = new JPanel();
		panel_2.setBorder(UIManager.getBorder("InternalFrame.border"));
		panel_2.setBounds(394, 113, 66, 203);
		contentPane.add(panel_2);
	}

}
