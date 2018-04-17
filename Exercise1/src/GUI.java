import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class GUI extends JPanel {
	
	static ArrayList<Object> exchangeArray =  new ArrayList<>();
	static JTextField outputField = new JTextField(10); 
	
	public GUI(int gridLength) {
		
		SwingUtilities.invokeLater(() -> {
		PrepGui(gridLength, gridLength);
		});
	}
	
	static void RestartGUI(int x, int y) {
		
		SwingUtilities.invokeLater(() -> {
			PrepGui(y, x);
			});
	}
	
	static void PrepGui(int gridLengthX, int gridLengthY) {

	    Font font = new Font("Verdana",Font.BOLD,12);
		int gridMaxX = gridLengthX;
		int gridMaxY = gridLengthY;
		// Grid size of 0 validation
		if(gridLengthX == 0 || gridLengthY == 0) {
			gridMaxX++;
			gridMaxY++;
		}
		String xText = "", yText = "";
		String xLabel = "xLabel", yLabel = "yLabel";
		JTextField inputX = new JTextField(xText);
	    JTextField inputY = new JTextField(yText);
	    inputX = new JTextField(16);
	    inputY = new JTextField(16);
        inputX.setText("");
        inputX.setFont(font);
        inputY.setText("");
        inputY.setFont(font);
        inputX.putClientProperty("xLabel", xLabel);
        inputY.putClientProperty("yLabel", yLabel);
        inputX.addActionListener(new EventHandler(inputX, inputY));
        inputY.addActionListener(new EventHandler(inputX, inputY));
        
        JButton submit = new JButton("REDRAW");
        submit.addActionListener(new EventHandler(inputX, inputY));
        inputX.putClientProperty("customer", xLabel);

        JLabel closestExchangeOutput = new JLabel("");
        JLabel inputXLabel = new JLabel("input x:");
        JLabel inputYLabel = new JLabel("input y:");
        JFrame frame = new JFrame("Telco");
		JPanel inputPanel = new JPanel();
		JPanel gridPanel = new JPanel(new GridLayout(gridMaxX,gridMaxY));
		gridPanel.setSize(new Dimension(800,800));
        JLabel closestExchangeLabel = new JLabel("Closest Exchange ID:    ");
        closestExchangeOutput.setBackground(Color.GRAY);
		JPanel blankPanel = new JPanel();
        
        frame.setSize(1000,800);
		frame.add(inputPanel,BorderLayout.NORTH);
		inputPanel.add(inputXLabel);
		inputPanel.add(inputX);
		inputPanel.add(inputYLabel);
		inputPanel.add(inputY);
		inputPanel.add(submit);
		inputPanel.add(blankPanel);
		inputPanel.add(closestExchangeLabel);
		inputPanel.add(outputField);
		outputField.setFont(font);
		
		JButton[][] buttons = new JButton[gridMaxX][gridMaxY];
		JPanel [][] cells = new JPanel[gridMaxX][gridMaxY];
        for (int i = 0; i < gridMaxX; i++) {
            for (int j = 0; j < gridMaxY; j++) {
            	cells[i][j] = new JPanel();
                frame.add(cells[i][j]);
                
                int[] location = {i,j};
                buttons[i][j] = new JButton();
                buttons[i][j].setBackground(Color.GRAY);
                buttons[i][j].setPreferredSize(new Dimension(70, 70));
                buttons[i][j].setSize(new Dimension(70, 70));
                buttons[i][j].addActionListener(new EventHandler(location));
				buttons[i][j].addMouseListener(new MouseHandler(j, i));
                cells[i][j].add(buttons[i][j]); 
                gridPanel.add(cells[i][j]);
                if (i == 0 && j == 0) {
                buttons[0][0].putClientProperty("customer", new Customer());
                buttons[0][0].setBackground(Color.PINK);
                buttons[0][0].setText("C: " + i + "," +j);
                }
            }
        }
        
        gridPanel.setSize(new Dimension(800, 800));
		JScrollPane scrollPane = new JScrollPane(gridPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        frame.add(scrollPane,BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);       
        frame.setVisible(true);       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
    }
	
	public static void performLogic() {
		for(int i=0;i<GUI.exchangeArray.size();i++) {
			GUI.outputField.setText(((Exchange) GUI.exchangeArray.get(i)).ShortestExchangeId());
			if(GUI.exchangeArray.size() == 0) {
				GUI.outputField.setText("");
			}
		}
	}
}
