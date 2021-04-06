package presentation;

import javax.swing.JFrame;

public class GraphicController {
	private JFrame mainFrame;
	private LogInPanel logInPanel;
	
	public void showMainFrame() {
		mainFrame=new JFrame();
		mainFrame.setTitle("Restaurant");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setBounds(100,200,700,700);
		mainFrame.setSize(500, 500);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setResizable(false);
		mainFrame.setVisible(true);
	}
	
	public void showLogInPanel() {
		mainFrame.getContentPane().removeAll();
		logInPanel=new LogInPanel();
		mainFrame.add(logInPanel);
		mainFrame.pack();
	}
	
	public LogInPanel getLogInPanel() {
		return logInPanel;
	}

	public void setLogInPanel(LogInPanel logInPanel) {
		this.logInPanel = logInPanel;
	}

	public JFrame getMainFrame() {
		return mainFrame;
	}

	public void setMainFrame(JFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
	
}
