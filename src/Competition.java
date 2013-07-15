
public class Competition {
	private String title;
	private String description;
	
	public Competition(String s) {
		// TODO Auto-generated constructor stub
		int index1 = s.indexOf("<h2>") + 4;
		int index2 = s.indexOf("</h2>");
		this.title = s.substring(index1, index2);
//		System.out.println(s.substring(index1, index2));
	}

	public String getTitle() {
		return title;
	}

	private void setTitle(String title) {
		this.title = title;
	}
}
