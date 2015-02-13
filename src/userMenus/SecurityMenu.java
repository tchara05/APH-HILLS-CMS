package userMenus;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class SecurityMenu extends JPanel {

	private JFrame frmSecurityMenu;
	
	public static void main(String[] args) {
		
		SecurityMenu window = new SecurityMenu();
		window.frmSecurityMenu.setVisible(true);
	}
	
	public SecurityMenu() {
		initialize();
	}
	
	
	private void initialize() {
		
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            System.out.println("here");
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, you can set the GUI to another look and feel.
		}
		//testing111222333
		frmSecurityMenu = new JFrame();
		frmSecurityMenu.setTitle("Security Menu");
		frmSecurityMenu.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		
		frmSecurityMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon image = new ImageIcon("aphrodite-resort-logo.png");
		JLabel lblNewLabel = new JLabel(image);
		lblNewLabel.setBackground(Color.BLACK);
		
	}
}
