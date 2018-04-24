import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class Pieces {
	
	String pieceType;
	String pieceSymbol;
	int pieceID;
	boolean isWhitePiece;
	boolean isSelected;
	BoardSquare boardSquareLocatedOn;
	
	static class Pawn extends Pieces {
		
		public Pawn(boolean isWhitePiece, BoardSquare boardSquareLocatedOn) {
			this.pieceType = "Pawn";
			this.isWhitePiece = isWhitePiece;
			this.boardSquareLocatedOn= boardSquareLocatedOn;
			
			if (isWhitePiece) {
				this.pieceSymbol = "\u2659"; //white pawn
			} else {
				this.pieceSymbol = "\u265F"; //black pawn
			}
		}
	}

	static class King extends Pieces {
		
		public King(boolean isWhitePiece, BoardSquare boardSquareLocatedOn) {
			this.pieceType = "King";
			this.isWhitePiece = isWhitePiece;
			this.boardSquareLocatedOn= boardSquareLocatedOn;
			
			if (isWhitePiece) {
				this.pieceSymbol = "\u2654"; //white king
			} else {
				this.pieceSymbol = "\u265A"; //black king
			}			
		}
	}

	static class Queen extends Pieces {
		
		public Queen(boolean isWhitePiece, BoardSquare boardSquareLocatedOn) {
			this.pieceType = "Queen";
			this.isWhitePiece = isWhitePiece;
			this.boardSquareLocatedOn= boardSquareLocatedOn;
			
			if (isWhitePiece) {
				this.pieceSymbol = "\u2655"; //white queen
			} else {
				this.pieceSymbol = "\u265B"; //black queen
			}	
		}		
	}

	static class Bishop extends Pieces {
		
		public Bishop(boolean isWhitePiece, BoardSquare boardSquareLocatedOn) {
			this.pieceType = "Bishop";
			this.isWhitePiece = isWhitePiece;
			this.boardSquareLocatedOn= boardSquareLocatedOn;
			
			if (isWhitePiece) {
				this.pieceSymbol = "\u2657"; //white bishop
			} else {
				this.pieceSymbol = "\u265D"; //black bishop
			}		
		}
	}

	static class Knight extends Pieces {
		
		public Knight(boolean isWhitePiece, BoardSquare boardSquareLocatedOn) {
			this.pieceType = "Knight";
			this.isWhitePiece = isWhitePiece;
			this.boardSquareLocatedOn= boardSquareLocatedOn;
			
			if (isWhitePiece) {
				this.pieceSymbol = "\u2658"; //white bishop
			} else {
				this.pieceSymbol = "\u265E"; //black bishop
			}					
		}
	}

	static class Rook extends Pieces {
		
		public Rook(boolean isWhitePiece, BoardSquare boardSquareLocatedOn) {
			this.pieceType = "Rook";
			this.isWhitePiece = isWhitePiece;
			this.boardSquareLocatedOn= boardSquareLocatedOn;
			
			if (isWhitePiece) {
				this.pieceSymbol = "\u2656"; //white rook
			} else {
				this.pieceSymbol = "\u265C"; //black rook
			}			
		}
	}
	
	public String getPieceType() {
		return this.pieceType;
	}
	
	public String getPieceSymbol() {
		return this.pieceSymbol;
	}
	
	public boolean getIsWhitePiece() {
		return this.isWhitePiece;
	}
	
	public void setIsSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}
	
	public boolean getIsSelected() {
		return this.isSelected;
	}
	
	public BoardSquare getBoardSquareLocatedOn() {
		return this.boardSquareLocatedOn;
	}
	
	public void setBoardSquareLocatedOn(BoardSquare boardSquareLocatedOn) {
		this.boardSquareLocatedOn = boardSquareLocatedOn;
	}
	
	public void setMovementPaths(boolean areVisible) {
		
		//set highlights on or off
		Border HighlightBorder;
		if (areVisible) {
			HighlightBorder = ChessGUI.movementHighlightedBorder;
		} else {
			HighlightBorder = null; }
		
		//directional modifier
		int direction;
			if (!isWhitePiece) {
				direction = -1;
			} else { direction = 1; }

			int x = boardSquareLocatedOn.locationX;
			int y = boardSquareLocatedOn.locationY;
		
		if (isSelected && pieceType == "Pawn") {
			//Three squares ahead
			highlightPainter(x+direction, y, HighlightBorder);
			highlightPainter(x+direction, y+direction, HighlightBorder);
			highlightPainter(x+direction, y-direction, HighlightBorder);
		}
		
		if (isSelected && pieceType == "Knight") {
			//Two farthest squares ahead
			highlightPainter(x+2*direction, y+direction, HighlightBorder);
			highlightPainter(x+2*direction, y-direction, HighlightBorder);
			//Two second farther squares ahead
			highlightPainter(x+direction, y+2*direction, HighlightBorder);
			highlightPainter(x+direction, y-2*direction, HighlightBorder);
			//Two second farther squares behind
			highlightPainter(x-direction, y+2*direction, HighlightBorder);
			highlightPainter(x-direction, y-2*direction, HighlightBorder);
			//Two farthest squares behind
			highlightPainter(x-2*direction, y+direction, HighlightBorder);
			highlightPainter(x-2*direction, y-direction, HighlightBorder);
		}
		
		if (isSelected && pieceType == "King") {
			
			//All squares surrounding
			for (int i=-1;i<2;i++) {
				for(int j=-1;j<2;j++) {
					if (i==0 & j==0) {} else {
						highlightPainter(x+i, y+j, HighlightBorder);
					}
				}
			}
		}
		
		if (isSelected && pieceType == "Rook") {
			//All vertical and horizontal directions
			try {
				for (int i=1; i<7; i++) {
					if (chessPieceAt(x, y-i) == null) {
						highlightPainter(x, y-i, HighlightBorder);
					} else { break; }
				}
			} catch (ArrayIndexOutOfBoundsException e) {}
			
			try {
				for (int i=1; i<7; i++) {
					if (chessPieceAt(x, y+i) == null) {
						highlightPainter(x, y+i, HighlightBorder);
					} else { break; }
				}
			} catch (ArrayIndexOutOfBoundsException e) {}
			
			try {
				for (int i=1; i<7; i++) {
					if (chessPieceAt(x+i, y) == null) {
						highlightPainter(x+i, y, HighlightBorder);
					} else { break; }
				}
			} catch (ArrayIndexOutOfBoundsException e) {}
			
			try {
				for (int i=1; i<7; i++) {
					if (chessPieceAt(x-i, y) == null) {
						highlightPainter(x-i, y, HighlightBorder);
					} else { break; }
				}
			} catch (ArrayIndexOutOfBoundsException e) {}
		}
				
		if (isSelected && pieceType == "Bishop") {
			//All diagonal directions
			try {
				for (int i=1; i<7; i++) {
					if (chessPieceAt(x-i, y-i) == null) {
						highlightPainter(x-i, y-i, HighlightBorder);
					} else { break; }
				}
			} catch (ArrayIndexOutOfBoundsException e) {}
			
			try {
				for (int i=1; i<7; i++) {
					if (chessPieceAt(x+i, y+i) == null) {
						highlightPainter(x+i, y+i, HighlightBorder);
					} else { break; }
				}
			} catch (ArrayIndexOutOfBoundsException e) {}
			
			try {
				for (int i=1; i<7; i++) {
					if (chessPieceAt(x+i, y-i) == null) {
						highlightPainter(x+i, y-i, HighlightBorder);
					} else { break; }
				}
			} catch (ArrayIndexOutOfBoundsException e) {}
			
			try {
				for (int i=1; i<7; i++) {
					if (chessPieceAt(x-i, y+i) == null) {
						highlightPainter(x-i, y+i, HighlightBorder);
					} else { break; }
				}
			} catch (ArrayIndexOutOfBoundsException e) {}
		}
		
		if (isSelected && pieceType == "Queen") {
			//All diagonal directions
			try {
				for (int i=1; i<7; i++) {
					if (chessPieceAt(x-i, y-i) == null) {
						highlightPainter(x-i, y-i, HighlightBorder);
					} else { break; }
				}
			} catch (ArrayIndexOutOfBoundsException e) {}
			
			try {
				for (int i=1; i<7; i++) {
					if (chessPieceAt(x+i, y+i) == null) {
						highlightPainter(x+i, y+i, HighlightBorder);
					} else { break; }
				}
			} catch (ArrayIndexOutOfBoundsException e) {}
			
			try {
				for (int i=1; i<7; i++) {
					if (chessPieceAt(x+i, y-i) == null) {
						highlightPainter(x+i, y-i, HighlightBorder);
					} else { break; }
				}
			} catch (ArrayIndexOutOfBoundsException e) {}
			
			try {
				for (int i=1; i<7; i++) {
					if (chessPieceAt(x-i, y+i) == null) {
						highlightPainter(x-i, y+i, HighlightBorder);
					} else { break; }
				}
			} catch (ArrayIndexOutOfBoundsException e) {}
			//All vertical and horizontal directions
			try {
				for (int i=1; i<7; i++) {
					if (chessPieceAt(x, y-i) == null) {
						highlightPainter(x, y-i, HighlightBorder);
					} else { break; }
				}
				
			} catch (ArrayIndexOutOfBoundsException e) {}
			
			try {
				for (int i=1; i<7; i++) {
					if (chessPieceAt(x, y+i) == null) {
						highlightPainter(x, y+i, HighlightBorder);
					} else { break; }
				}
			} catch (ArrayIndexOutOfBoundsException e) {}
			
			try {
				for (int i=1; i<7; i++) {
					if (chessPieceAt(x+i, y) == null) {
						highlightPainter(x+i, y, HighlightBorder);
					} else { break; }
				}
			} catch (ArrayIndexOutOfBoundsException e) {}
			
			try {
				for (int i=1; i<7; i++) {
					if (chessPieceAt(x-i, y) == null) {
						highlightPainter(x-i, y, HighlightBorder);
					} else { break; }
				}
			} catch (ArrayIndexOutOfBoundsException e) {}
		}
	}
	
	public void highlightPainter(int x, int y, Border HighlightBorder) {		
		try { ChessGUI.boardSquares[x][y].setBorder(HighlightBorder); 
		} catch (ArrayIndexOutOfBoundsException e) {}
	}
	
	public Object chessPieceAt(int x, int y) {
		return ChessGUI.boardSquares[x][y].getClientProperty("Piece");
	}
}
