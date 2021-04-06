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

public class WaiterMainPanel extends JPanel{
	private JButton ordersButton;
	private JButton addOrderButton;
	private JButton computePriceButton;
	private JButton generateBillButton;
	private JButton cancelButton;
	private GridBagConstraints constraints=new GridBagConstraints();

	public WaiterMainPanel() {
		init();
	}

	private void init() {
		setLayout(new GridBagLayout());
		ordersButton=new JButton("Orders");
		addOrderButton=new JButton("Add order");
		computePriceButton=new JButton("Total order");
		generateBillButton=new JButton("Generate bill");
		cancelButton=new JButton("Cancel");
		constraints.fill=GridBagConstraints.HORIZONTAL;
		
		constraints.insets=new Insets(10,200,10,200);
		constraints.anchor=GridBagConstraints.PAGE_START;
		constraints.gridx=0;
		constraints.gridy=0;
		constraints.weightx=0.5;
		constraints.weighty=0.5;
		ordersButton.setPreferredSize(new Dimension(100,50));
		addOrderButton.setPreferredSize(new Dimension(100,50));
		computePriceButton.setPreferredSize(new Dimension(100,50));
		generateBillButton.setPreferredSize(new Dimension(100,50));
		cancelButton.setPreferredSize(new Dimension(100,50));
		ordersButton.setFont(new Font("Berlin Sans FB Demi",Font.CENTER_BASELINE,25));
		addOrderButton.setFont(new Font("Berlin Sans FB Demi",Font.CENTER_BASELINE,25));
		computePriceButton.setFont(new Font("Berlin Sans FB Demi",Font.CENTER_BASELINE,25));
		generateBillButton.setFont(new Font("Berlin Sans FB Demi",Font.CENTER_BASELINE,25));
		cancelButton.setFont(new Font("Berlin Sans FB Demi",Font.CENTER_BASELINE,25));
		Color buttonColor=new Color(0xffe4e1);
		Color backgroundColor=new Color(0xf5f5f5);
		ordersButton.setBackground(buttonColor);
		ordersButton.setForeground(Color.darkGray);
		addOrderButton.setBackground(buttonColor);
		addOrderButton.setForeground(Color.darkGray);
		computePriceButton.setBackground(buttonColor);
		computePriceButton.setForeground(Color.darkGray);
		generateBillButton.setBackground(buttonColor);
		generateBillButton.setForeground(Color.darkGray);
		cancelButton.setBackground(buttonColor);
		cancelButton.setForeground(Color.darkGray);
		setBackground(backgroundColor);
		constraints.ipadx=140;
		constraints.ipady=30;	
		constraints.gridy++;
		add(ordersButton,constraints);
		constraints.gridy++;
		add(addOrderButton,constraints);
		constraints.gridy++;
		add(computePriceButton,constraints);
		constraints.gridy++;
		add(generateBillButton,constraints);
		constraints.gridy++;
		add(cancelButton,constraints);
	}
	public void addOrdersButtonListener(ActionListener a) {
		ordersButton.addActionListener(a);
	}
	public void addAddOrderButtonListener(ActionListener a) {
		addOrderButton.addActionListener(a);
	}
	public void addTotalOrderButtonListener(ActionListener a) {
		computePriceButton.addActionListener(a);
	}
	public void addGenerateBillButtonListener(ActionListener a) {
		generateBillButton.addActionListener(a);
	}
	public void addCancelButtonListener(ActionListener a) {
		cancelButton.addActionListener(a);
	}

}
