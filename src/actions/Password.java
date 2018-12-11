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

import dao.BaseDAO;
import entities.Person;

public class Password {
	private Person person;
	private BaseDAO dao;
	private String returnMessage;

	public Password() {
		dao = new BaseDAO();
	}

	public String sendReset() {

		if (dao.checkEmail(person.getEmail())) {

			Properties props = new Properties();
			props.put("mail.smtp.auth", true);
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.mailtrap.io");
			props.put("mail.smtp.port", "2525");
			props.put("mail.smtp.ssl.trust", "smtp.mailtrap.io");

			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("d458670b53102b", "f8bea4e67431e8");
				}
			});

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

				Transport.send(message);
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
