package darts;

public class index extends players {


	public static void main(String[] args) {
		index startGame= new index();
		
		System.out.println("501");
		
		startGame.setPlayerNames();
		startGame.welcomeMessage();
		
		players.beginGame(true);
		
		startGame.game();

			
		
		
	}
}
