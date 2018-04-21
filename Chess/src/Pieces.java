
public class Pieces {
	
	String pieceType;
	String pieceSymbol;
	int pieceID;
	boolean isWhitePiece;
	
	static class Pawn extends Pieces {
		
		public Pawn(boolean isWhitePiece) {
			this.pieceType = "Pawn";
			this.isWhitePiece = isWhitePiece;
			
			if (isWhitePiece == true) {
				this.pieceSymbol = "\u2659"; //white pawn
			} else {
				this.pieceSymbol = "\u265F"; //black pawn
			}			
		}
	}

	static class King extends Pieces {
		
		public King(boolean isWhitePiece) {
			this.pieceType = "King";
			this.isWhitePiece = isWhitePiece;
			
			if (isWhitePiece == true) {
				this.pieceSymbol = "\u2654"; //white king
			} else {
				this.pieceSymbol = "\u265A"; //black king
			}			
		}
	}

	static class Queen extends Pieces {
		
		public Queen(boolean isWhitePiece) {
			this.pieceType = "Queen";
			this.isWhitePiece = isWhitePiece;
			
			if (isWhitePiece == true) {
				this.pieceSymbol = "\u2655"; //white queen
			} else {
				this.pieceSymbol = "\u265B"; //black queen
			}	
		}		
	}

	static class Bishop extends Pieces {
		
		public Bishop(boolean isWhitePiece) {
			this.pieceType = "Bishop";
			this.isWhitePiece = isWhitePiece;
			
			if (isWhitePiece == true) {
				this.pieceSymbol = "\u2657"; //white bishop
			} else {
				this.pieceSymbol = "\u265D"; //black bishop
			}		
		}
	}

	static class Knight extends Pieces {
		
		public Knight(boolean isWhitePiece) {
			this.pieceType = "Knight";
			this.isWhitePiece = isWhitePiece;
			
			if (isWhitePiece == true) {
				this.pieceSymbol = "\u2658"; //white bishop
			} else {
				this.pieceSymbol = "\u265E"; //black bishop
			}					
		}
	}

	static class Rook extends Pieces {
		
		public Rook(boolean isWhitePiece) {
			this.pieceType = "Rook";
			this.isWhitePiece = isWhitePiece;
			
			if (isWhitePiece == true) {
				this.pieceSymbol = "\u2656"; //white rook
			} else {
				this.pieceSymbol = "\u265C"; //black rook
			}			
		}
	}
}
