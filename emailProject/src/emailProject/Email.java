//-----------------------------------------------------
// Title: Email
// Author: csukesan
// Description: This class is the class that is implemented email
//-----------------------------------------------------

package emailProject;
public class Email {

	
		public String subject;
		public int ID;
		public String message;
		public int time; //milliseconds
		public boolean flag;
		
		public String getSubject() {
			return subject;
		}
		public void setSubject(String subject) {
			this.subject = subject;
		}
		public int getID() {
			return ID;
		}
		public void setID(int iD) {
			ID = iD;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public int getTime() {
			return time;
		}
		public void setTime(int time) {
			this.time = time;
		}
		public boolean isFlag() {
			return flag;
		}
		public void setFlag(boolean flag) {
			this.flag = flag;
		}
		public Email(String subject, int iD, String message, int time, boolean flag) {
			this.subject = subject;
			ID = iD;
			this.message = message;
			this.time = time;
			this.flag = flag;
		}
		
		

	

}
