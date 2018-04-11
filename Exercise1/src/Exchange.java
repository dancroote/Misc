import java.util.Arrays;

public class Exchange {
	
		int[] location;
		
		public Exchange(int[] location) {
			
			this.location = location;
		}
		
		public String getId() {
			return "ID: " + Arrays.toString(this.location);
		}
		
		public int[] getLocation() {
			return this.location;
		}
		
		public int getDistance() {
			
			int distance = this.location[0] + this.location[1];
			return distance;
		}
}
