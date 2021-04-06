package presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class LogInPanel extends JPanel{
	private JButton menuButton;
	private JButton administratorButton;
	private JButton waiterButton;
	private GridBagConstraints constraints=new GridBagConstraints();
	
	public LogInPanel() {
		init();	
	}
	private void init() {
		setLayout(new GridBagLayout());
		menuButton=new JButton("Menu");
		administratorButton=new JButton("Administrator");
		waiterButton=new JButton("Waiter");
		constraints.fill=GridBagConstraints.VERTICAL;
		constraints.gridx=0;
		constraints.gridy=0;
		constraints.anchor=GridBagConstraints.PAGE_START;
		constraints.weightx=0.5;
		constraints.weighty=0.5;
		
		menuButton.setPreferredSize(new Dimension(100,50));
		administratorButton.setPreferredSize(new Dimension(100,50));
		waiterButton.setPreferredSize(new Dimension(100,50));
		constraints.insets=new Insets(10,200,10,200);
		
		menuButton.setFont(new Font("Berlin Sans FB Demi",Font.CENTER_BASELINE,25));
		administratorButton.setFont(new Font("Berlin Sans FB Demi",Font.CENTER_BASELINE,25));
		waiterButton.setFont(new Font("Berlin Sans FB Demi",Font.CENTER_BASELINE,25));
		Color buttonColor=new Color(0xffe4e1);
		Color backgroundColor=new Color(0xf5f5f5);
		menuButton.setBackground(buttonColor);
		menuButton.setForeground(Color.darkGray);
		administratorButton.setBackground(buttonColor);
		administratorButton.setForeground(Color.darkGray);
		waiterButton.setBackground(buttonColor);
		waiterButton.setForeground(Color.darkGray);
		setBackground(backgroundColor);
		
		constraints.ipadx=110;
		constraints.ipady=50;
		constraints.gridy++;
		add(menuButton,constraints);
		
		constraints.gridy++;
		add(administratorButton,constraints);
		
		constraints.gridy++;
		add(waiterButton,constraints);
		
	}
	public void addMenuButtonListener(ActionListener a) {
		menuButton.addActionListener(a);
	}
	
	public void addAdministratorButtonListener(ActionListener a) {
		administratorButton.addActionListener(a);
	}
	public void addWaiterButtonListener(ActionListener a) {
		waiterButton.addActionListener(a);
	}
}
