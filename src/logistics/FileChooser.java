package logistics;

import java.awt.EventQueue;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileChooser extends JFrame {

	private JFileChooser fileChooser;
	public static File file;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileChooser window = new FileChooser();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FileChooser() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		 fileChooser = new JFileChooser(){
				public void approveSelection(){
					file =  fileChooser.getSelectedFile();
					new ReadExcelBtn().start();
				}
				public void cancelSelection(){
					hideFather();
				}
			};
			
			fileChooser.setAcceptAllFileFilterUsed(false);
			FileNameExtensionFilter filter1 = new FileNameExtensionFilter(".xls" ,"xls");
			FileNameExtensionFilter filter2 = new FileNameExtensionFilter(".xlsx","xlsx");
			fileChooser.setFileFilter(filter1);	
			fileChooser.setFileFilter(filter2);
			fileChooser.setBounds(43, 0, 610, 453);
		    this.getContentPane().add(fileChooser);
	}
	
	private  void hideFather(){
		
		this.setVisible(false);
		
	}
}
 
