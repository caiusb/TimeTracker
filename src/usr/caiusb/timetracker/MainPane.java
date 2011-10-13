package usr.caiusb.timetracker;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

public class MainPane extends ContentPane {
	
	private JPanel panel;

	public MainPane(MainWindow owner) {
		
		super(owner);
		BorderLayout layout = new BorderLayout();
		panel = new JPanel(layout);
		
		JTable table = new JTable();
		
		panel.add(table, layout.CENTER);
		
		JButton addProject = new JButton("Add project");
		
		panel.add(addProject, layout.SOUTH);
	}

	@Override
	public JPanel getPane() {
		return panel;
	}
}
