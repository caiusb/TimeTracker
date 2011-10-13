package usr.caiusb.timetracker;

import javax.swing.UIManager;

public class Main {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.setProperty("com.apple.mrj.application.apple.menu.about.name", "TimeTracker");
        try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
		}
        
		MainWindow window = new MainWindow();
		window.show();
	}

}
