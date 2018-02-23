// TO DO: betere manier om path van de games in te voeren -> hoe gaan die paths zijn als ge die allemaal in 1 exe steekt. Fix op einde

package testsnake;

import java.io.*;

public class Exec {
	public static void main(String[] args) {

		try {
			String line;
			Process p = Runtime.getRuntime().exec("cmd /c java -jar \"C:\\Users\\gauthier\\Desktop\\School\\SEM 4\\4-Software design\\Project\\Snake-master\\SnakeGame.jar\"");
			
			BufferedReader bri = new BufferedReader(new InputStreamReader(p.getInputStream()));
			BufferedReader bre = new BufferedReader(new InputStreamReader(p.getErrorStream()));      
			while ((line = bri.readLine()) != null) {
				System.out.println(line);
			}
			bri.close();
			while ((line = bre.readLine()) != null) {
				System.out.println(line);
			}
			
		    bre.close();

		    p.waitFor();
		    System.out.println("Program closed!");
	 	}
	    catch (Exception err) {
	      err.printStackTrace();
	    }
		
	}
}
