import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class MouseHandler implements MouseListener {
	int xCoord;
	int yCoord;
	
	public MouseHandler(int xCoord, int yCoord) {
		this.xCoord = yCoord;
		this.yCoord = xCoord;
	}

	@Override
	public void mouseClicked(MouseEvent mouseAction) {

		JButton buttonSelected = (JButton)mouseAction.getSource();
		if(mouseAction.getButton() == MouseEvent.BUTTON3 && buttonSelected.getClientProperty("customer") == null) {
			if(buttonSelected.getClientProperty("exchanges") != null) {
				for(int i=0;i<GUI.exchangeArray.size();i++) {	
					int[] location = ((Exchange) buttonSelected.getClientProperty("exchanges")).getLocation();
				if (((Exchange) GUI.exchangeArray.get(i)).getLocation() == location) {
					buttonSelected.putClientProperty("exchanges", null);
					GUI.exchangeArray.remove(i);
					}
				}
				if(buttonSelected.getClientProperty("customer") == null) {
					buttonSelected.setBackground(Color.GRAY);
					buttonSelected.setText( "" );
					} else {
					buttonSelected.setBackground(Color.PINK);
					buttonSelected.setText( "C: "+ (xCoord) +","+ (yCoord) );
				}				
			}
		}
		if(GUI.exchangeArray.size() > 1) {
			GUI.performLogic();
			}
		if(GUI.exchangeArray.size() == 1) {
			GUI.outputField.setText("");			
			}
	}

	@Override
	public void mouseEntered(MouseEvent mouseAction) {

		JButton buttonSelected = (JButton)mouseAction.getSource();		
		if(buttonSelected.getClientProperty("customer") != null) {				
			} else if (buttonSelected.getClientProperty("exchanges") == null) {
				buttonSelected.setBackground(Color.LIGHT_GRAY);
				buttonSelected.setText( (xCoord) +","+ (yCoord) );
			} else if (buttonSelected.getClientProperty("exchanges") != null){
				buttonSelected.setBackground(Color.GREEN);
				buttonSelected.setText( "E: "+ (xCoord) +","+ (yCoord) );
		}
	}

	@Override
	public void mouseExited(MouseEvent mouseAction) {
		
		JButton buttonSelected = (JButton)mouseAction.getSource();
		
		if(buttonSelected.getClientProperty("customer") != null) {
		} else if (buttonSelected.getClientProperty("exchanges") == null) {
			buttonSelected.setBackground(Color.GRAY);
			buttonSelected.setText( "" );
		} else {
			buttonSelected.setBackground(Color.GREEN);
			buttonSelected.setText( "E: "+ (xCoord) +","+ (yCoord) );
		}
		if(GUI.exchangeArray.size() > 1) {
			GUI.performLogic();
			}
		if(GUI.exchangeArray.size() == 0) {
			GUI.outputField.setText("");
		}
	}

	@Override
	public void mousePressed(MouseEvent mouseAction) {

		JButton buttonSelected = (JButton)mouseAction.getSource();
		
		if(buttonSelected.getClientProperty("customer") != null) {	
		} else if (buttonSelected.getClientProperty("exchanges") == null) {
		buttonSelected.setBackground(Color.RED);
		buttonSelected.setText( (xCoord) +","+ (yCoord) );
		} else if (buttonSelected.getClientProperty("exchanges") != null){
			buttonSelected.setBackground(Color.GREEN);
			buttonSelected.setText( "E: "+ (xCoord) +","+ (yCoord) );
		}
		if(GUI.exchangeArray.size() > 1) {
			GUI.performLogic();
			}
		if(GUI.exchangeArray.size() == 0) {
			GUI.outputField.setText("");
		}
	}

	@Override
	public void mouseReleased(MouseEvent mouseAction) {
		
		JButton buttonSelected = (JButton)mouseAction.getSource();

		try {
		if(mouseAction.getButton() == MouseEvent.BUTTON3) {
			if(buttonSelected.getClientProperty("exchanges") != null) {
				for(int i=0;i<GUI.exchangeArray.size();i++) {	
					int[] location = ((Exchange) buttonSelected.getClientProperty("exchanges")).getLocation();
				if (((Exchange) GUI.exchangeArray.get(i)).getLocation() == location) {
					buttonSelected.putClientProperty("exchanges", null);
					GUI.exchangeArray.remove(i);

					if(buttonSelected.getClientProperty("customer") == null) {
					buttonSelected.setBackground(Color.GRAY);
					buttonSelected.setText( "" );
					} else {
						buttonSelected.setBackground(Color.PINK);
						buttonSelected.setText( "C: "+ (xCoord) +","+ (yCoord) );
							}
						}
					}
				}
			}
		} catch(Exception NullPointerException) {}
		
		if(GUI.exchangeArray.size() > 1) {
			GUI.performLogic();
			}
		if(GUI.exchangeArray.size() == 1) {
			GUI.outputField.setText("");			
		}
	}
}