package logistics;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ExportProformaButton extends Thread {
	
	
	
	public void run(){
		
		String  folderName = new SimpleDateFormat("dd_MM_yyyy").format(Calendar.getInstance().getTime());
		File dir = new File("proforma/"+folderName);
		if (dir.mkdirs()){
			System.out.println("proformas/folderName");
		}
		
		
	}

}
