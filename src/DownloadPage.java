import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;


public class DownloadPage {
	public static String downloadPage()
	{
		//sciagniecie strony
		String web ="";
		
		web = download();
		//jezeli sie udalo to idzie dalej a jezeli nie to czeka i ponawia probe
		while(web == ""){
			try {
				Thread.sleep(1000*30);
				web = download();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		return web;
	}
	
	private static String download()
	{
		URL url;
		
		InputStream is = null;
		BufferedReader br;
		String line;
		String web = "";
		
		try{
			url = new URL("http://demotywatory.pl/wygraj");
//			url = new URL("file:C:\\Users\\dev\\Downloads\\Demotywatory.pl.htm");
			is = url.openStream();
			br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			
			while((line = br.readLine() ) != null)
			{
//				System.out.println(line);
				web += line;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("wyjatek przy pobieraniu strony");
		}
		
		return web;
	}
}
