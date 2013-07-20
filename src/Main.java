import java.util.ArrayList;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;


public class Main{

	/**
	 * @param args
	 * @throws MessagingException 
	 * @throws AddressException 
	 */
	public static void main(String[] args) throws AddressException, MessagingException {
		
		MyWindow myWindow = new MyWindow();
		myWindow.setVisible(true);
		
		ArrayList<Competition> List1 = new ArrayList<>(), List2 = new ArrayList<>();
		String web = DownloadPage.downloadPage();
		Parse parser = new Parse();
		
		List1 = parser.parse(web);
		
		while(true)
		{
			String tmp = List1.toString();
			web = DownloadPage.downloadPage();
			List2 = new Parse().parse(web);
			
			if(!OperationOnCompetitionList.CompareList(List1, List2))
			{
				myWindow.addToLog("pojawil sie nowy konkurs!");
				
				SendMail t = new SendMail(List2);
				t.run();
//				Thread t = new Thread(new Runnable() {
//					
//					@Override
//					public void run() {
//						// TODO Auto-generated method stub
//						try {
//							new SendMail().sendMail();
//						} catch (MessagingException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//					}
//				});
//				t.run();
//				new SendMail().sendMail(List2);
				List1 = new ArrayList<>(List2);
			}
//			brak komunikatu gdy nie ma konkursu
			else
				myWindow.addToLog("brak nowego konkursu!");
			
			List2.clear();
			
			try {
				//sleep na minute
				Thread.sleep(1000*60);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
	}

}
