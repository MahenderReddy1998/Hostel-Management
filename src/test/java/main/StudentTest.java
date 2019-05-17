package main;

import static org.junit.Assert.*;
import main.Hostel;

import org.junit.Test;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;	
public class StudentTest {
	Hostel h ;
	@SuppressWarnings("static-access")
	@Test
	public void studentNameTest() throws IOException {
		boolean chk = true;
		h	= new Hostel();
		
		BufferedWriter out = new BufferedWriter(new FileWriter("hostel.txt",true));
//		assertEquals(false,h.verifyName("test rNo"));
		
			try{
				out.write("tekjhgfdsst rNo");
				out.newLine();
	           }catch(Exception e){
	               //print
	               System.out.println(e);
	               
	           }finally{
	               out.close();
	           }
		
		
		assertEquals(true,h.verifyName("tekjhgfdsst"));
		
		
		
		
//		fail("Not yet implemented");
	}
	@SuppressWarnings("static-access")
	@Test
	public void studentDuplicacyTest() throws IOException{
//		boolean chk = true;
		assertEquals(false,h.verifyName("abcdef"));
	}


}
