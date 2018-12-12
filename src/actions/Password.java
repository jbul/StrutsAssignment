package actions;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.sun.mail.smtp.SMTPTransport;

import dao.BaseDAO;
import entities.Person;

public class Password {
	private Person person;
	private BaseDAO dao;
	private String returnMessage;

	public Password() {
		dao = new BaseDAO();
	}
	
	/**
	 * Sends an email to the user trying to recover his password.
	 * CHECK SPAM EMAILS as the email can be sent here
	 * @return
	 */
	public String sendReset() {

		if (dao.checkEmail(person.getEmail())) {

			Properties props = new Properties();
			props.put("mail.smtps.host", "smtp.mailgun.org");
	        props.put("mail.smtps.auth", "true");

	        Session session = Session.getInstance(props, null);

			Message message = new MimeMessage(session);
			try {
				message.setFrom(new InternetAddress("juliebulandajb@gmail.com"));

				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(person.getEmail()));
				message.setSubject("Reset password");

				String msg = "In order to reset your password, please click: <a href=\"http://localhost:8080/Struts/resetPassword.jsp?email=" + person.getEmail() + "\">here</a>";

				MimeBodyPart mimeBodyPart = new MimeBodyPart();
				mimeBodyPart.setContent(msg, "text/html");

				Multipart multipart = new MimeMultipart();
				multipart.addBodyPart(mimeBodyPart);

				message.setContent(multipart);

		        SMTPTransport t =
		                (SMTPTransport) session.getTransport("smtps");
		            t.connect("smtp.mailgun.com", "postmaster@sandbox009815e8edb541bfbd15ca27b40b9100.mailgun.org", "06c1222bca72f3d2cbeb7be8f3bc5e65-e89319ab-2f75482f");
		            t.sendMessage(message, message.getAllRecipients());

		            System.out.println("Response: " + t.getLastServerResponse());

		            t.close();
				returnMessage = "An email has been sent, check your mailbox to get your reset link";
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "SUCCESS";
	}
	
	public String reset() {
		dao.updatePassword(person);
		returnMessage = "Successfully reset password";
		return "SUCCESS";
	}

	public String getReturnMessage() {
		return returnMessage;
	}

	public void setReturnMessage(String returnMessage) {
		this.returnMessage = returnMessage;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
}
