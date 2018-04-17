import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class EventHandler implements ActionListener {
	
		int exchangeCount = 0;
		int[] location;
		JTextField textfieldX;
		JTextField textfieldY;
		String xText;
		String yText;
		
		public EventHandler(int[] location) {
			this.location = location;
		}
		
		public EventHandler(JTextField textfieldX, JTextField textfieldY) {
			this.textfieldX = textfieldX;
			this.textfieldY = textfieldY;
		}

		public void actionPerformed(ActionEvent E2) {

			JButton buttonSelected = (JButton)E2.getSource();
			int maxGridSize = 100;
			
			if (buttonSelected.getText() == "REDRAW") {
				try {
				textfieldX.setText(textfieldX.getText());
				textfieldY.setText(textfieldY.getText());
				int x = Integer.parseInt(textfieldX.getText());
				int y = Integer.parseInt(textfieldY.getText());
				if ((x <= maxGridSize && y <= maxGridSize) && (x >=0 && y >= 0)) {
					((JFrame) buttonSelected.getParent().getParent().getParent().getParent().getParent()).dispose();
					GUI.exchangeArray.clear();
					GUI.outputField.setText("");
					GUI.RestartGUI(x, y);
				} else {
					JOptionPane.showMessageDialog(null, "Please enter positive values up to " + maxGridSize + ".");
					textfieldX.setText("");
					textfieldY.setText("");
				}
				} catch(Exception NumberFormatException) {
					JOptionPane.showMessageDialog(null, "Invalid input!");
					textfieldX.setText("");
					textfieldY.setText("");
				}
			} 			
			else if (buttonSelected.getClientProperty("exchanges") == null && GUI.exchangeArray.size() < 10) {
			buttonSelected.setBackground(Color.GREEN);
			buttonSelected.setText("E: " + buttonSelected.getText());
			buttonSelected.putClientProperty("exchanges", new Exchange(location));
			GUI.exchangeArray.add(new Exchange(location));
			((Exchange) GUI.exchangeArray.get(0)).ShortestExchangeId();
			
			if(GUI.exchangeArray.size() > 1) {
				GUI.performLogic();
				}
			} else {
				if(buttonSelected.getClientProperty("exchanges") != null) {
					JOptionPane.showMessageDialog(null, "An Exchange already exists at this location.");
				} else {
					JOptionPane.showMessageDialog(null, "The maximum number of exchanges is 10.");
				}
			}
		}
	}