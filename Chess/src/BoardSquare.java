import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BoardSquare extends JPanel{

	public int locationX;
	public int locationY;
	public boolean isHighlighted = false;
	
	public BoardSquare(int locationX, int locationY) {
		
		this.locationX = locationX;
		this.locationY = locationY;
	}

	public int getLocationX() {
		return this.locationX;
	}
	
	public int getLocationY() {
		return this.locationY;
	}
	
	public void drawHighlightHoverBorder() {
		setBorder(ChessGUI.boardSquareWhenSelectedBorder);
	}
}
