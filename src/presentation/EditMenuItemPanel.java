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

public class EditMenuItemPanel extends JPanel{
	
	private JButton changePriceButton;
	private JButton addBaseProductToCPButton;
	private JButton deleteBaseProductFromCPButton;
	private JButton cancelButton;
	private GridBagConstraints constraints=new GridBagConstraints();
	
	public EditMenuItemPanel() {
		init();
	}
	
	private void init() {
		setLayout(new GridBagLayout());
		changePriceButton=new JButton("Change price");
		addBaseProductToCPButton=new JButton();
		addBaseProductToCPButton.setText("Add base product to CP");
		deleteBaseProductFromCPButton=new JButton("Delete base product from CP");
		cancelButton=new JButton("Cancel");
		constraints.fill=GridBagConstraints.HORIZONTAL;
		constraints.insets=new Insets(10,100,10,100);
		constraints.anchor=GridBagConstraints.PAGE_START;
		constraints.gridx=0;
		constraints.gridy=0;
		constraints.weightx=0.5;
		constraints.weighty=0.5;
		changePriceButton.setPreferredSize(new Dimension(140,50));
		addBaseProductToCPButton.setPreferredSize(new Dimension(140,50));
		deleteBaseProductFromCPButton.setPreferredSize(new Dimension(140,50));
		cancelButton.setPreferredSize(new Dimension(100,50));
		changePriceButton.setFont(new Font("Berlin Sans FB Demi",Font.CENTER_BASELINE,25));
		addBaseProductToCPButton.setFont(new Font("Berlin Sans FB Demi",Font.CENTER_BASELINE,25));
		deleteBaseProductFromCPButton.setFont(new Font("Berlin Sans FB Demi",Font.CENTER_BASELINE,23));
		cancelButton.setFont(new Font("Berlin Sans FB Demi",Font.CENTER_BASELINE,25));
		Color buttonColor=new Color(0xffe4e1);
		Color backgroundColor=new Color(0xf5f5f5);
		changePriceButton.setBackground(buttonColor);
		changePriceButton.setForeground(Color.darkGray);
		addBaseProductToCPButton.setBackground(buttonColor);
		addBaseProductToCPButton.setForeground(Color.darkGray);
		deleteBaseProductFromCPButton.setBackground(buttonColor);
		deleteBaseProductFromCPButton.setForeground(Color.darkGray);
		cancelButton.setBackground(buttonColor);
		cancelButton.setForeground(Color.darkGray);
		setBackground(backgroundColor);
		constraints.ipadx=200;
		constraints.ipady=60;
		constraints.gridy++;
		add(changePriceButton,constraints);
		constraints.gridy++;
		add(addBaseProductToCPButton,constraints);
		constraints.gridy++;
		add(deleteBaseProductFromCPButton,constraints);
		constraints.gridy++;
		add(cancelButton,constraints);
	}
	public void addChangePriceButtonListener(ActionListener a) {
		changePriceButton.addActionListener(a);
	}
	public void addAddBaseProductToCPButtonListener(ActionListener a) {
		addBaseProductToCPButton.addActionListener(a);
	}
	public void addDeleteBaseProductFromCPButtonListener(ActionListener a) {
		deleteBaseProductFromCPButton.addActionListener(a);
	}
	public void addCancelButtonListener(ActionListener a) {
		cancelButton.addActionListener(a);
	}
	

}
