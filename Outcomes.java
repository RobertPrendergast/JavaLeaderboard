public class Outcomes
 {
  private int FixtureNumber;
  private int HomeScore;
  private int AwayScore;
  
  Outcomes(int FN, int HS, int AS)
   {
    FixtureNumber = FN;
    HomeScore = HS;
    AwayScore = AS;
   }
  
  public int GetFixtureNumber()
   {
	return FixtureNumber;   
   }
   
  public int GetHomeScore()
   {
	return HomeScore;   
   }
   
  public int GetAwayScore()
   {
	return AwayScore;   
   }    
 }