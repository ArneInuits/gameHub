import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.Scanner;

public class Game {
	protected String name;
	private ArrayList<Score> highScore;
	//private ArrayList<Settings> listSettings;
	private Path locationPhoto;
	private Path locationDescription;
	private Path locationGame;
	//private Path locationHighScores;
	
	public Game() throws FileNotFoundException { // basics die een Game MOET hebben bij opstart
		highScore = new ArrayList<>();
		
		Scanner sName = new Scanner(new File("src/HighScores.txt"));// nog 2 aparte bestanden maken voor score en naam.
		Scanner sScore = new Scanner(new File("src/HighScores.txt"));
		
		while(sName.hasNext() || sScore.hasNext()){
			int s = sScore.nextInt();
			String namePlayer = sName.next();
			Score score = new Score(namePlayer, s);
			highScore.add(score);
		}
		sScore.close();
		sName.close();
		
		for(int i=0; i<highScore.size();i++) {	// test om te zien dat of de scores juist gelezen worden van het bestand
			Score score = highScore.get(i);
			System.out.println(score.getScore());
		}
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<Score> getHighScore() {
		return highScore;
	}
	
	public Path getDescriptionPath()
	{
		return locationDescription;
	}
	//public ArrayList<Settings> getSettings{
		//return listSettings();
	//}

	public Path getPhotoPath() {
		return locationPhoto;
	}
	
	public Path getGamePath() {
		return locationGame;
	}
	
	/**
	 * Wanneer een spel wordt beeindigd dan moet de high score in de lijst worden gezet.
	 * Note: enkel de top 10 wordt opgeslagen.
	 * De ArrayList wordt weer weggeschreven in text bestand en kan zo ook na afsluiten van het spel bewaard worden.
	 * 
	 * @param nieuweScore
	 * @param namePlayer
	 */
	public void setHighScore(int nieuweScore, String namePlayer) {
		for(int i=0;i<highScore.size();i++) {
			Score scoreH = highScore.get(i);
			if(nieuweScore > scoreH.getScore()) {
				Score nieuweHigh = new Score(namePlayer, nieuweScore);
				for(int j=i;j<highScore.size()-1;j++) {
					Score score1 = highScore.get(j);
					
					highScore.set(j+1,score1);
				}
				highScore.add(i,nieuweHigh);
				i=highScore.size()+1;
			}
		}
		for(int i=0;i<highScore.size();i++) {
			//ArrayList naar file schrijven
		}
	}
	//Tijdelijk voor een test
	public int getL() {
		return highScore.size();
	}
	
	/**
	 * Tijdelijk een main om testjes te kunnen uitvoeren op Game
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Game test = new Game();
		test.setHighScore(4,"Arne");
		ArrayList<Score> a = test.getHighScore();
		for(int i=0; i<test.getL();i++) {
			Score t = a.get(i);
			System.out.println(t.getScore());
		}
	}
	
}