import javax.swing.*;
import java.util.*;
import java.io.*;
public class Group18Project4
 {
  public static void main(String[]args) throws IOException
   {
	int choice;
	String MenuOption = "";   
	ArrayList<TeamOrPlayer> aTeamOrPlayer = new ArrayList<TeamOrPlayer>(); 
	ArrayList<Outcomes> aOutcomes = new ArrayList<Outcomes>();
	ArrayList<Fixtures> aFixtures = new ArrayList<Fixtures>();
	ArrayList<Integer> FixturesScheduled = new ArrayList<Integer>();
	ArrayList<Integer> FixturesPlayed = new ArrayList<Integer>();
	GetTeamData(aTeamOrPlayer);
	GetOutcomeData(aOutcomes);
	GetFixturesData(aFixtures);
	GetFixtureSchedule(FixturesScheduled);
	GetResultNumbers(FixturesPlayed);
	
    while((MenuOption != null ) && (!(MenuOption.equals(0))))
     {
	  MenuOption = GetMenu();  
	  if(MenuOption != null)
	   {
		choice = Integer.parseInt(MenuOption);
		 {
		  switch(choice)
		   {    
			  case 0: System.exit(0); break;
			  case 1: DisplayPlayedFixtures(aFixtures, aOutcomes, aTeamOrPlayer); break;
			  case 2: DisplayUnplayedFixtures(aFixtures, aOutcomes, aTeamOrPlayer, FixturesScheduled, FixturesPlayed); break;
			  case 3: DisplayLeaderboard(aFixtures, aOutcomes, aTeamOrPlayer, FixturesPlayed);break;
		   }	 		   
		 }   
	   } 
     }   
   }
   
   public static String GetMenu()
    {
	 String MenuScreen = "1. View list of fixtures played." + 
	                      "\n2. View list of fixtures still to be played." +
	                      "\n3. Display up to date league table." + 
	                      "\n0. Exit";
	 boolean ValidInput = false;
	 String Selection = "", MenuScreenPattern = "[0-3]{1}";
	 String errorMessage = "Invalid menu selection.";
	        errorMessage += "\n\nValid options are 0 to 3 inclusive.";
	        errorMessage += "\nSelect OK to retry.";                
	 while(!(ValidInput))
	  {
	   Selection = JOptionPane.showInputDialog(null,MenuScreen);
	   if(Selection == null || Selection.matches(MenuScreenPattern))
	    ValidInput = true;
	   else
	    JOptionPane.showMessageDialog(null,errorMessage,"Error in user input",2); 	  
	  }
	 return Selection;                 
    } 
    
   public static void DisplayPlayedFixtures(ArrayList<Fixtures> aFixtures, ArrayList<Outcomes> aOutcomes, ArrayList<TeamOrPlayer> aTeamOrPlayer)
    {
	 int TempNum, HomeScore, AwayScore, FixtureNumber, HomeTeamNumber, AwayTeamNumber;
	 String HomeTeam = "", AwayTeam = "";
	 Fixtures FixtureDetails;
	 Outcomes OutcomeDetails;
	 TeamOrPlayer HomeTeamDetails, AwayTeamDetails;
	 System.out.println("Fixtures played to date:");
	 System.out.println();
	 for(int a = 0; a < aOutcomes.size(); a++)
	  {
	  	OutcomeDetails = aOutcomes.get(a);
	  	FixtureNumber = OutcomeDetails.GetFixtureNumber();
	  	HomeScore = OutcomeDetails.GetHomeScore();
	  	AwayScore = OutcomeDetails.GetAwayScore();
	  	FixtureDetails = aFixtures.get(FixtureNumber-1);
	  	HomeTeamNumber = FixtureDetails.GetHomeTeam();
	  	AwayTeamNumber = FixtureDetails.GetAwayTeam();
	  	HomeTeamDetails = aTeamOrPlayer.get(HomeTeamNumber-1);
	  	AwayTeamDetails = aTeamOrPlayer.get(AwayTeamNumber-1);
	  	HomeTeam = HomeTeamDetails.GetTeamOrPlayerName();
	  	AwayTeam = AwayTeamDetails.GetTeamOrPlayerName();
	  	String Score = (HomeScore+":"+AwayScore); 
	  	System.out.printf( "%-20s %1s %-20s %2s %n", HomeTeam, "Vs", AwayTeam, Score); 
	  }   
    }
    
   public static void GetTeamData(ArrayList <TeamOrPlayer> aTeamOrPlayer) throws IOException
    {
	 File TeamName = new File("PremiershipTeamsOrPlayers.txt");
	 Scanner in = new Scanner(TeamName);
	 String LineFromFile = "";
	 String TempTeamName = "";
	 String TempTeamNum = "";
	 int CommaPos, aTempTeamNum;
	 TeamOrPlayer TeamDetails;
	 while(in.hasNext())
	  {
	   LineFromFile = in.nextLine();
	   CommaPos = LineFromFile.indexOf(",");
	   TempTeamNum =  LineFromFile.substring(0, CommaPos);
	   aTempTeamNum = Integer.parseInt(TempTeamNum);
	   TempTeamName = LineFromFile.substring(CommaPos + 1);
	   TeamDetails = new TeamOrPlayer(aTempTeamNum, TempTeamName);
	   aTeamOrPlayer.add(TeamDetails);	  
	  }
	 in.close(); 
    }  
    
    public static void GetOutcomeData(ArrayList<Outcomes> aOutcomes) throws IOException
     {
	  File Results = new File("PremiershipResults.txt");
	  Scanner in = new Scanner(Results);
	  String LineFromFile = "";
	  int FirstComma, SecondComma;
	  int FixtureNumber, HomeScore, AwayScore;
	  Outcomes OutcomeDetails;
	  while(in.hasNext())
	   {
		LineFromFile = in.nextLine();
		FirstComma = LineFromFile.indexOf(",");
		SecondComma = LineFromFile.lastIndexOf(",");
		FixtureNumber = Integer.parseInt(LineFromFile.substring(0,FirstComma));
		HomeScore = Integer.parseInt(LineFromFile.substring(FirstComma+1,SecondComma));
		AwayScore = Integer.parseInt(LineFromFile.substring(SecondComma+1));
		OutcomeDetails = new Outcomes(FixtureNumber,HomeScore,AwayScore);
		aOutcomes.add(OutcomeDetails);    
	   }  
	  in.close();   
     }
     
    public static void GetFixturesData(ArrayList<Fixtures> aFixtures) throws IOException
     {
	  File FixturesList = new File("PremiershipFixtures.txt");
	  Scanner in = new Scanner(FixturesList);
	  String LineFromFile = "";
	  int FirstComma, SecondComma;
	  int FixtureNumber, HomeTeamNumber, AwayTeamNumber;
	  Fixtures FixtureDetails;  
	  while(in.hasNext())
	   {
		LineFromFile = in.nextLine();
		FirstComma = LineFromFile.indexOf(",");
		SecondComma = LineFromFile.lastIndexOf(",");
		FixtureNumber = Integer.parseInt(LineFromFile.substring(0,FirstComma));
		HomeTeamNumber = Integer.parseInt(LineFromFile.substring(FirstComma+1,SecondComma));
		AwayTeamNumber = Integer.parseInt(LineFromFile.substring(SecondComma+1)); 
		FixtureDetails = new Fixtures(FixtureNumber,HomeTeamNumber,AwayTeamNumber);
		aFixtures.add(FixtureDetails);  
	   } 
	  in.close();  
     } 
     
    public static void GetFixtureSchedule(ArrayList<Integer> FixturesSchedule) throws IOException
     {
	  File Fixtures = new File("PremiershipFixtures.txt");   
	  String LineFromFile = "";
	  Scanner in = new Scanner(Fixtures);
	  int FirstComma, TempFixNum;
	  while(in.hasNext())
	   {
		LineFromFile = in.nextLine();
		FirstComma = LineFromFile.indexOf(",");
		TempFixNum = Integer.parseInt(LineFromFile.substring(0,FirstComma));   
		FixturesSchedule.add(TempFixNum);
	   } 
	  in.close();  
     } 
     
        public static void GetResultNumbers(ArrayList<Integer> FixturesPlayed)throws IOException
     {
	  File Results = new File("PremiershipResults.txt");   
	  String LineFromFile = "";
	  Scanner in = new Scanner(Results);
	  int FirstComma, TempResNum;
	  while(in.hasNext())
	   {
		LineFromFile = in.nextLine();
		FirstComma = LineFromFile.indexOf(",");
		TempResNum = Integer.parseInt(LineFromFile.substring(0,FirstComma));   
		FixturesPlayed.add(TempResNum);
	   } 
	  in.close();
     } 
     
     public static void DisplayUnplayedFixtures(ArrayList<Fixtures> aFixtures, ArrayList<Outcomes> aOutcomes, ArrayList<TeamOrPlayer> aTeamOrPlayer, ArrayList<Integer> FixturesScheduled, ArrayList<Integer>FixturesPlayed)
      {   
	   int TempNum, FixtureNumber, HomeTeamNumber, AwayTeamNumber;
	   String HomeTeam = "", AwayTeam = "";
	   Fixtures FixtureDetails;
	   Outcomes OutcomeDetails;
	   int  Start = ((FixturesScheduled.size()) - (((FixturesScheduled.size()) - (FixturesPlayed.size()))));
	   TeamOrPlayer HomeTeamDetails, AwayTeamDetails;
	   System.out.println("Fixtures not played to date:");
	   System.out.println();
	   for(int a = Start; a <= aFixtures.size(); a++)
	    {
		  { 
	  	   FixtureNumber = a;
	  	   FixtureDetails = aFixtures.get(FixtureNumber-1);
	  	   HomeTeamNumber = FixtureDetails.GetHomeTeam();
	  	   AwayTeamNumber = FixtureDetails.GetAwayTeam();
	   	   HomeTeamDetails = aTeamOrPlayer.get(HomeTeamNumber-1);
	  	   AwayTeamDetails = aTeamOrPlayer.get(AwayTeamNumber-1);
	   	   HomeTeam = HomeTeamDetails.GetTeamOrPlayerName();
	  	   AwayTeam = AwayTeamDetails.GetTeamOrPlayerName();
	  	   System.out.printf( "%-20s %1s %-20s %n", HomeTeam, "Vs", AwayTeam); 
	      }
        }
      } 
      
  public static void DisplayLeaderboard(ArrayList<Fixtures>aFixtures, ArrayList<Outcomes>aOutcomes, ArrayList<TeamOrPlayer>aTeamOrPlayer, ArrayList<Integer> FixturesPlayed)
   {
	ArrayList<Leaderboard> aLeaderboard = new ArrayList<Leaderboard>(aTeamOrPlayer.size());
	for(int i = 0; i < aTeamOrPlayer.size(); i++)
	 {
	  Leaderboard aLeaderboardEntry = new Leaderboard(i,0,0,0,0,0,0,0,0,0,0,0,0,0);
	  aLeaderboard.add(aLeaderboardEntry);	 
	 }  
	 
	for(int a = 0; a < aOutcomes.size(); a++)
	 {
	  Outcomes OutcomeDetails = aOutcomes.get(a);
	  int FixtureNumber = OutcomeDetails.GetFixtureNumber();
	  int HomeScore = OutcomeDetails.GetHomeScore();
	  int AwayScore = OutcomeDetails.GetAwayScore();
	  int position = FixturesPlayed.indexOf(FixtureNumber);
	  Fixtures FixtureDetails = aFixtures.get(position);
	  int HomeTeamNumber = FixtureDetails.GetHomeTeam();
	  int AwayTeamNumber = FixtureDetails.GetAwayTeam();
	  
	  if(HomeScore == AwayScore)
	   {
		RecordFixtureResultForHomeTeam(aLeaderboard, HomeTeamNumber,0,1,0,HomeScore,AwayScore,1);
		RecordFixtureResultForAwayTeam(aLeaderboard, AwayTeamNumber,0,1,0,HomeScore,AwayScore,1);   
	   }
	   
	  else if(HomeScore > AwayScore)
	   {
		RecordFixtureResultForHomeTeam(aLeaderboard, HomeTeamNumber,1,0,0,HomeScore,AwayScore,3);
		RecordFixtureResultForAwayTeam(aLeaderboard, AwayTeamNumber,0,0,1,HomeScore,AwayScore,0);
	   }
	   
	  else
	   {
		RecordFixtureResultForHomeTeam(aLeaderboard, HomeTeamNumber,0,0,1,HomeScore,AwayScore,0);
		RecordFixtureResultForAwayTeam(aLeaderboard, AwayTeamNumber,1,0,0,HomeScore,AwayScore,3);
	   }
     }
    OrderLeaderboard(aLeaderboard);
    DisplayLeaderboard(aLeaderboard, aTeamOrPlayer);   	 
   }
   
  public static void RecordFixtureResultForHomeTeam(ArrayList<Leaderboard> aLeaderboard, int HomeTeamNumber, int W, int D, int L, int HScore, int AScore, int Points)
   {
	Leaderboard aLeaderboardEntry = null;
	aLeaderboardEntry = aLeaderboard.get(HomeTeamNumber-1);
	aLeaderboardEntry.SetGamesPlayed(1);
	aLeaderboardEntry.SetHomeWins(W);
	aLeaderboardEntry.SetHomeDraws(D);
	aLeaderboardEntry.SetHomeLosses(L);
	aLeaderboardEntry.SetHomeGoalsFor(HScore);
	aLeaderboardEntry.SetHomeGoalsAgainst(AScore);
	aLeaderboardEntry.SetGoalDifference(HScore - AScore);
	aLeaderboardEntry.SetTotalPoints(Points);   
   }
   
  public static void RecordFixtureResultForAwayTeam(ArrayList<Leaderboard> aLeaderboard, int AwayTeamNumber, int W, int D, int L, int HScore, int AScore, int Points)
   {
    Leaderboard aLeaderboardEntry = null;
	aLeaderboardEntry = aLeaderboard.get(AwayTeamNumber-1);
	aLeaderboardEntry.SetGamesPlayed(1);
	aLeaderboardEntry.SetAwayWins(W);
	aLeaderboardEntry.SetAwayDraws(D);
	aLeaderboardEntry.SetAwayLosses(L);
	aLeaderboardEntry.SetAwayGoalsFor(AScore);
	aLeaderboardEntry.SetAwayGoalsAgainst(HScore);
	aLeaderboardEntry.SetGoalDifference(AScore - HScore);
	aLeaderboardEntry.SetTotalPoints(Points);
   } 
   
  public static void OrderLeaderboard(ArrayList<Leaderboard> aLeaderboard)
   {
	Leaderboard temp;
	int Pass, Comparison;
	for(Pass = 1; Pass <= (aLeaderboard.size() - 1); Pass++)
	 {
	  for(Comparison = 1; Comparison <= (aLeaderboard.size()-Pass); Comparison++)
	   {
		if(((aLeaderboard.get(Comparison - 1)).GetTotalPoints()) < ((aLeaderboard.get(Comparison)).GetTotalPoints()))
		 {
		  temp = aLeaderboard.get(Comparison - 1);
		  aLeaderboard.set((Comparison - 1), aLeaderboard.get(Comparison));	 
		  aLeaderboard.set((Comparison), temp);
		 }   
	   }	 
	 }   
   }
   
  public static void DisplayLeaderboard(ArrayList<Leaderboard> aLeaderboard, ArrayList<TeamOrPlayer>aTeamOrPlayer)
   {
	Leaderboard LeaderboardDetails;
	TeamOrPlayer TeamDetails;
	String TeamName = "";
	int TeamNumber, GamesPlayed, HomeWins, HomeDraws, HomeLosses, HomeGoalsFor, HomeGoalsAgainst, AwayWins, AwayDraws, AwayLosses
	    ,AwayGoalsFor, AwayGoalsAgainst, GoalDifference, TotalPoints;   
	
	System.out.printf("%-20s %-3s %-3s %-3s %-3s %-3s %-3s %-3s %-3s %-3s %-3s %-3s %3s %-3s %n",
	                  "Team Name","GP","HW","HD","HL","GF","GA","AW","AD","AL","GF","GA","GD","TP");
	System.out.println();                          
	for(int i = 0; i < aLeaderboard.size(); i++)
	 {
	  LeaderboardDetails = aLeaderboard.get(i);
	  TeamNumber = LeaderboardDetails.GetTeamNumber();
	  TeamDetails = aTeamOrPlayer.get(TeamNumber);
	  TeamName = TeamDetails.GetTeamOrPlayerName();
	  GamesPlayed = LeaderboardDetails.GetGamesPlayed();
	  HomeWins = LeaderboardDetails.GetHomeWins();
	  HomeDraws = LeaderboardDetails.GetHomeDraws();
	  HomeLosses = LeaderboardDetails.GetHomeLosses();
	  HomeGoalsFor = LeaderboardDetails.GetHomeGoalsFor();
	  HomeGoalsAgainst = LeaderboardDetails.GetHomeGoalsAgainst();
	  AwayWins = LeaderboardDetails.GetAwayWins();
	  AwayDraws = LeaderboardDetails.GetAwayDraws();
	  AwayLosses = LeaderboardDetails.GetAwayLosses();
	  AwayGoalsFor = LeaderboardDetails.GetAwayGoalsFor();
	  AwayGoalsAgainst = LeaderboardDetails.GetAwayGoalsAgainst();
	  GoalDifference = LeaderboardDetails.GetGoalDifference();
	  TotalPoints = LeaderboardDetails.GetTotalPoints();
	
	  System.out.printf("%-20s %-3s %-3s %-3s %-3s %-3s %-3s %-3s %-3s %-3s %-3s %-3s %3s %-3s %n",
	                   TeamName, GamesPlayed, HomeWins, HomeDraws, HomeLosses, HomeGoalsFor, HomeGoalsAgainst, 
	                                           AwayWins, AwayDraws, AwayLosses, AwayGoalsFor, AwayGoalsAgainst,
	                                           GoalDifference, TotalPoints); 	 
	 }                        
   }      
 }     