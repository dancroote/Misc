import java.util.ArrayList;

public class Exercise1 {

	public static void main(String args[]) {
		
		//Create array of x,y coordinates for each Exchange and Create empty Object list.
		int[][] exchangeLocations = {{6,5},{11,11}};
		ArrayList<Object> exchangeArray = new ArrayList<>();
		
		//Populate Object list with Exchanges.
		for(int i=0;i<exchangeLocations.length; i++) {
		CreateExchange(exchangeArray,exchangeLocations[i][0],exchangeLocations[i][1]);
		}
		
		//Perform logic and print ID of closest Exchange.
		int output = ShortestExchangeId(exchangeArray);
		System.out.println("ID of closest exchange is: " + output); 
	}
	
	//Returns ID of closest exchange from list of Exchanges.
	public static int ShortestExchangeId(ArrayList<Object> exchangeArray) {
		
		int shortestExchangeId = 0;
		int[] locationArray = new int[exchangeArray.size()];
		int distance = locationArray[0];
		int minDistance = locationArray[0];
		
		//Create array of distances of Exchanges, find smallest distance in array and return ID of that Exchange.
		for(int i=0;i<exchangeArray.size();i++ ) {
			locationArray[i] = ((Exchange) exchangeArray.get(i)).getDistance();
	            distance = locationArray[i];
	            minDistance = locationArray[0];
	            if(distance < minDistance) {
	            	minDistance = locationArray[i];
	            	shortestExchangeId = (((Exchange) exchangeArray.get(i)).getIdNo());
	            }
			}
				return shortestExchangeId;
	}
	
	//Instantiates new Exchange Object and stores in Object list.
	public static void CreateExchange(ArrayList<Object> exchangeArray, int xLocation, int yLocation) {
		int newExchangeId = exchangeArray.size();
		Exchange newExchange = new Exchange(newExchangeId, xLocation, yLocation);
		exchangeArray.add(newExchange);
	}
}
