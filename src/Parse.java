import java.util.ArrayList;




public class Parse {
	private ArrayList<Competition> CompetitionList = new ArrayList<Competition>();
	
	public ArrayList<Competition> parse(String s)
	{
		int start_competition = s.indexOf("<h2>Wygraj</h2>");
		s = s.substring(start_competition);
		
		
		int start_article, end_article;
		start_article = s.indexOf("<article>");
		end_article = s.indexOf("</article>");
		s = s.substring(start_article+9, end_article);
		
		parseCompetition(s);
		return CompetitionList;
		
	}
	
	private void parseCompetition(String s)
	{
		String[] CompetitonStrings;
		String sub;
		CompetitonStrings = s.split("<div class=\"demotivator\" style=\"margin-bottom:10px;\">");
		
		for(int i=1; i<CompetitonStrings.length; i++)
		{
			CompetitionList.add(new Competition(CompetitonStrings[i]));
//			System.out.println(i);
		}
	}
}
