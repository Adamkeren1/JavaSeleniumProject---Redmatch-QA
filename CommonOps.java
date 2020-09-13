package production.Staging;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class CommonOps {
	
	
	private WebDriver driver;



   
	
	public CommonOps(WebDriver driver){
		
		this.driver = driver;
	}
	
	 public static  void SendEmil(String To ,String From) {    
	      // Recipient's email ID needs to be mentioned.
	      String to = "akeren@redmatch.com";

	      // Sender's email ID needs to be mentioned
	      String from = "akeren@redmatch.com";

	      // Assuming you are sending email from localhost
	      String host = From ;

	      // Get system properties
	      Properties properties = System.getProperties();

	      // Setup mail server
	      properties.setProperty("RM-Mail", host);

	      // Get the default Session object.
	      Session session = Session.getDefaultInstance(properties);

	      try {
	         // Create a default MimeMessage object.
	         MimeMessage message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(from));

	         // Set To: header field of the header.
	         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

	         // Set Subject: header field
	         message.setSubject("This is the Subject Line!");

	         // Now set the actual message
	         message.setText("This is actual message");

	         // Send message
	         Transport.send(message);
	         System.out.println("Sent message successfully....");
	      }catch (MessagingException mex) {
	         mex.printStackTrace();
	      }}
	
	 
	 public static void main(String [] args) {    
	      // Recipient's email ID needs to be mentioned.
	      String to = "akeren@redmatch.com";

	      // Sender's email ID needs to be mentioned
	      String from = "web@gmail.com";

	      // Assuming you are sending email from localhost
	      String host = "localhost";

	      // Get system properties
	      Properties properties = System.getProperties();

	      // Setup mail server
	      properties.setProperty("mail.smtp.host", host);

	      // Get the default Session object.
	      Session session = Session.getDefaultInstance(properties);

	      try {
	         // Create a default MimeMessage object.
	         MimeMessage message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(from));

	         // Set To: header field of the header.
	         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

	         // Set Subject: header field
	         message.setSubject("This is the Subject Line!");

	         // Now set the actual message
	         message.setText("This is actual message");

	         // Send message
	         Transport.send(message);
	         System.out.println("Sent message successfully....");
	      }catch (MessagingException mex) {
	         mex.printStackTrace();
	      }
	   }
	
	


	public  void OpenBrowser(String surl){
		
	
	driver.navigate().to(surl);
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
}
	}
