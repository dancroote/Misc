import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class MouseHandler implements MouseListener {
	
	@Override
	public void mouseClicked(MouseEvent mouseAction) {
	
		BoardSquare boardSquareSelected = (BoardSquare) mouseAction.getSource();
		Pieces pieceSelected = (Pieces) boardSquareSelected.getClientProperty("Piece");
		
		//Set selected piece
		
		if(pieceSelected != null && pieceSelected != GameController.pieceSelected) {
			
			//Change old selected piece
			GameController.previousBoardSquareSelected = GameController.boardSquareSelected;
			GameController.previousPieceSelected = GameController.pieceSelected;
			if (GameController.previousBoardSquareSelected != null) {
			GameController.previousPieceSelected.setMovementPaths(false);
			((JLabel) GameController.previousBoardSquareSelected.getComponent(0)).setBorder(null);
			GameController.previousPieceSelected.setIsSelected(false);
			}
			
			//Select new piece
			GameController.boardSquareSelected = boardSquareSelected;
			GameController.pieceSelected = (Pieces) boardSquareSelected.getClientProperty("Piece");			
			pieceSelected.setIsSelected(true);
			pieceSelected.setMovementPaths(true);
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent mouseAction) {
		
		BoardSquare boardSquareSelected = (BoardSquare) mouseAction.getSource();
		Pieces pieceSelected = (Pieces) boardSquareSelected.getClientProperty("Piece");
		
		//Draw border when hovered over		
		if(pieceSelected != null) {
			((JLabel) boardSquareSelected.getComponent(0)).setBorder(ChessGUI.pieceWhenSelectedBorder);
		}
			if (boardSquareSelected.getBorder() == ChessGUI.movementHighlightedBorder) {
				boardSquareSelected.setBorder(ChessGUI.boardSquareWhenSelectedBorder);
			}
	}

	@Override
	public void mouseExited(MouseEvent mouseAction) {
		
		BoardSquare boardSquareSelected = (BoardSquare) mouseAction.getSource();
		Pieces pieceSelected = (Pieces) boardSquareSelected.getClientProperty("Piece");
		
		//Remove border when mouse moves away		
		if(pieceSelected != null && pieceSelected != GameController.pieceSelected) {
			((JLabel) boardSquareSelected.getComponent(0)).setBorder(null);
		}
		
		if (boardSquareSelected.getBorder() == ChessGUI.boardSquareWhenSelectedBorder) {
			boardSquareSelected.setBorder(ChessGUI.movementHighlightedBorder);
		}
	}

	@Override
	public void mousePressed(MouseEvent mouseAction) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent mouseAction) {
		// TODO Auto-generated method stub
		
	}
}
