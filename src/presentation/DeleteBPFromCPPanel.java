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

public class DeleteBPFromCPPanel extends JPanel{
	
	private JLabel nameLabel;
	private JLabel baseProductNameLabel;
	private JTextField nameTextField;
	private JTextField baseProductTextField;
	private JButton deleteBPFromCPButton;
	private JButton cancelButton;
	private GridBagConstraints constraints=new GridBagConstraints();
	
	public DeleteBPFromCPPanel() {
		init();
	}
	public void init() {
		setLayout(new GridBagLayout());
		
		nameLabel=new JLabel("Product name:");
		baseProductNameLabel=new JLabel("Base product:");
		nameLabel.setFont(new Font("Berlin Sans FB Demi",Font.CENTER_BASELINE,20));
		baseProductNameLabel.setFont(new Font("Berlin Sans FB Demi",Font.CENTER_BASELINE,20));
		nameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		baseProductNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		nameTextField=new JTextField();
		baseProductTextField=new JTextField();
		deleteBPFromCPButton=new JButton("Delete product");
		cancelButton=new JButton("Cancel");
		constraints.fill=GridBagConstraints.BOTH;
		constraints.anchor=GridBagConstraints.PAGE_START;
		constraints.insets = new Insets(5, 5, 5, 15);
		constraints.gridx=0;
		constraints.gridy=0;
		constraints.weightx=0.5;
		constraints.weighty=0.5;
		deleteBPFromCPButton.setPreferredSize(new Dimension(100,40));
		cancelButton.setPreferredSize(new Dimension(100,40));
		deleteBPFromCPButton.setFont(new Font("Berlin Sans FB Demi",Font.CENTER_BASELINE,25));
		cancelButton.setFont(new Font("Berlin Sans FB Demi",Font.CENTER_BASELINE,25));
		Color buttonColor=new Color(0xffe4e1);
		Color backgroundColor=new Color(0xf5f5f5);
		deleteBPFromCPButton.setBackground(buttonColor);
		deleteBPFromCPButton.setForeground(Color.darkGray);
		cancelButton.setBackground(buttonColor);
		cancelButton.setForeground(Color.darkGray);
		setBackground(backgroundColor);
		constraints.ipadx=120;
		constraints.gridy++;
		add(nameLabel,constraints);
		constraints.gridx++;
		add(nameTextField,constraints);
		constraints.gridy++;
		constraints.gridx--;
		add(baseProductNameLabel,constraints);
		constraints.gridx++;
		add(baseProductTextField,constraints);
		constraints.gridy++;
		add(deleteBPFromCPButton,constraints);
		constraints.gridx--;
		add(cancelButton,constraints);
	}
	public void addDeleteBPFromCPButtonListener(ActionListener a) {
		deleteBPFromCPButton.addActionListener(a);
	}
	public void addCancelButtonListener(ActionListener a) {
		cancelButton.addActionListener(a);
	}
	
	public String getCompositeProductNameTextField() {
		return nameTextField.getText();
	}
	public String getBaseProductNameTextField() {
		return baseProductTextField.getText();
	}
	

}
