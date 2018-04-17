
public class Pieces {
	
	String pieceType;
	String pieceSymbol;
	int pieceID;
	boolean isWhitePiece;
	
	class Pawn extends Pieces {
		
		public Pawn() {
			this.pieceType = "Pawn";
			
			if (isWhitePiece == true) {
				this.pieceSymbol = "\u2659"; //white pawn
			} else {
				this.pieceSymbol = "\u265F"; //black pawn
			}			
		}
	}

	class King extends Pieces {
		
		public King() {
			this.pieceType = "King";
			
			if (isWhitePiece == true) {
				this.pieceSymbol = "\u2654"; //white king
			} else {
				this.pieceSymbol = "\u265A"; //black king
			}			
		}
	}

	class Queen extends Pieces {
		
		public Queen(boolean isWhitePiece) {
			this.pieceType = "Queen";	
			
			if (isWhitePiece == true) {
				this.pieceSymbol = "\u2655"; //white queen
			} else {
				this.pieceSymbol = "\u265B"; //black queen
			}	
		}		
	}

	class Bishop extends Pieces {
		
		public Bishop(boolean isWhitePiece) {
			this.pieceType = "Bishop";	
			
			if (isWhitePiece == true) {
				this.pieceSymbol = "\u2657"; //white bishop
			} else {
				this.pieceSymbol = "\u265D"; //black bishop
			}		
		}
	}

	class Knight extends Pieces {
		
		public Knight(boolean isWhitePiece) {
			this.pieceType = "Knight";	
			
			if (isWhitePiece == true) {
				this.pieceSymbol = "\u2658"; //white bishop
			} else {
				this.pieceSymbol = "\u265E"; //black bishop
			}					
		}
	}

	class Rook extends Pieces {
		
		public Rook(boolean isWhitePiece) {
			this.pieceType = "Rook";	
			
			if (isWhitePiece == true) {
				this.pieceSymbol = "\u2656"; //white rook
			} else {
				this.pieceSymbol = "\u265C"; //black rook
			}			
		}
	}
}
