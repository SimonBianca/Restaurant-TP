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

public class DeleteMenuItemPanel extends JPanel{
	
	private JButton deleteBaseProductButton;
	private JButton deleteCompositeProductButton;
	private JButton cancelButton;
	private GridBagConstraints constraints=new GridBagConstraints();
	
	public DeleteMenuItemPanel() {
		init();
	}
	
	public void init() {
		setLayout(new GridBagLayout());
		deleteBaseProductButton=new JButton("Delete base product");
		deleteCompositeProductButton=new JButton("Delete composite product");
		cancelButton=new JButton("Cancel");
		constraints.fill=GridBagConstraints.HORIZONTAL;
		constraints.anchor=GridBagConstraints.PAGE_START;
		constraints.insets = new Insets(10,150, 10, 150);
		constraints.gridx=0;
		constraints.gridy=0;
		constraints.weightx=0.5;
		constraints.weighty=0.5;
		deleteBaseProductButton.setPreferredSize(new Dimension(100,40));
		deleteCompositeProductButton.setPreferredSize(new Dimension(100,40));
		cancelButton.setPreferredSize(new Dimension(100,40));
		deleteBaseProductButton.setFont(new Font("Berlin Sans FB Demi",Font.CENTER_BASELINE,25));
		deleteCompositeProductButton.setFont(new Font("Berlin Sans FB Demi",Font.CENTER_BASELINE,23));
		cancelButton.setFont(new Font("Berlin Sans FB Demi",Font.CENTER_BASELINE,25));
		Color buttonColor=new Color(0xffe4e1);
		Color backgroundColor=new Color(0xf5f5f5);
		deleteCompositeProductButton.setBackground(buttonColor);
		deleteCompositeProductButton.setForeground(Color.darkGray);
		deleteBaseProductButton.setBackground(buttonColor);
		deleteBaseProductButton.setForeground(Color.darkGray);
		cancelButton.setBackground(buttonColor);
		cancelButton.setForeground(Color.darkGray);
		setBackground(backgroundColor);
		constraints.ipadx=210;
		constraints.ipady=60;
		constraints.gridy++;
		add(deleteBaseProductButton,constraints);
		constraints.gridy++;
		add(deleteCompositeProductButton,constraints);
		constraints.gridy++;
		add(cancelButton,constraints);
	}
	public void addDeleteCompositeProductButtonListener(ActionListener a) {
		deleteCompositeProductButton.addActionListener(a);
	}
	public void addDeleteBaseProductButtonListener(ActionListener a) {
		deleteBaseProductButton.addActionListener(a);
	}
	public void addCancelButtonListener(ActionListener a) {
		cancelButton.addActionListener(a);
	}
}
