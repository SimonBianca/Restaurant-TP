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

public class AddBaseProductPanel extends JPanel{
	
	private JLabel nameLabel;
	private JLabel priceLabel;
	private JTextField nameTextField;
	private JTextField priceTextField;
	private JButton addBaseProductButton;
	private JButton cancelButton;
	private GridBagConstraints constraints=new GridBagConstraints();
	
	public AddBaseProductPanel() {
		init();
	}
	
	public void init() {
		setLayout(new GridBagLayout());
		
		nameLabel=new JLabel("Product name:");
		priceLabel=new JLabel("Price:");
		nameLabel.setFont(new Font("Berlin Sans FB Demi",Font.CENTER_BASELINE,20));
		priceLabel.setFont(new Font("Berlin Sans FB Demi",Font.CENTER_BASELINE,20));
		nameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		priceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		nameTextField=new JTextField();
		priceTextField=new JTextField();
		addBaseProductButton=new JButton("Add product");
		cancelButton=new JButton("Cancel");
		constraints.fill=GridBagConstraints.BOTH;
		constraints.anchor=GridBagConstraints.PAGE_START;
		constraints.insets = new Insets(5, 5, 5, 20);
		constraints.gridx=0;
		constraints.gridy=0;
		constraints.weightx=0.5;
		constraints.weighty=0.5;
		addBaseProductButton.setPreferredSize(new Dimension(100,40));
		cancelButton.setPreferredSize(new Dimension(100,40));
		addBaseProductButton.setFont(new Font("Berlin Sans FB Demi",Font.CENTER_BASELINE,25));
		cancelButton.setFont(new Font("Berlin Sans FB Demi",Font.CENTER_BASELINE,25));
		Color buttonColor=new Color(0xffe4e1);
		Color backgroundColor=new Color(0xf5f5f5);
		addBaseProductButton.setBackground(buttonColor);
		addBaseProductButton.setForeground(Color.darkGray);
		cancelButton.setBackground(buttonColor);
		cancelButton.setForeground(Color.darkGray);
		setBackground(backgroundColor);
		constraints.ipadx=80;
		constraints.gridy++;
		add(nameLabel,constraints);
		constraints.gridx++;
		add(nameTextField,constraints);
		constraints.gridy++;
		constraints.gridx--;
		add(priceLabel,constraints);
		constraints.gridx++;
		add(priceTextField,constraints);
		constraints.gridy++;
		add(addBaseProductButton,constraints);
		constraints.gridx--;
		add(cancelButton,constraints);
	}
	public void addBaseProductButtonListener(ActionListener a) {
		addBaseProductButton.addActionListener(a);
	}
	public void addCancelButtonListener(ActionListener a) {
		cancelButton.addActionListener(a);
	}
	
	public String getBaseProductNameTextField() {
		return nameTextField.getText();
	}
	public Double getBaseProductPriceTextField() {
		return Double.parseDouble(priceTextField.getText());
	}
	

}
