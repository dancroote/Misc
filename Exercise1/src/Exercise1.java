import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.EventHandler;
import java.util.ArrayList;

public class Exercise1 {

	public static void main(String args[]) {
		
		int gridLength = 20;
		
		TextField screen;
		screen = new TextField(36); screen.setText("");

		Frame frame = new Frame("Telco");
		Panel inputPanel = new Panel();
		Panel gridPanel = new Panel();
		gridPanel.setLayout(new GridLayout(gridLength,gridLength));
		//EventHandler E = new EventHandler(PARAM);
		frame.add(inputPanel,BorderLayout.NORTH);
		frame.add(gridPanel,BorderLayout.CENTER);
		inputPanel.add(screen);
		AllowWindowExit(frame);
		
		frame.setSize(1050, 720);
		frame.setVisible(true);
		
		Label msglabel;
		msglabel = new Label();
		msglabel.setText("HELLO");
		
		Component [][] cells = new Button[gridLength][gridLength];
		
		//Create cell Objects
		for(int i=0;i<gridLength;i++) {
			for(int j=0;j<gridLength;j++) {
			cells[i][j] = new Button();
			//((Button) cells[i][j]).setBackground(Color.magenta);
			}
		}
		
		((Button) cells[0][0]).setLabel("Cust: 0,0");
		//Add cell Objects to grid
		for(int i=0;i<gridLength;i++) {
			for(int j=0;j<gridLength;j++) {
			gridPanel.add(cells[i][j]);
			}
		}
		
		//Create array of x,y coordinates for each Exchange and Create empty Object list.
		int[][] exchangeLocations = {{6,4},{11,11},{1,2}};
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
		int minDistance = ((Exchange) exchangeArray.get(0)).getDistance();
		
		//Create array of distances of Exchanges, find smallest distance in array and return ID of that Exchange.
		for(int i=0;i<exchangeArray.size();i++ ) {
				shortestExchangeId = (((Exchange) exchangeArray.get(0)).getId());
				locationArray[i] = ((Exchange) exchangeArray.get(i)).getDistance();
	            if(locationArray[i] < minDistance) {
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
	
	public static void AllowWindowExit(Frame frame) {
		frame.addWindowListener(new WindowAdapter() 
	      
	      {
	         public void windowClosing(WindowEvent windowEvent){
	            System.exit(0);
	         }        
	      }
	      
	    		  );
	}
}
