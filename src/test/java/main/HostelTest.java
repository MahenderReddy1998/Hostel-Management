package main;

import static org.junit.Assert.*;

import org.junit.Test;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import main.Hostel;
public class HostelTest {

	public String givenCorrect() {
		  
	    int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 10;
	    Random random = new Random();
	    StringBuilder buffer = new StringBuilder(targetStringLength);
	    for (int i = 0; i < targetStringLength; i++) {
	        int randomLimitedInt = leftLimit + (int) 
	          (random.nextFloat() * (rightLimit - leftLimit + 1));
	        buffer.append((char) randomLimitedInt);
	    }
	    String generatedString = buffer.toString();
	 
	    return generatedString;
	}
	Hostel h;
	@SuppressWarnings("static-access")
	@Test
	public void hostelAllotTest() throws IOException {
		BufferedWriter out = null;
		String test="";
		 try {
             out = new BufferedWriter(new FileWriter("hostel.txt", true));
             test = givenCorrect();    
             out.write(test+" "+1);
                 out.newLine();
         } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
             if(out!=null){
                 out.close();
             }
         }	
		 h.allotHostel();
		 boolean chk= true;
			try{
	       		BufferedReader br = new BufferedReader(new FileReader("allotedhostel.txt"));
	                   
	            String line = null;
	           while ((line = br.readLine()) != null) {
	               String[] splited = line.split("\\s+");
	                   if(splited[0].equals(test)){
	                	  chk = false;
	                	   assertEquals(test,splited[0]);
	                	   break;
	                   }
	               }
	           }catch(Exception e){
	               System.out.println(e);
	           }
			if(chk) {
				assertEquals("test1","xw");
			}
	}
}
