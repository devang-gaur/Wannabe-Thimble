import java.io.*;

import javax.swing.JTextArea;

/**
 * 
 * @author DEVANG GAUR
 *
 */
public class ReadWriteLogic {
 
	BufferedWriter writer=null;
	BufferedReader reader = null;
	static String str="";
		public void Read()
		{
			try
			{
				String line;
				reader = new BufferedReader(new FileReader("The_File.html"));
				while((line=reader.readLine())!=null){
					 str=str+line;
				 }
				reader.close();
			}
			catch(IOException e)
			{
				e.getMessage();
			}
		}
		
		public void Write(JTextArea area)
		{
			try
			{
				writer=new BufferedWriter(new FileWriter("The_File.html",true));
				writer.write(area.getText());
				writer.close();
			}
			catch(IOException e)
			{
				e.getMessage();
			}
		}
		
		public String getStr()
		{
			return str;
		}
	}

