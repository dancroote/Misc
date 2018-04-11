import java.util.ArrayList;

public class Exercise1 {

	public static void main(String args[]) {
		
		//Create array of x,y coordinates for each Exchange and Create empty Object list.
		int[][] exchangeLocations = {{6,5},{11,11}};
		ArrayList<Object> exchangeArray = new ArrayList<>();
		
		//Populate Object list with Exchanges.
		for(int i=0;i<exchangeLocations.length; i++) {
		CreateExchange(exchangeArray,exchangeLocations[i]);
		}
		
		//Perform logic and print ID of closest Exchange.
		String output = ShortestExchangeId(exchangeArray);
		System.out.println("The closest exchange is: " + output); 
	}
	
	//Returns ID of closest exchange from list of Exchanges.
	public static String ShortestExchangeId(ArrayList<Object> exchangeArray) {
		
		String shortestExchangeId = "";
		int[] locationArray = new int[exchangeArray.size()];
		int distance = locationArray[0];
		int minDistance = locationArray[0];
		
		//Create array of distances of Exchanges, find smallest distance in array and return ID of that Exchange.
		for(int i=0;i<exchangeArray.size();i++ ) {
				shortestExchangeId = (((Exchange) exchangeArray.get(0)).getId());
				locationArray[i] = ((Exchange) exchangeArray.get(i)).getDistance();
	            distance = locationArray[i];
	            if(distance < minDistance) {
	            	minDistance = locationArray[i];
	            	shortestExchangeId = (((Exchange) exchangeArray.get(i)).getId());
	            }
			}
				return shortestExchangeId;
	}
	
	//Instantiates new Exchange Object and stores in Object list.
	public static void CreateExchange(ArrayList<Object> exchangeArray, int[] location) {
		Exchange newExchange = new Exchange(location);
		exchangeArray.add(newExchange);
	}
}
