import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class ChessGUI {

	static Color BROWN = new Color(142, 59, 0);
	static Color DARK_RED = new Color(142, 0, 0);
	static Color DARK_YELLOW = new Color(200, 200, 0);
	static Color LIGHT_BLACK = new Color(95, 95, 95);
	static Color DARK_WHITE = new Color(220, 220, 220);
	
	//Create chess board grid
	static BoardSquare [][] boardSquares = new BoardSquare[8][8];
	static ArrayList<Object>[][] pieceArray;
	static Border pieceWhenSelectedBorder = BorderFactory.createDashedBorder(Color.DARK_GRAY, 2, 2, 1, true);
	static Border boardSquareWhenSelectedBorder = BorderFactory.createDashedBorder(Color.DARK_GRAY, 2, 2, 1, true);
	static Border movementHighlightedBorder = BorderFactory.createDashedBorder(Color.RED, 3, 3, 1, true);
	static Border movementHighlightedSelectedBorder = BorderFactory.createLineBorder(Color.RED, 8);	
	
	public ChessGUI() {
		
	}

	static void prepGUI() {
		
		//Create main window frame/panel objects
        JFrame mainWindow = new JFrame("Chess");
        JPanel sidePanel = new JPanel();
        JPanel gridPanel = new JPanel(new GridLayout(8, 8, 2, 2));

        //Initialise main window frame/panels
        mainWindow.setSize(1000,800);
        mainWindow.setBackground(BROWN);
		gridPanel.setBackground(BROWN);

        //Menu setup
		JMenuBar mainWindowMenuBar = new JMenuBar();
		mainWindowMenuBar.add(Box.createHorizontalGlue());
		mainWindowMenuBar.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        JMenu mainWindowMenu = new JMenu("\u2699 Options");
        mainWindowMenu.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        mainWindowMenuBar.setPreferredSize(new Dimension(50,50));
        
        //Menu Items
        JMenuItem testMenuItem = new JMenuItem("A text-only menu item");
		
        //Draw the chess board
        for (int i=0 ; i< 8 ; i++) {
        	for (int j=0 ; j< 8 ; j++) {
        		boardSquares[i][j] = new BoardSquare(i,j);
        		boardSquares[i][j].add(new JLabel());
        		boardSquares[i][j].addMouseListener(new MouseHandler());
        		((JLabel) boardSquares[i][j].getComponent(0)).setFont(new Font("Ariel", Font.BOLD, 62));
        		boardSquares[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
        		gridPanel.add(boardSquares[i][j]);
        		
        		//Colour the board squares
        		if ((i%2 == 0 && j%2 == 1) || (i%2 == 1 && j%2 == 0)) {
            		boardSquares[i][j].setBackground(LIGHT_BLACK);    			
        		} else {
        			boardSquares[i][j].setBackground(DARK_WHITE); 
        		}
        	}
        }

        //Add pieces to the chess board
        for (int i=0 ; i< 8 ; i++) {
        	for (int j=0 ; j< 8 ; j++) {
        	//	boardSquares[i][j].add(testMenuItem, new Pieces.Pawn());
        	}
        }
        
        //Add objects to main window
        mainWindow.add(gridPanel,BorderLayout.CENTER);
        mainWindow.add(sidePanel,BorderLayout.EAST);
        //Add objects to main window panels
        mainWindow.add(mainWindowMenuBar,BorderLayout.NORTH);
        mainWindow.add(mainWindowMenuBar,BorderLayout.NORTH);
        mainWindowMenuBar.add(mainWindowMenu,BorderLayout.WEST);
        //Add objects to menu
        mainWindowMenu.add(testMenuItem);
        //Main window general operations
        mainWindow.setLocationRelativeTo(null);       
        mainWindow.setVisible(true);       
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//Refreshes board icons
	static void RefreshBoard() {
		
		for (int i=0 ; i< 8 ; i++) {
        	for (int j=0 ; j< 8 ; j++) {
        		
        		if (boardSquares[i][j].getClientProperty("Piece") != null) {
        			String pieceSymbol = ((Pieces) boardSquares[i][j].getClientProperty("Piece")).getPieceSymbol();
        			((JLabel) boardSquares[i][j].getComponent(0)).setText(pieceSymbol);
        		}
        		
        	}
		}
	}

	//Sets the initial piece layout of the board
	public static void populateBoard() {
		
		//TEMP
		boardSquares[4][5].putClientProperty("Piece", new Pieces.Queen(false,boardSquares[4][5]));
		boardSquares[4][2].putClientProperty("Piece", new Pieces.Pawn(false,boardSquares[4][2]));
		
		for (int i=0 ; i<8 ; i++) {
			for (int j=0 ; j<8 ; j++) {
				
				if (i == 0) {
				boardSquares[i][0].putClientProperty("Piece", new Pieces.Rook(true,boardSquares[i][0]));
				boardSquares[i][1].putClientProperty("Piece", new Pieces.Knight(true,boardSquares[i][1]));
				boardSquares[i][2].putClientProperty("Piece", new Pieces.Bishop(true,boardSquares[i][2]));
				boardSquares[i][3].putClientProperty("Piece", new Pieces.King(true,boardSquares[i][3]));
				boardSquares[i][4].putClientProperty("Piece", new Pieces.Queen(true,boardSquares[i][4]));
				boardSquares[i][5].putClientProperty("Piece", new Pieces.Bishop(true,boardSquares[i][5]));
				boardSquares[i][6].putClientProperty("Piece", new Pieces.Knight(true,boardSquares[i][6]));
				boardSquares[i][7].putClientProperty("Piece", new Pieces.Rook(true,boardSquares[i][7]));
				}
				
				if (i == 1) {
				boardSquares[i][j].putClientProperty("Piece", new Pieces.Pawn(true,boardSquares[i][j]));
				}
				
				if (i == 6) {
				boardSquares[i][j].putClientProperty("Piece", new Pieces.Pawn(false,boardSquares[i][j]));
				}
				
				if (i == 7) {
				boardSquares[i][0].putClientProperty("Piece", new Pieces.Rook(false,boardSquares[i][0]));
				boardSquares[i][1].putClientProperty("Piece", new Pieces.Knight(false,boardSquares[i][1]));
				boardSquares[i][2].putClientProperty("Piece", new Pieces.Bishop(false,boardSquares[i][2]));
				boardSquares[i][3].putClientProperty("Piece", new Pieces.King(false,boardSquares[i][3]));
				boardSquares[i][4].putClientProperty("Piece", new Pieces.Queen(false,boardSquares[i][4]));
				boardSquares[i][5].putClientProperty("Piece", new Pieces.Bishop(false,boardSquares[i][5]));
				boardSquares[i][6].putClientProperty("Piece", new Pieces.Knight(false,boardSquares[i][6]));
				boardSquares[i][7].putClientProperty("Piece", new Pieces.Rook(false,boardSquares[i][7]));
				}
			}
		}
	}
}
