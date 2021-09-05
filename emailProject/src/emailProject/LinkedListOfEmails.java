//-----------------------------------------------------
// Title: LinkedListOfEmails
// Author: csukesan
// Description: This class defines the linked list functions that is important for application 
//-----------------------------------------------------

package emailProject;

public class LinkedListOfEmails {
	
	//inner Node class
	class Node {

		 private Email email; 
		 private Node next;
		 
		 Node(Email em) 
		 {
		 email = em;
		 }
		 
		 public Email getEmail() { return email; }
		
		 public Node getNext() { return next; }
		
		 public void setEmail(Email newEmail) {email = newEmail; }
		
		 public void setNext(Node newNext) { next = newNext; }
		
	}
	protected Node head; 
	public long size; 
	
	 //Constructor of linked list
	public LinkedListOfEmails() {
	head = null;
	size = 0;
	}
	public long getSize() {
		return size;
	}
	
	//adding the mail that is sent newly to linked lists
	public void addEmail(Email E) {       
        Node newNode = new Node(E);
        Node current;
        if(head == null|| head.getEmail().getTime() < newNode.getEmail().getTime())
        {
        	head = newNode.getNext(); 
        	head = newNode;
        	System.out.println("Successfull");
        }
        else 
        {
        	current = head;
        	while(current.getNext() != null && current.getEmail().getTime() > newNode.getEmail().getTime())
        	{
        		current=current.getNext();
        	}
        	newNode.next = current.getNext();
        	current.next = newNode;
        	System.out.println("Successful");
        } 
        size++;
	}  
	
	//reading the mail that has the given id
	public void read(int id)
	{
		Node temp = head;
		boolean isTrue = false;
		for(int i = 0; i<size; i++)
		{
			if(id== temp.getEmail().getID())
			{
			isTrue = true;
			temp.getEmail().isFlag();
			System.out.println("Email id: " + temp.getEmail().getID());
			System.out.println("Subject: "+ temp.getEmail().getSubject());
			System.out.println("Body: "+ temp.getEmail().getMessage());
			System.out.println("Time received: "+ temp.getEmail().getTime());
				if(temp.getEmail().isFlag() == true)
				{
				System.out.println("Status: Read");
				}
			}
			temp = temp.getNext();
		}
		//checking the existence of mail that has the given id
		if(!isTrue)
		{
			System.out.println("No such email.");
		}
	}
	
	//deleting the mail that has the given id
	public Email EmailDelete (int id)
	{
		Node temp = head; //Node object that points the head of linked list
		Node m = temp.getNext(); // Node object that points the next of head

		for(int i = 0; i<size; i++)
		{
			if(temp.getEmail().getID() == id) // deleting the head
			{
				head = m;
				temp.setEmail(null);
				temp.setNext(null);
				size--;
				System.out.println("Email is deleted.");
				return m.getEmail();
			}
			else
			{
				while(temp.getEmail().getID() != id)
					{
					m = m.getNext();
					temp = temp.getNext();
					}
			}
			
			//deleting the last node
			if(m.getNext() == null && m.getEmail().getID() ==id) //deleting the last node
			{
				temp.setNext(null); //temp become last node
				m.setEmail(null);
				size--;
				System.out.println("Email is deleted.");
				return m.getEmail();
			}
			else if (m.getNext() != null && m.getEmail().getID() == id) //deleting from middle of linked list
			{
				temp.setNext(m.getNext());
				m.setEmail(null);
				m.setNext(null);
				size--;
				System.out.println("Email is deleted.");
				return m.getEmail();
			}
			else if (m.getNext() == null && m.getEmail().getID() == id)
			{
				System.out.println("No such email.");
				Node k = null;
				return k.getEmail();
			}
		}
		return null;
		
	}
	
