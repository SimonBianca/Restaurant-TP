package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class AdministratorController {
	
	private GraphicAdministratorController graphicAdministratorController;
	private RestaurantLogicController restaurantLogicController;
	
	public AdministratorController() {
		graphicAdministratorController=new GraphicAdministratorController();
		displayAdministratorFrame();
		displayAdministratorMainPanel();
	}
	private void displayAdministratorFrame() {
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run() {
				graphicAdministratorController.showAdministratorFrame();
			}
		});
	}
	private void displayAdministratorMainPanel() {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				graphicAdministratorController.showAdministratorMainPanel();
				addAdministratorMainPanelCancelButtonListener();
				addAdministratorMainPanelAddMenuItemButonListener();
				addAdministratorMainPanelDeleteMenuItemButonListener();
				addAdministratorMainPanelEditMenuItemButonListener();
			}
		});
	}
	private void addAdministratorMainPanelEditMenuItemButonListener() {
		graphicAdministratorController.getAdministratorMainPanel().addEditMenuItemButtonListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayEditMenuItemPanel();
			}
		});
	}
	private void displayEditMenuItemPanel() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				graphicAdministratorController.showEditMenuItemPanel();
				addEditMenuItemPanelCancelButtonListener();
				addEditMenuItemPanelChangePriceButtonListener();
				addEditMenuItemPanelAddBaseProductToCPButtonListener();
				addEditMenuItemPanelDeleteBaseProductFromCPButtonListener();
			}	
		});
	}
	private void addEditMenuItemPanelDeleteBaseProductFromCPButtonListener() {
		graphicAdministratorController.getEditMenuItemPanel().addDeleteBaseProductFromCPButtonListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayDeleteBPFromCPPanel();
			}
		});
	}
	private void displayDeleteBPFromCPPanel() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				graphicAdministratorController.showDeleteBPFromCPPanel();
				addDeleteBPFromCPPanelCancelButtonListener();
				addDeleteBPFromCPPanelDeleteBPFromCPButtonListener();
			}	
		});
	}
	private void addDeleteBPFromCPPanelDeleteBPFromCPButtonListener() {
		graphicAdministratorController.getDeleteBPFromCPPanel().addDeleteBPFromCPButtonListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					restaurantLogicController=new RestaurantLogicController("restaurant.ser");
					String productName=graphicAdministratorController.getDeleteBPFromCPPanel().getCompositeProductNameTextField();
					String baseProduct=graphicAdministratorController.getDeleteBPFromCPPanel().getBaseProductNameTextField();
					if(baseProduct.matches("(( )*[a-zA-Z]{1,15}( )*){1,5}") && productName.matches("(( )*[a-zA-Z]{1,15}( )*){1,5}")) {
						String firstString=productName.trim();
						String secondString=baseProduct.trim();
						if(restaurantLogicController.deleteBPFromCP(firstString, secondString)) {
							displayAdministratorMainPanel();
						}
						else {
							 JOptionPane.showMessageDialog(null, "Verify the input data! \n You don't have the base product or the composite porduct!", null, JOptionPane.ERROR_MESSAGE);
							 displayDeleteBPFromCPPanel();
						}
					}
					else {
						 JOptionPane.showMessageDialog(null, "Verify the input data! \n Please try again!", null, JOptionPane.ERROR_MESSAGE);
						 displayDeleteBPFromCPPanel();
					}
			}
		});
	}
	private void addDeleteBPFromCPPanelCancelButtonListener() {
		graphicAdministratorController.getDeleteBPFromCPPanel().addCancelButtonListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayEditMenuItemPanel();
			}
		});
	}
	
	private void addEditMenuItemPanelAddBaseProductToCPButtonListener() {
		graphicAdministratorController.getEditMenuItemPanel().addAddBaseProductToCPButtonListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayAddBPToCPPanel();
			}
		});
	}
	private void displayAddBPToCPPanel() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				graphicAdministratorController.showAddBPToCPPanel();
				addAddBPToCPPanelCancelButtonListener();
				addAddBPToCPPanelAddBPToCPButtonListener();
			}	
		});
	}
	private void addAddBPToCPPanelAddBPToCPButtonListener() {
		graphicAdministratorController.getAddBPToCPPanel().addAddBPToCPButtonListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					restaurantLogicController=new RestaurantLogicController("restaurant.ser");
					String productName=graphicAdministratorController.getAddBPToCPPanel().getCompositeProductNameTextField();
					String baseProduct=graphicAdministratorController.getAddBPToCPPanel().getBaseProductNameTextField();
					if(baseProduct.matches("(( )*[a-zA-Z]{1,15}( )*){1,5}") && productName.matches("(( )*[a-zA-Z]{1,15}( )*){1,5}")) {
						String firstString=productName.trim();
						String secondString=baseProduct.trim();
						if(restaurantLogicController.addBPToCP(firstString, secondString)) {
							displayAdministratorMainPanel();
						}
						else {
							 JOptionPane.showMessageDialog(null, "Verify the input data! \n You don't have the base product or the composite porduct!", null, JOptionPane.ERROR_MESSAGE);
							 displayAddBPToCPPanel();
						}
					}
					else {
						 JOptionPane.showMessageDialog(null, "Verify the input data! \n Please try again!", null, JOptionPane.ERROR_MESSAGE);
						 displayAddBPToCPPanel();
					}
			}
		});
	}
	private void addAddBPToCPPanelCancelButtonListener() {
		graphicAdministratorController.getAddBPToCPPanel().addCancelButtonListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayEditMenuItemPanel();
			}
		});
	}
	private void addEditMenuItemPanelChangePriceButtonListener() {
		graphicAdministratorController.getEditMenuItemPanel().addChangePriceButtonListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayChangePricePanel();
			}
		});
	}
	private void displayChangePricePanel() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				graphicAdministratorController.showChangePricePanel();
				addChangePricePanelCancelButtonListener();
				addChangePricePanelChangePriceButtonListener();
			}	
		});
	}
	private void addChangePricePanelChangePriceButtonListener() {
		graphicAdministratorController.getChangePricePanel().addChangePriceButtonListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					restaurantLogicController=new RestaurantLogicController("restaurant.ser");
					String productName=graphicAdministratorController.getChangePricePanel().getBaseProductNameTextField();
					double productPrice=graphicAdministratorController.getChangePricePanel().getBaseProductPriceTextField();
					String str=String.valueOf(productPrice);
					String firstString=productName.trim();
					if(str.matches("( )*[\\d]{1,5}(.)?[\\d]{0,5}( )*") && productName.matches("(( )*[a-zA-Z]{1,15}( )*){1,5}")){
						if(restaurantLogicController.changePrice(firstString, productPrice)) {
							displayAdministratorMainPanel();
						}
						else {
							JOptionPane.showMessageDialog(null, "Verify the input data! \n You don't have this product!", null, JOptionPane.ERROR_MESSAGE);
							displayChangePricePanel();
						}	
					}
					else {
						JOptionPane.showMessageDialog(null, "Verify the input data! \n Please try again!", null, JOptionPane.ERROR_MESSAGE);
						displayChangePricePanel();
						
					}
				}catch(NumberFormatException exc) {
					 JOptionPane.showMessageDialog(null, "Verify the input data! \n Please try again!", null, JOptionPane.ERROR_MESSAGE);
					
				}
			}
		});
	}
	private void addChangePricePanelCancelButtonListener() {
		graphicAdministratorController.getChangePricePanel().addCancelButtonListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayEditMenuItemPanel();
			}
		});
	}
	private void addEditMenuItemPanelCancelButtonListener() {
		graphicAdministratorController.getEditMenuItemPanel().addCancelButtonListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayAdministratorMainPanel();
			}
		});
	}
	private void addAdministratorMainPanelCancelButtonListener() {
		graphicAdministratorController.getAdministratorMainPanel().addCancelButtonListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				graphicAdministratorController.getAdministratorFrame().dispose();
				ApplicationController app=new ApplicationController("restaurant.ser");
			}
		});
	}
	private void addAdministratorMainPanelDeleteMenuItemButonListener() {
		graphicAdministratorController.getAdministratorMainPanel().addDeleteMenuItemButtonListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayDeleteMenuItemPanel();
			}
		});
	}
	private void displayDeleteMenuItemPanel() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				graphicAdministratorController.showDeleteMenuItemPanel();
				addDeleteMenuItemPanelCancelButtonListener();
				addDeleteMenuItemPanelDeleteBaseProductButtonListener();
				addDeleteMenuItemPanelDeleteCompositeProductButtonListener();
			}	
		});
	}
	private void addDeleteMenuItemPanelDeleteBaseProductButtonListener() {
		graphicAdministratorController.getDeleteMenuItemPanel().addDeleteBaseProductButtonListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayDeleteBaseProductPanel();
			}
		});
	}
	private void displayDeleteBaseProductPanel() {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				graphicAdministratorController.showDeleteBaseProductPanel();
				addDeleteBaseProductPanelCancelButtonListener();
				addDeleteBaseProductPanelDeleteProductButtonListener();
			}	
		});
	}
	private void addDeleteBaseProductPanelDeleteProductButtonListener() {
		graphicAdministratorController.getDeleteBaseProductPanel().addDeleteBaseProductButtonListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					restaurantLogicController=new RestaurantLogicController("restaurant.ser");
					String productName=graphicAdministratorController.getDeleteBaseProductPanel().getBaseProductNameTextField();
					if(productName.matches("(( )*[a-zA-Z]{1,15}( )*){1,5}")){
						String firstString=productName.trim();
						if(restaurantLogicController.deleteBaseProduct(firstString)) {
							displayAdministratorMainPanel();
						}
						else {
							 JOptionPane.showMessageDialog(null, "Verify the input data! \n This product doesn't exist!", null, JOptionPane.ERROR_MESSAGE);
							 displayDeleteBaseProductPanel();
						}
					}
					else {
						 JOptionPane.showMessageDialog(null, "Verify the input data! \n Please try again!", null, JOptionPane.ERROR_MESSAGE);
						 displayDeleteBaseProductPanel();
					}
			}
		});
	}
	private void addDeleteBaseProductPanelCancelButtonListener() {
		graphicAdministratorController.getDeleteBaseProductPanel().addCancelButtonListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayAdministratorMainPanel();
			}
		});
	}
	private void addDeleteMenuItemPanelDeleteCompositeProductButtonListener() {
		graphicAdministratorController.getDeleteMenuItemPanel().addDeleteCompositeProductButtonListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayDeleteCompositeProductPanel();
			}
		});
	}
	private void displayDeleteCompositeProductPanel() {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				graphicAdministratorController.showDeleteCompositeProductPanel();
				addDeleteCompositeProductPanelCancelButtonListener();
				addDeleteCompositeProductPanelDeleteProductButtonListener();
			}	
		});
	}
	private void addDeleteCompositeProductPanelDeleteProductButtonListener() {
		graphicAdministratorController.getDeleteCompositeProductPanel().addDeleteCompositeProductButtonListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					restaurantLogicController=new RestaurantLogicController("restaurant.ser");
					String productName=graphicAdministratorController.getDeleteCompositeProductPanel().getCompositeProductNameTextField();
					if(productName.matches("(( )*[a-zA-Z]{1,15}( )*){1,5}")){
						String firstString=productName.trim();
						if(restaurantLogicController.deleteCompositeProduct(firstString)) {
							displayAdministratorMainPanel();
						}
						else {
							 JOptionPane.showMessageDialog(null, "Verify the input data! \n This product doesn't exist!", null, JOptionPane.ERROR_MESSAGE);
							 displayDeleteCompositeProductPanel();
						}
					}
					else {
						 JOptionPane.showMessageDialog(null, "Verify the input data! \n Please try again!", null, JOptionPane.ERROR_MESSAGE);
						 displayDeleteCompositeProductPanel();
					}
			}
		});
	}
	private void addDeleteCompositeProductPanelCancelButtonListener() {
		graphicAdministratorController.getDeleteCompositeProductPanel().addCancelButtonListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayAdministratorMainPanel();
			}
		});
	}
	private void addDeleteMenuItemPanelCancelButtonListener() {
		graphicAdministratorController.getDeleteMenuItemPanel().addCancelButtonListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayAdministratorMainPanel();
			}
		});
	}
	private void addAdministratorMainPanelAddMenuItemButonListener() {
		graphicAdministratorController.getAdministratorMainPanel().addAddMenuItemButtonListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayAddMenuItemPanel();
			}
		});
	}
	private void displayAddMenuItemPanel() {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				graphicAdministratorController.showAddMenuItemPanel();
				addAddMenuItemPanelCancelButtonListener();
				addMenuItemPanelAddBaseProductButtonListener();
				addMenuItemPanelAddCompositeProductButtonListener();
			}	
		});
	}
	private void addMenuItemPanelAddCompositeProductButtonListener() {
		graphicAdministratorController.getAddMenuItemPanel().addAddCompositeProductButtonListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayAddCompositeProductPanel();
			}
		});
	}
	private void displayAddCompositeProductPanel() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				graphicAdministratorController.showAddCompositeProductPanel();
				addCompositeProductPanelCancelButtonListener();
				addCompositeProductPanelAddCompositeProductButtonListener();
			}	
		});
	}
	private void addCompositeProductPanelAddCompositeProductButtonListener() {
		graphicAdministratorController.getAddCompositeProductPanel().addAddCompositeProductButtonListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					restaurantLogicController=new RestaurantLogicController("restaurant.ser");
					String productName=graphicAdministratorController.getAddCompositeProductPanel().getCompositeProductNameTextField();
					String baseProducts=graphicAdministratorController.getAddCompositeProductPanel().getBaseProductsTextField();
					List<String> list=new ArrayList<String>();
					if(baseProducts.matches("(( )*[a-zA-Z]{1,15}( )*(,){0,1}){1,10}(( )*[a-zA-Z]*){0,10}") && productName.matches("(( )*[a-zA-Z]{1,15}( )*){1,5}")) {
						list=extractList(baseProducts);
						String firstString=productName.trim();
						if(restaurantLogicController.addCompositeProduct(firstString, list)) {
							displayAdministratorMainPanel();
						}
						else {
							 JOptionPane.showMessageDialog(null, "Verify the input data! \n You don't have some base products or this product exists!", null, JOptionPane.ERROR_MESSAGE);
							 displayAddCompositeProductPanel();
						}
					}
					else {
						 JOptionPane.showMessageDialog(null, "Verify the input data! \n Please try again!", null, JOptionPane.ERROR_MESSAGE);
						 displayAddCompositeProductPanel();
					}
			}
		});
	}
	private List<String> extractList(String baseProducts){
		List<String> list=new ArrayList<String>();
		String newString=baseProducts.trim();
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
	private void addCompositeProductPanelCancelButtonListener() {
		graphicAdministratorController.getAddCompositeProductPanel().addCancelButtonListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayAddMenuItemPanel();
			}
		});
	}
	private void addMenuItemPanelAddBaseProductButtonListener() {
		graphicAdministratorController.getAddMenuItemPanel().addAddBaseProductButtonListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayAddBaseProductPanel();
			}
		});
	}
	private void displayAddBaseProductPanel() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				graphicAdministratorController.showAddBaseProductPanel();
				addBaseProductPanelCancelButtonListener();
				addBaseProductPanelAddBaseProductButtonListener();
			}	
		});
	}
	private void addBaseProductPanelAddBaseProductButtonListener() {
		graphicAdministratorController.getAddBaseProductPanel().addBaseProductButtonListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					restaurantLogicController=new RestaurantLogicController("restaurant.ser");
					String productName=graphicAdministratorController.getAddBaseProductPanel().getBaseProductNameTextField();
					double productPrice=graphicAdministratorController.getAddBaseProductPanel().getBaseProductPriceTextField();
					String str=String.valueOf(productPrice);
					String firstString=productName.trim();
					if(str.matches("( )*[\\d]{1,5}(.)?[\\d]{0,5}( )*") && productName.matches("(( )*[a-zA-Z]{1,15}( )*){1,5}")){
						if(restaurantLogicController.addBaseProduct(firstString, productPrice)) {
							displayAdministratorMainPanel();
						}
						else {
							JOptionPane.showMessageDialog(null, "Verify the input data! \n You have this product!", null, JOptionPane.ERROR_MESSAGE);
							displayAddBaseProductPanel();
						}	
					}
					else {
						JOptionPane.showMessageDialog(null, "Verify the input data! \n Please try again!", null, JOptionPane.ERROR_MESSAGE);
						displayAddBaseProductPanel();
						
					}
				}catch(NumberFormatException exc) {
					 JOptionPane.showMessageDialog(null, "Verify the input data! \n Please try again!", null, JOptionPane.ERROR_MESSAGE);
					
				}
			}
		});
	}
	private void addBaseProductPanelCancelButtonListener() {
		graphicAdministratorController.getAddBaseProductPanel().addCancelButtonListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayAddMenuItemPanel();
			}
		});
	}
	private void addAddMenuItemPanelCancelButtonListener() {
		graphicAdministratorController.getAddMenuItemPanel().addCancelButtonListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayAdministratorMainPanel();
			}
		});
	}
}
