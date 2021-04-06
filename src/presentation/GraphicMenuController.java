package presentation;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

public class GraphicMenuController {
	private JFrame menuFrame;
	private MenuMainPanel menuMainPanel;
	
	public void showMenuFrame() {
		menuFrame=new JFrame();
		menuFrame.setTitle("Menu");
		menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuFrame.setBounds(100,200,700,700);
		menuFrame.setSize(500, 500);
		menuFrame.setLocationRelativeTo(null);
		menuFrame.setResizable(false);
		menuFrame.setVisible(true);
	}
	public void showMenuMainPanel() {
		menuFrame.getContentPane().removeAll();
		menuMainPanel=new MenuMainPanel();
		menuFrame.add(menuMainPanel);
		menuFrame.pack();
	}
	
	public void showBaseProductsPanel(String[][] data) {
		menuFrame.getContentPane().removeAll();
		menuFrame.pack();
		new GridLayout(1,0);
		String[] columnNames={"Name","Price"};
		JTable table=new JTable(data,columnNames);
		table.setBounds(30, 40, 100, 200);
		JScrollPane scrollPane=new JScrollPane(table);
		TableColumn column=null;
		for(int index=0;index<2;index++) {
			column=table.getColumnModel().getColumn(index);
			if(index==1) {
				column.setPreferredWidth(100);
			}
			else{
				column.setPreferredWidth(150);
			}
		}
		menuFrame.add(scrollPane);
		menuFrame.setSize(250, 600);
	}
	public void showCompositeProductsPanel(String[][] data) {
		menuFrame.getContentPane().removeAll();
		menuFrame.pack();
		new GridLayout(1,0);
		String[] columnNames={"Name","Base Products","Price"};
		JTable table=new JTable(data,columnNames);
		table.setBounds(30, 40, 100, 200);
		JScrollPane scrollPane=new JScrollPane(table);
		TableColumn column=null;
		for(int index=0;index<3;index++) {
			column=table.getColumnModel().getColumn(index);
			if(index==1) {
				column.setPreferredWidth(300);
			}
			else if(index==2) {
				column.setPreferredWidth(100);
			}
			else {
				column.setPreferredWidth(150);
			}
		}
		menuFrame.add(scrollPane);
		menuFrame.setSize(600, 450);
	}
	
	public JFrame getMenuFrame() {
		return menuFrame;
	}
	public void setMenuFrame(JFrame menuFrame) {
		this.menuFrame = menuFrame;
	}
	public MenuMainPanel getMenuMainPanel() {
		return menuMainPanel;
	}
	public void setMenuMainPanel(MenuMainPanel menuMainPanel) {
		this.menuMainPanel = menuMainPanel;
	}

}
