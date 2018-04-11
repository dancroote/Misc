
public class Exchange {
	
		int id;
		int locationX;
		int locationY;
		
		public Exchange(int id, int locationX, int locationY) {
			
			this.id = id;
			this.locationX = locationX;
			this.locationY = locationY;
		}
		
		public int getIdNo() {
			return this.id;
		}

		public int getLocationX() {
			return this.locationX;
		}
		
		public int getLocationY() {
			return this.locationY;
		}
		
		public int getDistance() {
			
			int distance = this.locationX + this.locationY;
			return distance;
		}
		
}
