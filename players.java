package darts;
import java.util.Scanner;


public class players {
	private String playerOne;
	private String playerTwo;
	private int P1CurrentScore = 501;
	private int P2CurrentScore = 501;
		

	private int P1SetWins = 0;
	private int P2SetWins = 0;
	private int P1LegWins = 0;
	private int P2LegWins = 0;
	
	//Constructors
	public players() {
	}

	Scanner sc = new Scanner(System.in);
	
	//PlayerNames
	public void setPlayerNames() {
		System.out.println("Player One Name: ");
		String player_one = sc.nextLine();
		this.playerOne = player_one;		
		System.out.println("Player Two Name: ");
		String player_two = sc.nextLine();
		this.playerTwo = player_two;		
	}

	public String getPlayerOneName() {
		return playerOne;
	}

	public String getPlayerTwoName() {
		return playerTwo;
	}

	//startup methods
	public void welcomeMessage() {
		System.out.println("Welcome " + getPlayerOneName() + " and " + getPlayerTwoName()+ ". This is 501! May the best player win!");
	}

	public static void beginGame(boolean startGame) {
		do {
			System.out.println("To begin game, press enter");
			Scanner sc = new Scanner(System.in);
			String input = sc.nextLine();
		} while(!startGame);
	}
	
	

	//Functionality
	public void reset() {
		P1CurrentScore = 501;
		P2CurrentScore = 501;
	}

	public void scores() {
		System.out.println("\t -----------------------");
		System.out.println("\t|     \t|Sets \t| Legs \t|");
		System.out.println("\t| " + getPlayerOneName() + "\t|" + P1SetWins + "\t| " + P1LegWins + "\t|");
		System.out.println("\t| " + getPlayerTwoName() + "\t|" + P2SetWins + "\t| " + P2LegWins + "\t|");
		System.out.println("\t ----------------------- ");
	}

	//Main Functionality
	public void game() {
		while(P1LegWins != 3 || P2LegWins != 3) {
			
			for(int P1dartsCount=1; P1dartsCount <4;P1dartsCount++) {
				System.out.println(getPlayerOneName());
				System.out.println("Throw " + P1dartsCount + ": ");
				int P1score = sc.nextInt();
				P1CurrentScore = P1CurrentScore - P1score;
					if (P1CurrentScore == 1 || P1CurrentScore < 0) { 
						System.out.println("Bust\n--------------------------------------");
						P1CurrentScore = P1CurrentScore + P1score;
						break;
					} else if(P1score %2 == 1 && P1CurrentScore == 0) {
						System.out.println("Bust\n--------------------------------------");
						P1CurrentScore = P1CurrentScore + P1score;
						break;
					} else if (P1CurrentScore== 0){
						System.out.println("Game Won");
						P1LegWins ++;
						reset();
						scores();
						break;
					} else {
						System.out.println("\t\t\t" + P1CurrentScore+ " Remaining\n--------------------------------------");
					}
				}	
			
			for(int P2dartsCount =1; P2dartsCount <4;P2dartsCount++) {
				System.out.println(getPlayerTwoName());
				System.out.println("Throw " + P2dartsCount + ": ");
				int P2score = sc.nextInt();
				P2CurrentScore = P2CurrentScore - P2score;
				if (P2CurrentScore == 1 || P2CurrentScore < 0) { 
					System.out.println("Bust\n--------------------------------------");
					P2CurrentScore = P2CurrentScore + P2score;
					break;
				} else if(P2score %2 == 1 && P2CurrentScore == 0) {
					System.out.println("Bust\n--------------------------------------");
					P2CurrentScore = P2CurrentScore + P2score;
					break;
				} else if (P2CurrentScore== 0){
					System.out.println("Game Won");
					P2LegWins ++;
					reset();
					scores();
					break;
				} else {
					System.out.println("\t\t\t" + P2CurrentScore+ " Remaining\n--------------------------------------");
				}
			}
		}
	}

}