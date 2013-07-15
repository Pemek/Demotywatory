import java.util.ArrayList;


public class OperationOnCompetitionList {

	public static Boolean CompareList(ArrayList<Competition> List1 , ArrayList<Competition> List2)
	{
		for(int i=0; i < List1.size(); i++)
		{
			if(!List1.get(i).getTitle().equals(List2.get(i).getTitle()))
			{
				return false;
			}
		}
		return true;
	}
	
	public static String CompetitionListToString(ArrayList<Competition> List)
	{
		String result = "";
		for(int i=0; i<List.size(); i++)
		{
			result += List.get(i).getTitle();
			result += "\n";
		}
		return result;
	}
}
