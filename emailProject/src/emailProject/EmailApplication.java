//-----------------------------------------------------
// Title: EmailApplication
// Author: csukesan
// Description: This class is the main class for email application
//-----------------------------------------------------

package emailProject;
import java.util.Scanner;
public class EmailApplication {

	public static void main(String[] args) {
	
			Scanner keyboard = new Scanner (System.in);
			
			//creating the linked list objects
			LinkedListOfEmails Inbox  = new LinkedListOfEmails();
			LinkedListOfEmails Archive  = new LinkedListOfEmails();
			LinkedListOfEmails Trash  = new LinkedListOfEmails();
			
			//endless loop for inputs
			int k = 0;
			for(;;)
			
			{
		
			String inputs = keyboard.nextLine();
			//reading the first letter and also function
			String app = inputs.substring(0,1);
			
			String[] arr = inputs.split("//");
			
			
			//new mail function
			if(app == "N")
			{
				
					String s = arr[1];
					String s1 = arr[2];
					String s2 = arr[3];
					String s3 = arr[4];
					
					
					int tid = Integer.parseInt(s1);	
					int ttime = Integer.parseInt(s3);
					
					Email newEmail = new Email(s, tid, s2, ttime, false);
					
					Inbox.addEmail(newEmail);	
					
					k++;
			}
			//read function for given id
			else if (app == "R")
			{
					
					String rest = arr[1];
					int tid = Integer.parseInt(rest);
					Inbox.read(tid);
					
					k++;
					
			}
			
			//archive function for given id 
			else if (app == "A")
			{
				for(int i =0 ; i<Inbox.size ; i++)
				{
					
					String rest = arr[1];
					int tid = Integer.parseInt(rest);
					Archive.addEmail(Inbox.EmailDelete(tid));
					System.out.println("Email" + tid+ " archived.");
				}
				k++;
			}
			
			//delete function for given id
			else if (app == "D")
			{
				for(int i =0; i< Inbox.size ; i++)
				{
					
					String rest = arr [1];
					int tid = Integer.parseInt(rest);
					Trash.addEmail(Inbox.EmailDelete(tid));
					
				}
				k++;
			}
			
			//show detail function for given folder
			else if ( app == "S")
			{
				
				String rest = arr [1];
				
				if(rest =="Inbox")
				{
					Inbox.showAll(true);
				}
				else if (rest =="Archive")
				{
					Archive.showAll(true);
				}
				else if (rest == "Trash")
				{
					Trash.showAll(true);
				}
				
				k++;
			}
			
			//showing the unread mails 
			else if (app == "U")
			{
				
				String rest = arr [1];
				
				if(rest == "Inbox")
				{
					Inbox.showAll(false);
				}
				else if (rest =="Archive")
				{
					Archive.showAll(false);
				}
				else if (rest == "Trash")
				{
					Trash.showAll(false);
				}
				
				k++;
			}
			
			//clear the content of given linked list
			else if (app == "C")
			{
				
				String rest = arr[1];
				
				if(rest == "Inbox")
				{
					for (int i = 0 ; i< Inbox.size ; i++)
					{
						Email e = Inbox.head.getEmail();
						Trash.addEmail(Inbox.EmailDelete(e.ID));
					}
				}
				else if (rest =="Archive")
				{
					for (int j = 0; j < Archive.size ; j++)
					{
						Email a = Archive.head.getEmail();
						Trash.addEmail(Archive.EmailDelete(a.ID));
					}
				}
				else if (rest == "Trash")
				{
					for( int i = 0; i< Trash.size ; i++)
					{
						Email o = Trash.head.getEmail();
						Trash.EmailDelete(o.ID);
					}
				}
				k++;
			}
		}
		
	}

	
	}


