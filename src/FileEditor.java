import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class FileEditor{

	static public void addToFile(String log)
	{
		MThread mThread = new MThread(log);
	}	
}

class MThread implements Runnable
{	
	String log;
	public MThread(String l) {
		// TODO Auto-generated constructor stub
		this.log = l;
		run();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			FileWriter fstream = new FileWriter("log.txt", true);
			BufferedWriter out = new BufferedWriter(fstream);
			
			out.write(log + "\n");
			out.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
