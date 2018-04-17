import java.awt.*;
import javax.swing.*;

public class CivGUI {
	
	public CivGUI() {
		
	}

	static void prepGUI() {
		
		//Main window frame/panel objects
        JFrame mainWindow = new JFrame("Telco");
        JPanel mainWindowTopBar = new JPanel();
        Menu mainWindowMenu = new Menu();

        //Main window frame/panels initialisation
        mainWindow.setSize(1000,800);
        
        JLabel mainLabel = new JLabel();
        
        JPanel gamePanel = new JPanel();
        

        
        mainWindow.setLocationRelativeTo(null);       
        mainWindow.setVisible(true);       
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
        
	}
}
