package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

public class MenuController {
	
	private GraphicMenuController graphicMenuController;
	private RestaurantLogicController restaurantLogicController;
	
	public MenuController() {
		graphicMenuController=new GraphicMenuController();
		displayMenuFrame();
		displayMenuMainPanel();
	}
	private void displayMenuFrame() {
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run() {
				graphicMenuController.showMenuFrame();
			}
		});
	}
	private void displayMenuMainPanel() {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				graphicMenuController.showMenuMainPanel();
				addAdministratorMainPanelCancelButtonListener();
				addMenuMainPanelBaseProductsButonListener();
				addMenuMainPanelCompositeProductsButonListener();
			}
		});
	}
	private void addAdministratorMainPanelCancelButtonListener() {
		graphicMenuController.getMenuMainPanel().addCancelButtonListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				graphicMenuController.getMenuFrame().dispose();
				ApplicationController app=new ApplicationController("restaurant.ser");
			}
		});
	}
	private void addMenuMainPanelCompositeProductsButonListener() {
		graphicMenuController.getMenuMainPanel().addCompositeProductsButtonListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayCompositeProductsPanel();
			}
		});
	}
	private void displayCompositeProductsPanel() {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				restaurantLogicController=new RestaurantLogicController("restaurant.ser");
				String[][] data=restaurantLogicController.extractCompositeProductsData();
				graphicMenuController.showCompositeProductsPanel(data);
			}
		});
	}
	private void addMenuMainPanelBaseProductsButonListener() {
		graphicMenuController.getMenuMainPanel().addBaseProductsButtonListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayBaseProductsPanel();
			}
		});
	}
	private void displayBaseProductsPanel() {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				restaurantLogicController=new RestaurantLogicController("restaurant.ser");
				String[][] data=restaurantLogicController.extractBaseProductsData();
				graphicMenuController.showBaseProductsPanel(data);
			}
		});
	}
}
