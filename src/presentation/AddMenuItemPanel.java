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

public class AddMenuItemPanel extends JPanel{
	private JButton addBaseProductButton;
	private JButton addCompositeProductButton;
	private JButton cancelButton;
	private GridBagConstraints constraints=new GridBagConstraints();
	
	public AddMenuItemPanel() {
		init();
	}
	private void init() {
		setLayout(new GridBagLayout());
		addBaseProductButton=new JButton("Add base product");
		addCompositeProductButton=new JButton("Add composite product");
		cancelButton=new JButton("Cancel");
		constraints.fill=GridBagConstraints.HORIZONTAL;
		
		constraints.insets=new Insets(10,160,10,160);
		constraints.anchor=GridBagConstraints.PAGE_START;
		constraints.gridx=0;
		constraints.gridy=0;
		constraints.weightx=0.5;
		constraints.weighty=0.5;
		addBaseProductButton.setPreferredSize(new Dimension(120,50));
		addCompositeProductButton.setPreferredSize(new Dimension(120,50));
		cancelButton.setPreferredSize(new Dimension(120,50));
		addBaseProductButton.setFont(new Font("Berlin Sans FB Demi",Font.CENTER_BASELINE,25));
		addCompositeProductButton.setFont(new Font("Berlin Sans FB Demi",Font.CENTER_BASELINE,25));
		cancelButton.setFont(new Font("Berlin Sans FB Demi",Font.CENTER_BASELINE,25));
		Color buttonColor=new Color(0xffe4e1);
		Color backgroundColor=new Color(0xf5f5f5);
		addBaseProductButton.setBackground(buttonColor);
		addBaseProductButton.setForeground(Color.darkGray);
		addCompositeProductButton.setBackground(buttonColor);
		addCompositeProductButton.setForeground(Color.darkGray);
		cancelButton.setBackground(buttonColor);
		cancelButton.setForeground(Color.darkGray);
		
		
		setBackground(backgroundColor);
		constraints.ipadx=175;
		constraints.ipady=60;
		constraints.gridy++;
		add(addBaseProductButton,constraints);
		
		constraints.gridy++;
		add(addCompositeProductButton,constraints);
		
		constraints.gridy++;
		add(cancelButton,constraints);
	}
	public void addAddBaseProductButtonListener(ActionListener a) {
		addBaseProductButton.addActionListener(a);
	}
	public void addAddCompositeProductButtonListener(ActionListener a) {
		addCompositeProductButton.addActionListener(a);
	}
	public void addCancelButtonListener(ActionListener a) {
		cancelButton.addActionListener(a);
	}

}
