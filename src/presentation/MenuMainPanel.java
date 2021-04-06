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

public class MenuMainPanel extends JPanel{
	private JButton baseProductButton;
	private JButton compositeProductButton;
	private JButton cancelButton;
	private GridBagConstraints constraints=new GridBagConstraints();
	
	public MenuMainPanel() {
		init();
	}
	private void init() {
		setLayout(new GridBagLayout());
		baseProductButton=new JButton("Base products");
		compositeProductButton=new JButton("Composite products");
		cancelButton=new JButton("Cancel");
		constraints.fill=GridBagConstraints.HORIZONTAL;
		constraints.insets=new Insets(10,160,10,160);
		constraints.anchor=GridBagConstraints.PAGE_START;
		constraints.gridx=0;
		constraints.gridy=0;
		constraints.weightx=0.5;
		constraints.weighty=0.5;
		baseProductButton.setPreferredSize(new Dimension(120,50));
		compositeProductButton.setPreferredSize(new Dimension(120,50));
		cancelButton.setPreferredSize(new Dimension(120,50));
		baseProductButton.setFont(new Font("Berlin Sans FB Demi",Font.CENTER_BASELINE,25));
		compositeProductButton.setFont(new Font("Berlin Sans FB Demi",Font.CENTER_BASELINE,25));
		cancelButton.setFont(new Font("Berlin Sans FB Demi",Font.CENTER_BASELINE,25));
		Color buttonColor=new Color(0xffe4e1);
		Color backgroundColor=new Color(0xf5f5f5);
		baseProductButton.setBackground(buttonColor);
		baseProductButton.setForeground(Color.darkGray);
		compositeProductButton.setBackground(buttonColor);
		compositeProductButton.setForeground(Color.darkGray);
		cancelButton.setBackground(buttonColor);
		cancelButton.setForeground(Color.darkGray);
		setBackground(backgroundColor);
		constraints.ipadx=140;
		constraints.ipady=30;
		constraints.gridy++;
		add(baseProductButton,constraints);
		constraints.gridy++;
		add(compositeProductButton,constraints);
		constraints.gridy++;
		add(cancelButton,constraints);
	}
	public void addBaseProductsButtonListener(ActionListener a) {
		baseProductButton.addActionListener(a);
	}
	public void addCompositeProductsButtonListener(ActionListener a) {
		compositeProductButton.addActionListener(a);
	}
	public void addCancelButtonListener(ActionListener a) {
		cancelButton.addActionListener(a);
	}

}
