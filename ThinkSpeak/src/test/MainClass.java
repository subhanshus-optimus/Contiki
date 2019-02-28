package test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MainClass {
	public static void main(String[] agrs) throws InterruptedException
	{
		//RESTCall http=new RESTCall();
		//http.sendDataOverRest(32);
		
		BufferedReader reader;
		try{
			reader = new BufferedReader(new FileReader("C:\\Users\\Subhanshu Sahu\\Desktop\\testfile.txt"));
			String line = reader.readLine();
			RESTCall http=new RESTCall();
			String test[]=null;
			
			while(line!= null)
			{
				//System.out.println(line);
				test=line.split("Temp: ",2);
				System.out.println(test[1]);		
				
				http.sendDataOverRest(Double.parseDouble(test[1]));
				
				line=reader.readLine();
				Thread.sleep(15000);
				
			}
			reader.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}
