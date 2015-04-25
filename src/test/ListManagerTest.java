package test;

import static org.junit.Assert.*;

import javax.swing.JComboBox;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import extras.ListManager;

public class ListManagerTest {
	
	private JComboBox<String> list;

	@Before
	public void setUp() throws Exception {
		list = new JComboBox<String>();
	}

	
	@Test
	public void testUpdateJCombox() {

			String sortNames[] = new String[5];
			int control = 0;
			String temp[];
			String okNames[]={"AZAA","FFAA","KLEF","RFKLL","ZZZZ"};
			
			ListManager.UpdateList("3", "ZZ", "ZZ", list);
			ListManager.UpdateList("1", "AZ", "AA", list);
			ListManager.UpdateList("2", "FF", "AA", list);
			ListManager.UpdateList("4", "KL", "EF", list);
			ListManager.UpdateList("5", "RFK", "LL", list);
			
			for (int i=0;i<5;i++){
				sortNames[i]=list.getItemAt(i);
				temp=ListManager.SplitThreeItem(sortNames[i]);
				if (okNames[i].equals(temp[1]+temp[2])){
					control++;
				}
			}	
			assertTrue(" [OK]",control==5);		
	}
	@Test
	public void testThreeSplit(){
		
		String strs[];
		strs = ListManager.SplitThreeItem("1 2 3");
		assertTrue("[OK]",strs[0].equals("1"));
		assertTrue("[OK]",strs[1].equals("2"));
		assertTrue("[OK]",strs[2].equals("3"));
		
		strs = ListManager.SplitThreeItem("AA BB CC");
		
		assertTrue("[OK]",strs[0].equals("AA"));
		assertTrue("[OK]",strs[1].equals("BB"));
		assertTrue("[OK]",strs[2].equals("CC"));
		strs = ListManager.SplitThreeItem("1 Marios Theodoros");
		
		assertTrue("[OK]",strs[0].equals("1"));
		assertTrue("[OK]",strs[1].equals("Marios"));
		assertTrue("[OK]",strs[2].equals("Theodoros"));
		
	}
	
	@Test
	public void testTwoSplit(){
		
		String strs[];
		strs = ListManager.SplitTwoItem("1 2 3");
		
		System.out.println(strs[0]);
		System.out.println(strs[1]);
		
		assertTrue("[OK]",strs[0].equals("1"));
		assertTrue("[OK]",strs[1].equals("2 3"));
		

		
		strs = ListManager.SplitTwoItem("AA BB CC");
		
		assertTrue("[OK]",strs[0].equals("AA"));
		assertTrue("[OK]",strs[1].equals("BB CC"));
		
		strs = ListManager.SplitTwoItem("1 Marios Theodoros");
		
		assertTrue("[OK]",strs[0].equals("1"));
		assertTrue("[OK]",strs[1].equals("Marios Theodoros"));
	}
	
	
	
	
	
}
