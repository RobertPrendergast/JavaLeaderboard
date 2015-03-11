public class Fixtures
 {
  private int FixtureNumber;
  private int HomeTeamNumber;
  private int AwayTeamNumber;

 Fixtures(int FN, int hTN, int aTN)
  {
   FixtureNumber = FN;
   HomeTeamNumber = hTN;
   AwayTeamNumber = aTN;	 
  }
 
 public int GetFixNum()
  {
   return FixtureNumber;	 
  }
 
 public int GetHomeTeam()
  {
   return HomeTeamNumber;	 
  }

 public int GetAwayTeam()
  {
   return AwayTeamNumber;	 
  }
 }
    