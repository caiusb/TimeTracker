package usr.caiusb.timetracker;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainWindow {
	
	private JFrame frame;
	private JButton backButton;
	private JButton forwardButton;
	
	private Queue<ContentPane> panes = new LinkedBlockingQueue<ContentPane>();
	private Queue<ContentPane> removedPanes = new LinkedBlockingQueue<ContentPane>();
	
	public MainWindow() {
		frame = new JFrame();
		
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setSize(400, 200);
		frame.setTitle("TimeTracker");
		
		JPanel navigationPanel = newPanelWithGridBagLayout();
		frame.getContentPane().add(navigationPanel, BorderLayout.NORTH);
		
		ActionListener backActionListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (panes.size() < 1) {
					backButton.setEnabled(false);
					return;
				}
				
				ContentPane topPane = panes.remove();
				removedPanes.add(topPane);
				
				frame.getContentPane().add(topPane.getPane(), BorderLayout.CENTER);
			}
		};
		
		String leftTriangle = "\u25C0";
		backButton = new JButton(leftTriangle);
		backButton.addActionListener(backActionListener);
		GridBagConstraints backButtonConstraints = new GridBagConstraints();
		backButtonConstraints.gridx = 0;
		backButtonConstraints.gridy = 0;
		navigationPanel.add(backButton, backButtonConstraints);
		
		backButton.setEnabled(false);
		
		ActionListener forwardActionListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (removedPanes.size() == 0) {
					forwardButton.setEnabled(false);
					return;
				}
				
				ContentPane topPane = removedPanes.remove();
				panes.add(topPane);
				frame.getContentPane().add(topPane.getPane(), BorderLayout.CENTER);
			}
		};
		
		String rightTriangle = "\u25BA";
		forwardButton = new JButton(rightTriangle);
		backButton.addActionListener(forwardActionListener);
		GridBagConstraints forwardButtonConstaints = new GridBagConstraints();
		forwardButtonConstaints.gridx = 1;
		forwardButtonConstaints.gridy = 0;
		navigationPanel.add(forwardButton, forwardButtonConstaints);
		forwardButton.setEnabled(false);
		
		MainPane mainPane = new MainPane(this);
		panes.add(mainPane);
		
		frame.getContentPane().add(mainPane.getPane(), BorderLayout.CENTER);
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
	
	public void addPane(ContentPane pane) {
		panes.add(pane);
		removedPanes.clear();
		
		backButton.setEnabled(true);
		frame.getContentPane().add(pane.getPane(), BorderLayout.CENTER);
	}
}