	//showing the truncated content of given folder
	public void showAll (boolean flag)
	{
		Node temp = head;
		
		//if user wants to read all mails
		if(flag)
		{
			//design of headers
			System.out.printf("%-6.5s", "Email");
			System.out.printf("%-26.7s" , "Subject");
			System.out.printf("%-41.4", "Body");
			System.out.printf("%-11.4s" , "Time");
			System.out.printf("%-1.4s", "Read");
		
			
			for ( int i=0; i<size; i++)
			{
				int i1 = temp.getEmail().getID();
				int t1 = temp.getEmail().getTime();
				String m1 = temp.getEmail().getMessage();
				String s1 = temp.getEmail().getSubject();

				//for read mails
				if(temp.getEmail().isFlag())
				{
					if (s1.length() > 25) 
					{
						if(m1.length() > 40)
						{
							//design of both messages and subjects longer than they shoul be
							System.out.printf("%-6s", i1);
							System.out.printf("%-22.22s", s1);
							System.out.printf("%-1.4s", "...");
							System.out.printf("%-37.37s" , m1);
							System.out.printf("%-1.4s", "...");
							System.out.printf("%-6.5s", t1);
							System.out.printf("%-25.7s" , "Yes");
						}
						else
						{
							//design of subjects is longer but message is not
							System.out.printf("%-6s", i1);
							System.out.printf("%-22.22s", s1);
							System.out.printf("%-1.4s", "...");
							System.out.printf("%-41.40s" , m1);
							System.out.printf("%-6.5s", t1);
							System.out.printf("%-25.7s" , "Yes");
						}
					}
					else
					{
						if(m1.length() > 40)
						{
							//design of message is longer but subject is not
							System.out.printf("%-6s", i1);
							System.out.printf("%-26.25s", s1);							
							System.out.printf("%-37.37s" , m1);
							System.out.printf("%-1.4s", "...");
							System.out.printf("%-6.5s", t1);
							System.out.printf("%-25.7s" , "Yes");
						}
						else
						{
							//design of both are shorter than given number of char
							System.out.printf("%-6s", i1);
							System.out.printf("%-26.25s", s1);
							System.out.printf("%-41.40s" , m1);
							System.out.printf("%-6.5s", t1);
							System.out.printf("%-25.7s" , "Yes");
						}
					}
					temp = temp.getNext();
				}
				
				//for unread mails
				else 
				{
					if (s1.length() > 25) 
					{
						if(m1.length() > 40)
						{
							System.out.printf("%-6s", i1);
							System.out.printf("%-22.22s", s1);
							System.out.printf("%-1.4s", "...");
							System.out.printf("%-37.37s" , m1);
							System.out.printf("%-1.4s", "...");
							System.out.printf("%-6.5s", t1);
							System.out.printf("%-25.7s" , "Yes");
						}
						else
						{
							System.out.printf("%-6s", i1);
							System.out.printf("%-22.22s", s1);
							System.out.printf("%-1.4s", "...");
							System.out.printf("%-41.40s" , m1);
							System.out.printf("%-6.5s", t1);
							System.out.printf("%-25.7s" , "Yes");
						}
					}
					else
					{
						if(m1.length() > 40)
						{
							System.out.printf("%-6s", i1);
							System.out.printf("%-26.25s", s1);							
							System.out.printf("%-37.37s" , m1);
							System.out.printf("%-1.4s", "...");
							System.out.printf("%-6.5s", t1);
							System.out.printf("%-25.7s" , "Yes");
						}
						else
						{
							System.out.printf("%-6s", i1);
							System.out.printf("%-26.25s", s1);
							System.out.printf("%-41.40s" , m1);
							System.out.printf("%-6.5s", t1);
							System.out.printf("%-25.7s" , "Yes");
						}
					}
					temp = temp.getNext();
				}
			}
		}
		
		//if user wants to read only unread mails
		else if (!flag)
		{
			System.out.printf("%-6.5s", "Email");
			System.out.printf("%-26.7s" , "Subject");
			System.out.printf("%-41.4", "Body");
			System.out.printf("%-11.4s" , "Time");
			System.out.printf("%-1.4s", "Read");
			
			for ( int i=0; i<size; i++)
			{
				int i1 = temp.getEmail().getID();
				int t1 = temp.getEmail().getTime();
				String m1 = temp.getEmail().getMessage();
				String s1 = temp.getEmail().getSubject();

				if(!temp.getEmail().isFlag())
				{
					if (s1.length() > 25) 
					{
						if(m1.length() > 40)
						{
							System.out.printf("%-6s", i1);
							System.out.printf("%-22.22s", s1);
							System.out.printf("%-1.4s", "...");
							System.out.printf("%-37.37s" , m1);
							System.out.printf("%-1.4s", "...");
							System.out.printf("%-6.5s", t1);
							System.out.printf("%-25.7s" , "Yes");
						}
						else
						{
							System.out.printf("%-6s", i1);
							System.out.printf("%-22.22s", s1);
							System.out.printf("%-1.4s", "...");
							System.out.printf("%-41.40s" , m1);
							System.out.printf("%-6.5s", t1);
							System.out.printf("%-25.7s" , "Yes");
						}
					}
					else
					{
						if(m1.length() > 40)
						{
							System.out.printf("%-6s", i1);
							System.out.printf("%-26.25s", s1);							
							System.out.printf("%-37.37s" , m1);
							System.out.printf("%-1.4s", "...");
							System.out.printf("%-6.5s", t1);
							System.out.printf("%-25.7s" , "Yes");
						}
						else
						{
							System.out.printf("%-6s", i1);
							System.out.printf("%-26.25s", s1);
							System.out.printf("%-41.40s" , m1);
							System.out.printf("%-6.5s", t1);
							System.out.printf("%-25.7s" , "Yes");
						}
					}
					
					temp = temp.getNext();
				}
				else 
				{
					temp = temp.getNext();
				}
					
			}
		}
			
	}
	
	
	}
	
	
	
	
