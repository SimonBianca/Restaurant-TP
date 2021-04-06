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

public class GenerateBillPanel extends JPanel{
	private JLabel tableNameLabel;
	private JTextField tableNameTextField;
	private JButton GenerateBillButton;
	private JButton cancelButton;
	private GridBagConstraints constraints=new GridBagConstraints();
	
	public GenerateBillPanel() {
		init();
	}
	public void init() {
		setLayout(new GridBagLayout());
		tableNameLabel=new JLabel("Table name:");
		tableNameLabel.setFont(new Font("Berlin Sans FB Demi",Font.CENTER_BASELINE,20));
		tableNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		tableNameTextField=new JTextField();
		GenerateBillButton=new JButton("Generate bill");
		cancelButton=new JButton("Cancel");
		constraints.fill=GridBagConstraints.BOTH;
		constraints.anchor=GridBagConstraints.PAGE_START;
		constraints.insets = new Insets(5, 5, 5, 20);
		constraints.gridx=0;
		constraints.gridy=0;
		constraints.weightx=0.5;
		constraints.weighty=0.5;
		GenerateBillButton.setPreferredSize(new Dimension(100,40));
		cancelButton.setPreferredSize(new Dimension(100,40));
		GenerateBillButton.setFont(new Font("Berlin Sans FB Demi",Font.CENTER_BASELINE,20));
		cancelButton.setFont(new Font("Berlin Sans FB Demi",Font.CENTER_BASELINE,20));
		Color buttonColor=new Color(0xffe4e1);
		Color backgroundColor=new Color(0xf5f5f5);
		GenerateBillButton.setBackground(buttonColor);
		GenerateBillButton.setForeground(Color.darkGray);
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
		add(cancelButton,constraints);
		constraints.gridx++;
		add(GenerateBillButton,constraints);
	}
	public void addGenerateBillButtonListener(ActionListener a) {
		GenerateBillButton.addActionListener(a);
	}
	public void addCancelButtonListener(ActionListener a) {
		cancelButton.addActionListener(a);
	}
	
	public String getTableNameTextField() {
		return tableNameTextField.getText();
	}
}
