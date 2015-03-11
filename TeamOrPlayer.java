public class TeamOrPlayer
 {
  private int TeamOrPlayerNumber;
  private String TeamOrPlayerName;
  
  TeamOrPlayer(int TPNum, String TPName)
   {
	TeamOrPlayerNumber = TPNum;
	TeamOrPlayerName = TPName;   
   }	
   
  public int GetTeamOrPlayerID()
   {
	return TeamOrPlayerNumber;   
   }
  
  public String GetTeamOrPlayerName()
   {
	return TeamOrPlayerName;   
   }    
 }