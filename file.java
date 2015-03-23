package file;
import java.io.*;


public class file 
{
	public static void main(String args[])throws Exception
	{
		File dir = new File(".");
		File fin = new File(dir.getCanonicalPath() + File.separator + "Router.log");
		 
		readFile1(fin);	
	}
	private static void readFile1(File fin) throws IOException {
		FileInputStream fis = new FileInputStream(fin);
	 
		//Construct BufferedReader from InputStreamReader
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
	 
		String line = null;
		String temp1=null;
		String temp2=null;
		String temp3=null;
		String temp4=null;
		String temp5=null;
		String temp6=null;
		while ((line = br.readLine()) != null) {
			
			System.out.println(line);
			temp1=temp2;
			temp2=temp3;
			
			if(line.indexOf("Failed")!=-1)
			{
				temp4=br.readLine();
				temp5=br.readLine();
				temp6=br.readLine();
				if((temp1.indexOf("Failed"))==-1&&(temp2.indexOf("Failed"))==-1&&(temp3.indexOf("Failed"))==-1&&(temp4.indexOf("Failed"))==-1&&(temp5.indexOf("Failed"))==-1&&(temp6.indexOf("Failed"))==-1)
				{
					System.out.println("-----------------------------------------------------------------------------------------------");
					System.out.println("\n\n\n\n\t\t\tWrong prediction\n\n\n");
					System.out.println("-----------------------------------------------------------------------------------------------");
				}
			}
			temp3=line;
		}
	 
		br.close();
	}
}
