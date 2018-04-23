public class GameController {
	
	static Pieces previousPieceSelected;
	static Pieces pieceSelected;
	static BoardSquare previousBoardSquareSelected;
	static BoardSquare boardSquareSelected;

	public static void main(String[] args) {
		
		ChessGUI.prepGUI();
		ChessGUI.populateBoard();
        
        System.out.println(ChessGUI.boardSquares[0][0].getClientProperty("Piece"));
        
        ChessGUI.RefreshBoard();

	}
}
