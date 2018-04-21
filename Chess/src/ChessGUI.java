import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class ChessGUI {
	
	//Create chess board grid
	static JPanel [][] boardSquares = new JPanel[8][8];
	static ArrayList<Object>[][] pieceArray;
	
	public ChessGUI() {
		
	}

	static void prepGUI() {
		

		Color BROWN = new Color(142, 59, 0);
		
		//Create main window frame/panel objects
        JFrame mainWindow = new JFrame("Chess");
        JPanel mainWindowTopBar = new JPanel();
		JPanel gridPanel = new JPanel(new GridLayout(8, 8, 2, 2));

        //Initialise main window frame/panels
        mainWindow.setSize(1000,800);
        mainWindow.setBackground(BROWN);
		gridPanel.setBackground(BROWN);

        //Menu setup
		JMenuBar mainWindowMenuBar = new JMenuBar();
        JMenu mainWindowMenu = new JMenu("Menu");
        mainWindowMenuBar.setPreferredSize(new Dimension(50,50));
        
        //Menu Items
        JMenuItem testMenuItem = new JMenuItem("A text-only menu item");
		
        //Draw the chess board
        for (int i=0 ; i< 8 ; i++) {
        	for (int j=0 ; j< 8 ; j++) {
        		boardSquares[i][j] = new JPanel();
        		boardSquares[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
        		gridPanel.add(boardSquares[i][j]);
        		
        		//Colour the board squares
        		if ((i%2 == 0 && j%2 == 1) || (i%2 == 1 && j%2 == 0)) {
            		boardSquares[i][j].setBackground(Color.DARK_GRAY);       			
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
        mainWindow.add(mainWindowTopBar,BorderLayout.NORTH);
        mainWindow.add(gridPanel,BorderLayout.CENTER);
        //Add objects to main window panels
        mainWindowTopBar.add(mainWindowMenuBar,BorderLayout.WEST);
        mainWindowMenuBar.add(mainWindowMenu,BorderLayout.WEST);
        //Add objects to menu
        mainWindowMenu.add(testMenuItem);
        //Main window general operations
        mainWindow.setLocationRelativeTo(null);       
        mainWindow.setVisible(true);       
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        
        System.out.println(boardSquares[0][0].getComponent(0));
	}
	
	static void RefreshBoard() {
		
		for (int i=0 ; i< 8 ; i++) {
        	for (int j=0 ; j< 8 ; j++) {
        		
        		if (boardSquares[i][j].getClientProperty("Piece") != null) {
        			boardSquares[i][j].getComponent(0);
        		}
        		
        	}
		}
	}
	
	static void DrawPiece(JPanel panelSelected) {
		
	}
	
}
