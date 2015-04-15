package logistics;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.BorderLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileChooser {

	private JFrame frame;
	static JFileChooser fileChooser ;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileChooser window = new FileChooser();
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
	public FileChooser() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 598, 411);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		fileChooser = new JFileChooser(){
			
			public void approveSelection(){
				
				File f =  fileChooser.getSelectedFile();
				
				
				Scanner s;
				try {
				
						s = new Scanner(f);
						while (s.hasNext()){
							System.out.println(s.nextLine());
						}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			
			}
			public void cancelSelection(){
				frame.setVisible(false);
			}
			
			
		};
		
		fileChooser.setAcceptAllFileFilterUsed(false);
	//	FileNameExtensionFilter filter1 = new FileNameExtensionFilter(".xls" ,"xls");
	//	FileNameExtensionFilter filter2 = new FileNameExtensionFilter(".xlsx","xlsx");
	//	fileChooser.setFileFilter(filter1);	
	//	fileChooser.setFileFilter(filter2);
		fileChooser.setBounds(43, 0, 610, 453);
		frame.getContentPane().add(fileChooser);
		
	}

}
