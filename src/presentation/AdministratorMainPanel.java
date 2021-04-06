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

public class AdministratorMainPanel extends JPanel{

	private JButton addMenuItemButton;
	private JButton deleteMenuItemButton;
	private JButton editMenuItemButton;
	private JButton cancelButton;
	private GridBagConstraints constraints=new GridBagConstraints();

	public AdministratorMainPanel() {
		init();
	}

	private void init() {
		setLayout(new GridBagLayout());
		addMenuItemButton=new JButton("Add menu item");
		deleteMenuItemButton=new JButton("Delete menu item");
		editMenuItemButton=new JButton("Edit menu item");
		cancelButton=new JButton("Cancel");
		constraints.fill=GridBagConstraints.HORIZONTAL;
		constraints.insets=new Insets(10,200,10,200);
		constraints.anchor=GridBagConstraints.PAGE_START;
		constraints.gridx=0;
		constraints.gridy=0;
		constraints.weightx=0.5;
		constraints.weighty=0.5;
		addMenuItemButton.setPreferredSize(new Dimension(100,50));
		deleteMenuItemButton.setPreferredSize(new Dimension(100,50));
		editMenuItemButton.setPreferredSize(new Dimension(100,50));
		cancelButton.setPreferredSize(new Dimension(100,50));
		addMenuItemButton.setFont(new Font("Berlin Sans FB Demi",Font.CENTER_BASELINE,25));
		deleteMenuItemButton.setFont(new Font("Berlin Sans FB Demi",Font.CENTER_BASELINE,25));
		editMenuItemButton.setFont(new Font("Berlin Sans FB Demi",Font.CENTER_BASELINE,25));
		cancelButton.setFont(new Font("Berlin Sans FB Demi",Font.CENTER_BASELINE,25));
		Color buttonColor=new Color(0xffe4e1);
		Color backgroundColor=new Color(0xf5f5f5);
		addMenuItemButton.setBackground(buttonColor);
		addMenuItemButton.setForeground(Color.darkGray);
		deleteMenuItemButton.setBackground(buttonColor);
		deleteMenuItemButton.setForeground(Color.darkGray);
		editMenuItemButton.setBackground(buttonColor);
		editMenuItemButton.setForeground(Color.darkGray);
		cancelButton.setBackground(buttonColor);
		cancelButton.setForeground(Color.darkGray);
		setBackground(backgroundColor);
		constraints.ipadx=140;
		constraints.ipady=60;
		constraints.gridy++;
		add(addMenuItemButton,constraints);
		constraints.gridy++;
		add(deleteMenuItemButton,constraints);
		constraints.gridy++;
		add(editMenuItemButton,constraints);
		constraints.gridy++;
		add(cancelButton,constraints);
	}
	public void addAddMenuItemButtonListener(ActionListener a) {
		addMenuItemButton.addActionListener(a);
	}
	public void addDeleteMenuItemButtonListener(ActionListener a) {
		deleteMenuItemButton.addActionListener(a);
	}
	public void addEditMenuItemButtonListener(ActionListener a) {
		editMenuItemButton.addActionListener(a);
	}
	public void addCancelButtonListener(ActionListener a) {
		cancelButton.addActionListener(a);
	}
}
