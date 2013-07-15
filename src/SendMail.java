import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SendMail {
	public void sendMail() throws AddressException, MessagingException
	{
		///////////////////////////////////////////////////////////
		String host = "smtp.gmail.com";
	    String from = "demotcompetition";
	    String pass = "DemotCompetitionPassword";
	    Properties props = System.getProperties();
	    props.put("mail.smtp.starttls.enable", "true"); // added this line
	    props.put("mail.smtp.host", host);
	    props.put("mail.smtp.user", from);
	    props.put("mail.smtp.password", pass);
	    props.put("mail.smtp.port", "587");
	    props.put("mail.smtp.auth", "true");
//
	    String[] to = {"madej.magda.mm@gamil.com" , "DemotCompetition@gmail.com", "przemyslaw.madej@yahoo.pl"}; // added this line
//
	    Session session = Session.getDefaultInstance(props, null);
	    MimeMessage message = new MimeMessage(session);
	    message.setFrom(new InternetAddress(from));
//
	    InternetAddress[] toAddress = new InternetAddress[to.length];
//
//	    // To get the array of addresses
	    for( int i=0; i < to.length; i++ ) { // changed from a while loop
	        toAddress[i] = new InternetAddress(to[i]);
	    }
	    System.out.println(Message.RecipientType.TO);
//
	    for( int i=0; i < toAddress.length; i++) { // changed from a while loop
	        message.addRecipient(Message.RecipientType.TO, toAddress[i]);
	    }
	    message.setSubject("Demotywatory Konkurs!");
	    message.setText("Wlasnie ukazal sie nowy konkurs na demotywatorach");
	    Transport transport = session.getTransport("smtp");
	    transport.connect(host, from, pass);
	    transport.sendMessage(message, message.getAllRecipients());
	    transport.close();
	}
	
	public void sendMail(ArrayList<Competition> competitionList) throws AddressException, MessagingException
	{
		///////////////////////////////////////////////////////////
		String host = "smtp.gmail.com";
	    String from = "demotcompetition";
	    String pass = "DemotCompetitionPassword";
	    Properties props = System.getProperties();
	    props.put("mail.smtp.starttls.enable", "true"); // added this line
	    props.put("mail.smtp.host", host);
	    props.put("mail.smtp.user", from);
	    props.put("mail.smtp.password", pass);
	    props.put("mail.smtp.port", "587");
	    props.put("mail.smtp.auth", "true");
//
	    String[] to = {"przemyslaw.madej0@gmail.com" , "DemotCompetition@gmail.com", "przemyslaw.madej@yahoo.pl"}; // added this line
//
	    Session session = Session.getDefaultInstance(props, null);
	    MimeMessage message = new MimeMessage(session);
	    message.setFrom(new InternetAddress(from));
//
	    InternetAddress[] toAddress = new InternetAddress[to.length];
//
//	    // To get the array of addresses
	    for( int i=0; i < to.length; i++ ) { // changed from a while loop
	        toAddress[i] = new InternetAddress(to[i]);
	    }
	    System.out.println(Message.RecipientType.TO);
//
	    for( int i=0; i < toAddress.length; i++) { // changed from a while loop
	        message.addRecipient(Message.RecipientType.TO, toAddress[i]);
	    }
	    message.setSubject("Demotywatory Konkurs!");
	    message.setText("Wlasnie ukazal sie nowy konkurs na demotywatorach\n"
	    		+ OperationOnCompetitionList.CompetitionListToString(competitionList)
	    		);
	    Transport transport = session.getTransport("smtp");
	    transport.connect(host, from, pass);
	    transport.sendMessage(message, message.getAllRecipients());
	    transport.close();
	}
}
