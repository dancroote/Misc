import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

class Exercise1UnitTests {

	//New main-method-containing object
	Exercise1 e1 = new Exercise1();
	
	//Sample Exchange location data array
	int[][] testLocations = { {2,2} , {3,5} , {16,14} , {100,100} , {10,10} , {99,100} , {100,99} , {50,50}};

	//Sample object array to store Exchange objects
	ArrayList<Object> emptyTestArray = new ArrayList<Object>();
	
	//Sample instantiation of Exchange object at first location in sample location array
	Exchange testExchange0 = new Exchange(testLocations[0]);
	
	//Method to populate an array with sample location data
	public void populateSampleArray(ArrayList<Object> locationArray) {
		for (int i=0;i<testLocations.length;i++) {
			locationArray.add(new Exchange(testLocations[i]));
		}
	}
	
	@Test
	void CreateExchange() {
		e1.CreateExchange(emptyTestArray, testLocations[0]);
		assertEquals(((Exchange) emptyTestArray.get(0)).getLocation(), testLocations[0]);
	}
	
	@Test
	void getId() {
		for (int i=0;i<testLocations.length;i++) {
		assertEquals("ID: "+Arrays.toString(testLocations[i]),"ID: "+Arrays.toString(new Exchange(testLocations[i]).getLocation()));
		}
	}
	
	@Test
	void getLocation() {
		for (int i=0;i<testLocations.length;i++) {
		assertEquals(testLocations[i], (new Exchange(testLocations[i]).getLocation() ));
		}
	}

	@Test
	void getDistance() {
		for (int i=0;i<testLocations.length;i++) {
		assertEquals(testLocations[i][0] + testLocations[i][1], (new Exchange(testLocations[i]).getDistance()));
		}
	}
	
	@Test
	void ShortestExchangeIdSingleExchange() {
		// One Exchange.
		Exchange testExchange = new Exchange(testLocations[0]);
		GUI.exchangeArray.add(testExchange);
		assertEquals("ID: " + Arrays.toString(testLocations[0]), testExchange0.ShortestExchangeId());
	}
	
	@Test
	void ShortestExchangeIdMultipleExchange() {
		// Multiple Exchanges.
		populateSampleArray(GUI.exchangeArray);
		assertEquals("ID: " + Arrays.toString(testLocations[0]), testExchange0.ShortestExchangeId());
	}
}
