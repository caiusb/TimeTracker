package usr.caiusb.timetracker;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

public class TimeTrackerMainWindow {
	
	private JFrame frame;
	private JTable table;
	private JButton backButton;
	private JButton forwardButton;
	
	public TimeTrackerMainWindow() {
		frame = new JFrame();
		
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setSize(400, 200);
		frame.setTitle("TimeTracker");
		
		JPanel navigationPanel = newPanelWithGridBagLayout();
		frame.getContentPane().add(navigationPanel, BorderLayout.NORTH);
		
		ActionListener dumbActionListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		};
		
		String leftTriangle = "\u25C0";
		backButton = new JButton(leftTriangle);
		backButton.addActionListener(dumbActionListener);
		GridBagConstraints backButtonConstraints = new GridBagConstraints();
		backButtonConstraints.gridx = 0;
		backButtonConstraints.gridy = 0;
		navigationPanel.add(backButton, backButtonConstraints);
		
		backButton.setEnabled(false);
		
		String rightTriangle = "\u25BA";
		forwardButton = new JButton(rightTriangle);
		backButton.addActionListener(dumbActionListener);
		GridBagConstraints forwardButtonConstaints = new GridBagConstraints();
		forwardButtonConstaints.gridx = 1;
		forwardButtonConstaints.gridy = 0;
		navigationPanel.add(forwardButton, forwardButtonConstaints);
		forwardButton.setEnabled(false);
		
		table = new JTable();
		frame.getContentPane().add(table, BorderLayout.CENTER);
		
		JPanel newActivityPanel = newPanelWithGridBagLayout();
		frame.getContentPane().add(newActivityPanel, BorderLayout.SOUTH);
		
		JButton newActivityButton = new JButton("New activity");
		GridBagConstraints newActivityButtonConstaints = new GridBagConstraints();
		newActivityButtonConstaints.insets = new Insets(0, 0, 0, 5);
		newActivityButtonConstaints.gridx = 11;
		newActivityButtonConstaints.gridy = 0;
		newActivityPanel.add(newActivityButton, newActivityButtonConstaints);
	}

	private JPanel newPanelWithGridBagLayout() {
		JPanel panel = new JPanel();
		GridBagLayout layout = new GridBagLayout();
		layout.columnWidths = new int[]{0, 0, 0, 0};
		layout.rowHeights = new int[]{0, 0};
		layout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		layout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(layout);
		return panel;
	}
	
	public void show() {
		frame.setVisible(true);
	}
	
	public void hide() {
		frame.setVisible(false);
	}
	
	public void setBackEnabled(boolean enabled) {
		backButton.setEnabled(enabled);
	}
	
	public void setForwardEnabled(boolean enabled) {
		forwardButton.setEnabled(enabled);
	}
}
