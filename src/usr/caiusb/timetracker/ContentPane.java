package usr.caiusb.timetracker;

import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class ContentPane {
	
	protected MainWindow ownerFrame;
	
	public ContentPane(MainWindow owner) {
		this.ownerFrame = owner;
	}
	
	/**
	 * Returns the <code>JPanel</code> that will be used in
	 * the window
	 * @return
	 */
	public abstract JPanel getPane();
}
