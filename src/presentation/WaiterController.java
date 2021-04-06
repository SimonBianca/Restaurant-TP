package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class WaiterController {

	private GraphicWaiterController graphicWaiterController;
	private RestaurantLogicController restaurantLogicController;
	
	public WaiterController() {
		graphicWaiterController=new GraphicWaiterController();
		displayWaiterFrame();
		displayWaiterMainPanel();
	}
	public void displayWaiterFrame() {
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run() {
				graphicWaiterController.showWaiterFrame();
			}
		});
	}
	public void displayWaiterMainPanel() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				graphicWaiterController.showWaiterMainPanel();
				addWaiterMainPanelCancelButtonListener();
				addWaiterMainPanelAddOrderButtonListener();
				addWaiterMainPanelOrdersButtonListener();
				addWaiterMainPanelTotalOrderButtonListener();
				addWaiterMainPanelGenerateBillButtonListener();
			}	
		});
	}
	private void addWaiterMainPanelGenerateBillButtonListener() {
		graphicWaiterController.getWaiterMainPanel().addGenerateBillButtonListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayGenerateBillPanel();

			}
		});
	}
	private void displayGenerateBillPanel() {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				graphicWaiterController.showGenerateBillPanel();
				addGenerateBillPanelCancelButtonListener();
				addGenerateBillPanelGenerateBillButtonListener();
			}
		});
	}
	private void addGenerateBillPanelGenerateBillButtonListener() {
		graphicWaiterController.getGenerateBillPanel().addGenerateBillButtonListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					restaurantLogicController=new RestaurantLogicController("restaurant.ser");
					String tableName=graphicWaiterController.getGenerateBillPanel().getTableNameTextField();
					if(tableName.matches("Table[0-9]{1,5}")) {
						if(restaurantLogicController.generateBill(tableName)) {
							displayWaiterMainPanel();
						}
						else {
							 JOptionPane.showMessageDialog(null, "Verify the input data! \n You don't have order at this table!", null, JOptionPane.ERROR_MESSAGE);
							 displayGenerateBillPanel();
						}
					}
					else {
						 JOptionPane.showMessageDialog(null, "Verify the input data! \n Please try again!", null, JOptionPane.ERROR_MESSAGE);
						 displayGenerateBillPanel();
					}
			}
		});
	}
	private void addGenerateBillPanelCancelButtonListener() {
		graphicWaiterController.getGenerateBillPanel().addCancelButtonListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayWaiterMainPanel();
			}
		});
	}
	private void addWaiterMainPanelTotalOrderButtonListener() {
		graphicWaiterController.getWaiterMainPanel().addTotalOrderButtonListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayTotalOrderPanel();

			}
		});
	}
	private void displayTotalOrderPanel() {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				graphicWaiterController.showTotalOrderPanel();
				addTotalOrderPanelCancelButtonListener();
				addTotalOrderPanelTotalOrderButtonListener();
			}
		});
	}
	private void addTotalOrderPanelTotalOrderButtonListener() {
		graphicWaiterController.getTotalOrderPanel().addTotalOrderButtonListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					restaurantLogicController=new RestaurantLogicController("restaurant.ser");
					String tableName=graphicWaiterController.getTotalOrderPanel().getTableNameTextField();
					if(tableName.matches("Table[0-9]{1,5}")) {
						if(restaurantLogicController.computeOrderPrice(tableName)>0) {
							displayWaiterMainPanel();
						}
						else {
							 JOptionPane.showMessageDialog(null, "Verify the input data! \n You don't have order at this table!", null, JOptionPane.ERROR_MESSAGE);
							 displayTotalOrderPanel();
						}
					}
					else {
						 JOptionPane.showMessageDialog(null, "Verify the input data! \n Please try again!", null, JOptionPane.ERROR_MESSAGE);
						 displayTotalOrderPanel();
					}
			}
		});
	}
	private void addTotalOrderPanelCancelButtonListener() {
		graphicWaiterController.getTotalOrderPanel().addCancelButtonListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayWaiterMainPanel();
			}
		});
	}
	private void addWaiterMainPanelOrdersButtonListener() {
		graphicWaiterController.getWaiterMainPanel().addOrdersButtonListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayOrdersPanel();
			}
		});
	}
	private void displayOrdersPanel() {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				restaurantLogicController=new RestaurantLogicController("restaurant.ser");
				String[][] data=restaurantLogicController.extractOrdersData();
				graphicWaiterController.showOrdersPanel(data);
			}
		});
	}
	private void addWaiterMainPanelAddOrderButtonListener() {
		graphicWaiterController.getWaiterMainPanel().addAddOrderButtonListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayAddOrderPanel();
			}
		});
	}
	private void displayAddOrderPanel() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				graphicWaiterController.showAddOrderPanel();
				addAddOrderPanelCancelButtonListener();
				addAddOrderPanelAddOrderButtonListener();
			}	
		});
	}
	private void addAddOrderPanelAddOrderButtonListener() {
		graphicWaiterController.getAddOrderPanel().addAddOrderButtonListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					restaurantLogicController=new RestaurantLogicController("restaurant.ser");
					String tableName=graphicWaiterController.getAddOrderPanel().getTableNameTextField();
					String orderedProducts=graphicWaiterController.getAddOrderPanel().getOrderedProductsTextField();
					List<String> list=new ArrayList<String>();
					if(orderedProducts.matches("(( )*[a-zA-Z]{1,15}( )*(,){0,1}){1,10}(( )*[a-zA-Z]*){0,10}") && tableName.matches("Table[0-9]{1,5}")) {
						list=extractList(orderedProducts);
						String firstString=tableName.trim();
						if(restaurantLogicController.createOrder(firstString, list)) {
							displayWaiterMainPanel();
						}
						else {
							 JOptionPane.showMessageDialog(null, "Verify the input data! \n You don't have some products or that table has already ordered!", null, JOptionPane.ERROR_MESSAGE);
							 displayAddOrderPanel();
						}
					}
					else {
						 JOptionPane.showMessageDialog(null, "Verify the input data! \n Please try again!", null, JOptionPane.ERROR_MESSAGE);
						 displayAddOrderPanel();
					}
			}
		});
	}
	private List<String> extractList(String orderedProducts){
		List<String> list=new ArrayList<String>();
		String newString=orderedProducts.trim();
		while(newString.endsWith(",")) {
			newString=newString.substring(0, newString.length()-1);
		}
		if(newString.contains(",")) {
			String[] firstList=newString.split(",");
			for(int index=0;index<firstList.length;index++) {
				String element=firstList[index].trim();
				list.add(element);
			}
		}
		else {
			String element=newString.trim();
			list.add(element);
		}
		return list;
	}
	private void addAddOrderPanelCancelButtonListener() {
		graphicWaiterController.getAddOrderPanel().addCancelButtonListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayWaiterMainPanel();
			}
		});
	}
	private void addWaiterMainPanelCancelButtonListener() {
		graphicWaiterController.getWaiterMainPanel().addCancelButtonListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				graphicWaiterController.getWaiterFrame().dispose();
				ApplicationController app=new ApplicationController("restaurant.ser");
			}
		});
	}

}
