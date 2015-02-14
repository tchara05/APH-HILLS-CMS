package security;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class SecurityForm extends JPanel {

private JFrame frmSecurityForm;
	
	public static void main(String[] args) {
		
		SecurityForm window = new SecurityForm();
		window.frmSecurityForm.setVisible(true);
	}
	
	public SecurityForm() {
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
		frmSecurityForm = new JFrame();
		frmSecurityForm.setTitle("Security Menu");
		frmSecurityForm.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		
		frmSecurityForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSecurityForm.getContentPane().setLayout(null);
		ImageIcon image = new ImageIcon("aphrodite-resort-logo.png");
		JLabel lblNewLabel = new JLabel(image);
		lblNewLabel.setBackground(Color.BLACK);
		
	}

}
