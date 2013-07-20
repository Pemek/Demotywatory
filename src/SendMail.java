import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail implements Runnable{
	private ArrayList<Competition> competitionList;
	private String[] toMails = {
			"madej.magda.mm@gmail.com" , 
			"DemotCompetition@gmail.com", 
			"przemyslaw.madej@yahoo.pl", 
//			"przemyslaw.madej0@gmail.com"
			"kudlaty.true@gmail.com"
			}; // added this line;
	
	public SendMail(ArrayList<Competition> cl)
	{
		this.competitionList = new ArrayList<Competition>(cl);
	}
	
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
	    String[] to = toMails;
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
	    //polskie znaki zgodne z norma iso
	    props.put("mail.mime.charset", "ISO-8859-2");
	    
	    String[] to = toMails;
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
	    message.setText("Wlasnie ukazal sie nowy konkurs na demotywatorach\n" +
	    		"lista ostatnich 10 konkursow\n\n\n"
	    		+ OperationOnCompetitionList.CompetitionListToString(competitionList)
	    		);
	    Transport transport = session.getTransport("smtp");
	    transport.connect(host, from, pass);
	    transport.sendMessage(message, message.getAllRecipients());
	    transport.close();
	}

	@Override
	public void run() {
		try {
			sendMail(competitionList);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
