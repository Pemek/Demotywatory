import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;


public class DownloadPage {
	public static String downloadPage()
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
		}
		
		return web;
	}
}
