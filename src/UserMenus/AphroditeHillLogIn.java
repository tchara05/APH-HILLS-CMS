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
		
		ImageIcon image = new ImageIcon("img/aphrodite-resort-logo.png");
		
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
					.addComponent(lblIcon, GroupLayout.PREFERRED_SIZE, 549, GroupLayout.PREFERRED_SIZE)
					.addGap(429))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(560)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 361, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(519, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addComponent(lblIcon, GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
					.addGap(36)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
					.addGap(288))
		);
		
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
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblUsername)
						.addComponent(lblPassword))
					.addGap(65)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtPassword, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
						.addComponent(txtUserName, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
					.addContainerGap(64, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(60)
					.addComponent(btnLogIn, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnHelp, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(63, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(43)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtUserName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUsername))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPassword)
						.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLogIn)
						.addComponent(btnHelp))
					.addContainerGap(87, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		frmAphroditeHill.getContentPane().setLayout(groupLayout);
		frmAphroditeHill.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		frmAphroditeHill.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
