package banksys.persistence;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LogData {

	
	public LogData(){
		
	}
	
	public static void record(String dir,String message){
		try {
			FileWriter arq = new FileWriter(dir,true);
			PrintWriter gravarArq = new PrintWriter(arq);
			
			gravarArq.println(message);
			
			arq.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
