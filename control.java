
import java.util.Scanner;
import java.io.FileOutputStream;
import java.util.Formatter;


class file
{
	static Formatter fmtFile;
	static int i=0;
	file()throws Exception
	{
		fmtFile = new Formatter(new FileOutputStream("Router.log"));
	}
	static void writesender(String s)
	{
		fmtFile.format("%10s %10s %15s\n", i, s,"Received");
		i++;
	}
	static void writecongestion(String s)
	{
		fmtFile.format("%10s %10s %15s\n", i, s,"Failed");
		i++;
	}
	static void writeprocessor()
	{
		fmtFile.format("%10s %10s %15s\n", i, "D1","Processed");
		i++;
	}
	
}
class size
{
	static int n;
	static public int buffer[]=new int[30];
	static int max=30;
	static public int top=-1;
	size()
	{
		Scanner read=new Scanner(System.in);
		  System.out.println("Enter the Number of packets to send from Source to Destination");
		   n=Integer.parseInt(read.nextLine());
	}
}

class sender1 extends Thread 
{
	
	
  public void run()
  {  
	  
	  for(int i=0;i<size.n;i++)
	  {
		  
		  
			  if(size.top==size.max-1)
			  {
				  
				  System.out.println("\n\nStatus of Sender-1: Conjustion has happend! Lets wait few moments\n\n");
				  file.writecongestion("S1");
				  Thread.yield();
				  try
	              {
	        
	                Thread.sleep(1000);
	        
	               }
	             catch(InterruptedException e)
	               {
	                  System.out.println("my thread interrupted");
	                }
			  }
			  else
			  {
				  size.top++;
				  size.buffer[size.top]=i;
				  
				 
				 if(size.top>0 && size.top<size.max)
				 {
				  System.out.println("The Data packet "+size.buffer[size.top]+" of Source1 has been Sent from Source");
				  file.writesender("S1");
				 }
				 
				 try
		          {
		    
		            Thread.sleep(100);
		    
		           }
		         catch(InterruptedException e)
		           {
		              System.out.println("my thread interrupted");
		            }
			  }
			  
			 
       }
	  
	  
}
}
class sender2 extends Thread 
{
	
	
  public void run()
  {  
	  
	  for(int i=0;i<size.n;i++)
	  {
		  
		  
			  if(size.top==size.max-1)
			  {
				  
				  System.out.println("\n\nStatus of Sender-2: Conjustion has happend! Lets wait few moments\n\n");
				  file.writecongestion("S2");
				  Thread.yield();
				  try
	              {
	        
	                Thread.sleep(1000);
	        
	               }
	             catch(InterruptedException e)
	               {
	                  System.out.println("my thread interrupted");
	                }
			  }
			  else
			  {
				  size.top++;
				  size.buffer[size.top]=i;
				  
				 
				 if(size.top>0 && size.top<size.max)
				 {
				  System.out.println("The Data packet "+size.buffer[size.top]+" of Source2 has been Sent from Source");
				  file.writesender("S2");
				 }
				 
				 try
		          {
		    
		            Thread.sleep(100);
		    
		           }
		         catch(InterruptedException e)
		           {
		              System.out.println("my thread interrupted");
		            }
			  }
			  
			 
       }
	  
	  
}
}
class sender3 extends Thread 
{
	
	
  public void run()
  {  
	  
	  for(int i=0;i<size.n;i++)
	  {
		  
		  
			  if(size.top==size.max-1)
			  {
				  
				  System.out.println("\n\nStatus of Sender-3: Conjustion has happend! Lets wait few moments\n\n");
				  file.writecongestion("S3");
				  Thread.yield();
				  try
	              {
	        
	                Thread.sleep(1000);
	        
	               }
	             catch(InterruptedException e)
	               {
	                  System.out.println("my thread interrupted");
	                }
			  }
			  else
			  {
				  size.top++;
				  size.buffer[size.top]=i;
				  
				 
				 if(size.top>0 && size.top<size.max)
				 {
				  System.out.println("The Data packet "+size.buffer[size.top]+" of Source3 has been Sent from Source");
				  file.writesender("S3");
				 }
				 
				 try
		          {
		    
		            Thread.sleep(100);
		    
		           }
		         catch(InterruptedException e)
		           {
		              System.out.println("my thread interrupted");
		            }
			  }
			  
			 
       }
	  
	  
}
}
class proceesing extends Thread
{
	
    public void run(){  
	  for(int i=0;i<(size.n*3);i++)
	  {
		  
		  
		
		 
		  if(size.top==-1)
		  {
			
			  System.out.println("Now Buffer is Empty");
			  Thread.yield();
			  try
              {
        
                Thread.sleep(100);
        
               }
             catch(InterruptedException e)
               {
                  System.out.println("my thread interrupted");
                }
		    }
		  
		  if(size.top>0 && size.top<size.max)
		  {
		  
	 System.out.println("The Data Packet "+size.buffer[size.top--]+" has been Proceeded");
	 file.writeprocessor();
		   }
	
	 try
     {

       Thread.sleep(200);
       continue;

      }
    catch(InterruptedException e)
      {
         System.out.println("my thread interrupted");
       }
	  }
	  file.fmtFile.close();
}
}
class control
{
  public static void main(String args[])throws Exception
  {  
	  
	   size si=new size();
	   file ob=new file();
	   sender1 obj1=new sender1();   
	   sender2 obj2=new sender2(); 
	   sender3 obj3=new sender3(); 
	   proceesing objp2=new proceesing();   
		  
	  obj1.start();
	  obj2.start();
	  obj3.start();
	  objp2.start();
	  
	  
  }
}
