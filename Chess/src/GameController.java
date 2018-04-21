import java.util.ArrayList;

public class GameController {
	
	static ArrayList<Object>[][] pieceArray;

	public static void main(String[] args) {
		
		ChessGUI.prepGUI();

	}

	public void populateBoard() {
		
		for (int i=8 ; i<8 ; i++) {
			for (int j=8 ; j<8 ; j++) {
				//ChessGUI.boardSquares[i][j].putClientProperty("Pawn", new Pieces.Pawn());
			}
		}
		  ChessGUI.boardSquares[0][0].add(null, new Pieces.Pawn(true));
		  
	}
}
