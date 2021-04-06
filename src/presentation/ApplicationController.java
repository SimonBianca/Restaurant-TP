package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

public class ApplicationController {
	
	private GraphicController graphicController;
	private RestaurantLogicController restaurantLogicController;
	
	public ApplicationController(String fileName) {
		graphicController=new GraphicController();
		restaurantLogicController=new RestaurantLogicController(fileName);
		displayMainFrame();
		displayLogInPanel();
	}
	private void displayMainFrame() {
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run() {
				graphicController.showMainFrame();
			}
		});
	}
	
	private void displayLogInPanel() {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				graphicController.showLogInPanel();
				addLogInPanelMenuButtonListener();
				addLogInPanelAdministratorButtonActionListener();
				addLogInPanelWaiterButtonActionListener();
			}	
		});
	}

	public void addLogInPanelAdministratorButtonActionListener() {
		graphicController.getLogInPanel().addAdministratorButtonListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				graphicController.getMainFrame().dispose();
				AdministratorController administrator=new AdministratorController();
			}
		});
	}
	public void addLogInPanelMenuButtonListener() {
		graphicController.getLogInPanel().addMenuButtonListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				graphicController.getMainFrame().dispose();
				MenuController menu=new MenuController();
			}
		});
	}
	public void addLogInPanelWaiterButtonActionListener() {
		graphicController.getLogInPanel().addWaiterButtonListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				graphicController.getMainFrame().dispose();
				WaiterController waiter=new WaiterController();
	
			}
		});
	}
}
