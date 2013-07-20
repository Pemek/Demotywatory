

public class Competition {
	private String title;
	private String description;
	private String link;
	
	
	public Competition(String s) {
		// TODO Auto-generated constructor stub
		int index1 = s.indexOf("<h2>") + 4;
		int index2 = s.indexOf("</h2>");

		this.title = s.substring(index1, index2);
		index1 = s.indexOf("href=")+6;
		index2 = s.indexOf("\">", index1);
		this.link = "http://demotywatory.pl/" + s.substring(index1, index2);
//		System.out.println(s.substring(index1, index2));
	}

	public String getTitle() {
		return title;
	}


	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
}
