import java.util.Arrays;

public class Exchange {
	
		int[] location;
		
		public Exchange(int[] location) {
			
			this.location = location;
		}
		
		public String getId() {
			return "ID: " +Arrays.toString(this.location); 
		}
		
		public int[] getLocation() {
			return this.location; 
		}
		
		public int getDistance() {
			
			int distance = this.location[0] + this.location[1];
			return distance;
		}
		
		public String ShortestExchangeId() {
			
			String shortestExchangeId = "";
			int[] locationArray = new int[GUI.exchangeArray.size()];
			int minDistance = ((Exchange) GUI.exchangeArray.get(0)).getDistance();
			
			for(int i=0;i<GUI.exchangeArray.size();i++ ) {
					shortestExchangeId = (((Exchange) GUI.exchangeArray.get(0)).getId());
					locationArray[i] = ((Exchange) GUI.exchangeArray.get(i)).getDistance();
		            if(locationArray[i] < minDistance) {
		            	minDistance = locationArray[i];
		            	shortestExchangeId = (((Exchange) GUI.exchangeArray.get(i)).getId());
		            }
				}
					return shortestExchangeId;
		}
}
