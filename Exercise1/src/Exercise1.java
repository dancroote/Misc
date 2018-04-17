import java.util.ArrayList;

public class Exercise1 {

	static int gridLength = 20;
	
	public static void main(String args[]) {
		
		new GUI(gridLength);
	}
	
	//Instantiates new Exchange Object and stores in Object list.
	public void CreateExchange(ArrayList<Object> exchangeArray, int[] location) {
		Exchange newExchange = new Exchange(location);
		exchangeArray.add(newExchange);
	}
	
}
