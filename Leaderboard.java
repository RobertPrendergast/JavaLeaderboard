public class Leaderboard
 {
  private int TeamNumber;
  private int GamesPlayed;
  private int HomeWins;
  private int HomeDraws;
  private int HomeLosses;
  private int HomeGoalsFor;
  private int HomeGoalsAgainst;
  private int AwayWins;
  private int AwayDraws;
  private int AwayLosses;
  private int AwayGoalsFor;
  private int AwayGoalsAgainst;
  private int GoalDifference;
  private int TotalPoints;
  
  Leaderboard(int TN, int GP, int HW, int HD, int HL, int HGF, int HGA, int AW, int AD, int AL, int AGF, int AGA, int GD, int TP)
   {
	TeamNumber = TN;
    GamesPlayed = GP;
    HomeWins = HW;
    HomeDraws = HD;
    HomeLosses = HL;
    HomeGoalsFor = HGF;
    HomeGoalsAgainst = HGA;
    AwayWins = AW;
    AwayDraws = AD;
    AwayLosses = AL;
    AwayGoalsFor = AGF;
    AwayGoalsAgainst = AGA;
    GoalDifference = GD;
    TotalPoints = TP;
   }
   
   public void SetTeamNumber(int TN)
    {
	 TeamNumber = TN;   
    }
    
   public int GetTeamNumber()
    {
	 return TeamNumber;   
    }
    
   public void SetGamesPlayed(int GP)
    {
	 GamesPlayed += GP;   
    } 
    
   public void SetHomeWins(int HW)
    {
	 HomeWins += HW;   
    }
    
   public void SetHomeDraws(int HD)
    {
	 HomeDraws += HD;   
    }   
    
   public void SetHomeLosses(int HL)
    {
	 HomeLosses += HL;   
    } 
    
   public void SetHomeGoalsFor(int HGF)
    {
	 HomeGoalsFor += HGF;   
    } 
    
   public void SetHomeGoalsAgainst(int HGA)
    {
	 HomeGoalsAgainst += HGA;   
    } 
    
   public void SetAwayWins(int AW)
    {
	 AwayWins += AW;   
    } 
    
   public void SetAwayDraws(int AD)
    {
	 AwayDraws += AD;   
    } 
    
   public void SetAwayLosses(int AL)
    {
	 AwayLosses += AL;   
    } 
    
   public void SetAwayGoalsFor(int AGF)
    {
	 AwayGoalsFor += AGF;   
    }

   public void SetAwayGoalsAgainst(int AGA)
    {
	 AwayGoalsAgainst += AGA;   
    } 
       
   public void SetGoalDifference(int GD)
    {
	 GoalDifference += GD;   
    }
    
   public void SetTotalPoints(int TP)
    {
	 TotalPoints += TP;   
    }
    
   public int GetGamesPlayed()
    {
	 return GamesPlayed;   
    }
    
    public int GetHomeWins()
    {
	 return HomeWins;   
    }       
     
    public int GetHomeDraws()
     {
	  return HomeDraws;   
     } 
     
    public int GetHomeLosses()
     {
	  return HomeLosses;   
     }
     
    public int GetHomeGoalsFor()
     {
	  return HomeGoalsFor;   
     }  
     
    public int GetHomeGoalsAgainst()
     {
	  return HomeGoalsAgainst;   
     }
     
    public int GetAwayWins()
     {
	  return AwayWins;   
     }  
     
    public int GetAwayDraws()
     {
	  return AwayDraws;   
     } 
     
    public int GetAwayLosses()
     {
	  return AwayLosses;   
     }
     
    public int GetAwayGoalsFor()
     {
	  return AwayGoalsFor;   
     }  
     
    public int GetAwayGoalsAgainst()
     {
	  return AwayGoalsAgainst;   
     }
     
    public int GetGoalDifference()
     {
	  return GoalDifference;   
     }
     
    public int GetTotalPoints()
     {
	  return TotalPoints;   
     }   
 }