package presentation;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

public class GraphicWaiterController {
	private JFrame waiterFrame;
	private WaiterMainPanel waiterMainPanel;
	private AddOrderPanel addOrderPanel;
	private TotalOrderPanel totalOrderPanel;
	private GenerateBillPanel generateBillPanel;
	
	public void showWaiterFrame() {
		waiterFrame=new JFrame();
		waiterFrame.setTitle("Waiter");
		waiterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		waiterFrame.setBounds(100,200,700,700);
		waiterFrame.setSize(500, 500);
		waiterFrame.setLocationRelativeTo(null);
		waiterFrame.setResizable(false);
		waiterFrame.setVisible(true);
	}
	public void showWaiterMainPanel() {
		waiterFrame.getContentPane().removeAll();
		waiterMainPanel=new WaiterMainPanel();
		waiterFrame.add(waiterMainPanel);
		waiterFrame.pack();
	}
	
	public void showAddOrderPanel() {
		waiterFrame.getContentPane().removeAll();
		addOrderPanel=new AddOrderPanel();
		waiterFrame.add(addOrderPanel);
		waiterFrame.pack();
	}
	
	public void showOrdersPanel(String[][] data) {
		waiterFrame.getContentPane().removeAll();
		waiterFrame.pack();
		new GridLayout(1,0);
		String[] columnNames={"Id order","Date","Table name","Ordered menu items","Total order"};
		JTable table=new JTable(data,columnNames);
		table.setBounds(30, 40, 100, 200);
		JScrollPane scrollPane=new JScrollPane(table);
		TableColumn column=null;
		for(int index=0;index<5;index++) {
			column=table.getColumnModel().getColumn(index);
			if(index==3) {
				column.setPreferredWidth(300);
			}
			else if(index==1){
				column.setPreferredWidth(200);
			}
			else {
				column.setPreferredWidth(100);
			}
		}
		waiterFrame.add(scrollPane);
		waiterFrame.setSize(800, 350);
	}
	
	public void showTotalOrderPanel() {
		waiterFrame.getContentPane().removeAll();
		totalOrderPanel=new TotalOrderPanel();
		waiterFrame.add(totalOrderPanel);
		waiterFrame.pack();
	}
	
	public void showGenerateBillPanel() {
		waiterFrame.getContentPane().removeAll();
		generateBillPanel=new GenerateBillPanel();
		waiterFrame.add(generateBillPanel);
		waiterFrame.pack();
	}
	
	public GenerateBillPanel getGenerateBillPanel() {
		return generateBillPanel;
	}
	public void setGenerateBillPanel(GenerateBillPanel generateBillPanel) {
		this.generateBillPanel = generateBillPanel;
	}
	public TotalOrderPanel getTotalOrderPanel() {
		return totalOrderPanel;
	}
	public void setTotalOrderPanel(TotalOrderPanel totalOrderPanel) {
		this.totalOrderPanel = totalOrderPanel;
	}
	public JFrame getWaiterFrame() {
		return waiterFrame;
	}
	public void setWaiterFrame(JFrame waiterFrame) {
		this.waiterFrame = waiterFrame;
	}
	public WaiterMainPanel getWaiterMainPanel() {
		return waiterMainPanel;
	}
	public void setWaiterMainPanel(WaiterMainPanel waiterMainPanel) {
		this.waiterMainPanel = waiterMainPanel;
	}
	public AddOrderPanel getAddOrderPanel() {
		return addOrderPanel;
	}
	public void setAddOrderPanel(AddOrderPanel addOrderPanel) {
		this.addOrderPanel = addOrderPanel;
	}
	

}
