
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

// I need to make this an abstract object later 
public abstract class Tile {
	protected Player player;

	public Tile(Player newPlayer) {
		player = newPlayer;
	}
	
	public abstract String getTileName();
	
	

}







