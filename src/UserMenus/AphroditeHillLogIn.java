package UserMenus;


import java.awt.Toolkit;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AphroditeHillLogIn {

	private JFrame frmAphroditeHill;
	private JTextField txtUserName;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

					AphroditeHillLogIn window = new AphroditeHillLogIn();
					window.frmAphroditeHill.setVisible(true);
					
					
	}				
				

	/**
	 * Create the application.
	 */
	public AphroditeHillLogIn() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAphroditeHill = new JFrame();
		frmAphroditeHill.setTitle("Aphrodite Hill");
		frmAphroditeHill.setBackground(Color.GRAY);
		frmAphroditeHill.getContentPane().setForeground(UIManager.getColor("Button.darkShadow"));
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		ImageIcon image = new ImageIcon("aphrodite-resort-logo.png");
		
		JLabel lblIcon = new JLabel(image);
		lblIcon.setBackground(UIManager.getColor("Button.foreground"));
		lblIcon.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		lblIcon.setForeground(UIManager.getColor("DesktopIcon.labelBackground"));
		lblIcon.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout groupLayout = new GroupLayout(frmAphroditeHill.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(462, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 361, GroupLayout.PREFERRED_SIZE)
							.addGap(520))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(lblIcon, GroupLayout.PREFERRED_SIZE, 549, GroupLayout.PREFERRED_SIZE)
							.addGap(429))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addComponent(lblIcon, GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
					.addGap(38)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE)
					.addGap(246))
		);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		
		JLabel lblPermision = new JLabel("Permision:");
		
		JLabel lblUsername = new JLabel("Username:");
		
		txtUserName = new JTextField();
		txtUserName.setColumns(10);
		
		txtPassword = new JPasswordField();
		
		JLabel lblPassword = new JLabel("Password:");
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnHelp = new JButton("Help");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblUsername)
								.addComponent(lblPassword)
								.addComponent(lblPermision, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
							.addGap(49)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBox, 0, 146, Short.MAX_VALUE)
								.addComponent(txtPassword, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
								.addComponent(txtUserName, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(59)
							.addComponent(btnLogIn, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnHelp, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addContainerGap(64, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(56)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPermision)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsername)
						.addComponent(txtUserName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPassword))
					.addGap(28)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnHelp)
						.addComponent(btnLogIn))
					.addContainerGap(31, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		frmAphroditeHill.getContentPane().setLayout(groupLayout);
		frmAphroditeHill.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		frmAphroditeHill.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
