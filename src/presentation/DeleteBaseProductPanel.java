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

public class DeleteBaseProductPanel extends JPanel{
	private JLabel nameLabel;
	private JTextField nameTextField;
	private JButton deleteBaseProductButton;
	private JButton cancelButton;
	private GridBagConstraints constraints=new GridBagConstraints();
	
	public DeleteBaseProductPanel() {
		init();
	}
	public void init() {
		setLayout(new GridBagLayout());
		nameLabel=new JLabel("Product name:");
		nameLabel.setFont(new Font("Berlin Sans FB Demi",Font.CENTER_BASELINE,20));
		nameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		nameTextField=new JTextField();
		deleteBaseProductButton=new JButton("Delete product");
		cancelButton=new JButton("Cancel");
		constraints.fill=GridBagConstraints.BOTH;
		constraints.anchor=GridBagConstraints.PAGE_START;
		constraints.insets = new Insets(5, 5, 5, 20);
		constraints.gridx=0;
		constraints.gridy=0;
		constraints.weightx=0.5;
		constraints.weighty=0.5;
		deleteBaseProductButton.setPreferredSize(new Dimension(100,40));
		cancelButton.setPreferredSize(new Dimension(100,40));
		deleteBaseProductButton.setFont(new Font("Berlin Sans FB Demi",Font.CENTER_BASELINE,20));
		cancelButton.setFont(new Font("Berlin Sans FB Demi",Font.CENTER_BASELINE,20));
		Color buttonColor=new Color(0xffe4e1);
		Color backgroundColor=new Color(0xf5f5f5);
		deleteBaseProductButton.setBackground(buttonColor);
		deleteBaseProductButton.setForeground(Color.darkGray);
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
		add(cancelButton,constraints);
		constraints.gridx++;
		add(deleteBaseProductButton,constraints);
	}
	public void addDeleteBaseProductButtonListener(ActionListener a) {
		deleteBaseProductButton.addActionListener(a);
	}
	public void addCancelButtonListener(ActionListener a) {
		cancelButton.addActionListener(a);
	}
	
	public String getBaseProductNameTextField() {
		return nameTextField.getText();
	}
}
