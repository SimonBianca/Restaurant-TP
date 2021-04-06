package presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AddOrderPanel extends JPanel{
	private JLabel tableNameLabel;
	private JLabel orderedProductsLabel;
	private JTextField tableNameTextField;
	private JTextField orderedProductsTextField;
	private JButton addOderButton;
	private JButton cancelButton;
	private GridBagConstraints constraints=new GridBagConstraints();
	
	public AddOrderPanel() {
		init();
	}
	public void init() {
		setLayout(new GridBagLayout());
		
		tableNameLabel=new JLabel("Table name:");
		orderedProductsLabel=new JLabel("Ordered products:");
		tableNameLabel.setFont(new Font("Berlin Sans FB Demi",Font.CENTER_BASELINE,20));
		orderedProductsLabel.setFont(new Font("Berlin Sans FB Demi",Font.CENTER_BASELINE,20));
		tableNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		orderedProductsLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		tableNameTextField=new JTextField();
		orderedProductsTextField=new JTextField();
		addOderButton=new JButton("Add order");
		cancelButton=new JButton("Cancel");
		constraints.fill=GridBagConstraints.BOTH;
		constraints.anchor=GridBagConstraints.PAGE_START;
		constraints.insets = new Insets(5, 5, 5, 15);
		constraints.gridx=0;
		constraints.gridy=0;
		constraints.weightx=0.5;
		constraints.weighty=0.5;
		addOderButton.setPreferredSize(new Dimension(100,40));
		cancelButton.setPreferredSize(new Dimension(100,40));
		addOderButton.setFont(new Font("Berlin Sans FB Demi",Font.CENTER_BASELINE,25));
		cancelButton.setFont(new Font("Berlin Sans FB Demi",Font.CENTER_BASELINE,25));
		Color buttonColor=new Color(0xffe4e1);
		Color backgroundColor=new Color(0xf5f5f5);
		addOderButton.setBackground(buttonColor);
		addOderButton.setForeground(Color.darkGray);
		cancelButton.setBackground(buttonColor);
		cancelButton.setForeground(Color.darkGray);
		setBackground(backgroundColor);
		constraints.ipadx=80;
		constraints.gridy++;
		add(tableNameLabel,constraints);
		constraints.gridx++;
		add(tableNameTextField,constraints);
		constraints.gridy++;
		constraints.gridx--;
		add(orderedProductsLabel,constraints);
		constraints.gridx++;
		add(orderedProductsTextField,constraints);
		constraints.gridy++;
		add(addOderButton,constraints);
		constraints.gridx--;
		add(cancelButton,constraints);
	}
	public void addAddOrderButtonListener(ActionListener a) {
		addOderButton.addActionListener(a);
	}
	public void addCancelButtonListener(ActionListener a) {
		cancelButton.addActionListener(a);
	}
	
	public String getTableNameTextField() {
		return tableNameTextField.getText();
	}
	public String getOrderedProductsTextField() {
		return orderedProductsTextField.getText();
	}
	

}
